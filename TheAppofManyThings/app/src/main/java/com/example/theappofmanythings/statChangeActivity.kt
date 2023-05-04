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
        val dexAdd = findViewById<Button>(com.example.theappofmanythings.R.id.dexPlusButton)
        val dexSubtract = findViewById<Button>(com.example.theappofmanythings.R.id.dexMinusButton)
        val constAdd = findViewById<Button>(com.example.theappofmanythings.R.id.constPlusButton)
        val constSubtract = findViewById<Button>(com.example.theappofmanythings.R.id.constMinusButton)
        val intAdd = findViewById<Button>(com.example.theappofmanythings.R.id.intPlusButton)
        val intSubtract = findViewById<Button>(com.example.theappofmanythings.R.id.intMinusButton)
        val wisAdd = findViewById<Button>(com.example.theappofmanythings.R.id.wisPlusButton)
        val wisSubtract = findViewById<Button>(com.example.theappofmanythings.R.id.wisMinusButton)
        val charAdd = findViewById<Button>(com.example.theappofmanythings.R.id.charPlusButton)
        val charSubtract = findViewById<Button>(com.example.theappofmanythings.R.id.charMinusButton)



        val strengthReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.strengthReplace)
        val dexReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.dexReplace)
        val constReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.constReplace)
        val intReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.intReplace)
        val wisReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.wisReplace)
        val charReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.charReplace)

        val changeToSaving = findViewById<Button>(com.example.theappofmanythings.R.id.savingPage)
        val changeToSkills = findViewById<Button>(com.example.theappofmanythings.R.id.backButton)

        strengthReplace.text = character.getStrength().toString()
        dexReplace.text = character.getDex().toString()
        constReplace.text = character.getConst().toString()
        intReplace.text = character.getIntelligence().toString()
        wisReplace.text = character.getWis().toString()
        charReplace.text = character.getCharisma().toString()

        strengthAdd.setOnClickListener{
            var strength = character.getStrength()?.toInt()
            if (strength != null && strength < 30) {
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
            if (strength != null && strength > 0) {
                strength -= 1
            }
            if (strength != null) {
                character.setStrength(strength)
            }
            strengthReplace.text = character.getStrength().toString()
            character.saveInBackground()
        }

        dexAdd.setOnClickListener{
            var strength = character.getDex()?.toInt()
            if (strength != null && strength < 30) {
                strength += 1
            }
            if (strength != null) {
                character.setDex(strength)
            }
            dexReplace.text = character.getDex().toString()
            character.saveInBackground()
        }

        dexSubtract.setOnClickListener{
            var strength = character.getDex()?.toInt()
            if (strength != null && strength > 0) {
                strength -= 1
            }
            if (strength != null) {
                character.setDex(strength)
            }
            dexReplace.text = character.getDex().toString()
            character.saveInBackground()
        }

        constAdd.setOnClickListener{
            var strength = character.getConst()?.toInt()
            if (strength != null && strength < 30) {
                strength += 1
            }
            if (strength != null) {
                character.setConst(strength)
            }
            constReplace.text = character.getConst().toString()
            character.saveInBackground()
        }

        constSubtract.setOnClickListener{
            var strength = character.getConst()?.toInt()
            if (strength != null && strength > 0) {
                strength -= 1
            }
            if (strength != null) {
                character.setConst(strength)
            }
            constReplace.text = character.getConst().toString()
            character.saveInBackground()
        }

        intAdd.setOnClickListener{
            var strength = character.getIntelligence()?.toInt()
            if (strength != null && strength < 30) {
                strength += 1
            }
            if (strength != null) {
                character.setIntelligence(strength)
            }
            intReplace.text = character.getIntelligence().toString()
            character.saveInBackground()
        }

        intSubtract.setOnClickListener{
            var strength = character.getIntelligence()?.toInt()
            if (strength != null && strength > 0) {
                strength -= 1
            }
            if (strength != null) {
                character.setIntelligence(strength)
            }
            intReplace.text = character.getIntelligence().toString()
            character.saveInBackground()
        }

        wisAdd.setOnClickListener{
            var strength = character.getWis()?.toInt()
            if (strength != null && strength < 30) {
                strength += 1
            }
            if (strength != null) {
                character.setWis(strength)
            }
            wisReplace.text = character.getWis().toString()
            character.saveInBackground()
        }

        wisSubtract.setOnClickListener{
            var strength = character.getWis()?.toInt()
            if (strength != null && strength > 0) {
                strength -= 1
            }
            if (strength != null) {
                character.setWis(strength)
            }
            wisReplace.text = character.getWis().toString()
            character.saveInBackground()
        }

        charAdd.setOnClickListener{
            var strength = character.getCharisma()?.toInt()
            if (strength != null && strength < 30) {
                strength += 1
            }
            if (strength != null) {
                character.setCharisma(strength)
            }
            charReplace.text = character.getCharisma().toString()
            character.saveInBackground()
        }

        charSubtract.setOnClickListener{
            var strength = character.getCharisma()?.toInt()
            if (strength != null && strength > 0) {
                strength -= 1
            }
            if (strength != null) {
                character.setCharisma(strength)
            }
            charReplace.text = character.getCharisma().toString()
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