package com.example.theappofmanythings
import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.parse.ParseObject


class statChangeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.stat_changer)

        val strengthAdd = findViewById<Button>(com.example.theappofmanythings.R.id.strengthPlusButton)
        val strengthSubtract = findViewById<Button>(com.example.theappofmanythings.R.id.strengthMinusButton)

        val strengthReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.strengthReplace)
        val dexReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.dexReplace)
        val constReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.constReplace)
        val intReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.intReplace)
        val wisReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.wisReplace)
        val charReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.charReplace)

        val changeToSaving = findViewById<Button>(com.example.theappofmanythings.R.id.savingPage)
        val changeToSkills = findViewById<Button>(com.example.theappofmanythings.R.id.backButton)

        strengthReplace.text = character.getStrength().toString()
        /*dexReplace.text =
        constReplace.text =
        intReplace.text =
        wisReplace.text =
        charReplace.text = */

        strengthAdd.setOnClickListener{
            var strength = character.getStrength()?.toInt()
            if (strength != null) {
                strength += 1
            }
            if (strength != null) {
                character.setStrength(strength)
            }
            strengthReplace.text = character.getStrength().toString()
            character.saveInBackground()
        }

        strengthSubtract.setOnClickListener {
            var strength = character.getStrength()?.toInt()
            if (strength != null) {
                strength -= 1
            }
            if (strength != null) {
                character.setStrength(strength)
            }
            strengthReplace.text = character.getStrength().toString()
            character.saveInBackground()
        }

        changeToSkills.setOnClickListener {
            val intent = Intent(this@statChangeActivity, SkillActivity::class.java)
            startActivity(intent)
        }
        changeToSaving.setOnClickListener {
            val intent = Intent(this@statChangeActivity, SavingThrowsActivity::class.java)
            startActivity(intent)
        }
        }
}