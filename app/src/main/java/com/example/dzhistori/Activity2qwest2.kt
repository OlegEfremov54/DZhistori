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

class Activity2qwest2 : AppCompatActivity() {

    private lateinit var toolbarQwest2: Toolbar
    private lateinit var buttonQwest2BTN: Button
    private lateinit var qwest2RB1: RadioButton
    private lateinit var qwest2RB2: RadioButton
    private lateinit var qwest2RB3: RadioButton
    private lateinit var qwest2RB4: RadioButton
    private lateinit var qwest2RB5: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_activity2qwest2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbarQwest2 = findViewById(R.id.toolbarQwest2)
        setSupportActionBar(toolbarQwest2)
        title = " Я историк"
        toolbarQwest2.subtitle = "  Версия 1. Вопросы викторины"
        toolbarQwest2.setLogo(R.drawable.orig)

        qwest2RB1=findViewById(R.id.qwest2RB1)
        qwest2RB2=findViewById(R.id.qwest2RB2)
        qwest2RB3=findViewById(R.id.qwest2RB3)
        qwest2RB4=findViewById(R.id.qwest2RB4)
        qwest2RB5=findViewById(R.id.qwest2RB5)

        var result= intent.getIntExtra("result", 0)

        val radioButtonClickListener =
            View.OnClickListener { view ->
                val radioButton = view as RadioButton
                when (radioButton.id) {
                    R.id.qwest2RB2 -> {
                        val score = 100
                        result += score
                        val intent = Intent(this, Activity2qwest3::class.java)
                        intent.putExtra("result", result)
                        startActivity(intent)
                        finish()
                    }
                    else -> {
                        val intent = Intent(this, Activity2qwest3::class.java)
                        intent.putExtra("score", result)
                        startActivity(intent)
                        finish()
                    }
                }
            }

        qwest2RB1.setOnClickListener(radioButtonClickListener)
        qwest2RB2.setOnClickListener(radioButtonClickListener)
        qwest2RB3.setOnClickListener(radioButtonClickListener)
        qwest2RB4.setOnClickListener(radioButtonClickListener)
        qwest2RB5.setOnClickListener(radioButtonClickListener)

        buttonQwest2BTN = findViewById(R.id.buttonQwest2BTN)
        buttonQwest2BTN.setOnClickListener { view ->
            val intent = Intent(this, Activity2qwest3::class.java)
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