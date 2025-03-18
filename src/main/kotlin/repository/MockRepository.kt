package code.yakovenko.repository

import code.yakovenko.models.*
import code.yakovenko.models.enums.DiskType
import code.yakovenko.models.enums.Month

class MockRepository: LibraryRepository {
    private val data = mutableListOf<LibraryItem>()

    init {
        add(Book(1, "Книга №1", 111, "Автор №1", true))
        add(Book(2, "Книга №2", 222, "Автор №2", false))

        add(Disk(3, "Диск №1", DiskType.DVD, true))
        add(Disk(4, "Диск №2", DiskType.CD, false))

        add(Newspaper(5, "Газета №1", 111, Month.JANUARY, true))
        add(Newspaper(6, "Газета №2", 222, Month.FEBRUARY, false))
    }

    override val books
        get() = data.filterIsInstance<Book>()
    override val disks
        get() = data.filterIsInstance<Disk>()
    override val newspapers
        get() = data.filterIsInstance<Newspaper>()

    override fun add(libraryItem: LibraryItem) = data.add(libraryItem)
}
