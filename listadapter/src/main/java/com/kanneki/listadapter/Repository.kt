package com.kanneki.listadapter

object Repository {

    fun createFakeList(Number: Int): List<MyItem> {
        val fakeList = arrayListOf<MyItem>()

        for (i in 0 until Number) {
            val tmp = MyItem(
                id = i,
                title = "Item $i",
                content = "Content $i"
            )

            fakeList.add(tmp)
        }

        return fakeList
    }
}