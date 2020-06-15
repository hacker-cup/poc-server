package hacker.cup

import sbt._

object Dependencies {

  object Http4s {
    private val version = "0.21.4"
    val dsl = "org.http4s" %% "http4s-dsl" % version
    val server = "org.http4s" %% "http4s-blaze-server" % version
    val client = "org.http4s" %% "http4s-blaze-client" % version
    val circe = "org.http4s" %% "http4s-circe" % version
  }

  object FS2 {
    private val version = "2.4.0"
    val core = "co.fs2" %% "fs2-core" % version
  }

  object Cats {
    private val version = "2.0.0"
    val core = "org.typelevel" %% "cats-core" % version
    val effect = "org.typelevel" %% "cats-effect" % version
  }

  object Circe {
    private val version = "0.12.3"
    val core: ModuleID = "io.circe" %% "circe-core" % version
    val parser: ModuleID = "io.circe" %% "circe-parser" % version
    val config: ModuleID = "io.circe" %% "circe-config" % "0.6.0"
    val generic: ModuleID = "io.circe" %% "circe-generic" % version
    val literal: ModuleID = "io.circe" %% "circe-literal" % version
    val genericExtra: ModuleID = "io.circe" %% "circe-generic-extras" % version
    val refined = "io.circe" %% "circe-refined" % version
    val jawn = "io.circe" %% "circe-jawn" % version
  }
}
