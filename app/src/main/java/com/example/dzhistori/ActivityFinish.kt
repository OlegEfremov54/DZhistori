package com.example.dzhistori

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityFinish : AppCompatActivity() {
    private lateinit var toolbarFin: Toolbar
    private lateinit var buttonFinBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_finish)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbarFin = findViewById(R.id.toolbarFin)
        setSupportActionBar(toolbarFin)
        title = " Я историк"
        toolbarFin.subtitle = "  Версия 1. Результат викторины"
        toolbarFin.setLogo(R.drawable.orig)

        //buttonFinBTN.setOnClickListener{ view ->
        //    finishAffinity()
        //}

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_qvest,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.infoMenuMain -> {
                Toast.makeText(applicationContext, "Автор Ефремов О.В. Создан 6.11.2024",
                    Toast.LENGTH_LONG).show()
            }
            R.id.exitMenuMain ->{
                Toast.makeText(applicationContext, "Работа приложения завершена",
                    Toast.LENGTH_LONG).show()
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
