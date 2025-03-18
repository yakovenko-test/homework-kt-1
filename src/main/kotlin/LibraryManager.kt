package code.yakovenko

import code.yakovenko.feature.HomeTakeable
import code.yakovenko.feature.Readable
import code.yakovenko.models.*
import code.yakovenko.repository.LibraryRepository

class LibraryManager(
    private val libraryRepository: LibraryRepository
) {
    val books
        get() = libraryRepository.books
    val disks
        get() = libraryRepository.disks
    val newspapers
        get() = libraryRepository.newspapers

    fun showLibraryItems(libraryItems: Collection<LibraryItem>) {
        if (libraryItems.isEmpty()) {
            println("Список пуст")
        } else {
            libraryItems.forEachIndexed { index, libraryItem ->
                showLibraryItem(libraryItem, index + 1)
            }
        }
    }

    fun takeHomeItem(libraryItem: LibraryItem) {
        println(
            when {
                !libraryItem.isAvailable -> "Невозможно взять домой недоступный объект"
                libraryItem is HomeTakeable -> {
                    libraryItem.takeHome()
                    "${libraryItem.className} ${libraryItem.id} взяли домой"
                }
                else -> "Невозможно взять домой объект этого типа"
            }
        )
    }

    fun readItem(libraryItem: LibraryItem) {
        println(
            when {
                !libraryItem.isAvailable -> "Невозможно читать недоступный объект"
                libraryItem is Readable -> {
                    libraryItem.read()
                    "${libraryItem.className} ${libraryItem.id} взяли в читальный зал"
                }
                else -> "Невозможно читать объект этого типа"
            }
        )
    }

    fun returnItem(libraryItem: LibraryItem) {
        println(
            if (libraryItem.isAvailable) {
                "Невозможно вернуть доступный объект"
            } else {
                libraryItem.`return`()
                "${libraryItem.className} ${libraryItem.id} вернули"
            }
        )
    }

    private fun showLibraryItem(libraryItem: LibraryItem, number: Int) {
        println("$number. ${libraryItem.briefInformation}")
    }
}
