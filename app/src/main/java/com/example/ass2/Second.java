package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    Button con;
    TextView result ;

    TextView cal ;
    EditText num;

    Button reset;

    Button view;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        con = findViewById(R.id.btn);
        reset=findViewById(R.id.btn2);
        result = findViewById(R.id.res);
        view=findViewById(R.id.rec);
        cal=findViewById(R.id.cal);
        num = findViewById(R.id.num);
        sp=getSharedPreferences("Result", Context.MODE_PRIVATE);
        Spinner s1= findViewById(R.id.sp1);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.Units,
                R.layout.selected_item);
        adapter.setDropDownViewResource(R.layout.selected_item);
        s1.setAdapter(adapter);

        Spinner s2= findViewById(R.id.sp2);
        ArrayAdapter <CharSequence> adapter1= ArrayAdapter.createFromResource(this,R.array.Units,
                R.layout.selected_item);
        adapter1.setDropDownViewResource(R.layout.selected_item);
        s2.setAdapter(adapter1);

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = (String) s1.getSelectedItem();
                String str2= (String) s2.getSelectedItem();
                if(str1.equals(str2)) {
                    result.setText(num.getText());
                }
                else {
                    if (str1.equals("cm") && str2.equals("m")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) / 100;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "/" + "100" + "= " + temp + " " + str2);
                    } else if (str1.equals("cm") && str2.equals("km")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) / 100000;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "/" + "100000" + "= " + temp + " " + str2);
                    } else if (str1.equals("m") && str2.equals("cm")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) * 100;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "*" + "100" + "= " + temp + " " + str2);
                    } else if (str1.equals("m") && str2.equals("km")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) / 1000;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "/" + "1000" + "= " + temp + " " + str2);
                    } else if (str1.equals("km") && str2.equals("m")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) * 1000;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "*" + "100" + "= " + temp + " " + str2);
                    } else if (str1.equals("km") && str2.equals("cm")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) * 100000;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "*" + "100000" + "= " + temp + " " + str2);
                    } else if (str1.equals("kg") && str2.equals("gm")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) * 1000;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "*" + "1000" + "= " + temp + " " + str2);
                    } else if (str1.equals("gm") && str2.equals("kg")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) / 1000;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "/" + "1000" + "= " + temp + " " + str2);
                    } else if (str1.equals("day") && str2.equals("h")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) * 24;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "*" + "24" + "= " + temp + " " + str2);
                    } else if (str1.equals("day") && str2.equals("min")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) * 1440;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "*" + "1440" + "= " + temp + " " + str2);
                    } else if (str1.equals("day") && str2.equals("sec")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) * 86400;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "*" + "86400" + "= " + temp + " " + str2);
                    } else if (str1.equals("h") && str2.equals("day")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) / 24;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "/" + "24" + "= " + temp + " " + str2);
                    } else if (str1.equals("h") && str2.equals("min")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) * 60;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "*" + "60" + "= " + temp + " " + str2);
                    } else if (str1.equals("h") && str2.equals("sec")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) * 3600;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "*" + "3600" + "= " + temp + " " + str2);
                    } else if (str1.equals("min") && str2.equals("day")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) * 1440;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "*" + "1440" + "= " + temp + " " + str2);
                    } else if (str1.equals("min") && str2.equals("h")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) / 60;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "/" + "60" + "= " + temp + " " + str2);
                    } else if (str1.equals("min") && str2.equals("sec")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) * 60;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "*" + "60" + "= " + temp + " " + str2);
                    } else if (str1.equals("sec") && str2.equals("day")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) / 86400;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "/" + "86400" + "= " + temp + " " + str2);
                    } else if (str1.equals("sec") && str2.equals("h")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) / 3600;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "/" + "3600" + "= " + temp + " " + str2);
                    } else if (str1.equals("sec") && str2.equals("min")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) / 60;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "/" + "60" + "= " + temp + " " + str2);
                    } else if (str1.equals("L") && str2.equals("ml")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) * 1000;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "*" + "1000" + "= " + temp + " " + str2);
                    } else if (str1.equals("ml") && str2.equals("L")) {
                        double temp = Double.parseDouble(String.valueOf(num.getText())) / 1000;
                        result.setText(temp + " " + str2);
                        cal.setText("Calculation: " + "\n" + " " + num.getText() + "/" + "1000" + "= " + temp + " " + str2);
                    } else
                        result.setText("This operation is NOT valid");
                }

                SharedPreferences.Editor editor=sp.edit();
                editor.putString("Result",result.getText().toString());



            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num.setText("");
                result.setText("");
                cal.setText("");
                s1.setAdapter(adapter);
                s2.setAdapter(adapter1);

            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t1 = new Intent(Second.this,recycler.class);
                startActivity(t1);
                //finish();

            }
        });



    }
}