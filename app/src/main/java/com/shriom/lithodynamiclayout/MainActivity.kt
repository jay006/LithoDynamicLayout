package com.shriom.lithodynamiclayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.litho.ClickEvent
import com.facebook.litho.ComponentContext
import com.facebook.litho.EventHandler
import com.facebook.litho.LithoView
import com.facebook.litho.widget.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        val c = ComponentContext(this)
        val component = Text.create(c)
            .text("Hello World")
            .textSizeDip(50f)
            .build()
        setContentView(LithoView.create(c, component));

//        final ComponentContext c = new ComponentContext(this);
//
//        final Component component = Text.create(c)
//            .text("Hello World")
//            .textSizeDip(50)
//            .build();
//
//        setContentView(LithoView.create(c, component));
    }
}