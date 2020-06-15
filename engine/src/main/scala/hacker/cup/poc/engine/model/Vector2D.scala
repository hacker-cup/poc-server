package hacker.cup.poc.engine.model

import io.circe.generic.JsonCodec

@JsonCodec
case class Vector2D(x: Double, y: Double) {
  def +(that: Vector2D): Vector2D = Vector2D(x + that.x, y + that.y)
  def *(that: Double): Vector2D = Vector2D(x * that, y * that)
}
