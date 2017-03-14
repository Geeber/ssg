//The "io.keen" organization is set automatically, but can be overridden here
organization := "com.kevinlitwack"
name := "ssg"
version := "0.1.0"
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.google.guava" % "guava" % "21.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.+",
  "es.nitaur.markdown" % "txtmark" % "0.16",
  "org.specs2" %% "specs2-core" % "3.8.+" % "test",
  "org.specs2" %% "specs2-junit" % "3.8.+" % "test"
)

mainClass in Compile := Some("com.kevinlitwack.ssg.MainScript")
