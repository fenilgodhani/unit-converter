package com.example.fenil.convter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String [] units;
    int pos = 0;
    int lastValue = 0;

    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spin = (Spinner)findViewById(R.id.unit_spinner);
        Button btnConvert = (Button)findViewById(R.id.btnConvert);
        final EditText txtEntry = (EditText)findViewById(R.id.txtEntry);

        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(
                this, R.array.unit_arrays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(
                    AdapterView<?> parent, View view, int position, long id) {
                //showToast("Spinner2: position=" + position + " id=" + id);
                pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (txtEntry.getText().toString().trim().length() > 0){
                    String textValue = txtEntry.getText().toString();
                    lastValue = Integer.parseInt(textValue);
                    double km, m, cm,cel,fah;

                    if(pos==0){
                        km = lastValue / 1000;
                        showToast(lastValue + " m = " +  km + " km(s)");
                    }else if(pos==1){
                        m = lastValue * 1000;
                        showToast(lastValue + " km(s) = " +  m + " m");
                    }else if(pos==2){
                        cm = lastValue * 100;
                        showToast(lastValue + " m = " +  cm + " cm(s)");
                    }else if(pos==3){
                        fah = (lastValue-32)*.56;
                        showToast(lastValue + " celsious = " +  fah + " fehren");
                    }else{
                        cel = (1.8*lastValue)+32;
                        showToast(lastValue + " Fahren = " +  cel + " celsious");
                    }
                }
                else{
                    showToast("Please Enter Value");

                }

            }
        });
    }
}
