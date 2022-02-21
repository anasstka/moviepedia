package com.anasstka.moviepedia.domain.model

data class Cast(
    val id: Int,
    val knownForDepartment: String,
    val name: String,
    val profile: String,
    val character: String,
)