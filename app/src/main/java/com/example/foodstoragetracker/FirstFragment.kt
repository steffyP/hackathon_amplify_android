package com.example.foodstoragetracker

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Product
import com.example.foodstoragetracker.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var arrayAdapter: ArrayAdapter<String>? = null
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val productList: MutableList<Product> = ArrayList()
    val simpleList: MutableList<String> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val lv = binding.listProducts
        arrayAdapter = ArrayAdapter<String>(
            lv.context,
            R.layout.simple_list_item_1,
            simpleList
        )
        lv.setAdapter(arrayAdapter)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
        update_product_list()
        binding.buttonFirst.setOnClickListener { update_product_list() }
    }

    private fun update_product_list(){

        // load products from amplify
        productList.clear()
        simpleList.clear()
        Amplify.DataStore.query(
            Product::class.java,
            { items ->
                while (items.hasNext()) {
                    val item = items.next()
                    productList.add(item)

                    Log.i("Amplify", "Queried item: " + item.id)
                }

                for( p in productList) {
                    simpleList.add(p.name)
                }

                this@FirstFragment.activity?.runOnUiThread {
                    arrayAdapter?.notifyDataSetChanged()
                }

            },
            { failure -> Log.e("Tutorial", "Could not query DataStore", failure) }
        )

    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}