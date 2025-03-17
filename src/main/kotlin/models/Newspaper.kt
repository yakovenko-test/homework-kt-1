package code.yakovenko.models

import code.yakovenko.feature.Readable
import code.yakovenko.extensions.toRuText

class Newspaper(
    override val id: Int,
    override val name: String,
    private val issueNumber: Int,
    availability: Boolean,
): Readable {
    override var isAvailable = availability
    override val className = "Газета"

    override val detailedInformation: String
        get() = "выпуск: $issueNumber газеты $name с id: $id доступен: ${isAvailable.toRuText()}"
}
