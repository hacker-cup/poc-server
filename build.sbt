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

lazy val server = project
  .in(file("server"))
  .settings(
    name := "poc-server",
    commonSettings,
    libraryDependencies ++= Seq(
      Dependencies.Http4s.server
    )
  )

lazy val docs = project
  .in(file("docs"))
  .settings(
    micrositeName := "POC Server",
    micrositeCompilingDocsTool := WithTut,
    micrositeHighlightTheme := "atom-one-light"
  )
  .enablePlugins(MicrositesPlugin)

