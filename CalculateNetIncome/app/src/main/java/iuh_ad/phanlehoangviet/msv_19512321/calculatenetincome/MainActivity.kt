import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import iuh_ad.phanlehoangviet.msv_19512321.calculatenetincome.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var gross: Double = 0.0
    private var taxRate: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun calcTax() {
            val txtInput = grossIncome.text.toString()

            if (txtInput != "") {
                gross = txtInput.toDouble()

                taxRate = when {
                    radioHigh.isChecked -> 0.25
                    radioMedium.isChecked -> 0.2
                    else -> 0.15
                }

                val net_income = gross * (1 - taxRate)


                result.text = "${net_income.toString()}"
            } else {
                Toast.makeText(this, "Input gross income", Toast.LENGTH_SHORT).show()
            }

        }

        button.setOnClickListener() {
            calcTax()
            Toast.makeText(this, gross.toString(), Toast.LENGTH_SHORT).show()
        }


    }

}