package iuh_ad.phanlehoangviet.msv_19512321.calculatingnetincome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private var grossIncome: Double = 0.0
    private var taxRate: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun calcTax() {
            val txtInput = input.text.toString()
            val sw1 = findViewById<Switch>(R.id.rni)
            sw1?.setOnCheckedChangeListener{ _ , isChecked ->
                if (isChecked) {
                    if (txtInput != "") {
                        grossIncome = txtInput.toDouble()

                        taxRate = when {
                            bt_high.isChecked -> 0.2
                            bt_medium.isChecked -> 0.1
                            else -> 0.15
                        }

                        val net_income = kotlin.math.round(grossIncome * (1 - taxRate))

                        val formattedNetIncome = NumberFormat.getCurrencyInstance().format(net_income)
                        output.text = "${formattedNetIncome.toString()}"
                    } else {
                        Toast.makeText(this, "Input gross income", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    if (txtInput != "") {
                        grossIncome = txtInput.toDouble()

                        taxRate = when {
                            bt_high.isChecked -> 0.25
                            bt_medium.isChecked -> 0.2
                            else -> 0.15
                        }

                        val net_income = grossIncome * (1 - taxRate)

                        val formattedNetIncome = NumberFormat.getCurrencyInstance().format(net_income)
                        output.text = "${formattedNetIncome.toString()}"
                    } else {
                        Toast.makeText(this, "Input gross income", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            if (txtInput != "") {
                grossIncome = txtInput.toDouble()

                taxRate = when {
                    bt_high.isChecked -> 0.25
                    bt_medium.isChecked -> 0.2
                    else -> 0.15
                }

                val net_income = grossIncome * (1 - taxRate)

                val formattedNetIncome = NumberFormat.getCurrencyInstance().format(net_income)
                output.text = "${formattedNetIncome.toString()}"
            } else {
                Toast.makeText(this, "Input gross income", Toast.LENGTH_SHORT).show()
            }

        }

        bt_calculate.setOnClickListener() {
            calcTax()
            Toast.makeText(this, grossIncome.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}