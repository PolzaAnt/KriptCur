package com.ex.kriptcur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_coinmarketcap.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
setSupportActionBar(toolBar)
        toolBar.setNavigationOnClickListener {
            Toast.makeText(this, "Navigation Menu Clicked", Toast.LENGTH_SHORT).show()
        }


        imgBtc.setOnClickListener {
            val myIntent = Intent(this, CoinmarketcapActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemView=item.itemId

        when(itemView){
            R.id.app_bar_search -> Toast.makeText(applicationContext, "Search clicked", Toast.LENGTH_SHORT).show()
            R.id.help -> Toast.makeText(applicationContext, "Help clicked", Toast.LENGTH_SHORT).show()
        }
        return false
    }
}