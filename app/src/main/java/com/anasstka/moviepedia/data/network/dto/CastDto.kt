package com.anasstka.moviepedia.data.network.dto

import com.anasstka.moviepedia.domain.model.Cast
import com.google.gson.annotations.SerializedName

data class CastDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_path")
    val profile: String,
    @SerializedName("character")
    val character: String,
)

fun CastDto.toCast(): Cast =
    Cast(
        id = id,
        knownForDepartment = knownForDepartment,
        name = name,
        profile = profile,
        character = character
    )