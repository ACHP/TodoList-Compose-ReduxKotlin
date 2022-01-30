package Reducers

import RootState
import Models.Task
import Models.TaskStatus
import ReduxKit.Slice

data class TaskListState(
    val tasks: ArrayList<Task> = arrayListOf(),
    val areAllTaskCompleted: Boolean = false,
)

object TaskListAction{
    data class AddTask(val task: Task)
    data class RemoveTask(val task: Task)
    data class UpdateTaskStatus(val task: Task, val newStatus: TaskStatus)
}

val TaskSlice = Slice(
    reducer = { state, action ->
        when (action) {
            is TaskListAction.AddTask -> state.copy(tasks = ArrayList(state.tasks).also { it.add(action.task) })
            is TaskListAction.RemoveTask -> state.copy(tasks = ArrayList(state.tasks).also { it.remove(action.task) })
            is TaskListAction.UpdateTaskStatus -> state.copy(tasks = ArrayList(state.tasks).also {
                val taskIndex = it.indexOfFirst { t -> t.equals(action.task) }
                val task = it[taskIndex]?.copy(status = action.newStatus)
                it[taskIndex] = task
            })
            else -> state
        }
    },
    accessor = {state: RootState -> state.taskList},
    setter = {state, localState -> state.copy(taskList = localState)}
)
