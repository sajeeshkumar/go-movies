package net.sajeesh.go.movies

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import scala.concurrent.duration._

object Scenarios {

    val rampUpTimeSecs = 10

	/*
	 *	HTTP scenarios
     */

	// Browse
	val browse_guids = csv("movies.csv").circular
	val scn_Browse = scenario("GetMovies")
      .during(Conf.duration) {
		feed(browse_guids)
		.exec(
          http("GetMovies")
            .get("/movies/" + "${movieID}")
            .headers(Headers.http_header)
            .check(status.is(200))
          )
        .pause(1)
    }
}
