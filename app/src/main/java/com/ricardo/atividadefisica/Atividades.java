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

public class Atividades extends AppCompatActivity {
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
        setContentView(R.layout.atividades);

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

        btnInserir.setOnClickListener(new Atividades.escutadoBtnInserir());
    }

    public class escutadoBtnInserir implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String nome = txtNome.getText().toString().trim();
            String peso = txtPeso.getText().toString().trim();
            String idade = txtIdade.getText().toString().trim();
            String sexo = txtSexo.getText().toString().trim();
            String diaDaSemana = "";
            String descritivo = txtDescritivo.getText().toString().trim();

            int radSelect = radioGroup.getCheckedRadioButtonId();

            if (nome.equals("")) {
                Toast.makeText(Atividades.this, "Campo obrigatório! Digite o nome.", Toast.LENGTH_LONG).show();
            }

            if (peso.equals("")) {
                Toast.makeText(Atividades.this, "Campo obrigatório! Digite o peso.", Toast.LENGTH_LONG).show();
            }

            if (idade.equals("")) {
                Toast.makeText(Atividades.this, "Campo obrigatório! Digite a idade.", Toast.LENGTH_LONG).show();
            }

            if (sexo.equals("")) {
                Toast.makeText(Atividades.this, "Campo obrigatório! Digite o sexo.", Toast.LENGTH_LONG).show();
            }

            if (radSelect != -1) {
                if (radSelect == R.id.radDomingo) {
                    diaDaSemana = "Domingo";
                } else if (radSelect == R.id.radSegunda) {
                    diaDaSemana = "Segunda";
                } else if (radSelect == R.id.radTerca) {
                    diaDaSemana = "Terca";
                } else if (radSelect == R.id.radQuarta) {
                    diaDaSemana = "Quarta";
                } else if (radSelect == R.id.radQuinta) {
                    diaDaSemana = "Quinta";
                } else if (radSelect == R.id.radSexta) {
                    diaDaSemana = "Sexta";
                } else if (radSelect == R.id.radSabado) {
                    diaDaSemana = "Sabado";
                }
                finish();
            } else {
                Toast.makeText(Atividades.this, "Campo obrigatório! Selecione um dia da semana.", Toast.LENGTH_SHORT).show();
            }

            if (descritivo.equals("")) {
                Toast.makeText(Atividades.this, "Campo obrigatório! Digite o descritivo.", Toast.LENGTH_LONG).show();
            }

            Dados d = new Dados( nome, peso, idade, sexo, diaDaSemana, descritivo );

            BD.child("dados").setValue(d);

            Intent intent = new Intent(Atividades.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
