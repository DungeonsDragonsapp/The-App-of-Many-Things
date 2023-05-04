package com.example.theappofmanythings

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SkillActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.skill_page)


        val strength = character.getStrength()
        val dexterity = character.getDex()
        val constitution = character.getConst()
        val intelligence = character.getIntelligence()
        val wisdom = character.getWis()
        val charisma = character.getCharisma()

        val acrobatics = findViewById<TextView>(com.example.theappofmanythings.R.id.acrobatics)
        val animalHandling = findViewById<TextView>(com.example.theappofmanythings.R.id.animalHandling)
        val arcana = findViewById<TextView>(com.example.theappofmanythings.R.id.arcana)
        val athletics = findViewById<TextView>(com.example.theappofmanythings.R.id.athletics)
        val deception = findViewById<TextView>(com.example.theappofmanythings.R.id.deception)
        val history = findViewById<TextView>(com.example.theappofmanythings.R.id.history)
        val insight = findViewById<TextView>(com.example.theappofmanythings.R.id.insight)
        val intimidation = findViewById<TextView>(com.example.theappofmanythings.R.id.intimidation)
        val investigation = findViewById<TextView>(com.example.theappofmanythings.R.id.investigation)
        val medicine = findViewById<TextView>(com.example.theappofmanythings.R.id.medicine)
        val nature = findViewById<TextView>(com.example.theappofmanythings.R.id.nature)
        val perception = findViewById<TextView>(com.example.theappofmanythings.R.id.perception)
        val performance = findViewById<TextView>(com.example.theappofmanythings.R.id.performance)
        val persuasion = findViewById<TextView>(com.example.theappofmanythings.R.id.persuasion)
        val religion = findViewById<TextView>(com.example.theappofmanythings.R.id.religion)
        val sleightOfHand = findViewById<TextView>(com.example.theappofmanythings.R.id.sleightOfHand)
        val stealth = findViewById<TextView>(com.example.theappofmanythings.R.id.stealth)
        val survival = findViewById<TextView>(com.example.theappofmanythings.R.id.survival)

        val strengthMod = strength?.let { statModifier(it).toString() }
        val dexMod = dexterity?.let { statModifier(it).toString() }
        val constMod = constitution?.let { statModifier(it).toString() }
        val intMod = intelligence?.let { statModifier(it).toString() }
        val wisMod = wisdom?.let { statModifier(it).toString() }
        val charMod = charisma?.let { statModifier(it).toString() }

        acrobatics.text = "Acrobatics =$dexMod"
        animalHandling.text = "animalHandling =$wisMod"
        arcana.text = "arcana =$intMod"
        athletics.text = "athletics =$strengthMod"
        deception.text = "deception =$charMod"
        history.text = "history =$intMod"
        insight.text = "insight =$wisMod"
        intimidation.text = "intimidation =$charMod"
        investigation.text = "investigation =$intMod"
        medicine.text = "medicine =$wisMod"
        nature.text = "nature =$intMod"
        perception.text = "perception =$wisMod"
        performance.text = "performance =$charMod"
        persuasion.text = "persuasion =$charMod"
        religion.text = "religion =$intMod"
        sleightOfHand.text = "sleightOfHand =$dexMod"
        stealth.text = "stealth =$dexMod"
        survival.text = "survival =$wisMod"




    }

    fun statModifier(x: Int): Int {
        // Saving Throw Modifier = Corresponding Ability Score Modifier + Your Proficiency Bonus (if proficient)
        if (x<2)
        {
            return -5
        }
        if (x<4)
            return -4
        if (x<6)
            return -3
        if (x<8)
            return -2
        if (x<10)
            return -1
        if (x<12)
            return 0
        if (x<14)
            return 1
        if (x<16)
            return 2
        if (x<18)
            return 3
        if (x<20)
            return 4
        if (x<22)
            return 5
        if (x<24)
            return 6
        if (x<26)
            return 7
        if (x<28)
            return 8
        if (x<30)
            return 9
        if (x==30)
            return 10
        else
            return 0
    }
}