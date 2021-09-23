package com.example.provaservice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;

/**
 * MainActivity dell'applicazione si occupa dell'avvio del Service e termina l'applicazione.
 * @author Eugenio De Simone
 */
public class MainActivity extends Activity {

    Context context;

    @Override
    /**
     * Metodo onCreate, il primo metodo che viene avviato all'avvio dell'applicazione,
     * definisce il layout.
     * @param savedInstanceState riferimento al Bundle inviato all'activity.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context= getApplicationContext();

    }

    /**
     * Metodo che si occupa dell'individuazione di una chiamata VoIP.
     * {@link Alfred}
     * @param context Contesto dell'activity
     * @return true se è individuata una chiamata VoIP, false altrimenti
     */
    public  static boolean isVoip(Context context){
        AudioManager manager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        if(manager.getMode()== AudioManager.MODE_IN_COMMUNICATION){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Metodo che si occupa dell'avvio del Service "Alfred"
     *  {@link Alfred}
     * @param ctx Contesto dell'activity
     */
    public static void callingAlfred(Context ctx){
        Intent firstIntent = new Intent(ctx,Alfred.class);
        ctx.startService(firstIntent);
    }
    
    @Override
    /**
     * Metodo onResume sovrascritto, avvia il Service attraverso il metodo {@link #callingAlfred(Context)}
     * e termina l'applicazione, lasciando il Service in esecuzione.
     */
    protected void onResume() {
        super.onResume();
        callingAlfred(context);
        finish();
    }
}