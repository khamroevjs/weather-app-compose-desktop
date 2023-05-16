sealed class Lce<out T> {
    object Loading : Lce<Nothing>()
    data class Content<T>(val data: T) : Lce<T>()
    data class Error(val error: Throwable) : Lce<Nothing>()
}
