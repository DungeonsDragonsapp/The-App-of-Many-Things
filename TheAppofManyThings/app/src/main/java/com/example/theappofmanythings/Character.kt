package com.example.theappofmanythings

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Character(
    @SerialName("level")
    val level: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("race")
    val race: String?,
    @SerialName("background")
    val background: String?,
    @SerialName("Strength")
    val Strength: Int?,
    @SerialName("Dexterity")
    val Dexterity: Int?,
    @SerialName("Constitution")
    val Constitution: Int?,
    @SerialName("Intelligence")
    val Intelligence: Int?,
    @SerialName("Wisdom")
    val Wisdom: Int?,
    @SerialName("Charisma")
    val Charisma: Int?,

) :java.io.Serializable