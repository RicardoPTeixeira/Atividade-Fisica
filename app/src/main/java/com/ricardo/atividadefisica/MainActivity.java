package com.ricardo.atividadefisica;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReference  = FirebaseDatabase.getInstance().getReference();
    private TextView nome;
    private TextView peso;
    private TextView idade;
    private TextView sexo;
    private TextView diaDaSemana;
    private TextView descritivo;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById( R.id.nome );
        peso = findViewById( R.id.peso );
        idade = findViewById( R.id.idade );
        sexo = findViewById( R.id.sexo );
        diaDaSemana = findViewById( R.id.diaDaSemana );
        descritivo = findViewById( R.id.descritivo );

        databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if ( snapshot.exists() ) {
                    Dados d = snapshot.getValue(Dados.class);
                    nome.setText(d.getNome());
                    peso.setText(d.getPeso());
                    idade.setText(d.getIdade());
                    sexo.setText((d.getSexo()));
                    diaDaSemana.setText((d.getDiaDaSemana()));
                    descritivo.setText((d.getDescritivo()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Button btnSwitchActivity = findViewById(R.id.btnSwitchActivity);
        btnSwitchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Atividades.class);
                startActivity(intent);
            }
        });
    }
}


