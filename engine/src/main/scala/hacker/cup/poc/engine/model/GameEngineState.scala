package hacker.cup.poc.engine.model

import java.time.Instant

/**
  * Game engine state
  * @param timestamp Timestamp of last game state
  * @param gameState Game state
  */
case class GameEngineState(
  timestamp: Long,
  gameState: GameState
) {
  /**
    * Update game engine state
    */
  def update: GameEngineState = {
    val t2 = Instant.now.toEpochMilli
    val dt = t2 - timestamp
    GameEngineState(
      timestamp = t2,
      gameState = gameState.update(dt)
    )
  }
}

object GameEngineState {
  def init: GameEngineState = GameEngineState(
    timestamp = Instant.now.toEpochMilli,
    gameState = GameState.init
  )
}