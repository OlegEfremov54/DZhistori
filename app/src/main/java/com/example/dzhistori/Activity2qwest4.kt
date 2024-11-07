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

class Activity2qwest4 : AppCompatActivity() {

    private lateinit var toolbarQwest4: Toolbar
    private lateinit var buttonQwest4BTN: Button
    private lateinit var qwest4RB1: RadioButton
    private lateinit var qwest4RB2: RadioButton
    private lateinit var qwest4RB3: RadioButton
    private lateinit var qwest4RB4: RadioButton
    private lateinit var qwest4RB5: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_activity2qwest4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbarQwest4 = findViewById(R.id.toolbarQwest4)
        setSupportActionBar(toolbarQwest4)
        title = " Я историк"
        toolbarQwest4.subtitle = "  Версия 1. Вопросы викторины"
        toolbarQwest4.setLogo(R.drawable.orig)

        qwest4RB1=findViewById(R.id.qwest4RB1)
        qwest4RB2=findViewById(R.id.qwest4RB2)
        qwest4RB3=findViewById(R.id.qwest4RB3)
        qwest4RB4=findViewById(R.id.qwest4RB4)
        qwest4RB5=findViewById(R.id.qwest4RB5)

        var result= intent.getIntExtra("result", 0)

        val radioButtonClickListener =
            View.OnClickListener { view ->
                val radioButton = view as RadioButton
                when (radioButton.id) {
                    R.id.qwest4RB5 -> {
                        val score = 100
                        result += score
                        val intent = Intent(this, Activity2qwest5::class.java)
                        intent.putExtra("result", result)
                        startActivity(intent)
                        finish()
                    }
                    else -> {
                        val intent = Intent(this, Activity2qwest5::class.java)
                        intent.putExtra("score", result)
                        startActivity(intent)
                        finish()
                    }
                }
            }

        qwest4RB1.setOnClickListener(radioButtonClickListener)
        qwest4RB2.setOnClickListener(radioButtonClickListener)
        qwest4RB3.setOnClickListener(radioButtonClickListener)
        qwest4RB4.setOnClickListener(radioButtonClickListener)
        qwest4RB5.setOnClickListener(radioButtonClickListener)

        buttonQwest4BTN = findViewById(R.id.buttonQwest4BTN)
        buttonQwest4BTN.setOnClickListener { view ->
            val intent = Intent(this, Activity2qwest5::class.java)
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