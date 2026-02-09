package dev.akiprisaye.android

import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    private lateinit var webView: WebView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Créer et configurer le WebView
        webView = WebView(this).apply {
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                loadWithOverviewMode = true
                useWideViewPort = true
                
                // Paramètres de sécurité
                allowFileAccess = false
                allowContentAccess = false
                setGeolocationEnabled(false)
                databaseEnabled = true
                
                // Désactiver les accès aux fichiers depuis les URLs
                allowFileAccessFromFileURLs = false
                allowUniversalAccessFromFileURLs = false
            }
            
            // Garder la navigation dans l'application avec gestion d'erreurs
            webViewClient = object : WebViewClient() {
                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?
                ) {
                    super.onReceivedError(view, request, error)
                    // Afficher un message d'erreur convivial
                    if (request?.isForMainFrame == true) {
                        Toast.makeText(
                            this@MainActivity,
                            getString(R.string.connection_error_message),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
            
            // Charger le site web
            loadUrl("https://akiprisaye-web.pages.dev")
        }
        
        setContentView(webView)
        
        // Gérer le bouton retour avec l'API moderne
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }
}
