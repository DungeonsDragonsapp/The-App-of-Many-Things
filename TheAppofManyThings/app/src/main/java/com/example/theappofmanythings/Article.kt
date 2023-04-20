
package com.example.theappofmanythings
import androidx.annotation.Keep
import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SearchNewsResponse(
    @SerialName("results")
    val results: List<listSpell>?
) :java.io.Serializable

@Keep
@Serializable
data class listSpell(
    @SerialName("index")
    val index: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?,
) :java.io.Serializable

@Keep
@Serializable
data class CoolerSpell(
    @SerialName("index")
    val index: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?,
    @SerialName("level")
    val level: Int?,
    @SerialName("desc")
    val desc: List<String>?
) :java.io.Serializable

//god help me
@ParseClassName("Spells")
class Spell : ParseObject() {
    fun getLevel(): String? {
        return getString(KEY_LEVEL)
    }
    fun setLevel(make: String) {
        put(KEY_LEVEL, make.toInt())
    }
    fun getDescription(): String? {
        return getString(KEY_DESCRIPTION)
    }
    fun setDescription(descr: String) {
        put(KEY_DESCRIPTION, descr)
    }
    fun getName(): String? {
        return getString(KEY_NAME)
    }
    fun setName(sName: String) {
        put(KEY_NAME, sName)
    }
    fun getUser(): ParseUser? {
        return getParseUser(KEY_USER)
    }

    fun setUser(user: ParseUser) {
        put(KEY_USER, user)
    }

    //everything hurt

    companion object {
        const val KEY_NAME = "name"
        const val KEY_LEVEL = "level"
        const val KEY_DESCRIPTION = "description"
        //const val KEY_HORSEPOWER = "horsepower"
        const val KEY_USER = "user"
    }
}