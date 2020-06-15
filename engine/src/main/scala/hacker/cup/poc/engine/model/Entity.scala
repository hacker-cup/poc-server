package hacker.cup.poc.engine.model

import io.circe.generic.JsonCodec

/**
  * Place holder for game entity
  * @param p Position vector in units
  * @param v Velocity vector in units per second
  */
@JsonCodec
case class Entity(p: Vector2D, v: Vector2D) {
  /**
    * Update entity given dt (milliseconds)
    */
  def update(dt: Long): Entity = {
    Entity(
      p = p + (v * (dt / 1000.0)),
      v = v
    )
  }
}

