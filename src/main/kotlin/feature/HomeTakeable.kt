package code.yakovenko.feature

import code.yakovenko.models.LibraryItem

interface HomeTakeable: LibraryItem {
    fun takeHome() { isAvailable = false }
}
