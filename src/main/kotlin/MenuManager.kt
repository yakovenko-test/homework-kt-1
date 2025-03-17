package code.yakovenko

import code.yakovenko.models.BOOK_TYPE
import code.yakovenko.models.DISK_TYPE
import code.yakovenko.models.LibraryItem
import code.yakovenko.models.NEWSPAPER_TYPE

class MenuManager(
    private val libraryManager: LibraryManager
) {
    fun mainMenuProcess(): Pair<List<LibraryItem>?, Boolean> {
        var isContinue = true

        showMainMenu()

        print("Введите пункт меню: ")
        val pickedItems = when (readln().toIntOrNull()) {
            BOOK_TYPE -> libraryManager.books
            NEWSPAPER_TYPE -> libraryManager.disks
            DISK_TYPE -> libraryManager.newspapers
            -1 -> {
                println("Завершение работы программы")
                isContinue = false
                null
            }
            else -> null
        }

        if (pickedItems != null) {
            libraryManager.showLibraryItems(pickedItems)
        }

        return Pair(pickedItems, isContinue)
    }

    fun secondaryMenuProcess(libraryItem: LibraryItem): Boolean {
        showSecondaryMenu()

        print("Введите пункт меню: ")
        when(readln().toIntOrNull()) {
            -1 -> return false
            1 -> libraryManager.takeHomeItem(libraryItem)
            2 -> libraryManager.readItem(libraryItem)
            3 -> libraryItem.detailedInformation
            4 -> libraryManager.returnItem(libraryItem)
            else -> println("Некорректный пункт меню")
        }

        return true
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
}