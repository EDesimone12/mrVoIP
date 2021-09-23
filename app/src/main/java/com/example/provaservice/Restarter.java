package com.example.provaservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * BroadcastReceiver che si occupa del riavvio del Service tramite ForegroundService
 * @author Eugenio De Simone
 */
public class Restarter extends BroadcastReceiver {

    @Override
    /**
     * Metodo che si occupa di ricevere messaggi Broadcast, nello specifico "restartService"
     * indica che occorre riavviare il service mediante ForegroundService.
     */
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("restartService")){

            Intent service = new Intent(context,Alfred.class);
            context.startForegroundService(service);
            }

    }
}