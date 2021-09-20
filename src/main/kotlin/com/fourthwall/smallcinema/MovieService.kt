package com.fourthwall.smallcinema

import com.fourthwall.smallcinema.data.Movie
import com.fourthwall.smallcinema.data.MovieCatalog
import com.fourthwall.smallcinema.data.MovieImdb
import com.fourthwall.smallcinema.data.MovieRepository
import com.fourthwall.smallcinema.functions.omdbFastAndFuriousRequest
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class MovieService(
   val movieRepository: MovieRepository
) {

    fun getMovieDetails(): List<MovieImdb> {
        return try{ omdbFastAndFuriousRequest() } catch (r: RuntimeException ){ listOf<MovieImdb>()/**logger.error(r.message)*/}
    }

    fun getDateAndTimeOfaMovie(id: String): LocalDateTime {
        return movieRepository.findMovieCatalog(id).time
    }

    fun update(movie: MovieCatalog): MovieCatalog {
        return movieRepository.saveMovieCatalog(movie)
    }

    fun save(movie: Movie): Movie {
        return movieRepository.save(movie)
    }

}