package co.shek.kkiapayandroidsample.kotlin

import android.app.Application
import co.opensi.kkiapay.uikit.Kkiapay
import co.opensi.kkiapay.uikit.SdkConfig
import co.shek.kkiapayandroidsample.R

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //Initialisation de l'API
        Kkiapay.init(applicationContext,
                "<PUBLIC-API-KEY>",
            SdkConfig(themeColor = R.color.colorPrimary,
                imageResource = R.raw.armoiries,
                    /* set enableSandbox = false in case you are using live API Keys */
                    enableSandbox = false)
        )
    }
}
