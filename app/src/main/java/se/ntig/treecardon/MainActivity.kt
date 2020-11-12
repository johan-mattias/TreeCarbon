package se.ntig.treecardon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(view: View) {
        var tree = editTextTree.text.toString()
        var circumference = editTextCircumference.text.toString().toInt()
        var diameter = circumference / 3.14
        var height = editTextHeight.text.toString().toInt()
        var VS = 0.0

        when (tree) {
            "ek" -> {
                var temp1 = 0.03522*(diameter*diameter)*height
                var temp2 = 0.08772*diameter*height
                var temp3 = 0.04905*(diameter*diameter)
                VS = ((temp1 + temp2) - temp3)
            }
        }

        editTextResult.setText(VS.toString())
    }


}