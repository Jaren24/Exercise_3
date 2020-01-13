package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            var gender:String? = ""
            val age = spinnerAge.selectedItem as String

            if(radioButtonMale.isChecked)
                 gender = "Male"
            else
                gender = "Female"
            var smoker = checkBoxSmoker.isChecked
            var premium = 0
            var extra = 0
            Log.d("MainActivity", gender)
            when(age){
               "Less than 17" -> premium = 60
                "17 to 25" -> {
                    premium = 70
                    if(gender.equals("Male"))
                        extra += 50
                    if(smoker)
                        extra += 100
                }
                "26 to 30" -> {
                    premium = 90
                    if(gender.equals("Male"))
                        extra += 100
                    if(smoker)
                        extra += 150
                }
                "31 to 40" -> {
                    premium = 120
                    if(gender.equals("Male"))
                        extra += 150
                    if(smoker)
                        extra += 200
                }

                "41 to 55" -> {
                    premium = 150
                    if(gender.equals("Male"))
                        extra += 200
                    if(smoker)
                        extra += 250
                }
                "More than 55" -> {
                    premium = 150
                    if(gender.equals("Male"))
                        extra += 200
                    if(smoker)
                        extra += 300
                }
            }
            textViewPremium.text = "RM"+(premium+extra).toString()
        }
        buttonReset.setOnClickListener {
            spinnerAge.setSelection(0)
            radioButtonMale.isChecked = false
            radioButtonFemale .isChecked = false
            checkBoxSmoker.isChecked = false
            textViewPremium.text = "Insurance Premium: "
        }
    }

}
