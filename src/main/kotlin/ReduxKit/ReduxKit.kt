package ReduxKit

fun interface Reduc<out State> {
    fun invoke(state: @UnsafeVariance State, action: Any): State
}

typealias reducerAccessor<GS, LS> = (state: GS) -> LS
fun <State> combineSlices(vararg list: Slice<State, Any>): Reduc<State>{
    return Reduc{ state, action ->
        val s = list.fold(state){acc, slice ->
            val partialState = slice.accessor(acc);
            val updatedSlice = slice.reducer.invoke(partialState, action)
            slice.setter(acc, updatedSlice)
        }

        return@Reduc s
    }
}

class Slice<State, out LocalState>(
    val reducer: Reduc<LocalState>,
    val accessor:reducerAccessor<State, LocalState>,
    val setter: (State,@UnsafeVariance LocalState) -> State
)
