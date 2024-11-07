package com.example.dzhistori

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityFinish : AppCompatActivity() {

    private lateinit var toolbarFin: Toolbar
    private lateinit var buttonFinBTN: Button
    private lateinit var textViewCkr:TextView
    private lateinit var textViewStat:TextView

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

        textViewStat=findViewById(R.id.textViewStat)
        textViewCkr=findViewById(R.id.textViewCkr)
        buttonFinBTN=findViewById(R.id.buttonFinBTN)

        var result= intent.getIntExtra("result", 0)

        textViewStat.text = "Вы заработали $result баллов"
        when (result) {
            100 -> textViewCkr.text = "Ваш уровень знаний Детский Сад"
            200 -> textViewCkr.text = "Ваш уровень знаний Школьник"
            300 -> textViewCkr.text = "Ваш уровень знаний Студент"
            400 -> textViewCkr.text = "Ваш уровень знаний Профессор"
            500 -> textViewCkr.text = "Ваш уровень знаний Академик"
            else -> textViewCkr.text = "Всё очень печально, уровень Ясли"
        }
        buttonFinBTN.setOnClickListener { view ->
            finishAffinity()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_qvest,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.infoMenuMain -> {
                Toast.makeText(applicationContext, "Автор Ефремов О.В. Создан 7.11.2024",
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
