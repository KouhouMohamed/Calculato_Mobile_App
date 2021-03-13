package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int nbrResult;
    double res;
    TextView[] listHistoric;
    Button btn;
    Button remove_Btn;
    TextView txt;
    TextView rs;
    double number;
    TextView multyplOfnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.listHistoric =  new TextView[]{findViewById(R.id.res1), findViewById(R.id.res2), findViewById(R.id.res3), findViewById(R.id.res4), findViewById(R.id.res5)};
        this.btn = findViewById(R.id.Btn_Calcul);
        this.remove_Btn = findViewById(R.id.remove);
        this.txt = findViewById(R.id.calculate_number);
        this.rs = findViewById(R.id.result);
        this.multyplOfnumber = findViewById(R.id.multipleOfNumber);
        if(multyplOfnumber.getText().equals("")){
            multyplOfnumber.setText("1");
        }
        this.number = Double.parseDouble(String.valueOf(multyplOfnumber.getText()));

        this.btn.setOnClickListener(event->{
            if(multyplOfnumber.getText().equals("")){
                multyplOfnumber.setText("1");
            }
            this.number = Double.parseDouble(String.valueOf(multyplOfnumber.getText()));
            this.res = Double.parseDouble(String.valueOf(this.txt.getText()));
            this.res *= this.number;
            String his = txt.getText() + " * " +this.number + " = " + this.res;
            this.rs.setText(String.valueOf(this.res));

            TextView t = this.listHistoric[0];

            int j = this.listHistoric.length-1;
            while(j>0){
                this.listHistoric[j].setText(this.listHistoric[j-1].getText());
                j--;
            }
            t.setText(his);
            this.txt.setText("");
        });
        this.remove_Btn.setOnClickListener(event->{
            int i = 0;
            while(i<this.listHistoric.length){
                this.listHistoric[i].setText("");
                i++;
            }

        });
    }
}