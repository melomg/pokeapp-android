package com.melih.android.pokeapp.core.network

/**
 * Custom annotation to help R8 (the minification tool) avoid obfuscating classes
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.FIELD,
    AnnotationTarget.TYPE,
)
annotation class SerializedClass
