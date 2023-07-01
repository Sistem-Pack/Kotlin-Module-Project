import archives.ArchiveMenu

fun main() {
    val myArchive = ArchiveMenu()
    myArchive.showAllArchivesMenu()
}

interface Menu {
    fun showMenu()
    fun addToMenu()
}