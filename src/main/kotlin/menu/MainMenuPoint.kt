package code.yakovenko.menu

enum class MainMenuPoint(
    override val value: Int,
    override val task: String,
): IMenu {
    PROGRAM_SHUTDOWN(-1, "Завершение работы программы"),
    SHOW_BOOKS(1, "Показать книги"),
    SHOW_NEWSPAPERS(2, "Показать газеты"),
    SHOW_DISKS(3, "Показать диски"),
}
