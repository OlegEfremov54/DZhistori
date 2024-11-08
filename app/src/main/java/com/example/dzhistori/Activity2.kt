package com.example.dzhistori

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {

    private lateinit var toolbarQwest: Toolbar
    private lateinit var buttonQwest1BTN:Button
    private lateinit var qwest1RB1:RadioButton
    private lateinit var qwest1RB2:RadioButton
    private lateinit var qwest1RB3:RadioButton
    private lateinit var qwest1RB4:RadioButton
    private lateinit var qwest1RB5:RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbarQwest = findViewById(R.id.toolbarQwest)
        setSupportActionBar(toolbarQwest)
        title = " Я историк"
        toolbarQwest.subtitle = "  Версия 1. Вопросы викторины"
        toolbarQwest.setLogo(R.drawable.orig)

        qwest1RB1=findViewById(R.id.qwest1RB1)
        qwest1RB2=findViewById(R.id.qwest1RB2)
        qwest1RB3=findViewById(R.id.qwest1RB3)
        qwest1RB4=findViewById(R.id.qwest1RB4)
        qwest1RB5=findViewById(R.id.qwest1RB5)

        var result= intent.getIntExtra("result", 0)

        val radioButtonClickListener =
            View.OnClickListener { view ->
                val radioButton = view as RadioButton
                when (radioButton.id) {
                    R.id.qwest1RB4 -> {
                        val score = 100
                        result += score
                        val intent = Intent(this, Activity2qwest2::class.java)
                        intent.putExtra("result", result)
                        startActivity(intent)
                        finish()
                    }
                    else -> {
                        val intent = Intent(this, Activity2qwest2::class.java)
                        intent.putExtra("score", result)
                        startActivity(intent)
                        finish()
                    }
                }
            }

        qwest1RB1.setOnClickListener(radioButtonClickListener)
        qwest1RB2.setOnClickListener(radioButtonClickListener)
        qwest1RB3.setOnClickListener(radioButtonClickListener)
        qwest1RB4.setOnClickListener(radioButtonClickListener)
        qwest1RB5.setOnClickListener(radioButtonClickListener)

        buttonQwest1BTN = findViewById(R.id.buttonQwest1BTN)
        buttonQwest1BTN.setOnClickListener { view ->
            val intent = Intent(this, Activity2qwest2::class.java)
            intent.putExtra("result", result)
            startActivity(intent)
            finish()
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