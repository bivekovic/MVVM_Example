package com.algebra.mvvmexample.data

class MovieRepository private constructor( private val movieDao : SimulatorMovieDao ) {

    fun addMovie( movie : Movie ) {
        movieDao.addMovie( movie )
    }

    fun getMovies( ) = movieDao.getMovies( )

    companion object {
        @Volatile private var instance : MovieRepository? = null

        fun getInstance( movieDao : SimulatorMovieDao ) = instance ?: synchronized( this ) {
            instance ?: MovieRepository( movieDao ).also { instance = it }
        }
    }
}