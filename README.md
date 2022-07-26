# AdTrace android Examples
android application examples for adtrace different features.

**Note before any topic, it assumed that you implemented [basic implementation](https://github.com/adtrace/adtrace_sdk_android) for adtrace android sdk**


#### Table of Contents
- [Re-Attribution via deeplink](#ex-reattribution)


## <a id="ex-reattribution"></a> Re-Attribution via deeplink
start by creating a deeplink for you application. in `AndroidManifest.xml`:
```java
    <application
        ...
        >
        <activity
            android:name=".MainActivity"
            android:exported="true" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
            <intent-filter >
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />
                <!-- Accepts URIs that begin with "https://www.adtrace.io/example” -->
                <data android:scheme="https"
                    android:host="www.adtrace.io"
                    android:pathPrefix="/example" />
                <!-- note that the leading "/" is required for pathPrefix-->
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />
                <!-- Accepts URIs that begin with "adtrace://example” -->
                <data android:scheme="adtrace"
                    android:host="example" />
            </intent-filter>

            ...
        </activity>
        ...
    </application>
```
now your app accepts these deeplinks:

- `https://www.adtrace.io/example?anyparams=12345&anotherparams=tehran`

- `adtrace://example?anyparams=12345&anotherparams=tehran`

next step if you are using [deffered deeplink](https://github.com/adtrace/adtrace_sdk_android#dl-deferred) add listener to configuration.

to receive deeplink data inside the app, use intent data. [see this for more information](https://github.com/adtrace/adtrace_sdk_android#standard-deep-linking-scenario).

after finishing previous steps add this line after receiving deeplink data from the intent to handle it properly.
```java
AdTrace.appWillOpenUrl(uri,context);

```
Done! feel free to ask any questions in [issues](https://github.com/adtrace/adtrace-android-examples/issues) or cantact [our support](https://adtrace.io/).