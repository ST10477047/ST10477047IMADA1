package vcmsa.ci.imada1atempt2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Declaring Variables

        val timeInput = findViewById<EditText>(R.id.timeInput)
        val suggestMeal = findViewById<Button>(R.id.suggestMeal)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val displaySuggest = findViewById<TextView>(R.id.displaySuggest)

        suggestMeal.setOnClickListener {
            Toast.makeText(this@MainActivity, "Generating Suggestion...", Toast.LENGTH_SHORT).show()

            if (timeInput.text.toString().equals("Morning", ignoreCase = true)) {
                displaySuggest.setText("Meal recommendation:\nChicken, Rice, Egg Whites")
            } else if (timeInput.text.toString().equals("Mid-Morning", ignoreCase = true)) {
                displaySuggest.setText("Meal recommendation:\nNartjie")
            } else if (timeInput.text.toString().equals("Afternoon", ignoreCase = true)) {
                displaySuggest.setText("Meal recommendation:\nBeef Steak, Rice, Egg Whites")
            } else if (timeInput.text.toString().equals("Afternoon Snack", ignoreCase = true)) {
                displaySuggest.setText("Meal recommendation:\nBiltong")
            } else if (timeInput.text.toString().equals("Dinner", ignoreCase = true)) {
                displaySuggest.setText("Meal recommendation\nOstrich Steak, Rice, Egg Whites")
            } else if (timeInput.text.toString().equals("After Dinner", ignoreCase = true)) {
                displaySuggest.setText("Meal recommendation: \nProtein Shake")
            } else {
                Toast.makeText(this@MainActivity, "Invalid input! Please enter a valid meal time :)", Toast.LENGTH_LONG).show()
                displaySuggest.setText("Please enter one of the following:\nMorning\nMid-Morning\nAfternoon Snack\nDinner\nAfter Dinner")
            }
        }

        resetButton.setOnClickListener{
            timeInput.setText("")
            displaySuggest.setText("Please enter one of the following:\nMorning\nMid-Morning\nAfternoon Snack\nDinner\nAfter Dinner")
            Toast.makeText(this@MainActivity, "Reset successful :)", Toast.LENGTH_SHORT).show()
        }
    }
}