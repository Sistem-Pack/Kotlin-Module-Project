package archives

import Menu
import notes.NotesMenu
import notes.Notes
import java.util.Scanner
import kotlin.system.exitProcess


class ArchiveMenu : Menu {
    private val scan: Scanner = Scanner(System.`in`)
    private val notesMenu = NotesMenu()
    private val menuForArchive: MutableList<Archive> = mutableListOf(
        Archive("Создать архив", mutableListOf()),
        Archive("Выход", mutableListOf())
    )

    override fun showMenu() {
        val numbersIterator = menuForArchive.iterator().withIndex()
        println("АРХИВЫ:")
        while (numbersIterator.hasNext()) {
            numbersIterator.forEach {
                println("${it.index}. " + it.value.name)
            }
        }
    }

    override fun addToMenu() {
        println("Введите название архива")
        while(scan.hasNextLine()) {
            val userInput = scan.next()
            menuForArchive.add(menuForArchive.size - 1, Archive(userInput, mutableListOf()))
            break
        }
    }

    fun showAllArchivesMenu(): MutableList<Notes> {
        val errorMessageInput = "Необходимо ввести число соответствующее пункту меню"
        while (true) {
            showMenu()
            if (scan.hasNextInt()) {
                val userInput = scan.nextInt()
                if ((userInput > menuForArchive.lastIndex) || (userInput < 0)) {
                    println(errorMessageInput)
                } else {
                    when (userInput) {
                        0 -> addToMenu()
                        menuForArchive.lastIndex -> exitProcess(0)
                        else -> notesMenu.addToNotesMenu(menuForArchive[userInput].listForNotes)
                    }
                }
            } else {
                if (scan.nextLine().isNotEmpty()) {
                    println(errorMessageInput)
                }
            }
        }
    }
}