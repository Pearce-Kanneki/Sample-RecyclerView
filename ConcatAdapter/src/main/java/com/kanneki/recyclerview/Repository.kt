package com.kanneki.recyclerview

import kotlin.random.Random

object Repository {

    fun createGroupedItemList(headerNumber: Int): List<GroupItem> {
        val groupedItemList = arrayListOf<GroupItem>()

        for (i in 0 until headerNumber) {
            val headerText = "Header $i"
            val header = GroupItem.Header(headerText)
            val itemList = arrayListOf<GroupItem.Item>()
            val indexNumber = Random.nextInt(2, 5)

            for (j in 0 until indexNumber) {
                val itemText = "Item $j"
                itemList.add(GroupItem.Item(itemText))
            }
            val groupedItem = GroupItem(header, itemList)
            groupedItemList.add(groupedItem)
        }

        return groupedItemList
    }
}