package com.shriom.lithodynamiclayout

import android.graphics.Color
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.litho.annotations.FromEvent
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.common.DataDiffSection
import com.facebook.litho.sections.common.RenderEvent
import com.facebook.litho.sections.common.SingleComponentSection
import com.facebook.litho.sections.widget.GridRecyclerConfiguration
import com.facebook.litho.sections.widget.ListRecyclerConfiguration
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import com.facebook.litho.widget.ComponentRenderInfo
import com.facebook.litho.widget.RenderInfo
import com.facebook.litho.widget.SnapUtil.SNAP_TO_CENTER


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
/*

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
*/

    @OnCreateChildren
    fun onCreateChildren(c: SectionContext?): Children? {
        return Children.create()
            .child(
                SingleComponentSection.create(c)
                    .component(
                        RecyclerCollectionComponent.create(c)
                            .disablePTR(true)
                            .recyclerConfiguration(
                                ListRecyclerConfiguration.create()
                                    .orientation(LinearLayoutManager.HORIZONTAL)
                                    .reverseLayout(false).snapMode(
                                        SNAP_TO_CENTER
                                    ).build()
                            )
                            .section(
                                DataDiffSection.create<Int>(c)
                                    .data(generateData(32))
                                    .renderEventHandler(ListSection.onRender(c))
                                    .build()
                            )
                            .canMeasureRecycler(true).build()
                    )
                    .build()
            ).child(
                DataDiffSection.create<Int>(c)
                    .data(generateData(32))
                    .renderEventHandler(ListSection.onRender(c)).build()
            )
            .child(
                SingleComponentSection.create(c)
                    .component(
                        RecyclerCollectionComponent.create(c)
                            .disablePTR(true)
                            .recyclerConfiguration(
                                GridRecyclerConfiguration.create()
                                    .numColumns(2)
                                    .orientation(GridLayoutManager.HORIZONTAL)
                                    .build()
                            )
                            .section(
                                DataDiffSection.create<Int>(c)
                                    .data(generateData(32))
                                    .renderEventHandler(ListSection.onRender(c))
                                    .build()
                            )
                            .canMeasureRecycler(true).build()
                    )
                    .build()
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