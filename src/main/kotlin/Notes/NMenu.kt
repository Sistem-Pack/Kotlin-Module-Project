package Notes

import java.util.*

class NMenu {

    private val scan = Scanner(System.`in`)

    private fun addToNotes(notesMenu: MutableList<Notes>) {
        println("Введите название заметки")
        val noteName = scan.next()
        println("Введите текст заметки")
        val noteText = scan.next()
        notesMenu.add(notesMenu.size - 1, Notes(noteName, noteText))
        println("Заметка создана")
    }

    private fun showAllNotes(notesMenu: MutableList<Notes>) {
        println("3AMETKИ:")
        val numbersIterator = notesMenu.iterator().withIndex()
        while (numbersIterator.hasNext()) {
            numbersIterator.forEach {
                println("${it.index}. " + it.value.name)
            }
        }
    }

    fun addToNotesMenu(notesMenu: MutableList<Notes>) {
        if (notesMenu.isEmpty()) {
            notesMenu.add(Notes("Добавить заметку", ""))
            notesMenu.add(Notes("Выход", ""))
        }
        while (true) {
            showAllNotes(notesMenu)
            if (scan.hasNextInt()) {
                val userInput = scan.nextInt()
                if ((userInput > notesMenu.size - 1) || (userInput < 0)) {
                    print("Необходимо ввести число соответствующее пункту меню")
                }
                when (userInput) {
                    0 -> addToNotes(notesMenu)
                    notesMenu.size - 1 -> return
                    else -> {
                        println("Текст заметки: ")
                        println(notesMenu[userInput].textNote)
                    }
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