package iuh_ad.phanlehoangviet.msv_19512321.changemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var unformatedTxtInput: String = ""
    private val elements = arrayOf(
        R.id.amount20Dollar,
        R.id.amount10Dollar,
        R.id.amount5Dollar,
        R.id.amount1Dollar,
        R.id.amount25Cent,
        R.id.amount10Cent,
        R.id.amount5Cent,
        R.id.amount1Cent)


    // Create
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrayOf<View>(
            findViewById(R.id.zeroButton),
            findViewById(R.id.oneButton),
            findViewById(R.id.twoButton),
            findViewById(R.id.threeButton),
            findViewById(R.id.fourButton),
            findViewById(R.id.fiveButton),
            findViewById(R.id.sixButton),
            findViewById(R.id.sevenButton),
            findViewById(R.id.eightButton),
            findViewById(R.id.nineButton),
            findViewById(R.id.clearButton)
        ).forEach { it -> it.setOnClickListener(this) }
    }


    // Savingg
    override fun onSaveInstanceState(outState: Bundle) {
        var txtInput: TextView = findViewById(R.id.total_number)
        outState.putString("txtInput", txtInput.text.toString())
        super.onSaveInstanceState(outState)
    }


    // Restore
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        var txtInput: TextView = findViewById(R.id.total_number)
        txtInput.text = savedInstanceState.getString("txtInput")
    }


    // Onclick
    override fun onClick(v: View) {
        val value = getValue(v)
        var txtInput: TextView = findViewById(R.id.total_number)
        // update value
        if (value == -1) {
            unformatedTxtInput = ""
            txtInput.text = ""
            elements.forEach { it ->
                var elementAmount: TextView = findViewById(it)
                elementAmount.text = "0"
            }
            return
        } else {
            unformatedTxtInput += value.toString()
            unformatedTxtInput = unformatedTxtInput.toInt().toString()
        }
        var parsedNumber = unformatedTxtInput.toDouble() / 100.0
        txtInput.text = parsedNumber.toString()

        // processing step
        val numbers = arrayOf(20.0, 10.0, 5.0, 1.0, 0.25, 0.1, 0.05, 0.01)

        for (i in numbers.indices) {
            var amounts = (parsedNumber / numbers[i]).toInt()
            var elementAmount: TextView = findViewById(elements[i])
            elementAmount.text = amounts.toString()
            parsedNumber -= amounts.toDouble() * numbers[i]
        }
    }



    // get Value
    fun getValue(v: View): Int {
        return when (v.id) {
            R.id.zeroButton -> 0
            R.id.oneButton -> 1
            R.id.twoButton -> 2
            R.id.threeButton -> 3
            R.id.fourButton -> 4
            R.id.fiveButton -> 5
            R.id.sixButton -> 6
            R.id.sevenButton -> 7
            R.id.eightButton -> 8
            R.id.nineButton -> 9
            else -> -1
        }
    }
}