package com.example.reservamesas;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.reservamesas.dialog.ConfigDialog;
import com.example.reservamesas.util.Reservas;

public class ReservaActivity extends AppCompatActivity {
    private EditText txtNumMesa;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        sp = PreferenceManager.getDefaultSharedPreferences(ReservaActivity.this);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);


        Button btnSalvar = findViewById(R.id.btnSalvar);
        Button btnLiberar = findViewById(R.id.btnLiberar);
        Button btnTodas = findViewById(R.id.btnReservaTudo);
        Button btnConfig = findViewById(R.id.btnConfig);
        txtNumMesa = findViewById(R.id.txtNumMesa);
        LinearLayout lnl1 = findViewById(R.id.lnl1);
        LinearLayout lnl2 = findViewById(R.id.lnl2);
        LinearLayout lnl3 = findViewById(R.id.lnl3);
        LinearLayout lnl4 = findViewById(R.id.lnl4);
        LinearLayout lnl5 = findViewById(R.id.lnl5);
        LinearLayout lnl6 = findViewById(R.id.lnl6);
        LinearLayout lnl7 = findViewById(R.id.lnl7);
        LinearLayout lnl8 = findViewById(R.id.lnl8);
        LinearLayout lnl9 = findViewById(R.id.lnl9);
        TextView n1 = findViewById(R.id.n1);
        TextView n2 = findViewById(R.id.n2);
        TextView n3 = findViewById(R.id.n3);
        TextView n4 = findViewById(R.id.n4);
        TextView n5 = findViewById(R.id.n5);
        TextView n6 = findViewById(R.id.n6);
        TextView n7 = findViewById(R.id.n7);
        TextView n8 = findViewById(R.id.n8);
        TextView n9 = findViewById(R.id.n9);
        Button[] allbtn = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        LinearLayout[] allLnl = {lnl1, lnl2, lnl3, lnl4, lnl5, lnl6, lnl7, lnl8, lnl9};
        TextView[] alltxt = {n1, n2, n3, n4, n5, n6, n7, n8, n9};
        Boolean[] allMesas = {sp.getBoolean("m1", false), sp.getBoolean("m2", false), sp.getBoolean("m3", false), sp.getBoolean("m4", false), sp.getBoolean("m5", false), sp.getBoolean("m6", false), sp.getBoolean("m7", false), sp.getBoolean("m8", false), sp.getBoolean("m9", false), };
        Reservas reserv = new Reservas(allMesas,allbtn, allLnl, alltxt, ReservaActivity.this, getResources().getColor(R.color.branco), getResources().getColor(R.color.preto));
        reserv.configMesas();
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               reserv.reservaMesa(0);


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                reserv.reservaMesa(1);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                reserv.reservaMesa(2);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                reserv.reservaMesa(3);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                reserv.reservaMesa(4);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                reserv.reservaMesa(5);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                reserv.reservaMesa(6);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                reserv.reservaMesa(7);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                reserv.reservaMesa(8);
            }
        });
        btnLiberar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               reserv.liberaMesa(Integer.parseInt(txtNumMesa.getText().toString())-1);
            }
        });
        btnTodas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reserv.retornaCheia()){
                    AlertDialog.Builder erro = new AlertDialog.Builder(ReservaActivity.this);
                    erro.setTitle("Aviso!");
                    erro.setMessage(R.string.msgTodasReservadas);
                    erro.setCancelable(true);

                    erro.create();
                    erro.show();
                }else{
                    reserv.reservaTodas();

                }
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sp.edit();
                editor.putBoolean("m1", reserv.retornaMesas()[0]);
                editor.putBoolean("m2", reserv.retornaMesas()[1]);
                editor.putBoolean("m3", reserv.retornaMesas()[2]);
                editor.putBoolean("m4", reserv.retornaMesas()[3]);
                editor.putBoolean("m5", reserv.retornaMesas()[4]);
                editor.putBoolean("m6", reserv.retornaMesas()[5]);
                editor.putBoolean("m7", reserv.retornaMesas()[6]);
                editor.putBoolean("m8", reserv.retornaMesas()[7]);
                editor.putBoolean("m9", reserv.retornaMesas()[8]);
                editor.apply();
            }
        });
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigDialog dialog = new ConfigDialog(ReservaActivity.this);

                dialog.show(reserv);



            }
        });
    }
}
