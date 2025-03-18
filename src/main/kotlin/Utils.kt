package code.yakovenko

inline fun<reified T> instanceFilter(lst: List<*>) = lst.filterIsInstance<T>()
