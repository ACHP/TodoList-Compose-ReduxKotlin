import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PreviewBackground(
    isCentered: Boolean = false,
    component: @Composable () -> Unit
) {
    Box(
        modifier = previewBoxModifier,
        contentAlignment =
            if (isCentered)
                Alignment.Center
            else
                Alignment.TopStart) {
        component()
    }
}

val previewBoxModifier = Modifier
    .fillMaxSize()
    .background(color = Color(0xff222222))
