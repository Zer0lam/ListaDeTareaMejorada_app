package com.example.listadetareamejorada_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listadetareamejorada_app.databinding.ActivityUpdateNoteBinding
import com.example.listadetareamejorada_app.databinding.NoteItemBinding

class UpdateNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateNoteBinding
    private lateinit var db: NoteDataBaseHelper
    private var noteId: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDataBaseHelper(this)

        noteId = intent.getIntExtra("note_id",-1)
        if(noteId == -1){
            finish()
            return
        }

        val note = db.getNoteById(noteId)
        binding.titleETU.setText(note.title)
        binding.contentETU.setText(note.content)

        binding.saveBtnU.setOnClickListener {
            val newTitle = binding.titleETU.text.toString()
            val newContent = binding.contentETU.text.toString()
            val updateNote = Note(noteId,newTitle,newContent)
            db.updateNote(updateNote)
            finish()
            Toast.makeText(this,"Cambios realizados", Toast.LENGTH_SHORT).show()
        }
    }
}