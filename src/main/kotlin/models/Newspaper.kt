package code.yakovenko.models

import code.yakovenko.extensions.toRuText

class Newspaper(
    override val id: Int,
    override var isAvailable: Boolean,
    override val name: String,
    private val issueNumber: Int,
): LibraryItem {
    override val className = "Газета"

    override val detailedInformation: String
        get() = "выпуск: $issueNumber газеты $name с id: $id доступен: ${isAvailable.toRuText()}"
}
