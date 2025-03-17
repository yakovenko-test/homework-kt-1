package code.yakovenko.repository

import code.yakovenko.models.*

class MockRepository: LibraryRepository {
    private val data = mutableListOf<LibraryItem>()

    init {
        add(Book(1, "Книга №1", 111, "Автор №1", true))
        add(Book(2, "Книга №2", 222, "Автор №2", false))

        add(Disk(3, "Диск №1", CD, true))
        add(Disk(4, "Диск №2", DVD, false))

        add(Newspaper(5, "Газета №1", 111, true))
        add(Newspaper(6, "Газета №2", 222, false))
    }

    override val books
        get() = data.filterIsInstance<Book>()
    override val disks
        get() = data.filterIsInstance<Disk>()
    override val newspapers
        get() = data.filterIsInstance<Newspaper>()

    override fun add(libraryItem: LibraryItem) = data.add(libraryItem)
}
