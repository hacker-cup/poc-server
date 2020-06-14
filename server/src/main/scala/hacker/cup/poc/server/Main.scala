package hacker.cup.poc.server

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {

  def run(args: List[String]): IO[ExitCode] =
    for {
      _ <- IO(println("hello world"))
    } yield ExitCode.Success
}
