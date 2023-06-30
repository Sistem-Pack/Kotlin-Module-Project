import Archives.AMenu

fun main() {
    val myArchive = AMenu()
    myArchive.showAllArchivesMenu()
}

interface Menu {
    fun showMenu()
    fun addToMenu()
}