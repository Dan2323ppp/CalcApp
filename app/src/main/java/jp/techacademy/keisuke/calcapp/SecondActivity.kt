package jp.techacademy.keisuke.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val value: Double = intent.getDoubleExtra("VALUE", 0.0)


        textView.text = "$value"
        Log.d("calclog", "$value")

    }
}