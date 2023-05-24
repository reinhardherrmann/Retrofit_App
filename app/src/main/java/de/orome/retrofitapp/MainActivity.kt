package de.orome.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import de.orome.retrofitapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var data = ArrayList<Products>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    getAllProducts()







    }

    private fun getAllProducts() {

         val retrofit = ServiceBuilder.buildService(ServiceInterface::class.java)

        retrofit.getAllProducts().enqueue(object: Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                try {

                    // to avoid nullpointer exception
                    val responseBody = response.body()!!
                    data = responseBody.products

                    var adapter = ProductAdapter(data)
                    binding.recyclerView.adapter = adapter




                } catch (ex: Exception){
                    ex.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("Failed", "API failed " + t.message)
            }

        })








    }
}