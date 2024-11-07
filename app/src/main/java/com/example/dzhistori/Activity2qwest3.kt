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

class Activity2qwest3 : AppCompatActivity() {
    private lateinit var toolbarQwest3: Toolbar
    private lateinit var buttonQwest3BTN: Button
    private lateinit var qwest3RB1: RadioButton
    private lateinit var qwest3RB2: RadioButton
    private lateinit var qwest3RB3: RadioButton
    private lateinit var qwest3RB4: RadioButton
    private lateinit var qwest3RB5: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_activity2qwest3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbarQwest3 = findViewById(R.id.toolbarQwest3)
        setSupportActionBar(toolbarQwest3)
        title = " Я историк"
        toolbarQwest3.subtitle = "  Версия 1. Вопросы викторины"
        toolbarQwest3.setLogo(R.drawable.orig)

        qwest3RB1=findViewById(R.id.qwest3RB1)
        qwest3RB2=findViewById(R.id.qwest3RB2)
        qwest3RB3=findViewById(R.id.qwest3RB3)
        qwest3RB4=findViewById(R.id.qwest3RB4)
        qwest3RB5=findViewById(R.id.qwest3RB5)

        var result= intent.getIntExtra("result", 0)

        val radioButtonClickListener =
            View.OnClickListener { view ->
                val radioButton = view as RadioButton
                when (radioButton.id) {
                    R.id.qwest3RB2 -> {
                        val score = 100
                        result += score
                        val intent = Intent(this, Activity2qwest4::class.java)
                        intent.putExtra("result", result)
                        startActivity(intent)
                        finish()
                    }
                    else -> {
                        val intent = Intent(this, Activity2qwest4::class.java)
                        intent.putExtra("score", result)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        qwest3RB1.setOnClickListener(radioButtonClickListener)
        qwest3RB2.setOnClickListener(radioButtonClickListener)
        qwest3RB3.setOnClickListener(radioButtonClickListener)
        qwest3RB4.setOnClickListener(radioButtonClickListener)
        qwest3RB5.setOnClickListener(radioButtonClickListener)




        buttonQwest3BTN = findViewById(R.id.buttonQwest3BTN)
        buttonQwest3BTN.setOnClickListener { view ->
            val intent = Intent(this, Activity2qwest4::class.java)
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