name := "hellotf"

organization := "com.github.shokohara"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.3"

scalacOptions ++= Seq(
  "-encoding", "UTF-8"
)

libraryDependencies ++= Seq("org.tensorflow" % "tensorflow" % "1.3.0",
  "org.scalatest" %% "scalatest" % "3.0.1" % Test
)

sources in(Compile, doc) := Seq.empty

publishArtifact in(Compile, packageDoc) := false
