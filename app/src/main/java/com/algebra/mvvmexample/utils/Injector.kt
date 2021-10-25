package com.algebra.mvvmexample.utils

import com.algebra.mvvmexample.data.MovieRepository
import com.algebra.mvvmexample.data.SimulatorDatabase
import com.algebra.mvvmexample.ui.MoviesViewModelFactory

object Injector {

    fun provideMoviseViewModelFactory( ) : MoviesViewModelFactory {
        val repository = MovieRepository.getInstance( SimulatorDatabase.getInstance( ).movieDao )
        return MoviesViewModelFactory( repository )
    }
}