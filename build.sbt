import microsites._
import hacker.cup.Dependencies

lazy val commonSettings = Seq(
  scalaVersion := "2.13.2",
  organization := "com.disneystreaming",
  version := "0.0.1",
  scalacOptions := Seq("-Xlint", "-Ywarn-unused", "-deprecation", "-Ymacro-annotations"),
  dependencyUpdatesFailBuild := true
)

lazy val root = project
  .in(file("."))
  .settings(
    commonSettings
  )
  .aggregate(server, docs)

lazy val engine = project
  .in(file("engine"))
  .settings(
    name := "poc-engine",
    commonSettings,
    libraryDependencies ++= Seq(
      Dependencies.Cats.core,
      Dependencies.Cats.effect,
      Dependencies.FS2.core,
      Dependencies.Circe.core,
      Dependencies.Circe.generic
    )
  )

lazy val server = project
  .in(file("server"))
  .settings(
    name := "poc-server",
    commonSettings,
    libraryDependencies ++= Seq(
      Dependencies.Http4s.server,
      Dependencies.Http4s.dsl,
      Dependencies.Http4s.circe
    )
  )
  .dependsOn(engine)

lazy val docs = project
  .in(file("docs"))
  .settings(
    micrositeName := "POC Server",
    micrositeCompilingDocsTool := WithTut,
    micrositeBaseUrl := "poc-server",
    micrositeHomepage := "https://hacker-cup.github.io/poc-server/",
    micrositeHighlightTheme := "atom-one-light",
    git.remoteRepo := "https://github.com/hacker-cup/poc-server.git"
  )
  .enablePlugins(MicrositesPlugin)
