package com.example.foodstoragetracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify
import com.example.foodstoragetracker.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { view ->
            sign_up()
        }
        binding.buttonConfirm.setOnClickListener { view ->
            confirm()
        }

    }

    private fun confirm() {
        var username = binding.editUsername.text.toString()
        var token = binding.token.text.toString()
        Amplify.Auth.confirmSignUp(
            username, token,
            { result ->
                if (result.isSignUpComplete) {
                    Log.i("AuthQuickstart", "Confirm signUp succeeded")

                    this@RegisterActivity.runOnUiThread {
                        Snackbar.make(this@RegisterActivity.findViewById(R.id.main_register), "Sign up successful", Snackbar.LENGTH_LONG)
                        .show()

                        this@RegisterActivity.startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
                    }
                } else {
                    Log.i("AuthQuickstart","Confirm sign up not complete")
                    this@RegisterActivity.runOnUiThread {
                        Snackbar.make(
                            this@RegisterActivity.findViewById(R.id.main_register),
                            "Sign up failed",
                            Snackbar.LENGTH_LONG
                        )
                            .show()
                    }
                }
            },
            {
                Log.e("AuthQuickstart", "Failed to confirm sign up", it)
                this@RegisterActivity.runOnUiThread {
                    Snackbar.make(this@RegisterActivity.findViewById(R.id.main_register), "Sign up failed", Snackbar.LENGTH_LONG)
                        .show()
                }
            }
        )

    }

    private fun sign_up() {
        var username = binding.editUsername.text.toString()
        var password = binding.editPassword.text.toString()
        Log.i("AuthQuickstart", "trying to run sign-up...")
        val options = AuthSignUpOptions.builder()
            .userAttribute(AuthUserAttributeKey.email(), "my@email.com")
            .build()
        Amplify.Auth.signUp(username, password, options,
            { Log.i("AuthQuickStart", "Sign up succeeded: $it")
                Snackbar.make(this@RegisterActivity.findViewById(R.id.main_register), "Enter the token", Snackbar.LENGTH_LONG)
                    .show()
                this@RegisterActivity.runOnUiThread {
                    binding.token.visibility = View.VISIBLE
                    binding.buttonConfirm.visibility = View.VISIBLE
                    binding.editUsername.inputType = InputType.TYPE_NULL
                    binding.editPassword.setText("")
                    binding.editPassword.inputType = InputType.TYPE_NULL
                }


            },
            { Log.e ("AuthQuickStart", "Sign up failed", it)
                Snackbar.make(this@RegisterActivity.findViewById(R.id.main_register), "Sign in unsuccessful", Snackbar.LENGTH_LONG)
                    .show()
            }
        )
    }
}