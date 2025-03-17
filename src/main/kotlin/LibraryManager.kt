package code.yakovenko

import code.yakovenko.models.*
import code.yakovenko.repository.LibraryRepository

class LibraryManager(
    private val libraryRepository: LibraryRepository
) {
    fun mainMenuProcessor(): Pair<List<LibraryItem>?, Boolean> {
        showMainMenu()

        print("Введите пункт меню: ")
        return when (readln().toIntOrNull()) {
            -1 -> Pair(null, false)
            BOOK_TYPE -> Pair(libraryRepository.books, true)
            NEWSPAPER_TYPE -> Pair(libraryRepository.disks, true)
            DISK_TYPE -> Pair(libraryRepository.newspapers, true)
            else -> {
                println("Некорректный пункт меню")
                Pair(null, true)
            }
        }
    }

    fun secondaryMenuProcessor(libraryItem: LibraryItem): Boolean {
        showSecondaryMenu()

        print("Введите пункт меню: ")
        when(readln().toIntOrNull()) {
            -1 -> return false
            1 -> takeHomeItem(libraryItem)
            2 -> readItem(libraryItem)
            3 -> libraryItem.detailedInformation
            4 -> returnItem(libraryItem)
            else -> println("Некорректный пункт меню")
        }

        return true
    }

    fun showLibraryItems(libraryItems: Collection<LibraryItem>) {
        if (libraryItems.isEmpty()) {
            println("Список пуст")
        } else {
            libraryItems.forEachIndexed { index, libraryItem ->
                showLibraryItem(libraryItem, index + 1)
            }
        }
    }

    private fun showMainMenu() {
        println("-1. Завершение работы программы")
        println("1.  Показать книги")
        println("2.  Показать газеты")
        println("3.  Показать диски")
    }

    private fun showSecondaryMenu() {
        println("-1. Вернуться в меню выбора объекта")
        println("1.  Взять домой")
        println("2.  Читать в читальном зале")
        println("3.  Показать подробную информацию")
        println("4.  Вернуть")
    }

    private fun showLibraryItem(libraryItem: LibraryItem, number: Int) {
        println("$number. ${libraryItem.briefInformation}")
    }

    private fun takeHomeItem(libraryItem: LibraryItem) {
        if (libraryItem is Newspaper) {
            println("Невозможно взять домой газету")
        } else if (!libraryItem.isAvailable) {
            println("Невозможно взять домой недоступный объект")
        } else {
            libraryRepository.updateItemAvailability(libraryItem, false)
            println("${libraryItem.className} ${libraryItem.id} взяли домой")
        }
    }

    private fun readItem(libraryItem: LibraryItem) {
        if (libraryItem is Disk) {
            println("Невозможно читать диск")
        } else if (!libraryItem.isAvailable) {
            println("Невозможно взять домой недоступный объект")
        } else {
            libraryRepository.updateItemAvailability(libraryItem, false)
            println("${libraryItem.className} ${libraryItem.id} взяли в читальный зал")
        }
    }

    private fun returnItem(libraryItem: LibraryItem) {
        if (libraryItem.isAvailable) {
            println("Невозможно вернуть доступный объект")
        } else {
            libraryRepository.updateItemAvailability(libraryItem, true)
            println("${libraryItem.className} ${libraryItem.id} вернули")
        }
    }
}
