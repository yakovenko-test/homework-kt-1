package code.yakovenko.feature

import code.yakovenko.models.LibraryItem

interface Readable: LibraryItem {
    fun read() { isAvailable = false }
}
