package code.yakovenko.menu

import code.yakovenko.LibraryManager
import code.yakovenko.menu.MainMenuPoint.*
import code.yakovenko.menu.SecondaryMenuPoint.*
import code.yakovenko.models.LibraryItem

class MenuManager(
    private val libraryManager: LibraryManager
) {
    fun mainMenuProcess(): Pair<List<LibraryItem>?, Boolean> {
        var isContinue = true

        showMainMenu()

        print("Введите пункт меню: ")
        val pickedItems = when (readln().toIntOrNull()) {
            PROGRAM_SHUTDOWN.value -> {
                println("Завершение работы программы")
                isContinue = false
                null
            }
            SHOW_BOOKS.value -> libraryManager.books
            SHOW_DISKS.value -> libraryManager.disks
            SHOW_NEWSPAPERS.value -> libraryManager.newspapers
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
        when (readln().toIntOrNull()) {
            STEP_BACK.value -> return false
            TAKE_HOME.value -> libraryManager.takeHomeItem(libraryItem)
            READ.value -> libraryManager.readItem(libraryItem)
            SHOW_DETAILED_INFORMATION.value -> println(libraryItem.detailedInformation)
            RETURN.value -> libraryManager.returnItem(libraryItem)
            else -> println("Некорректный пункт меню")
        }

        return true
    }

    private fun showMainMenu() {
        for (point in MainMenuPoint.entries) {
            println("${point.value}. ${point.task}")
        }
    }

    private fun showSecondaryMenu() {
        for (point in SecondaryMenuPoint.entries) {
            println("${point.value}. ${point.task}")
        }
    }
}