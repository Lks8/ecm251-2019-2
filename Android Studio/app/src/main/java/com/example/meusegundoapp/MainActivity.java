package com.example.meusegundoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private TextView resultado;
    private Button btnSomar;
    @BindView(R.id.btnSubtrair)
    protected Button btnSubtrair;

//    private Button btnMultiplicar;
//    private Button btnDividir;

    @OnClick(R.id.btnSubtrair)
    void subtrair(){
        double n1,n2;
        try{
            n1 = Double.parseDouble(etNum1.getText().toString());
            n2 = Double.parseDouble(etNum2.getText().toString());
            resultado.setText("Resultado:" + (n1-n2));
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"Insira algum número, seu corno", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        etNum1 = (EditText)findViewById(R.id.etPrimeiroNumero);
        etNum2 = (EditText)findViewById(R.id.etSegundoNumero);
        resultado = (TextView) findViewById(R.id.tvResultado);
        btnSomar = (Button) findViewById(R.id.btnSomar);
        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1, n2;
                n1 = Double.parseDouble(etNum1.getText().toString());
                n2 = Double.parseDouble(etNum2.getText().toString());
                resultado.setText("Resultado:" + (n1+n2));
            }
        });
//        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
//        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                double n1, n2;
//                n1 = Double.parseDouble(etNum1.getText().toString());
//                n2 = Double.parseDouble(etNum2.getText().toString());
//                resultado.setText("Resultado:" + (n1*n2));
//            }
//        });
//        btnDividir = (Button) findViewById(R.id.btnDividir);
//        btnDividir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                double n1, n2;
//                n1 = Double.parseDouble(etNum1.getText().toString());
//                n2 = Double.parseDouble(etNum2.getText().toString());
//                if(n2==0){
//                    resultado.setText("Resultado: Impossível dividir por 0");
//
//                }else{
//                    resultado.setText("Resultado:" + (n1/n2));
//                }
//
//            }
//        });

    }
}
