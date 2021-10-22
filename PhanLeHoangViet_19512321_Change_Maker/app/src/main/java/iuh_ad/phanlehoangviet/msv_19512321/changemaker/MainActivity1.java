//package iuh_ad.phanlehoangviet.msv_19512321.changemaker;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//    private EditText sum;
//    private EditText[] ele = {
////            findViewById(R.id.amount20Dollar),
//            findViewById(R.id.amount10Dollar),
//            findViewById(R.id.amount5Dollar),
//            findViewById(R.id.amount10Dollar),
//            findViewById(R.id.amount25Cent),
//            findViewById(R.id.amount10Cent),
//            findViewById(R.id.amount5Cent),
//            findViewById( R.id.amount1Cent)
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        sum = findViewById(R.id.total_number);
//
//        sum.setShowSoftInputOnFocus(false);
//
//
//
//    }
//
//    private void updateText(String strToAdd) {
//        String oldStr = sum.getText().toString();
//        String leftStr = oldStr.substring(0, oldStr.length());
//        String rightStr = oldStr.substring(oldStr.length());
//        sum.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
//
//        int mySum = 0;
//        int one = 0;
//        try {
//            mySum = Integer.parseInt(sum.getText().toString());
//        } catch(NumberFormatException nfe) {
//            System.out.println("Could not parse " + nfe);
//        }
//
//    }
//
//
//
//    public void zeroBtn(View view){
//        updateText("0");
//    }
//    public void oneBtn(View view){
//        updateText("1");
//    }
//    public void twoBtn(View view){
//        updateText("2");
//    }
//    public void threeBtn(View view){
//        updateText("3");
//    }
//    public void fourBtn(View view){
//        updateText("4");
//    }
//    public void fiveBtn(View view){
//        updateText("5");
//    }
//    public void sixBtn(View view){
//        updateText("6");
//    }
//    public void sevenBtn(View view){
//        updateText("7");
//    }
//    public void eightBtn(View view){
//        updateText("8");
//    }
//    public void nineBtn(View view){
//        updateText("9");
//    }
//    public void clearBtn(View view){
//        sum.setText("");
//    }
//
//
//
//
//}
