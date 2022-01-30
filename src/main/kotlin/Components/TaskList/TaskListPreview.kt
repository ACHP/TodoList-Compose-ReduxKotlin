import Components.RadioButtonIndicator.RadioButtonIndicator
import Models.Task
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun PressableList_Default(){
    PreviewBackground (isCentered = true){
        TaskList(tasks = arrayListOf(
            Task(name= "une nouvelle tache"),
            Task(name= "une nouvelle tache"),
            Task(name= "une nouvelle tache"),
            Task(name= "une nouvelle tache ze"),
            Task(name= "une nouvelle tache azdad"),
            Task(name= "une nouvelle tache azdaz"),
            Task(name= "une nouvelle tachedz")
        ))
    }
}


