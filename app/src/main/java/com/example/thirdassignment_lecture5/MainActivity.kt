package com.example.thirdassignment_lecture5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thirdassignment_lecture5.databinding.ActivityMainBinding


//● შევსებულია თუ არა ყველა ველი. +
//● “Username” ში შეყვანილი სიმბოლოების
// რაოდენობა არ უნდა იყოს 10-ზე ნაკლები. +
//● ვალიდურია თუ არა ელექტრონული ფოსტა +
//● “Age” უნდა იყოს მთელი დადებითი რიცხვი +
//● რომელიმე პირობის შეუსრულებლობის შემთხვევაში გამოტანეთ ეკრანზე შესაბამისი
//ტექსტური შეტყობინება.
//
//“Clear” ღილაკზე დაჭერისას ველები უნდა გასუფთავდეს. აღნიშული ოპერაცია უნდა სრულდებოდეს მხოლოდ იმ შემთხვევაში
// თუ მომხარებელმა ღილაკს დააჭირა ხანგრძლივად

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        val mail = binding.mail
//        val age = age.text.toString().toDouble()
////        var age: String = age.text.toString() //toInt tu ewereba avtomaturad gadaintavs, ar mawyobs
//
//        username = binding.Username
//        firstName = binding.firstName
//        lastName = binding.lastName



        binding.save.setOnClickListener{
            checkIfBlank()
            checkUserName()
            checkAge()
            checkEmailValidity()
            binding.blankAlert.append("Your information is being saved")

        }

        binding.clear.setOnClickListener{
            clearEverything()
        }
    }

    private fun clearEverything() {
        binding.mail.text?.clear()
        binding.Username.text?.clear()
        binding.firstName.text?.clear()
        binding.lastName.text?.clear()
        binding.age.text?.clear()
    }

    private fun checkAge(){
        val age = binding.age.text.toString().toDouble()
        if(age % 1 != 0.0){
            binding.blankAlert.append("Please, enter Integer")
        }
        if(age < 1){
            binding.blankAlert.append("Please, enter number greater than 1")
        }
    } // checks if input is upper than 0 and Integer

    private fun checkEmailValidity(): Boolean {
        val matcher = android.util.Patterns.EMAIL_ADDRESS.matcher(binding.mail.toString())
        return matcher.matches() //returns if input matches mail type
    } // checks if input is email type: starts with alphanumeric chars, includes "@" and ".", is TLD...

    private fun checkUserName(): Boolean{
        if(binding.Username.text!!.length < 10){
            binding.blankAlert.append("Please, use 10 or more Characters")
            return false
        }
        return true
    } //checks if input has more then 10 characters



    private fun checkIfBlank(){

        val editTextArray = arrayOf(
            binding.mail,
            binding.Username,
            binding.firstName,
            binding.lastName,
            binding.age
        )

        for (editText in editTextArray) {
            if (editText.text!!.isNotBlank()) {
                binding.blankAlert.append("$editText")
            }
        }
        if(binding.blankAlert.text != ""){
            binding.blankAlert.append("are Blank. Please, Fill in")
        }
    } //checks if every space is filled and returns alert if needed


}
