package code.yakovenko.models

import code.yakovenko.feature.Readable
import code.yakovenko.extensions.toRuText
import code.yakovenko.models.enums.Month

class Newspaper(
    override val id: Int,
    override val name: String,
    private val issueNumber: Int,
    private val releaseMonth: Month,
    availability: Boolean,
): Readable {
    override var isAvailable = availability
    override val className = "Газета"

    override val detailedInformation: String
        get() = "выпуск: $issueNumber " +
                "газеты $name " +
                "от месяца: ${releaseMonth.cyrillic} " +
                "с id: $id " +
                "доступен: ${isAvailable.toRuText()}"
}
