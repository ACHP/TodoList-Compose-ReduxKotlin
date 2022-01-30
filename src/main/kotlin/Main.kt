// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import Models.TaskStatus
import Reducers.TaskListAction
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

val rootState = compositionLocalOf<RootState> { error("No active user found!") }

@Composable
@Preview
fun App() {

    val appFlow by storeFlow.collectAsState(RootState())

//    var text by remember { mutableStateOf("Hello, World!") }

    CompositionLocalProvider(rootState provides appFlow) {
        MaterialTheme {
            Box(modifier = Modifier.fillMaxSize().background(color = Color(0xff222222))){
                Column {
                    CreateTaskInput { task -> store.dispatch(TaskListAction.AddTask(task)) }
                    TaskList(
                        tasks = rootState.current.taskList.tasks,
                        onTaskPressed = { task ->
                            println("Should update task $task with status ${if(task.status == TaskStatus.COMPLETED) TaskStatus.NOT_COMPLETED else TaskStatus.COMPLETED}")
                            store.dispatch(TaskListAction.UpdateTaskStatus(
                                task,
                                if(task.status == TaskStatus.COMPLETED) TaskStatus.NOT_COMPLETED else TaskStatus.COMPLETED))
                        }
                    )

                }
            }
        }

    }

}
//
@Composable
@Preview
fun TestA() {
    val state = rootState.current.taskList
    Text(state.tasks.joinToString(" - "))
}


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
