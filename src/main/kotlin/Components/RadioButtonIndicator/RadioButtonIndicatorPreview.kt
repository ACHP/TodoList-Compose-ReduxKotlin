import Components.RadioButtonIndicator.RadioButtonIndicator
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun RadioButtonIndicator_Unselected(){
    PreviewBackground (isCentered = true){
        RadioButtonIndicator(false)
    }
}

@Composable
@Preview
fun RadioButtonIndicator_Selected(){
    PreviewBackground (isCentered = true){
        RadioButtonIndicator(true, strokeWidth = 3.dp, gapWidth = 4.dp)
    }
}

