package hacker.cup.poc.engine.model

import io.circe.generic.JsonCodec

/**
  * Place holder for game entity
  * @param p Position vector
  * @param v Velocity vector
  */
@JsonCodec
case class Entity(p: Vector2D, v: Vector2D) {
  def update(dt: Long): Entity = {
    Entity(
      p = p + (v * (dt / 1000.0)),
      v = v
    )
  }
}

