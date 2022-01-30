package Components.RadioButtonIndicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp


@Composable
fun RadioButtonIndicator(isSelected: Boolean = false, strokeWidth: Dp = 4.dp, gapWidth: Dp = 2.dp, size: Dp = 24.dp) {
    Box(modifier = Modifier
        .width(size)
        .height(size)
        .border(width = strokeWidth, color = Color(0xff00fe8f), shape = RoundedCornerShape(50)),
        contentAlignment = Alignment.Center
    ){
        if(isSelected) {
            Box(modifier = Modifier
                .background(shape = RoundedCornerShape(50), color = Color(0xff00fe8f))
                .width(size - (strokeWidth*2) - (gapWidth*2))
                .height(size - (strokeWidth*2) - (gapWidth*2))
            )
        }
    }
}
