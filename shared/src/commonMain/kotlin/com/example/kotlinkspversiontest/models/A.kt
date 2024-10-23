package com.example.kotlinkspversiontest.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class A (
    @SerialName("b")
    val b: String? = null
)