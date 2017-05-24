name := "haskellimport"

organization := "com.github.shokohara"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.2"

scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-language:implicitConversions",
  "-Ywarn-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-inaccessible",
  "-Ywarn-infer-any",
  "-Ywarn-nullary-override",
  "-Ywarn-nullary-unit",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused",
  "-Ywarn-unused-import",
  "-Ywarn-value-discard",
  "-Xfatal-warnings"
)

sources in (Compile, doc) := Seq.empty

publishArtifact in (Compile, packageDoc) := false

wartremoverErrors in (Compile, compile) ++= wartremover.Warts.allBut(
  wartremover.Wart.ExplicitImplicitTypes,
  wartremover.Wart.PublicInference,
  wartremover.Wart.ImplicitParameter,
  wartremover.Wart.ImplicitConversion,
  wartremover.Wart.Nothing) ++ Seq(
  ContribWart.NoNeedForMonad,
  ContribWart.OldTime,
  ContribWart.SealedCaseClass,
  ContribWart.SomeApply,
  ExtraWart.DateFormatPartial,
  ExtraWart.EnumerationPartial,
  ExtraWart.FutureObject,
  ExtraWart.GenMapLikePartial,
  ExtraWart.GenTraversableLikeOps,
  ExtraWart.GenTraversableOnceOps,
  ExtraWart.LegacyDateTimeCode,
  ExtraWart.ScalaGlobalExecutionContext,
  ExtraWart.StringOpsPartial,
  ExtraWart.TraversableOnceOps,
  ExtraWart.UntypedEquality
)
