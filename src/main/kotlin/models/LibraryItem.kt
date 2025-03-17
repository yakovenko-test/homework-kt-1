package code.yakovenko.models

import code.yakovenko.extensions.toRuText

interface LibraryItem {
    val id: Int
    var isAvailable: Boolean
    val name: String

    val className: String

    val briefInformation
        get() = "$name доступна: ${isAvailable.toRuText()}"
    val detailedInformation: String

    fun `return`() { isAvailable = true }
}
