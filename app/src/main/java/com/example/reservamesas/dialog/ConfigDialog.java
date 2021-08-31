package com.example.reservamesas.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.reservamesas.R;
import com.example.reservamesas.util.Reservas;

public class ConfigDialog {
    private final Activity activity;
    private AlertDialog dialog;
    private RadioGroup rbtnLivres, rbtnReservadas;
    private final SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public ConfigDialog(Activity activity){
        this.activity = activity;
        sp = PreferenceManager.getDefaultSharedPreferences(activity);
    }

    public void show(Reservas r){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View view =  inflater.inflate(R.layout.dialog_config, null);
        builder.setView(view);
        builder.setCancelable(false);
        rbtnLivres = view.findViewById(R.id.rbtnLivres);
        int []btns = r.retornaCoresInv(sp.getInt("mLivres", R.color.azulescuro), sp.getInt("mReservadas", R.color.vermelho));
        RadioButton btnlivres = view.findViewById(btns[0]);
        RadioButton btnreservadas = view.findViewById(btns[1]);
        btnlivres.setChecked(true);
        btnreservadas.setChecked(true);
        rbtnReservadas = view.findViewById(R.id.rbtnReservadas);
        Button btnSalvarCores = view.findViewById(R.id.btnSalvarCores);
        btnSalvarCores.setOnClickListener(v -> {

            if(r.verificaCores(rbtnLivres.getCheckedRadioButtonId(), rbtnReservadas.getCheckedRadioButtonId())){
                Toast.makeText(activity.getApplicationContext(), R.string.msgCoresIguais, Toast.LENGTH_SHORT).show();
            }else{
                editor = sp.edit();
                int[] cores = r.retornaCores(rbtnLivres.getCheckedRadioButtonId(), rbtnReservadas.getCheckedRadioButtonId());
                editor.putInt("mLivres", cores[0]);
                editor.putInt("mReservadas", cores[1]);
                editor.apply();
                r.configMesas();
                dialog.cancel();


            }
        });
        dialog = builder.create();
        dialog.show();


    }
}
