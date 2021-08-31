package com.example.reservamesas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
///Autor: Pedro Citadin Coelho
public class MainActivity extends AppCompatActivity {
    private EditText txtUser, txtSenha;
    private HashMap login;
    private TextView txtErro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        login = new HashMap<String, String>();
        login.put("Administrador", "Administrador");
        login.put("Adm", "Adm123");
        login.put("Administrator", "Que3B1eng4ElT0r0");
        login.put("Root", "pr0m1uscu0");
        Button btnLogin = findViewById(R.id.btnLogin);
        txtUser = findViewById(R.id.txtUser);
        txtSenha = findViewById(R.id.txtSenha);
        txtErro = findViewById(R.id.informaErro);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if(txtUser.getText().toString().isEmpty()){
                    txtUser.setError("Usuário em branco!");
                }else if(txtSenha.getText().toString().isEmpty()){
                    txtSenha.setError("Senha em branco!");
                }else{
                    Object lo = login.getOrDefault(txtUser.getText().toString(), "nulo");
                    if (lo.equals(txtSenha.getText().toString())){
                            startActivity(new Intent(MainActivity.this, ReservaActivity.class));
                    }else{
                        txtErro.setVisibility(1);
                    }
                }
            }
        });
    }
}