package code.yakovenko.repository

import code.yakovenko.models.Book
import code.yakovenko.models.Disk
import code.yakovenko.models.LibraryItem
import code.yakovenko.models.Newspaper

interface LibraryRepository {
    val books: List<Book>
    val disks: List<Disk>
    val newspapers: List<Newspaper>

    fun add(libraryItem: LibraryItem): Boolean
}
