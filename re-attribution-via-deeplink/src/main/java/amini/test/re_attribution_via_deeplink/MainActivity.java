package amini.test.re_attribution_via_deeplink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import io.adtrace.sdk.AdTrace;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);



        Intent intent;
        if(getIntent()!=null){
            intent = getIntent();
            if(intent.getData()!=null){
                Uri uri = intent.getData();
                handleDeeplink(uri);
            }
        }


    }

    private void handleDeeplink(Uri uri) {
        // handling deeplink
        tv.setText("DeepLink:" + uri.toString());
        AdTrace.appWillOpenUrl(uri,this);
    }

}