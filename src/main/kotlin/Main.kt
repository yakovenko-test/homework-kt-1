package code.yakovenko

import code.yakovenko.menu.MenuManager
import code.yakovenko.repository.LibraryRepository
import code.yakovenko.repository.MockRepository

fun main() {
    val libraryRepository: LibraryRepository = MockRepository()
    val libraryManager = LibraryManager(libraryRepository)
    val menuManager = MenuManager(libraryManager)

    Application(menuManager).start()
}
