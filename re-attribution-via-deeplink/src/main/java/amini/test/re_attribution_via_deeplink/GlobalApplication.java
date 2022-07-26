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


        /*
        After the AdTrace SDK receives the deep link information from our backend,
        the SDK will deliver you its content via the listener and expect the boolean
        return value from you. This return value represents your decision on whether
        or not the AdTrace SDK should launch the activity to which you have assigned
        the scheme name from the deeplink (like in the standard deeplinking scenario).

        If you return true, we will launch it, triggering the scenario described in
        the Standard deep linking scenario chapter. If you do not want the SDK to launch
        the activity, return false from the listener, and (based on the deep link content)
        decide on your own what to do next in your app.
         */

        // see this for more information: https://github.com/adtrace/adtrace_sdk_android#dl-deferred
        adTraceConfig.setOnDeeplinkResponseListener(new OnDeeplinkResponseListener() {
            @Override
            public boolean launchReceivedDeeplink(Uri uri) {
                return true;
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
