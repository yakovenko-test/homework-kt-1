package code.yakovenko.models

import code.yakovenko.feature.HomeTakeable
import code.yakovenko.feature.Readable
import code.yakovenko.extensions.toRuText

class Book(
    override val id: Int,
    override val name: String,
    private val pagesNumber: Int,
    private val author: String,
    availability: Boolean,
): Readable, HomeTakeable {
    override var isAvailable = availability
    override val className = "Книга"

    override val detailedInformation: String
        get() = "книга: $name ($pagesNumber стр.) автора: $author с id: $id доступна: ${isAvailable.toRuText()}"
}
