package hacker.cup.poc.engine

import java.time.Instant

import scala.language.postfixOps
import scala.concurrent.duration._

import cats.effect.{IO, Timer}
import fs2._
import hacker.cup.poc.engine.model.GameState

/**
  * Game engine
  */
object GameEngine {
  val fps = 60

  /**
    * Infinite stream given an initial timestamp and game state
    * Stack safe as ++ is lazy :)
    */
  def stream(t1: Long, state: GameState): Stream[IO, GameState] = {
    val t2 = Instant.now.toEpochMilli
    val dt = t2 - t1
    val next = state.update(dt)
    Stream.emit(next) ++ stream(t2, next)
  }

  /**
    * Game loop equivalent as stream
    * Throttled using awakeEvery
    */
  def stream(implicit timer: Timer[IO]): Stream[IO, GameState] =
    Stream
      .awakeEvery[IO]((1.0 / fps) seconds)
      .zipRight(
        stream(Instant.now.toEpochMilli, GameState.init)
      )
}
