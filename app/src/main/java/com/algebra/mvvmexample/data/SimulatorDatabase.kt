package com.algebra.mvvmexample.data

class SimulatorDatabase private  constructor( ) {

    var movieDao = SimulatorMovieDao( )
            private set

    companion object {
        @Volatile private var instance : SimulatorDatabase? = null

        fun getInstance( ) = instance ?: synchronized( this ) {
            instance ?: SimulatorDatabase( ).also { instance = it }
        }
    }
}