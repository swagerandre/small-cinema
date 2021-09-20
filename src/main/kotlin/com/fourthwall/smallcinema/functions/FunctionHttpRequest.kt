package com.fourthwall.smallcinema.functions

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fourthwall.smallcinema.data.Movie
import com.fourthwall.smallcinema.data.MovieImdb
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration

const val FAST_AND_FURIOUS: String = "https://http://www.omdbapi.com/?i=tt0232500&apikey=7e05e95e"

fun httpRequest(uri: String) =
    jacksonObjectMapper().readValue<List<Any>>(
                    HttpClient.newHttpClient()
                              .sendAsync(HttpRequest.newBuilder(URI(uri))
                              .timeout(Duration.ofMinutes(2))
                              .header("Accept", "application/json")
                              .build(), HttpResponse.BodyHandlers.ofString())
                              .thenApply{it.body()}
                              .get())

fun omdbFastAndFuriousRequest() =
    httpRequest(FAST_AND_FURIOUS) as List<MovieImdb>