package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    /* we need to initialize this binding object inside the onCreate(), it is a lair of glue between the layout and the data.
       the ActivityMainBinding class is created by the compiler specifically for this main activity and the name is  derived
       from the layout file (that is activity_main + binding) */
    private lateinit var binding: ActivityMainBinding

    // create the actual data for the Data Binding
    private val myName: MyName = MyName("Pietro Mennea")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // we need to replace setContentView with an instruction to create a binding object with all the magic that connects the layout activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
       // setContentView(R.layout.activity_main)

        /** WE CAN ACCESS NOW THE BUTTON THROUGH THE DATA BINDING
        we need to set an onClickListener for the btn inside onCreate()
        done_button.setOnClickListener{
        addNickname(it) // we pass inner reference to the handler (it in this context refers to the btn)
        }*/
        binding.doneButton.setOnClickListener{
            addNickname(it)
        }

        binding.myName = myName


    }

    /**
    // we need to implement the code that processes the button click and gets the text sets into the textView and swaps visibility
    private fun addNickname(view: View){ // view -> is the view on which the function is called (DONE btn)
    // we  set the text that is passed inside the editText to the TextView
    nickname_text.text = nickname_edit.text
    // we hide the EditText and the Button
    nickname_edit.visibility = View.GONE
    view.visibility = View.GONE
    // we set the TextView as visible
    nickname_text.visibility = View.VISIBLE

    // Hide the keyboard
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
    */
    // Now we can also access the views inside the method by using the data binding
    private fun addNickname(view: View){

        // we use apply to make the code easier to read
        binding.apply{
            // nicknameText.text = nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            // in order to refresh the UI with the new data we need to invalidate all the binding expression so they get recreated with the correct data
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}