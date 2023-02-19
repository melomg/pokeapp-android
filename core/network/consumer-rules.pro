# Proguard rules

# Keep fields for app classes that will be serialized/deserialized
-keep @com.melih.android.pokeapp.core.network.SerializedClass class * { *; }

-keepclasseswithmembers class * {
    @com.melih.android.pokeapp.core.network.SerializedClass <methods>;
    @com.melih.android.pokeapp.core.network.SerializedClass <fields>;
    @com.melih.android.pokeapp.core.network.SerializedClass <init>(...);
}
