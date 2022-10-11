package com.example.touchcount

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var count:TextView
    private lateinit var viewmodel:mainActivityViewModel
    lateinit var sf:SharedPreferences
    lateinit var editor:SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        viewmodel=ViewModelProvider(this).get(mainActivityViewModel::class.java)
        sf=getSharedPreferences("myfolder", MODE_PRIVATE)
        editor=sf.edit()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var screen = findViewById<ConstraintLayout>(R.id.hello)
        count = findViewById(R.id.cnt)
        //count.text=viewmodel.count.toString()
        //var cnt = 0
        viewmodel.count.observe(this, Observer { count.text=it.toString() })

        screen.setOnClickListener()
        {
            viewmodel.update()
            //count.text=viewmodel.count.toString()
        }

    }

  /*  override fun onPause() {
        super.onPause()
        var a=viewmodel.count
        editor.apply()
        {
            putInt("n",a)
        }
    }*/

   /* override fun onResume() {
        super.onResume()
        viewmodel.count=sf.getInt("n",0)
    }*/
}