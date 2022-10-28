package com.weborient.inventory.models

data class AttributeModel(
    val name: String,
    val type: AttributeTypeModel,
    val unit: String?,
    val valueSet: ArrayList<String>?
)