
package com.example.theappofmanythings
import androidx.annotation.Keep
import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class InitSpellResp(
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
data class InitItemResp(
    @SerialName("results")
    val results: List<listEquip>?
) :java.io.Serializable

@Keep
@Serializable
data class listEquip(
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

@Keep
@Serializable
data class CoolerItem(
    @SerialName("index")
    val index: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?,
    @SerialName("cost")
    val cost: CostInfo,
    //most items lack descriptions
    @SerialName("desc")
    val desc: List<String>,
    @SerialName("equipment_category")
    val equipment_category: EquipCategory?
) :java.io.Serializable

@ParseClassName("Items")
class Item : ParseObject() {
    fun getQuantity(): Int? {
        return getInt(KEY_QUANTITY)
    }
    fun setQuantity(make: Int) {
        put(KEY_QUANTITY, make)
    }

    fun getUnit(): String? {
        return getString(KEY_UNIT)
    }
    fun setUnit(unit: String) {
        put(KEY_UNIT, unit)
    }

    fun getCategory(): String? {
        return getString(KEY_CATEGORY)
    }

    fun setCategory(unit: String) {
        put(KEY_CATEGORY, unit)
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
        const val KEY_UNIT = "unit"
        const val KEY_QUANTITY = "quantity"
        const val KEY_DESCRIPTION = "description"
        const val KEY_CATEGORY = "category"
        const val KEY_USER = "user"
    }
}

@Keep
@Serializable
data class CostInfo(
    @SerialName("quantity")
    val quantity: Integer,
    @SerialName("unit")
    val unit: String?
)

@Keep
@Serializable
data class EquipCategory(
    @SerialName("index")
    val index: String?,
    @SerialName("name")
    val name: String?
)

@ParseClassName("Spells")
class Spell : ParseObject() {
    fun getLevel(): Int? {
        return getInt(KEY_LEVEL)
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
        const val KEY_USER = "user"
    }
}