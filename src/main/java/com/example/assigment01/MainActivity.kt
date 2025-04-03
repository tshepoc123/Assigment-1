package com.example.assigment01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize views
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val suggestButton = findViewById<Button>(R.id.submitButton)
        val mealSuggestion = findViewById<TextView>(R.id.mealSuggestion)
        val resetButton = findViewById<Button>(R.id.resetButton)
        // Set up click listener for the button
        suggestButton.setOnClickListener {
            // Get the time input as a string
            val inputTime = timeInput.text.toString()
        //Set up click listener for the resetButton
         resetButton.setOnClickListener {
             //Clear the time input field
             timeInput.text.clear()

             //Clear the meal suggestion text view
             mealSuggestion.text = ""
         }
             // Call function to suggest meal
            val suggestion = suggestMeal(inputTime)

            // Display the suggestion
            mealSuggestion.text = suggestion
        }
    }

    // Function to suggest a meal based on the time of day
    private fun suggestMeal(time: String): String {
        // Convert the input to lower case for easier comparison
        val timeOfDay = time.toLowerCase()

        return if (timeOfDay.contains("am")) {
            // Assuming breakfast time is from 6 AM to 11 AM
            if (timeOfDay.contains("6") || timeOfDay.contains("7") || timeOfDay.contains("8") ||
                timeOfDay.contains("9") || timeOfDay.contains("10") || timeOfDay.contains("11")) {
                "How about some pancakes or eggs for breakfast?"
            } else {
                "Please enter a valid breakfast time."
            }
        } else if (timeOfDay.contains("pm")) {
            // Assuming lunch time is from 12 PM to 4 PM
            if (timeOfDay.contains("12") || timeOfDay.contains("1") || timeOfDay.contains("2") ||
                timeOfDay.contains("3") || timeOfDay.contains("4")) {
                "How about a sandwich or salad for lunch?"
            } else if (timeOfDay.contains("5") || timeOfDay.contains("6") || timeOfDay.contains("7") ||
                timeOfDay.contains("8") || timeOfDay.contains("9")) {
                // Assuming dinner time is from 5 PM to 9 PM
                "How about some pasta or grilled chicken for dinner?"
            } else {
                "Please enter a valid lunch or dinner time."
            }
        } else {
            "Please enter a valid time (e.g., 7 AM or 3 PM)."
        }
    }
}
