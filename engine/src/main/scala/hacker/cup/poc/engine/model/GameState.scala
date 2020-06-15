package hacker.cup.poc.engine.model

import io.circe.generic.JsonCodec

/**
  * Placeholder for game state
  */
@JsonCodec
case class GameState(
  entities: List[Entity]
) {
  /**
    * Update entity given dt (milliseconds)
    */
  def update(dt: Long): GameState = GameState(
    entities = entities.map(_.update(dt))
  )
}

object GameState {
  /**
    * Place holder initial state
    */
  def init: GameState = GameState(
    entities = List(
      Entity(p = Vector2D(0,0), v = Vector2D(2,2)),
      Entity(p = Vector2D(200,200), v = Vector2D(-2,-2)),
    )
  )
}