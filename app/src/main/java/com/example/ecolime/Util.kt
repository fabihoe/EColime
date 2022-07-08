package com.example.ecolime;

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Patterns
import android.view.Gravity
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.ecolime.Activities.AvatarSelectionActivity
import com.example.ecolime.Interface.MessageListener
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern


class Util {


    companion object
    {
        fun showMessageDialog(context: Context,message:String,messageListener: MessageListener): Dialog
        {
            val dialog=Dialog(context)
            dialog.setContentView(R.layout.lyt_dialog_message)
            val window: Window=dialog.getWindow()!!
            window.setGravity(Gravity.BOTTOM)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            val txtMessage=dialog.findViewById<TextView>(R.id.txtMessage)
            val btnPositive: Button=dialog.findViewById(R.id.btnPositive)
            val btnNegative: Button=dialog.findViewById(R.id.btnNegative)

            txtMessage.text=message

            btnPositive.setOnClickListener {
                dialog.dismiss()
                messageListener.onSelected(true)
            }
            btnNegative.setOnClickListener {
                dialog.dismiss()
                messageListener.onSelected(false)
            }

            dialog.show();
            return dialog
        }


        fun getProgressDialog(context: Context,show:Boolean=false): Dialog
        {
            val dialog=Dialog(context)
            dialog.setContentView(R.layout.lyt_progress)
            val window: Window=dialog.window!!
            window.setGravity(Gravity.CENTER)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            dialog.setCancelable(false)

            if(show)
                dialog.show()
            return dialog
        }
        fun getProgressMessageDialog(context: Context): Dialog
        {
            val dialog=Dialog(context)
            dialog.setContentView(R.layout.lyt_progress_message)
            val window: Window=dialog.getWindow()!!
            window.setGravity(Gravity.CENTER)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            dialog.setCancelable(false)
            return dialog
        }

        fun isValidEmail(email:String):Boolean
        {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        fun showMessage(context: Context?, message: String?)
        {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }

        fun isEmpty(vararg  textInputLayouts: TextInputLayout ):Boolean
        {

            textInputLayouts.forEach { textinputlayout ->
                if(textinputlayout.editText!!.text.isEmpty())
                {
                    textinputlayout.editText!!.error="Required Field"
                    textinputlayout.editText!!.requestFocus()
                    return true
                }
            }
            return false
        }

        fun clearText(vararg  textInputLayouts: TextInputLayout)
        {

            textInputLayouts.forEach { textinputlayout ->
                textinputlayout.editText!!.text=null
            }
        }


    }
}