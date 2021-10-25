package com.algebra.mvvmexample.ui

import androidx.lifecycle.ViewModel
import com.algebra.mvvmexample.data.Movie
import com.algebra.mvvmexample.data.MovieRepository

class MoviesViewModel( private val movieRepository : MovieRepository ) : ViewModel( ) {

    fun getMovies( )              = movieRepository.getMovies( )
    fun addMovie( movie : Movie ) = movieRepository.addMovie( movie )

}