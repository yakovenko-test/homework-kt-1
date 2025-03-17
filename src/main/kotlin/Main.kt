package code.yakovenko

import code.yakovenko.models.*
import code.yakovenko.repository.InMemoryLibraryRepository

fun main() {
    val libraryRepository = InMemoryLibraryRepository()
    val libraryManager = LibraryManager(libraryRepository)

    libraryRepository.add(Book(1, true, "Книга №1", 111, "Автор №1"))
    libraryRepository.add(Book(2, false, "Книга №2", 222, "Автор №2"))

    libraryRepository.add(Disk(3, true, "Диск №1", CD))
    libraryRepository.add(Disk(4, false, "Диск №2", DVD))

    libraryRepository.add(Newspaper(1, true, "Газета №1", 111))
    libraryRepository.add(Newspaper(2, false, "Газета №2", 222))

    while (true) {
        val (pickedItems, isContinueProgram) = libraryManager.mainMenuProcessor()

        if (!isContinueProgram) break
        if (pickedItems == null) continue

        libraryManager.showLibraryItems(pickedItems)

        var isContinue = true

        while (isContinue) {
            print("Введите номер объекта (-1 -- вернуться в меню выбора объекта): ")
            val pickedNumber = readln().toIntOrNull()

            if (pickedNumber == null) {
                println("Некорректный номер объекта")
                continue
            } else if (pickedNumber == -1) {
                isContinue = false
            } else if (pickedNumber !in 1..3) {
                println("Некорректный номер объекта")
            }

            if (isContinue) {
                isContinue = libraryManager.secondaryMenuProcessor(pickedItems[pickedNumber.minus(1)])
            }
        }
    }

    println("Завершение работы программы")
}
