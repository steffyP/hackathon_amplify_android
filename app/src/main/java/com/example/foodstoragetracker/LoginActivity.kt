package com.example.foodstoragetracker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.amplifyframework.AmplifyException
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthSession
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.AWSDataStorePlugin
import com.example.foodstoragetracker.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            // only configure the first time
            try {
                //Amplify.addPlugin(AWSApiPlugin()) // UNCOMMENT this line once backend is deployed
                Amplify.addPlugin(AWSCognitoAuthPlugin())
                Amplify.addPlugin(AWSDataStorePlugin())
                Amplify.configure(applicationContext)
                Log.i("Amplify", "Initialized Amplify")
            } catch (e: AmplifyException) {
                Log.e("Amplify", "Could not initialize Amplify", e)
            }
        }
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { view ->
            Amplify.Auth.fetchAuthSession(
                { result: AuthSession ->
                    Log.i(
                        "AmplifyQuickstart",
                        result.toString()
                    )
                    login()
                }
            ) { error: AuthException ->
                Log.e(
                    "AmplifyQuickstart",
                    error.toString()
                )
                Snackbar.make(view, "Login Failed", Snackbar.LENGTH_LONG).show()

            }

        }
        binding.buttonRegister.setOnClickListener { view ->
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        check_logged_in()
    }

    private fun check_logged_in() {
        Amplify.Auth.fetchAuthSession(
            {
                Log.i("AmplifyQuickstart", "Auth session = $it")
                if (it.isSignedIn){
                    this@LoginActivity.runOnUiThread {
                        this@LoginActivity.startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    }
                }

            },
            { error -> Log.e("AmplifyQuickstart", "Failed to fetch auth session", error) }
        )
    }

    private fun login() {
        var username = binding.editUsername.text.toString()
        var password = binding.editPassword.text.toString()
        Amplify.Auth.signIn(username, password,
            { result ->
                if (result.isSignedIn) {
                    Log.i("AuthQuickstart", "Sign in succeeded")
                    this@LoginActivity.runOnUiThread {
                        this@LoginActivity.startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    }
                } else {
                    Log.i("AuthQuickstart", "Sign in failed")
                    this@LoginActivity.runOnUiThread {
                        Snackbar.make(this@LoginActivity.findViewById(R.id.main_login), "Sign in unsuccessful", Snackbar.LENGTH_LONG)
                            .show()
                    }
                }
            },
            {
                this@LoginActivity.runOnUiThread {
                    Snackbar.make(this@LoginActivity.findViewById(R.id.main_login), "Login Failed", Snackbar.LENGTH_LONG)
                        .show()
                }
                Log.e("AuthQuickstart", "Failed to sign in", it)
            }

        )
    }


}