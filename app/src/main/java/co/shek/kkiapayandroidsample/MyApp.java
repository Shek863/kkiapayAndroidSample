package co.shek.kkiapayandroidsample;

import android.app.Application;
import co.opensi.kkiapay.uikit.Kkiapay;
import co.opensi.kkiapay.uikit.SdkConfig;

public class MyApp extends Application {
    @Override
    public void onCreate () {
        super.onCreate ();
        //Initialisation de l'API
        Kkiapay.init(this,
                "LprYUAyMpfAjq4z2yTHPiY0b6XktIQ",
                new SdkConfig (R.raw.armoiries, R.color.colorPrimary, false));
    }
}
