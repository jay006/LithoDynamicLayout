package com.shriom.lithodynamiclayout

import android.graphics.Color
import com.facebook.litho.annotations.FromEvent
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.common.DataDiffSection
import com.facebook.litho.sections.common.RenderEvent
import com.facebook.litho.widget.ComponentRenderInfo
import com.facebook.litho.widget.RenderInfo
import com.shriom.lithodynamiclayout.ListSectionSpec.onRender


@GroupSectionSpec
object ListSectionSpec {

  /*  @OnCreateChildren
    fun onCreateChildren(c: SectionContext?): Children? {
        val builder = Children.create()
        for (i in 0..31) {
            builder.child(
                SingleComponentSection.create(c)
                    .key(i.toString())
                    .component(
                        ListItem.create(c)
                            .color(if (i % 2 == 0) Color.WHITE else Color.LTGRAY)
                            .title("$i Hello World")
                            .subtitle("Litho tutorial")
                            .build()
                    )
            )
        }
        return builder.build()
    }*/

    @OnCreateChildren
    fun onCreateChildren(c: SectionContext?): Children? {
        return Children.create()
            .child(
                DataDiffSection.create<Int>(c)
                    .data(generateData(32))
                    .renderEventHandler(ListSection.onRender(c))
            )
            .build()
    }

    @OnEvent(RenderEvent::class)
    fun onRender(c: SectionContext?, @FromEvent model: Int): RenderInfo? {
        return ComponentRenderInfo.create()
            .component(
                ListItem.create(c)
                    .color(if (model % 2 == 0) Color.WHITE else Color.LTGRAY)
                    .title("$model. Hello, world!")
                    .subtitle("Litho tutorial")
                    .build()
            )
            .build()
    }

    private fun generateData(count: Int): List<Int>? {
        val data: MutableList<Int> = ArrayList(count)
        for (i in 0 until count) {
            data.add(i)
        }
        return data
    }

}