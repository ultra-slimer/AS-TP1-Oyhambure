package com.example.tp1_oyhambure;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Part2Activity extends AppCompatActivity {
    EditText Texto;
    CheckBox Chequi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);
        Texto = findViewById(R.id.Texto);
        Chequi = findViewById(R.id.LimitCheck);
        Chequi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(Chequi.isChecked()){
                    Texto.setFilters(new InputFilter[] {new InputFilter.LengthFilter(10)});
                    CharSequence LOLO = Texto.getText().subSequence(0, 10);
                    Texto.setText(LOLO);
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
        /*else {
            Call = new Intent(this, Part3Activity.class);
        }*/
        else {
            return;
        }
        startActivity(Call);
    }
    /*public void MostrarLetras(View Vistaza){

    }*/
}
