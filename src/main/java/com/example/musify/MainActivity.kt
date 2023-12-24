package com.example.musify

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : ComponentActivity() {
    lateinit var myAdapter: MyAdapter
    lateinit var myRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView=findViewById(R.id.recyclerView)
        val retrofitBuilder= Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData= retrofitBuilder.getData("eminem")
        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val dataList= response.body()?.data
          //      val textView= findViewById<TextView>(R.id.helloText)
            //    textView.text= dataList.toString()
                myAdapter=myAdapter(this@MainActivity,dataList)
                myRecyclerView.adapter=myAdapter
                myRecyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                Log.d("TAG: onResponse","onResponse:"+ response.body())

            }


            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("TAG: onFailure","onFailure:"+ t.message)

            }
        })


    }



}

private fun <T> Call<T>.enqueue(callback: Callback<MyData?>) {
    TODO("Not yet implemented")
}
