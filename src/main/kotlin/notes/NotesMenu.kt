package notes

import java.util.*

class NotesMenu {

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
        val errorMessageInput = "Необходимо ввести число соответствующее пункту меню"
        while (true) {
            showAllNotes(notesMenu)
            if (scan.hasNextInt()) {
                val userInput = scan.nextInt()
                if ((userInput > notesMenu.lastIndex) || (userInput < 0)) {
                    print(errorMessageInput)
                } else {
                    when (userInput) {
                        0 -> addToNotes(notesMenu)
                        notesMenu.size - 1 -> return
                        else -> {
                            println("Текст заметки: ")
                            println(notesMenu[userInput].textNote)
                        }
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