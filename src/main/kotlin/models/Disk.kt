package code.yakovenko.models

import code.yakovenko.extensions.toRuText

typealias DiskType = String

const val CD: DiskType = "CD"
const val DVD: DiskType = "DVD"

class Disk(
    override val id: Int,
    override var isAvailable: Boolean,
    override val name: String,
    private val type: DiskType
): LibraryItem {
    override val className = "Диск"

    override val detailedInformation: String
        get() = "$type $name доступен: ${isAvailable.toRuText()}"
}
