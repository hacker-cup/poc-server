package hacker.cup.poc.engine

import scala.language.postfixOps
import scala.concurrent.duration._
import cats.effect.{IO, Timer}
import fs2._
import hacker.cup.poc.engine.model.{GameEngineState, GameState}

/**
  * Game engine
  */
object GameEngine {
  val fps = 60

  /**
    * Unthrottled game stream
    */
  def unthrottled: Stream[IO, GameState] =
    Stream.unfold(GameEngineState.init) { state =>
      val next = state.update
      Some((next.gameState, next))
    }

  /**
    * Game loop equivalent as stream
    * Throttled using awakeEvery
    */
  def stream(implicit timer: Timer[IO]): Stream[IO, GameState] =
    Stream
      .awakeEvery[IO]((1.0 / fps) seconds)
      .zipRight(unthrottled)
}
