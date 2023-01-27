package com.gnsfilho01.calorias;

import static java.lang.Double.parseDouble;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView resultado;
    private EditText totalProduto;
    private EditText totalPorcao;
    private EditText calpporcao;

    Button popupBTN;
    Dialog mDialog;


    RadioGroup radioGroup;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Título do diálogo");
//        builder.setMessage("Mensagem do diálogo");
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                //Ação a ser tomada ao clicar no botão OK
//            }
//        });
//        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                //Ação a ser tomada ao clicar no botão Cancelar
//            }
//        });
//
//        AlertDialog dialog = builder.create();
//        dialog.show();

        

        resultado = findViewById(R.id.textResultado);
        totalProduto = findViewById(R.id.totProduto);
        totalPorcao = findViewById(R.id.totPorcao);
        calpporcao = findViewById(R.id.calPorcao);



        radioGroup = findViewById(R.id.radioGroup);

        popupBTN = findViewById(R.id.popupBTN);
        mDialog = new Dialog(this);




        popupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.setContentView(R.layout.popup);

                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                mDialog.show();
            }
        });

        popupBTN.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View view, MotionEvent motionEvent) {
                mDialog.setContentView(R.layout.popup);

                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                mDialog.show();
                return false;
            }

        });


    }

        public void checkButton(View v){
            int radioId = radioGroup.getCheckedRadioButtonId();

            radioButton = findViewById(radioId);

            Toast.makeText(this, "Você escolheu: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
         }


    public void calcCalorias(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        if(totalProduto.getText().toString().equals("")){
            totalProduto.setError("Obigatório");
            resultado.setText("Há campo(s) em branco!");
            totalProduto.setHint("Quantas(os) " + radioButton.getText() + "?");
            totalProduto.requestFocus();
        }else if(totalPorcao.getText().toString().equals("")){
            totalPorcao.setError("Obigatório");
            resultado.setText("Há campo(s) em branco!");
            totalPorcao.requestFocus();
        }else if(calpporcao.getText().toString().equals("")){
            calpporcao.setError("Obigatório");
            resultado.setText("Há campo(s) em branco!");
            calpporcao.requestFocus();
        }else{

            if(radioButton.getText().toString().equals("ml/grama")){
                double totalCal = (parseDouble(totalProduto.getText().toString()) /
                        parseDouble(totalPorcao.getText().toString())) *
                        parseDouble(calpporcao.getText().toString());

                DecimalFormat df = new DecimalFormat(".00");

                resultado.setText(df.format(totalCal) + " Calorias");

            }else if(radioButton.getText().toString().equals("litro/kg")){
                double totalCal = ((parseDouble(totalProduto.getText().toString()) * 1000) /
                        parseDouble(totalPorcao.getText().toString())) *
                        parseDouble(calpporcao.getText().toString());

                DecimalFormat df = new DecimalFormat(".00");

                resultado.setText(df.format(totalCal) + " Calorias");

            }else{

            }

        }

    }

}