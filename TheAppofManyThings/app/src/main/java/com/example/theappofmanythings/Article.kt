
package com.example.theappofmanythings
import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SearchNewsResponse(
    @SerialName("results")
    val results: List<Spell>?
) :java.io.Serializable

@Keep
@Serializable
data class Spell(
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

