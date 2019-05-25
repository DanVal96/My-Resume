package com.example.data.models

import com.google.gson.annotations.SerializedName

data class Abilities (
	@SerializedName("name")
	val name : String?,
	@SerializedName("level")
	val level : String?,
	@SerializedName("keywords")
	val keywords : List<String>?
)