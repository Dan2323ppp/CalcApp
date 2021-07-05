package jp.techacademy.keisuke.calcapp//名前

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }

    //onClickメソッドの引数vに渡されているものは
    override fun onClick(v: View?) {
        //遷移
        val intent = Intent(this, SecondActivity::class.java)
//        ここでエラーがおきてる　文字列が数値ではない、空である

        if (editText1.text.toString().isEmpty() || editText2.text.toString().isEmpty()) {
            Snackbar.make(v!!, "数字を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action") {
                    Log.d("UI_PARTS", "Snackbarをタップした")
                }.show()
        } else {
            val value1: Double? = editText1.text.toString().toDouble()
            val value2: Double? = editText2.text.toString().toDouble()

            if (v?.id == R.id.button1) {
                val calc: Double = value1.toString().toDouble() + value2.toString().toDouble()
                intent.putExtra("VALUE", calc)
            } else if (v?.id == R.id.button2) {
                val calc: Double = value1.toString().toDouble() - value2.toString().toDouble()
                intent.putExtra("VALUE", calc)
            } else if (v?.id == R.id.button3) {
                val calc: Double = value1.toString().toDouble() * value2.toString().toDouble()
                intent.putExtra("VALUE", calc)
            } else if (v?.id == R.id.button4) {
                val calc: Double = value1.toString().toDouble() / value2.toString().toDouble()
                intent.putExtra("VALUE", calc)
            }

            startActivity(intent)
        }
    }
}

