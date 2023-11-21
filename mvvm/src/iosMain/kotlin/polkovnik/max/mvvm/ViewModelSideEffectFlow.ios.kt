package polkovnik.max.mvvm

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

actual class ViewModelSideEffectFlow<T : ViewModelSideEffect> actual constructor(
    private val origin: Flow<T>
) : Flow<T> by origin {
    fun watch(block: (T) -> Unit): Closeable {
        val job = Job()

        onEach {
            block(it)
        }.launchIn(CoroutineScope(Dispatchers.Main + job))

        return Closeable { job.cancel() }
    }

    fun interface Closeable {
        fun close()
    }
}

actual fun <T : ViewModelSideEffect> Flow<T>.toViewModelSideEffectFlow(): ViewModelSideEffectFlow<T> =
    ViewModelSideEffectFlow(this)