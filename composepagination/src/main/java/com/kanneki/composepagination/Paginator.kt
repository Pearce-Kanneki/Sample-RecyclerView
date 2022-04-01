package com.kanneki.composepagination

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}