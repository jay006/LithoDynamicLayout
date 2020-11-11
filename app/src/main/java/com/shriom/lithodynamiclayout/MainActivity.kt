package com.shriom.lithodynamiclayout

import android.app.LauncherActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.litho.ClickEvent
import com.facebook.litho.ComponentContext
import com.facebook.litho.EventHandler
import com.facebook.litho.LithoView
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import com.facebook.litho.widget.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        /* HELLO WORLD
        val c = ComponentContext(this)
        val component = Text.create(c)
            .text("Hello World")
            .textSizeDip(50f)
            .build()
        setContentView(LithoView.create(c, component));*/



        // First custom component
       /* val c = ComponentContext(this)
        setContentView(LithoView.create(c, ListItem.create(c).build()))*/

        //Creating List of itmes
        val c  = ComponentContext(this)
        val recyclerComponent = RecyclerCollectionComponent.create(c)
            .disablePTR(false)
            .section(ListSection.create(SectionContext(c)).build())
            .build()
        setContentView(LithoView.create(c, recyclerComponent))
    }
}