package com.fourthwall.smallcinema.data
import com.fourthwall.smallcinema.data.Movie
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface MovieRepository : MongoRepository<Movie, String> {
    fun findOneById(id: ObjectId): Movie

    fun saveMovieCatalog(movieCatalog: MovieCatalog): MovieCatalog

    fun findMovieCatalog(id: String): MovieCatalog
}
