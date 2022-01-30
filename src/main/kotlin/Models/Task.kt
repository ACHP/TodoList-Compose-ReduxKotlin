package Models

import java.util.*

data class Task(
    val name: String,
    val status: TaskStatus = TaskStatus.NOT_COMPLETED,
    val uuid: String = UUID.randomUUID().toString()
)
