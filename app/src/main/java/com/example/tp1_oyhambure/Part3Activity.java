package com.example.tp1_oyhambure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Part3Activity extends AppCompatActivity {
    EditText Invertido;
    Button Hacerlo;
    TextView Resultado;
    androidx.appcompat.widget.AppCompatImageButton ComeTogether;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);
        Invertido = findViewById(R.id.Invertido);
        Hacerlo = findViewById(R.id.Inversor);
        Resultado = findViewById(R.id.Inversion);
        ComeTogether = findViewById(R.id.ComeTogether);
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
    public void Invertir (View Vistacion){
        if (Invertido.getText().length() < 10){
            Toast.makeText(this, "por favor ingrese un texto de 10 caracteres o mas", Toast.LENGTH_LONG).show();
            return;
        }
        String Nueva = "";
        String lowercase = String.valueOf(Invertido.getText()).toLowerCase();
        Invertido.setText(lowercase);
        int len = Invertido.length();
        int lim = len;
        for (int i = 0; i < lim; i++){
            Nueva = Nueva + String.valueOf(Invertido.getText()).substring(len - 1, len);
            len--;
        }
        //Toast.makeText(this, "res: " + Nueva, Toast.LENGTH_LONG).show();
        Invertido.setVisibility(View.GONE);
        Resultado.setVisibility(View.VISIBLE);
        Hacerlo.setVisibility(View.GONE);
        ComeTogether.setVisibility(View.VISIBLE);

        if(Nueva.equals(String.valueOf(Invertido.getText()))) {
            Resultado.setText("Invertida es capicua: " + Invertido.getText());
        }
        else{
            Resultado.setText("Invertida: " + Nueva);
        }
    }
    public void ComeTogether(View Vistosito){
        Invertido.setVisibility(View.VISIBLE);
        Resultado.setVisibility(View.GONE);
        Hacerlo.setVisibility(View.VISIBLE);
        ComeTogether.setVisibility(View.GONE);

        Invertido.setText("");
    }
}
