package com.ex.kriptcur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ex.kriptcur.network.dto.BitcoinResponse
import com.ex.kriptcur.network.mappers.RatesMapper
import com.ex.kriptcur.network.networking.BitcoinAPI
import com.ex.kriptcur.network.retrofit.RetrofitFactory
import kotlinx.android.synthetic.main.activity_coinmarketcap.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class CoinmarketcapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coinmarketcap)

        setSupportActionBar(toolBar_return)
        toolBar_return.setNavigationOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }
        val retrofit: BitcoinAPI = RetrofitFactory().getRetrofit()
        val rateAdapter = RateAdapter()

        val  recycler_view_bitcoin=findViewById<RecyclerView>(R.id.recycler_view_bitcoin)
        recycler_view_bitcoin.apply {
            adapter = rateAdapter
            layoutManager = LinearLayoutManager(this@CoinmarketcapActivity)
        }

        button_get_bitcoin.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                val response: Response<BitcoinResponse> = retrofit.getRatesAsync().await()

                if (response.isSuccessful) {

                    val ratesResponse = response.body()?.data

                    val rates = ratesResponse?.map {
                        RatesMapper().map(it)
                    }
                    withContext(Dispatchers.Main) { rateAdapter.updateList(rates) }
                } else {
                    Handler(Looper.getMainLooper()).post {
                        Toast.makeText(this@CoinmarketcapActivity, "ERROR", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

            }


        }
    }
}