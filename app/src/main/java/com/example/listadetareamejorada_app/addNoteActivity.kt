package com.example.listadetareamejorada_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listadetareamejorada_app.databinding.ActivityAddNoteBinding

class addNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NoteDataBaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDataBaseHelper(this)

        binding.saveBtn.setOnClickListener{
            val title = binding.titleET.text.toString()
            val content = binding.contentET.text.toString()
            val note = Note(0, title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show()
        }

    }
}