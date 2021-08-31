package com.example.reservamesas.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.reservamesas.R;

public class Reservas extends AppCompatActivity {
    private final Boolean[] mesas;
    private final Button[] allbtn;
    private final LinearLayout[] allLnl;
    private final TextView[] allTxt;
    private final SharedPreferences sp;
    private final int branco, preto;
    public Reservas(Boolean[] mesas, Button[] allbtn, LinearLayout[] allLnl, TextView[] allTxt, Activity activity, int branco, int preto) {
        this.mesas = mesas;
        this.allbtn = allbtn;
        this.allLnl = allLnl;
        this.allTxt = allTxt;
        this.preto = preto;
        this.branco = branco;
        sp = PreferenceManager.getDefaultSharedPreferences(activity);

    }

    public void reservaMesa(int numMesa){
        mesas[numMesa] = true;
        allLnl[numMesa].setBackgroundResource(sp.getInt("mReservadas", R.color.vermelho));
        allbtn[numMesa].setEnabled(false);
        if(sp.getInt("mReservadas", R.color.vermelho)==R.color.branco){
            allTxt[numMesa].setTextColor(preto);
        }else{
            allTxt[numMesa].setTextColor(branco);
        }

    }
    public void liberaMesa(int numMesa){
        mesas[numMesa] = false;
        allLnl[numMesa].setBackgroundResource(sp.getInt("mLivres",R.color.azulescuro));
        allbtn[numMesa].setEnabled(true);

        if(sp.getInt("mLivres", R.color.vermelho)==R.color.branco){
            allTxt[numMesa].setTextColor(preto);
        }else{
            allTxt[numMesa].setTextColor(branco);
        }
    }
    public void reservaTodas(){
        for (int i = 0; i<9;i++){
            mesas[i] = true;
            allLnl[i].setBackgroundResource(sp.getInt("mReservadas", R.color.vermelho));
            allbtn[i].setEnabled(false);
            if(sp.getInt("mReservadas", R.color.vermelho)==R.color.branco){
                allTxt[i].setTextColor(preto);
            }else{
                allTxt[i].setTextColor(branco);
            }
        }
    }
    public boolean retornaCheia(){
        for (int i =0; i<9;i++){
            if(!mesas[i]){

                return false;

            }
        }
        return true;
    }
    public Boolean[] retornaMesas(){
        return mesas;
    }

    public void configMesas(){
        System.out.println(mesas[5]);
        for(int i =0 ;i<9; i++){
            if(mesas[i]){

                allLnl[i].setBackgroundResource(sp.getInt("mReservadas", R.color.vermelho));
                allbtn[i].setEnabled(false);
                if(sp.getInt("mReservadas", R.color.vermelho)==R.color.branco){
                    allTxt[i].setTextColor(preto);
                }else{
                    allTxt[i].setTextColor(branco);
                }
            }else{
                allLnl[i].setBackgroundResource(sp.getInt("mLivres",R.color.azulescuro));
                allbtn[i].setEnabled(true);
                if(sp.getInt("mLivres", R.color.vermelho)==R.color.branco){
                    allTxt[i].setTextColor(preto);
                }else{
                    allTxt[i].setTextColor(branco);
                }

            }
        }
    }
    @SuppressLint("NonConstantResourceId")
    public Boolean verificaCores(int idL, int idR){
        int cor1=-1, cor2=-1;
        switch (idL){
            case R.id.vermelhoL: cor1=0; break;
            case R.id.verdeL: cor1 = 1;break;
            case R.id.amareloL:cor1 =2;break;
            case R.id.azulL:cor1 = 3;break;
            case R.id.pretoL: cor1 = 4;break;
            case R.id.brancoL: cor1 = 5;break;
            case R.id.marromL: cor1 = 6;break;
        }
        switch (idR){
            case R.id.vermelhoR: cor2=0; break;
            case R.id.verdeR: cor2 = 1;break;
            case R.id.amareloR:cor2 =2;break;
            case R.id.azulR:cor2 = 3;break;
            case R.id.pretoR: cor2 = 4;break;
            case R.id.brancoR: cor2 = 5;break;
            case R.id.marromR: cor2 = 6;break;
        }

        System.out.println(cor1);
        System.out.println(cor2);
        return cor1 == cor2;
    }
    @SuppressLint("NonConstantResourceId")
    public int[] retornaCores(int idL, int idR){
        int cor1 = -1, cor2= -1;
        switch (idL){
            case R.id.vermelhoL: cor1=R.color.vermelho; break;
            case R.id.verdeL: cor1 = R.color.verde;break;
            case R.id.amareloL:cor1 =R.color.amarelo;break;
            case R.id.azulL:cor1 = R.color.azul;break;
            case R.id.pretoL: cor1 = R.color.preto;break;
            case R.id.brancoL: cor1 = R.color.branco;break;
            case R.id.marromL: cor1 = R.color.marrom;break;
        }
        switch (idR){
            case R.id.vermelhoR: cor2=R.color.vermelho; break;
            case R.id.verdeR: cor2 = R.color.verde;break;
            case R.id.amareloR:cor2 =R.color.amarelo;break;
            case R.id.azulR:cor2 = R.color.azul;break;
            case R.id.pretoR: cor2 = R.color.preto;break;
            case R.id.brancoR: cor2 = R.color.branco;break;
            case R.id.marromR: cor2 = R.color.marrom;break;
        }
        return new int[]{cor1, cor2};
    }
    @SuppressLint("NonConstantResourceId")
    public int[] retornaCoresInv(int idL, int idR){
        int cor1 = -1, cor2= -1;
        switch (idL){
            case R.color.vermelho: cor1=R.id.vermelhoL; break;
            case R.color.verde: cor1 = R.id.verdeL;break;
            case R.color.amarelo:cor1 =R.id.amareloL;break;
            case R.color.azul:cor1 = R.id.azulL;break;
            case R.color.preto: cor1 = R.id.pretoL;break;
            case R.color.branco: cor1 = R.id.brancoL;break;
            case R.color.marrom: cor1 = R.id.marromL;break;
        }
        switch (idR){
            case R.color.vermelho: cor2=R.id.vermelhoR; break;
            case R.color.verde: cor2 = R.id.verdeR;break;
            case R.color.amarelo:cor2 =R.id.amareloR;break;
            case R.color.azul:cor2 = R.id.azulR;break;
            case R.color.preto: cor2 = R.id.pretoR;break;
            case R.color.branco: cor2 = R.id.brancoR;break;
            case R.color.marrom: cor2 = R.id.marromR;break;
        }
        return new int[]{cor1, cor2};
    }

}
