package amini.test.re_attribution_via_deeplink;

import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.adtrace.sdk.AdTrace;
import io.adtrace.sdk.AdTraceConfig;
import io.adtrace.sdk.LogLevel;
import io.adtrace.sdk.OnDeeplinkResponseListener;

public class GlobalApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AdTraceConfig adTraceConfig = new AdTraceConfig(this,AdTraceInformation.appToken,AdTraceConfig.ENVIRONMENT_SANDBOX);
        adTraceConfig.setLogLevel(LogLevel.VERBOSE);


        adTraceConfig.setOnDeeplinkResponseListener(new OnDeeplinkResponseListener() {
            @Override
            public boolean launchReceivedDeeplink(Uri uri) {
                return false;
            }
        });



        AdTrace.onCreate(adTraceConfig);

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {

            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                AdTrace.onResume();
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {
                AdTrace.onPause();
            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }


}
