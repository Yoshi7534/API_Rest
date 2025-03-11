package com.example.api_rest

import ApiService
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.228:3000/") // Para emulador, usa la IP si es dispositivo real
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.getHello().enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    textView.text = response.body()
                } else {
                    textView.text = "Error: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                textView.text = "Error al obtener datos: ${t.message}"
            }
        })
    }
}
