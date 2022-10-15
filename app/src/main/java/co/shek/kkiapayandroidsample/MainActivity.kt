package co.shek.kkiapayandroidsample

import co.opensi.kkiapay.uikit.Kkiapay.get
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.opensi.kkiapay.STATUS
import android.widget.Toast
import android.content.Intent
import android.view.View
import android.widget.Button
import co.opensi.kkiapay.uikit.Kkiapay

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        // Setup listener for payment status
        Kkiapay.get().setListener { status, transactionId ->

            //The following code will be run when user will end the payment
            Toast.makeText(this@MainActivity, "Transaction: ${status.name} -> $transactionId", Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume() {
        super.onResume()
        val testButtonWithKkiapay = findViewById<View>(R.id.test_button_with_kkiapay) as Button
        testButtonWithKkiapay.setOnClickListener {
            Kkiapay.get().requestPayment(this, "1",
                reason = "Payment of awesome service", name = "Johna DOE",
                sandbox = true, //countries = listOf("CI"), partnerId = "AxXxxXXid",
                phone = "2250577100000", //email = "email@mail.com", paymentMethods = listOf("momo","card","direct_debit")
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Kkiapay.get().handleActivityResult(requestCode, resultCode, data)
    }
}