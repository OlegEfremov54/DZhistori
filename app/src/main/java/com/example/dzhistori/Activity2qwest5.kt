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

class Activity2qwest5 : AppCompatActivity() {

    private lateinit var toolbarQwest5: Toolbar
    private lateinit var buttonQwest5BTN: Button
    private lateinit var qwest5RB1: RadioButton
    private lateinit var qwest5RB2: RadioButton
    private lateinit var qwest5RB3: RadioButton
    private lateinit var qwest5RB4: RadioButton
    private lateinit var qwest5RB5: RadioButton

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

        qwest5RB1=findViewById(R.id.qwest5RB1)
        qwest5RB2=findViewById(R.id.qwest5RB2)
        qwest5RB3=findViewById(R.id.qwest5RB3)
        qwest5RB4=findViewById(R.id.qwest5RB4)
        qwest5RB5=findViewById(R.id.qwest5RB5)

        var result= intent.getIntExtra("result", 0)

        val radioButtonClickListener =
            View.OnClickListener { view ->
                val radioButton = view as RadioButton
                when (radioButton.id) {
                    R.id.qwest5RB1 -> {
                        val score = 100
                        result += score
                        val intent = Intent(this, ActivityFinish::class.java)
                        intent.putExtra("result", result)
                        startActivity(intent)
                        finish()
                    }
                    else -> {
                        val intent = Intent(this, ActivityFinish::class.java)
                        intent.putExtra("score", result)
                        startActivity(intent)
                        finish()
                    }
                }
            }

        qwest5RB1.setOnClickListener(radioButtonClickListener)
        qwest5RB2.setOnClickListener(radioButtonClickListener)
        qwest5RB3.setOnClickListener(radioButtonClickListener)
        qwest5RB4.setOnClickListener(radioButtonClickListener)
        qwest5RB5.setOnClickListener(radioButtonClickListener)

        buttonQwest5BTN = findViewById(R.id.buttonQwest5BTN)
        buttonQwest5BTN.setOnClickListener { view ->
            val intent = Intent(this, ActivityFinish::class.java)
            intent.putExtra("result", result)
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
