package com.fourthwall.smallcinema.controller

import com.fourthwall.smallcinema.MovieService
import com.fourthwall.smallcinema.data.Movie
import com.fourthwall.smallcinema.data.MovieCatalog
import com.fourthwall.smallcinema.data.MovieImdb
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.LocalDateTime
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/movies")
class MovieController( val service: MovieService ) {

    @Operation(summary = "Get all movies")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200",
                    description = "Found Foos",
                    content = [Content( mediaType = "application/json",
                    array = (ArraySchema(schema = Schema(implementation = Movie::class))))]),
        ApiResponse(responseCode = "400", description = "Bad request", content = []),
        ApiResponse(responseCode = "404", description = "Did not find any Foos", content = [])])
    @GetMapping
    fun getMovieDetails(): List<MovieImdb> {
       return service.getMovieDetails()
    }

    @GetMapping("/{id}")
    fun getMovieTime(id: String): LocalDateTime {
        return service.getDateAndTimeOfaMovie(id)
    }

    @PatchMapping("/{movie}")
    fun changePriceAndTimeOfaMovie(@RequestBody movie: MovieCatalog){
        service.update(movie)
    }


/*

    @PostMapping
    fun createPatient(@RequestBody request: movieRequest): Mono<Movie> {
        return repository.save(Movie(name = request.name))
    }

    @GetMapping("/{id}")
    fun getOnePatient(@PathVariable("id") id: String): Mono<Movie> {
        return repository.findOneById(ObjectId(id))
    }
*/

    object movieRequest {val name : String = ""}
}