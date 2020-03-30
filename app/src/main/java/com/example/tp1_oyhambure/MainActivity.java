package com.example.tp1_oyhambure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText Textito1;
    EditText Textito2;
    Button Botoncito;
    //Esta de aca abajo es para poder volver de la pantalla resultados a la pantalla
    //de ingreso de datos.
    AppCompatImageButton GoWest;
    TextView results;
    LinearLayout Limits1;
    LinearLayout Limits2;
    SeekBar Quantity1;
    SeekBar Quantity2;
    TextView Max1;
    TextView Max2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Textito1 = findViewById(R.id.TextBox1);
        Textito2 = findViewById(R.id.TextBox2);
        Botoncito = findViewById(R.id.Botorito);
        results = findViewById(R.id.Results);
        GoWest = findViewById(R.id.GoWest);
        Limits1 = findViewById(R.id.Limits1);
        Limits2 = findViewById(R.id.Limits2);
        Quantity1 = findViewById(R.id.Quantity1);
        Quantity2 = findViewById(R.id.Quantity2);
        Max1 = findViewById(R.id.Max1);
        Max2 = findViewById(R.id.Max2);
        //Esto de aca cumple la funcion de detectar cuando el texto cambia y que accion tomar antes
        //durante y despues del cambio del codigo
        Textito1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Quantity1.setMax(s.length());
                Max1.setText(String.valueOf(s.length()));
            }
        });
        Textito2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Quantity2.setMax(s.length());
                Max2.setText(String.valueOf(s.length()));
            }
        });
    }

    public void ApretaElBoton(View Vision) {

        if (Textito1.getText().toString().length() < Quantity1.getProgress() ||
                Textito2.getText().toString().length() < Quantity2.getProgress()) {
            //En caso de que esto se ejecute, corran por sus vidas
            String Message = ("ERROR: Largo pedido excede algun largo de los textos");
            Toast.makeText(this, Message, Toast.LENGTH_SHORT);
            return;
        }
        String Texto1 = Textito1.getText().toString();
        String Texto2 = Textito2.getText().toString();

        int Largo1 = Texto1.length();
        int Largo2 = Texto2.length();

        String Diferencia;
        if (Largo1 == Largo2) {
            Diferencia = "None";
        } else {
            int Diff = Largo1 - Largo2;
            if (Diff < 0) {
                Diff = Diff * -1;
            }
            Diferencia = String.valueOf(Diff);
        }
        String Concatenar = (Texto1.substring(0, Quantity1.getProgress()) + Texto2.substring(0, Quantity2.getProgress()));
        //Estos de aca son innecesarios para los resultados asi que se pueden retirar
        Textito1.setVisibility(View.GONE);
        Textito2.setVisibility(View.GONE);
        Botoncito.setVisibility(View.GONE);
        Quantity1.setVisibility(View.GONE);
        Quantity2.setVisibility(View.GONE);
        Limits1.setVisibility(View.GONE);
        Limits2.setVisibility(View.GONE);
        //Estos me sirven mucho para los resultados asi que deben de estar presentes
        GoWest.setVisibility(View.VISIBLE);
        results.setVisibility(View.VISIBLE);

        Textito1.setText("");
        Textito2.setText("");

        results.setText("Largo Texto 1: " + Largo1 + " caracteres\n" +
                "Largo Texto 2: " + Largo2 + " caracteres\n" +
                "Diferencia Largo de textos: " + Diferencia +
                " caracteres\n" +
                "Concatenado de los caracteres: " + Concatenar);
    }
    public void GoWest(View Vision) {
        results.setText("");
        //Estos me sirven mucho para los resultados asi que deben de estar presentes
        Textito1.setVisibility(View.VISIBLE);
        Textito2.setVisibility(View.VISIBLE);
        Botoncito.setVisibility(View.VISIBLE);
        Quantity1.setVisibility(View.VISIBLE);
        Quantity2.setVisibility(View.VISIBLE);
        Limits1.setVisibility(View.VISIBLE);
        Limits2.setVisibility(View.VISIBLE);
        //Estos de aca son innecesarios para los resultados asi que se pueden retirar
        GoWest.setVisibility(View.GONE);
        results.setVisibility(View.GONE);
        Quantity1.refreshDrawableState();
        Quantity2.refreshDrawableState();
    }
    public void ChangeActivity(View Vistaso){
        Intent Call;
        Button Pressed;
        Pressed = (Button)Vistaso;
        if(Pressed.getText().toString().contains("1")) {
            Toast.makeText(this, "Vamos al 1", Toast.LENGTH_SHORT);
            Call = new Intent(this, MainActivity.class);
        }
        else if(Pressed.getText().toString().contains("2")){
            Call = new Intent(this, Part2Activity.class);
        }
        /*else {
            Call = new Intent(this, Part3Activity.class);
        }*/
        else{
            return;
        }
        startActivity(Call);
    }
}