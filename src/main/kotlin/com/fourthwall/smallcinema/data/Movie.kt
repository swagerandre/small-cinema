package com.fourthwall.smallcinema.data

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document
data class Movie(
    @Id val id: ObjectId,
    val imdbID: String,
    val title: String,
    val plot: String,
    val year: String,
    val released: String,
    val ratings: List<Rating>,
    val movieCatalog: MovieCatalog,
    val rated: String,
    val runtime: String )

@Document
data class MovieCatalog(
    @Id val id: String ,
    val price: BigDecimal,
    val time: LocalDateTime,
    val imdbID: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class MovieImdb(
    @Id  val imdbID: String,
    @JsonProperty("Title")    val title: String,
    @JsonProperty("Plot")     val plot: String,
    @JsonProperty("Year")     val year: String,
    @JsonProperty("Released") val released: String,
    @JsonProperty("Ratings")  val ratings: List<Rating>,
    @JsonProperty("Rated")    val rated: String,
    @JsonProperty("Runtime")  val runtime: String,
    @JsonIgnore               val price: BigDecimal,
    @JsonIgnore               val time: LocalDateTime
)



class Rating {
    @JsonProperty("Source")
    var source: String? = null

    @JsonProperty("Value")
    var value: String? = null
}


/* Another Properties from IMDB
@JsonProperty("Rated")
val rated: String ,
@JsonProperty("Runtime")
val runtime: String ,
@JsonProperty("Genre")
val genre: String ,
@JsonProperty("Director")
val director: String ,
@JsonProperty("Writer")
val writer: String ,
@JsonProperty("Actors")
val actors: String ,
@JsonProperty("Plot")
val plot: String ,
@JsonProperty("Language")
val language: String ,
@JsonProperty("Country")
val country: String ,
@JsonProperty("Awards")
val awards: String ,
@JsonProperty("Poster")
val poster: String ,
@JsonProperty("Ratings")
val ratings: List<Rating> ,
@JsonProperty("Metascore")
val metascore: String ,
val imdbRating: String ,
val imdbVotes: String ,
val imdbID: String ,
@JsonProperty("Type")
val type: String ,
@JsonProperty("DVD")
val dVD: String ,
@JsonProperty("BoxOffice")
val boxOffice: String ,
@JsonProperty("Production")
val production: String ,
@JsonProperty("Website")
val website: String ,
@JsonProperty("Response")
val response: String
)*/