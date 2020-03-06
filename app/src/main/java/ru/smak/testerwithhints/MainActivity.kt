package ru.smak.testerwithhints

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHint.setOnClickListener {
            showHintActivity()
        }
    }

    private fun showHintActivity() {
        val userText = this.userText.text.toString()
        val i = Intent(this,
            HintActivity::class.java)
        i.putExtra(
            HintActivity.USER_TEXT,
            userText
        )
        startActivityForResult(i, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data!=null){
            val r =
                data.getStringExtra(HintActivity.USER_RESULT)
            userText.setText(r)
        }
    }
}
