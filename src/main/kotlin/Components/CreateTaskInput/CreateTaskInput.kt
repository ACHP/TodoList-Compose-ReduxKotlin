import Models.Task
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CreateTaskInput(
    onTaskCreated: (Task) -> Unit,
) {
    val (name, setName) = remember { mutableStateOf("") }

    fun onCreateTask() {
        if (name.isNotEmpty()) {
            onTaskCreated(Task(name))
            setName("")
        }
    }

    Row {
        TextField(
            value = name,
            placeholder = { Text("test placeholder", color = Color.DarkGray) },
            onValueChange = { value -> setName(value) },
            colors = textFieldColors(textColor = Color.White, placeholderColor = Color.Gray),
            modifier = Modifier.onKeyEvent {
                if (it.key == Key.Enter && it.isMetaPressed) {
                    onCreateTask()
                    return@onKeyEvent false
                }
                return@onKeyEvent true
            }
        )
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xff00fe8f),
                    shape = RoundedCornerShape(8.dp),
                )
                .height(50.dp)
                .padding(8.dp)
                .clickable { onCreateTask() },
            contentAlignment = Alignment.Center
        ) {
            Text("Create")
        }
    }
}
