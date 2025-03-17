package code.yakovenko

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
                print("Введите номер объекта (-1 -- вернуться в меню выбора объекта): ")
                val pickedNumber = readln().toIntOrNull()

                when (pickedNumber) {
                    -1 -> isContinue = false
                    null -> {
                        println("Некорректный номер объекта")
                        continue
                    }
                    !in 1..pickedItems.size -> {
                        println("Несуществующий номер объекта")
                        continue
                    }
                }

                if (isContinue) {
                    isContinue = menuManager.secondaryMenuProcess(pickedItems[pickedNumber!!.minus(1)])
                }
            }
        }
    }
}
