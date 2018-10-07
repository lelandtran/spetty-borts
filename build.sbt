name := """borts"""
organization := "com.bortsapp"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.4.2"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.bortsapp.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.bortsapp.binders._"
