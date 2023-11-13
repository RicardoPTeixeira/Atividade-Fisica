package com.ricardo.atividadefisica;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference BD = FirebaseDatabase.getInstance().getReference();
    private EditText txtNome;
    private EditText txtPeso;
    private EditText txtIdade;
    private EditText txtSexo;
    private EditText txtDescritivo;

    private RadioGroup radioGroup;
    private RadioButton radDomingo;
    private RadioButton radSegunda;
    private RadioButton radTerca;
    private RadioButton radQuarta;
    private RadioButton radQuinta;
    private RadioButton radSexta;
    private RadioButton radSabado;

    private Button btnInserir;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        txtPeso = findViewById(R.id.txtPeso);
        txtIdade = findViewById(R.id.txtIdade);
        txtSexo = findViewById(R.id.txtSexo);
        txtDescritivo = findViewById(R.id.txtDescritivo);

        radioGroup = findViewById(R.id.radioGroup);
        radDomingo = findViewById(R.id.radDomingo);
        radSegunda = findViewById(R.id.radSegunda);
        radTerca = findViewById(R.id.radTerca);
        radQuarta = findViewById(R.id.radQuarta);
        radQuinta = findViewById(R.id.radQuinta);
        radSexta = findViewById(R.id.radSexta);
        radSabado = findViewById(R.id.radSabado);

        btnInserir = findViewById(R.id.btnInserir);

        btnInserir.setOnClickListener(new MainActivity.escutadoBtnInserir());
    }

    public class escutadoBtnInserir implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String i = "";
            String nome = txtNome.getText().toString().trim();
            String peso = txtPeso.getText().toString().trim();
            String idade = txtIdade.getText().toString().trim();
            String sexo = txtSexo.getText().toString().trim();
            int radSelect = radioGroup.getCheckedRadioButtonId();
            String descritivo = txtDescritivo.getText().toString().trim();

            if (nome.equals("")) {
                Toast.makeText(MainActivity.this, "Campo obrigatório! Digite o nome.", Toast.LENGTH_LONG).show();
            } else {
                i = "Nome: "+ nome + ", ";
            }

            if (peso.equals("")) {
                Toast.makeText(MainActivity.this, "Campo obrigatório! Digite o peso.", Toast.LENGTH_LONG).show();
            } else {
                i = i + "peso: "+ peso + ", ";
            }

            if (idade.equals("")) {
                Toast.makeText(MainActivity.this, "Campo obrigatório! Digite a idade.", Toast.LENGTH_LONG).show();
            } else {
                i = i + "idade: "+ idade + ", ";
            }

            if (sexo.equals("")) {
                Toast.makeText(MainActivity.this, "Campo obrigatório! Digite o sexo.", Toast.LENGTH_LONG).show();
            } else {
                i = i + "sexo: "+ sexo + ", ";
            }

            if (radSelect != -1) {
                if (radSelect == R.id.radDomingo) {
                    i = i + "dia da semana: domingo, ";
                } else if (radSelect == R.id.radSegunda) {
                    i = i + "dia da semana: segunda, ";
                } else if (radSelect == R.id.radTerca) {
                    i = i + "dia da semana: terca, ";
                } else if (radSelect == R.id.radQuarta) {
                    i = i + "dia da semana: quarta, ";
                } else if (radSelect == R.id.radQuinta) {
                    i = i + "dia da semana: quinta, ";
                } else if (radSelect == R.id.radSexta) {
                    i = i + "dia da semana: sexta, ";
                } else if (radSelect == R.id.radSabado) {
                    i = i + "dia da semana: sabado, ";
                }
                finish();
            } else {
                Toast.makeText(MainActivity.this, "Campo obrigatório! Selecione um dia da semana.", Toast.LENGTH_SHORT).show();
            }

            if (descritivo.equals("")) {
                Toast.makeText(MainActivity.this, "Campo obrigatório! Digite o descritivo.", Toast.LENGTH_LONG).show();
            } else {
                i = i + "descritivo: "+ descritivo;
            }

            DatabaseReference atividades = BD.child("atividades");
            atividades.child("atividade").setValue(i);
        }
    }
}
