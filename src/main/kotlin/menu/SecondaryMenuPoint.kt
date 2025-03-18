package code.yakovenko.menu

enum class SecondaryMenuPoint(
    override val value: Int,
    override val task: String,
): IMenu {
    STEP_BACK(-1, "Вернуться в меню выбора объекта"),
    TAKE_HOME(1, "Взять домой"),
    READ(2, "Читать в читальном зале"),
    SHOW_DETAILED_INFORMATION(3, "Показать подробную информацию"),
    RETURN(4, "Вернуть"),
}
