package app.futured.donut.library.compose.data

import androidx.compose.Model
import androidx.ui.graphics.Color
import app.futured.donut.library.compose.DonutProgress
import app.futured.donut.library.compose.internal.extensions.sumByFloat

/**
 * Wrapper for all necessary data values used by [DonutProgress] to draw its content.
 *
 * @param cap Maximum value of sum of all entries in view, after which
 * all lines start to resize proportionally to amounts in their entry categories.
 * @param masterProgress Percentage of progress shown for all lines. Eg. when one line has 50% of total graph length,
 * setting this to 0.5f will result in that line being animated to 25% of total graph length.
 * @param gapWidthDegrees Size of gap opening in degrees. Eg. when set to 180° then the donut will result in the size
 * that is the half-circle.
 * @param gapAngleDegrees The angle in degrees, at which the gap will be displayed. Eg. when set to 90° then donut
 * will be rotated by 90° clockwise.
 * @param strokeWidth Stroke width of all lines in pixels.
 * @param backgroundLineColor The color of the donut background line.
 * @param datasets The data used to define each section of the donut. This data should keep the same size
 * since adding or removing of the new dataset is not supported yet. If the size of this list is changed then
 * an exception will be thrown.
 */
@Model data class DonutData(
    var cap: Float,
    var masterProgress: Float = 1f,
    var gapWidthDegrees: Float = 90f,
    var gapAngleDegrees: Float = 90f,
    var strokeWidth: Float = 30f,
    var backgroundLineColor: Color = Color.LightGray,
    var datasets: List<DonutDataset>
) {

    /**
     * Sum of all [DonutDataset.amount]
     */
    val datasetsCap: Float get() = datasets.sumByFloat { it.amount }
}
