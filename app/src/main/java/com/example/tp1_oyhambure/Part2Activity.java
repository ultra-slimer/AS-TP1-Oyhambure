package com.example.tp1_oyhambure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Part2Activity extends AppCompatActivity {
    private EditText Texto;
    private CheckBox Chequi;
    private EditText Letra;
    private LinearLayout LL;
    private Button botoncito;
    private AppCompatImageButton GetBack;
    private TextView Results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);
        Texto = findViewById(R.id.Texto);
        Chequi = findViewById(R.id.LimitCheck);
        Letra = findViewById(R.id.Letter);
        LL = findViewById(R.id.IngresoYCheck);
        botoncito = findViewById(R.id.Botoncito);
        GetBack = findViewById(R.id.GetBack);
        Results = findViewById(R.id.Responses);
        Chequi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(Chequi.isChecked()){
                    Texto.setFilters(new InputFilter[] {new InputFilter.LengthFilter(10)});
                    if(Texto.getText().length() > 10){
                        CharSequence LOLO = Texto.getText().subSequence(0, 10);
                        Texto.setText(LOLO);
                    }
                }
                else{
                    Texto.setFilters(new InputFilter[] {new InputFilter.LengthFilter(99999)});
                }
            }
        });
    }
    public void ChangeActivity(View Vistaso) {
        Intent Call;
        Button Pressed;
        Pressed = (Button) Vistaso;
        if (Pressed.getText().toString().contains("1")) {
            Call = new Intent(this, MainActivity.class);
        } else if (Pressed.getText().toString().contains("2")) {
            Call = new Intent(this, Part2Activity.class);
        }
        else {
            Call = new Intent(this, Part3Activity.class);
        }
        startActivity(Call);
    }
    public void MostrarLetras(View Vistaza){
        String Buscado = String.valueOf(Letra.getText());
        String Textito = String.valueOf(Texto.getText());
        String Comp = "";
        int Count = 0;
        int CountOpp = 0;
        if(Buscado.length() != 0 && Textito.length() != 0) {
            for (int i = 0; i < Textito.length(); i++) {
                String Idexito = Textito.substring(i, i + 1);
                if (Idexito.contains(Buscado)) {
                    Count++;
                }
                else if(Idexito.contains(Buscado.toLowerCase()) || Idexito.contains(Buscado.toUpperCase())){
                    CountOpp++;
                }
            }
            LL.setVisibility(View.GONE);
            botoncito.setVisibility(View.GONE);
            Letra.setVisibility(View.GONE);
            GetBack.setVisibility(View.VISIBLE);
            Results.setVisibility(View.VISIBLE);
            if(Buscado != Buscado.toLowerCase()){
                Results.setText("La cantidad de letras \"" + Buscado + "\" es: " + Count + " y para \"" + Buscado.toLowerCase() + "\" hay: " + CountOpp);
            }
            else if (Buscado != Buscado.toUpperCase()){
                Results.setText("La cantidad de letras \"" + Buscado + "\" es: " + Count + " y para \"" + Buscado.toUpperCase() + "\" hay: " + CountOpp);
            }
            else{
                Results.setText("La cantidad de letras \"" + Buscado + "\" es: " + Count);
            }
        }
        else{
            Toast.makeText(this, "Por favor ingrese alguna letra a buscar", Toast.LENGTH_LONG).show();
        }
    }
    public void GetBack(View Vistosito) {
        LL.setVisibility(View.VISIBLE);
        botoncito.setVisibility(View.VISIBLE);
        Letra.setVisibility(View.VISIBLE);
        GetBack.setVisibility(View.GONE);
        Results.setVisibility(View.GONE);
        Texto.setText("");
        Letra.setText("");
    }
}
