package com.shriom.lithodynamiclayout

import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.common.SingleComponentSection


@GroupSectionSpec
object ListSectionSpec {

    @OnCreateChildren
    fun onCreateChildren(c: SectionContext?): Children? {
        val builder = Children.create()
        for (i in 0..31) {
            builder.child(
                SingleComponentSection.create(c)
                    .key(i.toString())
                    .component(ListItem.create(c).build())
            )
        }
        return builder.build()
    }

}