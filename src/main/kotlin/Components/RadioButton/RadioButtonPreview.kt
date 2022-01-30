import Components.RadioButtonIndicator.RadioButtonIndicator
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun RadioButton_Unselected(){
    PreviewBackground (isCentered = true){
        RadioButton(
            text = "Hello :)",
            isChecked = true,
        )
    }
}


