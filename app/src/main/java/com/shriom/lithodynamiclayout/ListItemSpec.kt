package com.shriom.lithodynamiclayout

import android.graphics.Color
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaEdge


@LayoutSpec
object ListItemSpec {

    @OnCreateLayout
    fun onCreateLayout(c: ComponentContext?): Component? {
        return Column.create(c)
            .paddingDip(YogaEdge.ALL, 16f)
            .backgroundColor(Color.WHITE)
            .child(
                Text.create(c)
                    .text("Hello world")
                    .textSizeSp(40f)
            )
            .child(
                Text.create(c)
                    .text("Litho tutorial")
                    .textSizeSp(20f)
            )
            .build()
    }
}