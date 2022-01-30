import Components.RadioButtonIndicator.RadioButtonIndicator
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em


@Composable
fun RadioButton(
    text: String,
    isChecked: Boolean = false,
    onClick: () -> Unit = {}
){
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ){
        Row(modifier = Modifier
            .clickable(onClick = {onClick()})
            .wrapContentHeight()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                RadioButtonIndicator(isChecked, strokeWidth = 3.dp, gapWidth = 4.dp)
            }
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(start = 8.dp)
            ){
                Text(
                    text = text,
                    color = if (isChecked) Color.DarkGray else Color.White,
                    fontSize = 1.em,
                    style = if (isChecked)
                        TextStyle(textDecoration = TextDecoration.LineThrough)
                    else
                        TextStyle()

                )
            }
        }
    }
}
