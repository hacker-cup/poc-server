package hacker.cup.poc.engine.model

import io.circe.generic.JsonCodec

/**
  * Place holder for 2d vector (maybe consider library?)
  * @param x Magnitude in x
  * @param y Magnitude in y
  */
@JsonCodec
case class Vector2D(x: Double, y: Double) {
  /**
    * Vector addition
    */
  def +(that: Vector2D): Vector2D = Vector2D(x + that.x, y + that.y)

  /**
    * Vector scaling
    */
  def *(that: Double): Vector2D = Vector2D(x * that, y * that)
}
