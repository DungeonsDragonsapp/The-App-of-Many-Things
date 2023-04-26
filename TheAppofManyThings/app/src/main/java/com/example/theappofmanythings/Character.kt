package com.example.theappofmanythings

import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseUser

/**
 * Make : String
 * Model : File
 * User: User
 */
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
    }
}