package hacker.cup.poc.server

import cats.effect.{ExitCode, IO, IOApp}
import hacker.cup.poc.server.service.{HttpService}

import scala.concurrent.ExecutionContext

object Main extends IOApp {

  def run(args: List[String]): IO[ExitCode] =
    for {
      _ <- HttpService
        .builder(ExecutionContext.global)
        .bindHttp(8080, "0.0.0.0")
        .serve
        .compile
        .drain
    } yield ExitCode.Success
}
