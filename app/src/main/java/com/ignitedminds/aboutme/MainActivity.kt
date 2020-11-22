package com.ignitedminds.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.ignitedminds.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val myName = MyName("Nayan Agarwal")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
        binding.done.setOnClickListener { addNickname(it) }
        binding.nicknameText.setOnClickListener { updateNickname(it) }
    }

    private fun addNickname(view : View){
       binding.apply {

           //Setting The Variable in DataBinding
           myName?.nickName = nicknameEdit.text.toString()

           //To Update All The Binding Objects
           invalidateAll()

           nicknameEdit.visibility = View.GONE
           view.visibility = View.GONE
           nicknameText.visibility = View.VISIBLE
       }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun updateNickname(view : View){
       binding.apply {
           view.visibility = View.GONE
           done.visibility = View.VISIBLE
           nicknameEdit.visibility= View.VISIBLE
           nicknameEdit.requestFocus()
           val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
           imm.showSoftInput(nicknameEdit,0)
       }

    }
}