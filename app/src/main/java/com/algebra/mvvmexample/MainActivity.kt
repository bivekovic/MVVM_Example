package com.algebra.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.algebra.mvvmexample.data.Movie
import com.algebra.mvvmexample.ui.MoviesViewModel
import com.algebra.mvvmexample.utils.Injector
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity( ) {

    // val repository = MovieRepository.getInstance( SimulatorDatabase.getInstance( ).movieDao )

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        sutupUI( )
    }

    private fun sutupUI( ) {

        val factory = Injector.provideMoviseViewModelFactory( )
        val viewModel = ViewModelProvider( this, factory ).get( MoviesViewModel::class.java )

        viewModel.getMovies( ).observe( this, { movies ->
            val stringBuilder = StringBuilder( )
            movies.forEach {
                stringBuilder.append( "$it\n\n")
            }
            tvMovies.text = stringBuilder.toString( )
        } )

        bAdd.setOnClickListener {
            val movie = Movie( etTitle.text.toString( ), etDirector.text.toString( ) )
            viewModel.addMovie( movie )

            /*
            repository.addMovie( movie )
            val stringBuilder = StringBuilder( )
            repository.getMovies( ).forEach {
                stringBuilder.append( "$it\n\n")
            }
            tvMovies.text = stringBuilder.toString( )
            */

            etTitle.text.clear( )
            etDirector.text.clear( )
            etTitle.requestFocus( )
        }
    }
}