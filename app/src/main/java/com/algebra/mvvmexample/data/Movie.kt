package com.algebra.mvvmexample.data

data class Movie( val title : String, val director : String ) {
    override fun toString(): String {
        return "$title - $director"
    }
}