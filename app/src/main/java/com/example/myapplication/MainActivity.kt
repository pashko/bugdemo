package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.lib.Foo

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, Impl.name, Toast.LENGTH_LONG).show()
    }
}

interface Bar : Foo {

    override val name: String
        get() = "bar"
}

val FooImpl = object : Foo {
    override val name get() = "impl"
}

interface Baz : Foo {
    object NestedImpl : Baz, Foo by FooImpl
}

object Impl : Baz, Bar
