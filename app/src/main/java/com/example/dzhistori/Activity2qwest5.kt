package com.example.dzhistori

import android.content.Intent
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

class Activity2qwest5 : AppCompatActivity() {
    private lateinit var toolbarQwest5: Toolbar
    private lateinit var buttonQwest5BTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_activity2qwest5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbarQwest5 = findViewById(R.id.toolbarQwest5)
        setSupportActionBar(toolbarQwest5)
        title = " Я историк"
        toolbarQwest5.subtitle = "  Версия 1. Вопросы викторины"
        toolbarQwest5.setLogo(R.drawable.orig)

        buttonQwest5BTN = findViewById(R.id.buttonQwest5BTN)
        buttonQwest5BTN.setOnClickListener { view ->
            val intent = Intent(this, ActivityFinish::class.java)
            startActivity(intent)


        }

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
