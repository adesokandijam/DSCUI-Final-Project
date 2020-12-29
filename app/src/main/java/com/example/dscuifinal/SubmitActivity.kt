package com.example.dscuifinal

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.ask_dialog.*


class SubmitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_submit)

        setSupportActionBar(findViewById(R.id.my_toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val button = findViewById<Button>(R.id.submit_button)
        button.setOnClickListener()
        {
            createAskDialog()
        }
    }

    private fun createAskDialog() {
        val dialog: Dialog = Dialog(this)
        dialog.setContentView(R.layout.ask_dialog)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show()
        val window = dialog.window
        window!!.attributes = lp

        val yesButton:Button = dialog.findViewById<Button>(R.id.yes_button)
        yesButton.setOnClickListener {
            createDialog(R.layout.dialog_success)
            dialog.dismiss()
        }
        val cancelButton: ImageButton = dialog.findViewById<ImageButton>(R.id.cancel_button)
        cancelButton.setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun createDialog(view: Int)
    {
        val dialog: Dialog = Dialog(this)
        dialog.setContentView(view)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show()
        val window = dialog.window
        window!!.attributes = lp

    }
}


