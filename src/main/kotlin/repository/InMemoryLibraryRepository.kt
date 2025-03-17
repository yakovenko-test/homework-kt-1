package code.yakovenko.repository

import code.yakovenko.models.Book
import code.yakovenko.models.Disk
import code.yakovenko.models.LibraryItem
import code.yakovenko.models.Newspaper

class InMemoryLibraryRepository: LibraryRepository {
    private val data = mutableListOf<LibraryItem>()

    override val books
        get() = data.filterIsInstance<Book>()
    override val disks
        get() = data.filterIsInstance<Disk>()
    override val newspapers
        get() = data.filterIsInstance<Newspaper>()

    override fun add(libraryItem: LibraryItem) = data.add(libraryItem)

    override fun updateItemAvailability(libraryItem: LibraryItem, isAvailable: Boolean) {
        libraryItem.isAvailable = isAvailable
    }
}
