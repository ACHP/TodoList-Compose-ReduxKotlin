import Models.Task
import Models.TaskStatus
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskList(
    tasks: List<Task>,
    onTaskPressed: (Task) -> Unit = {},
) {
    LazyColumn {
        items(tasks, key = { it.uuid }) { task ->
            Box(modifier = Modifier.padding(8.dp)
            ) {
                RadioButton(
                    text = task.name,
                    isChecked = task.status == TaskStatus.COMPLETED,
                    onClick = { onTaskPressed(task) }
                )
            }
        }
    }
}
