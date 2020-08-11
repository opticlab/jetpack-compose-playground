package org.opticlab.android.compose.view.common

import androidx.compose.foundation.layout.Constraints
import androidx.compose.foundation.layout.DpConstraints
import androidx.compose.foundation.layout.MainAxisAlignment
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Layout
import androidx.compose.ui.Measurable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Placeable
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.util.fastForEach
import kotlin.math.min

@Composable
fun <T> Grid(
    items: List<T>,
    spanCount: Int,
    modifier: Modifier = Modifier,
    lastLineMainAxisAlignment: MainAxisAlignment = MainAxisAlignment.Center,
    itemContent: @Composable() (T) -> Unit
) {
    Layout(
        children = {
            items.take(spanCount * spanCount)
                .forEach { item -> itemContent(item) }
        },
        modifier = modifier.aspectRatio(1f),
        measureBlock = { measurables, constraints ->
            val itemCount = measurables.size
            val size = constraints.maxWidth

            val spanSize = size / min(itemCount, spanCount)
            val itemConstraints = Constraints(
                DpConstraints.fixed(
                    spanSize.toDp(),
                    spanSize.toDp()
                )
            )

            val itemPlaceables =
                mutableListOf<Pair<Placeable, IntOffset>>()

            fun positionRow(
                rowMeasurables: List<Measurable>,
                offset: IntOffset,
                space: Int
            ) {
                rowMeasurables.fold(offset.x) { x, measurable ->
                    val placeable = measurable.measure(itemConstraints)
                    itemPlaceables.add(
                        placeable to IntOffset(
                            x,
                            offset.y
                        )
                    )

                    x + space + spanSize
                }
            }

            val rowCount = (itemCount + (spanCount - 1)) / spanCount
            val topOffset = (size - rowCount * spanSize) / 2

            val rows = measurables.chunked(spanCount)
            val headRows = rows.subList(0, rows.lastIndex)
            val tailRowTopOffset = headRows.fold(topOffset) { y, row ->
                positionRow(row, IntOffset(0, y), 0)
                y + spanSize
            }

            val tailRow = rows.last()

            val columnCount = tailRow.size
            val rowFreeSpace = size - columnCount * spanSize
            val evenlyDividedFreeSpace = rowFreeSpace / (columnCount + 1)

            val (startOffset, space) = when (lastLineMainAxisAlignment) {
                MainAxisAlignment.Center -> rowFreeSpace / 2
                MainAxisAlignment.Start,
                MainAxisAlignment.SpaceBetween -> 0
                MainAxisAlignment.End -> rowFreeSpace
                MainAxisAlignment.SpaceEvenly,
                MainAxisAlignment.SpaceAround -> evenlyDividedFreeSpace
            } to when (lastLineMainAxisAlignment) {
                MainAxisAlignment.SpaceAround,
                MainAxisAlignment.SpaceEvenly -> evenlyDividedFreeSpace
                else -> 0
            }

            positionRow(
                tailRow,
                IntOffset(startOffset, tailRowTopOffset),
                space
            )

            layout(size, constraints.maxHeight) {
                itemPlaceables.fastForEach { (placeable, offset) ->
                    placeable.place(offset)
                }
            }
        }
    )
}