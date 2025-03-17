package code.yakovenko.models

import code.yakovenko.extensions.toRuText

class Book(
    override val id: Int,
    override var isAvailable: Boolean,
    override val name: String,
    private val pagesNumber: Int,
    private val author: String,
): LibraryItem {
    override val className = "Книга"

    override val detailedInformation: String
        get() = "книга: $name ($pagesNumber стр.) автора: $author с id: $id доступна: ${isAvailable.toRuText()}"
}
