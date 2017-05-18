import SonatypeKeys._
import scala.language.postfixOps

scalariformSettings

net.virtualvoid.sbt.graph.Plugin.graphSettings

sonatypeSettings



organization := "com.xad"

name := "awscala"

version := "0.3.2-compatible"

scalaVersion := "2.10.5"

crossScalaVersions := Seq("2.11.2", "2.10.4")


publishMavenStyle := true


publishTo := {
  Some(s3resolver.value("maven2 ", s3("xad-mvn-repo/maven2")) withMavenPatterns)
}
// publishTo <<= version { (v: String) => 
//   Some("releases" at "")
//   // val nexus = "https://oss.sonatype.org/"
//   // if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
//   // else Some("releases" at nexus + "service/local/staging/deploy/maven2")
// },

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies ++= Seq(
  "com.amazonaws"    %  "aws-java-sdk"    % "1.8.11",
  "joda-time"        %  "joda-time"       % "2.5",
  "org.joda"         %  "joda-convert"    % "1.7",
  "com.decodified"   %% "scala-ssh"       % "0.7.0"  % "provided",
  "org.bouncycastle" %  "bcprov-jdk16"    % "1.46"   % "provided",
  "ch.qos.logback"   %  "logback-classic" % "1.1.2"  % "test",
  "org.scalatest"    %% "scalatest"       % "2.2.2"  % "test"
)

sbtPlugin := false

transitiveClassifiers in Global := Seq(Artifact.SourceClassifier)

incOptions := incOptions.value.withNameHashing(true)

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

pomExtra := <url>http://seratch.github.com/awscala</url>
<licenses>
  <license>
    <name>Apache License, Version 2.0</name>
    <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
    <distribution>repo</distribution>
  </license>
</licenses>
<scm>
  <url>git@github.com:seratch/awscala.git</url>
  <connection>scm:git:git@github.com:seratch/awscala.git</connection>
</scm>
<developers>
  <developer>
    <id>seratch</id>
    <name>Kazuhiro Sera</name>
    <url>http://seratch.net/</url>
  </developer>
  <developer>
    <id>mslinn</id>
    <name>Mike Slinn</name>
    <url>https://github.com/mslinn</url>
  </developer>
  <developer>
    <id>Rheeseyb</id>
    <name>RheeseyB</name>
    <url>https://github.com/Rheeseyb</url>
  </developer>
  <developer>
    <id>gribeiro</id>
    <name>Georges Kovacs Ribeiro</name>
    <url>https://github.com/gribeiro</url>
  </developer>
</developers>
