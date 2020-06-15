package hacker.cup.poc.server.service

import cats.effect.{ContextShift, IO, Timer}
import org.http4s.server.{Router}
import org.http4s.{HttpApp}
import org.http4s.implicits._
import org.http4s.server.blaze.BlazeServerBuilder

import scala.concurrent.ExecutionContext

object HttpService {

  def routes(implicit timer: Timer[IO]): HttpApp[IO] =
    Router[IO](
      "game" -> GameService.routes
    ).orNotFound

  def builder(ec: ExecutionContext)(implicit timer: Timer[IO], cs: ContextShift[IO]): BlazeServerBuilder[IO] =
    BlazeServerBuilder[IO](ec)
      .withHttpApp(routes)
}
