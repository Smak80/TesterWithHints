package ru.smak.testerwithhints

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hint.*

class HintActivity : AppCompatActivity() {

    companion object{
        val USER_TEXT = "ru.smak.testerwithhints.user_text"
        val USER_RESULT = "ru.smak.testerwithhints.user_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hint)
        val userText = intent.getStringExtra(USER_TEXT)
        userTextView.text = userText ?: "Нет информации"
        editText.setOnKeyListener { v, keyCode, event ->
            updateResult()
            false
        }
    }

    private fun updateResult() {
        val i = Intent()
        i.putExtra(USER_RESULT, editText.text.toString())
        setResult(0, i)
    }
}
