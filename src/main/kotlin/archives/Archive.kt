package archives

import notes.Notes

data class Archive(
    val name: String,
    var listForNotes: MutableList<Notes>
)