package com.example.thirdassignment_lecture5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.thirdassignment_lecture5.databinding.ActivityMainBinding


//● შევსებულია თუ არა ყველა ველი. +
//● “Username” ში შეყვანილი სიმბოლოების რაოდენობა არ უნდა იყოს 10-ზე ნაკლები. +
//● ვალიდურია თუ არა ელექტრონული ფოსტა +
//● “Age” უნდა იყოს მთელი დადებითი რიცხვი +
//● რომელიმე პირობის შეუსრულებლობის შემთხვევაში გამოტანეთ ეკრანზე შესაბამისი
//ტექსტური შეტყობინება.
//
//“Clear” ღილაკზე დაჭერისას ველები უნდა გასუფთავდეს. აღნიშული ოპერაცია უნდა სრულდებოდეს მხოლოდ იმ შემთხვევაში
// თუ მომხარებელმა ღილაკს დააჭირა ხანგრძლივად

class MainActivity : AppCompatActivity() {
    private lateinit var userame: EditText
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var  age: EditText
    private lateinit var save: Button
    private lateinit var clear: Button
    private var blankAlert = ""
    //sisulelea amdeni text massage
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val mail = ""
        val age = age.text.toString().toDouble()
//        var age: String = age.text.toString() //toInt tu ewereba avtomaturad gadaintavs, ar mawyobs

        binding.save.setOnClickListener{
            checkIfBlank()
            checkUserName()
            checkAge(age)
            checkEmailValidity()
            blankAlert = "Your Information is saved"
        }

        binding.clear.setOnClickListener{
            clearEverything()
        }
    }

    private fun clearEverything() {

    }

    private fun checkAge(age: Double): Boolean{
        if(age % 1 != 0.0){
            blankAlert = "Plase, enter Integer"
            return false
        }
        if(age < 1){
            blankAlert += "Please, enter number greater than 1"
            return false
        }
        return true
    } // checks if input is upper than 0 and Integer

    private fun checkEmailValidity(): Boolean {
        val matcher = android.util.Patterns.EMAIL_ADDRESS.matcher(binding.mail.toString())
        return matcher.matches() //returns if input matches mail type
    } // checks if input is email type: starts with alphanumeric chars, includes "@" and ".", is TLD...

    private fun checkUserName(): Boolean{
        if(userame.text.length < 10){
            blankAlert  = "Please, use 10 or more Characters"
            return false
        }
        return true
    } //checks if input has more then 10 characters

    private val editTextArray = arrayOf(binding.mail, userame, firstName, lastName, age)

    private fun checkIfBlank(): Boolean {
        for (editText in editTextArray) {
            if (editText.text.isNotBlank()) {
                blankAlert += "$editText"
            }
        }
        if(blankAlert != ""){
            blankAlert +="are Blank. Please, Fill in"
            return false
        }
        return true
    } //checks if every space is filled and returns alert if needed


}
