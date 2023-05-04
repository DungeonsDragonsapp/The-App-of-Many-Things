package com.example.theappofmanythings

import androidx.annotation.Keep
import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseUser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Make : String
 * Model : File
 * User: User
 */

@Keep
@Serializable
data class listChar(
    @SerialName("index")
    val index: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?,

    @SerialName("race")
    val race: String?,
    @SerialName("class")
    val charClass: String?,
    @SerialName("level")
    val level: Int?,
    //@SerialName("image")
    //val image: ParseFile?,
    @SerialName("background")
    val background: String?,
    @SerialName("str")
    val str: Int?,
    @SerialName("dex")
    val dex: Int?,
    @SerialName("con")
    val con: Int?,
    @SerialName("int")
    val int: Int?,
    @SerialName("wis")
    val wis: Int?,
    @SerialName("charisma")
    val charisma: Int?,
    @SerialName("personality")
    val personality: String?,
    @SerialName("bond")
    val bond: String?,
    @SerialName("flaw")
    val flaw: String?,
    @SerialName("ideal")
    val ideal: String?,
) :java.io.Serializable

@ParseClassName("character")
class Character : ParseObject() {

    fun getUser(): ParseUser? {
        return getParseUser(KEY_USER)
    }

    fun setUser(user: ParseUser) {
        put(KEY_USER, user)
    }

    fun getName(): String? {
        return getString(KEY_NAME)
    }

    fun setName(make: String) {
        put(KEY_NAME, make)
    }
    fun getRace(): String? {
        return getString(KEY_RACE)
    }

    fun setRace(make: String) {
        put(KEY_RACE, make)
    }

    fun getClass(): String? {
        return getString(KEY_CLASS)
    }

    fun setClass(make: String) {
        put(KEY_CLASS, make)
    }

    fun getLevel(): Int? {
        return getInt(KEY_LEVEL)
    }

    fun setLevel(model: Int) {
        put(KEY_LEVEL, model)
    }

    fun getImage(): ParseFile? {
        return getParseFile(KEY_IMAGE)
    }

    fun setImage(parseFile: ParseFile) {
        put(KEY_IMAGE, parseFile)
    }

    fun getBackground(): String? {
        return getString(KEY_BACKGROUND)
    }

    fun setBackground(horsepower: String) {
        put(KEY_BACKGROUND, horsepower)
    }

    fun getStrength(): Int? {
        return getInt(KEY_STRENGTH)
    }

    fun setStrength(model: Int) {
        put(KEY_STRENGTH, model)
    }

    fun getDex(): Int? {
        return getInt(KEY_DEXTERITY)
    }

    fun setDex(model: Int) {
        put(KEY_DEXTERITY, model)
    }

    fun getConst(): Int? {
        return getInt(KEY_CONSTITUTION)
    }

    fun setConst(model: Int) {
        put(KEY_CONSTITUTION, model)
    }

    fun getIntelligence(): Int? {
        return getInt(KEY_INTELLIGENCE)
    }

    fun setIntelligence(model: Int) {
        put(KEY_INTELLIGENCE, model)
    }

    fun getWis(): Int? {
        return getInt(KEY_WISDOM)
    }

    fun setWis(model: Int) {
        put(KEY_WISDOM, model)
    }

    fun getCharisma(): Int? {
        return getInt(KEY_CHARISMA)
    }

    fun setCharisma(model: Int) {
        put(KEY_CHARISMA, model)
    }

    fun getPersonality(): String? {
        return getString(KEY_PERSONALITY)
    }

    fun setPersonality(horsepower: String) {
        put(KEY_PERSONALITY, horsepower)
    }

    fun getBonds(): String? {
        return getString(KEY_BONDS)
    }

    fun setBonds(horsepower: String) {
        put(KEY_BONDS, horsepower)
    }

    fun getFlaws(): String? {
        return getString(KEY_FLAWS)
    }

    fun setFlaws(horsepower: String) {
        put(KEY_FLAWS, horsepower)
    }
    fun getIdeals(): String? {
        return getString(KEY_IDEALS)
    }

    fun setIdeals(horsepower: String) {
        put(KEY_IDEALS, horsepower)
    }
    companion object {
        const val KEY_USER = "User"
        const val KEY_IMAGE = "img"
        const val KEY_NAME = "name"
        const val KEY_CLASS = "class"
        const val KEY_LEVEL = "level"
        const val KEY_RACE = "race"
        const val KEY_BACKGROUND = "background"
        const val KEY_STRENGTH = "Strength"
        const val KEY_DEXTERITY = "Dexterity"
        const val KEY_CONSTITUTION = "Constitution"
        const val KEY_INTELLIGENCE = "Intelligence"
        const val KEY_WISDOM = "Wisdom"
        const val KEY_CHARISMA = "Charisma"
        const val KEY_PERSONALITY = "Personality_Trait"
        const val KEY_BONDS= "Bonds"
        const val KEY_FLAWS = "Flaws"
        const val KEY_IDEALS = "Ideals"
    }
}