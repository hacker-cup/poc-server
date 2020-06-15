package hacker.cup.poc.server.service

import cats.effect.{IO, Timer}
import hacker.cup.poc.engine.GameEngine
import org.http4s.HttpRoutes
import org.http4s.circe.CirceEntityEncoder
import org.http4s.dsl.Http4sDsl

object GameService extends Http4sDsl[IO] with CirceEntityEncoder {

  def routes(implicit timer: Timer[IO]): HttpRoutes[IO] = HttpRoutes.of[IO] {
    case GET -> Root =>
      // Stream back our game stream
      Ok(GameEngine.stream)
  }
}
