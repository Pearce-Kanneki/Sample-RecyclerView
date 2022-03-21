package com.kanneki.recyclerview

data class GroupItem(
    val header: Header,
    val itemList: List<Item>
) {

    data class Header(
        val headerText: String
    )

    data class Item(
        val itemText: String
    )
}
