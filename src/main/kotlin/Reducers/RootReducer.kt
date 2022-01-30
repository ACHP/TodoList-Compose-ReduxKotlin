import Reducers.TaskListState
import Reducers.TaskSlice
import ReduxKit.combineSlices
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.shareIn
import org.reduxkotlin.createStore

data class RootState(
    val taskList: TaskListState = TaskListState()
    /* We can add more states here*/
)

val rootSlice = combineSlices(
    TaskSlice
)

val store = createStore(rootSlice::invoke, RootState())



@OptIn(ExperimentalCoroutinesApi::class)
val storeFlow = callbackFlow {
    store.subscribe {
        this.trySend(store.getState())
    }

    awaitClose {
        println("awaitclose called")
    }
}.shareIn(
    scope = GlobalScope,
    started = SharingStarted.Eagerly
)
