package no.arnsteo.arkeologi;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView mywebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mywebview = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebview.loadUrl("https://humgis.uiocloud.no/arcgis/apps/webappviewer/index.html?id=491d095405234f5a994671a1346d076c");
        mywebview.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed(){
        if(mywebview.canGoBack()) {
            mywebview.goBack();
        } else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
