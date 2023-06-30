package Archives

import Menu
import Notes.NMenu
import Notes.Notes
import java.util.Scanner
import kotlin.system.exitProcess


class AMenu : Menu {
    private val scan: Scanner = Scanner(System.`in`)
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

    private val notesMenu = NMenu()

    fun showAllArchivesMenu(): MutableList<Notes> {
        while (true) {
            showMenu()
            if (scan.hasNextInt()) {
                val userInput = scan.nextInt()
                if ((userInput > menuForArchive.size - 1) || (userInput < 0)) {
                    println("Необходимо ввести число соответствующее пункту меню")
                }
                when (userInput) {
                    0 -> addToMenu()
                    menuForArchive.size - 1 -> exitProcess(0)
                    else -> notesMenu.addToNotesMenu(menuForArchive[userInput].listForNotes)
                }
            } else {
                if (scan.nextLine().isNotEmpty()) {
                    println("Необходимо ввести число соответствующее пункту меню")
                }
            }
            continue
        }
    }
}