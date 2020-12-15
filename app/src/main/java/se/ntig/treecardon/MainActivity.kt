package se.ntig.treecardon

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject.NULL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        sharedPref?.let {
            val vs_from_shared = sharedPref.getFloat("ek", 0.0.toFloat())
            editTextResult.setText(vs_from_shared.toString())
        }

    }

    fun calculate(view: View) {
        var tree = editTextTree.text.toString()
        var circumference = editTextCircumference.text.toString().toInt()
        var diameter = circumference / 3.14
        var height = editTextHeight.text.toString().toInt()
        var VS = 0.0

        when (tree) {
            "ek" -> {
                var temp1 = (0.03522*diameter)*(0.03522*diameter)*height
                var temp2 = 0.08772*diameter*height
                var temp3 = (0.04905*diameter)*(0.04905*diameter)
                VS = ((temp1 + temp2) - temp3)
            }
        }

        editTextResult.setText(VS.toString())

        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putFloat(tree.toString(), VS.toFloat())
            apply()
        }
    }


}