package code.yakovenko

import code.yakovenko.menu.MenuManager
import code.yakovenko.menu.SecondaryMenuPoint.*

class Application(
    private val menuManager: MenuManager
) {
    fun start() {
        while (true) {
            val (pickedItems, isContinueProgram) = menuManager.mainMenuProcess()

            if (!isContinueProgram) break
            if (pickedItems == null) continue

            var isContinue = true

            while (isContinue) {
                print("Введите номер объекта (${STEP_BACK.value} -- ${STEP_BACK.task}): ")
                val pickedNumber = readln().toIntOrNull()

                isContinue = when (pickedNumber) {
                    STEP_BACK.value -> false
                    !in 1..pickedItems.size -> {
                        println("Номер несуществующего объекта")
                        true
                    }
                    null -> {
                        println("Некорректный номер объекта")
                        true
                    }
                    else -> {
                        menuManager.secondaryMenuProcess(pickedItems[pickedNumber.minus(1)])
                    }
                }
            }
        }
    }
}
