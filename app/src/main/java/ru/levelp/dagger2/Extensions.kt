package ru.levelp.dagger2

import android.content.Context
import android.widget.Toast

fun Context.toast(text: String){
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()

}

val Context.appComponent: AppComponent
get() = (applicationContext as App).appComponent


