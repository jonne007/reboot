import mill._, scalalib._, scalajslib._

val utestVersion = "0.7.5"
val sv = "2.13.7"
val upickle = "1.2.3"
val cask = "0.7.5"
val requestsVersion = "0.6.5"

object bicycle extends ScalaModule {
  def scalaVersion = sv
  def ivyDeps =
    Agg(
      ivy"com.lihaoyi::upickle:1.3.8",
      ivy"com.lihaoyi::requests:$requestsVersion",
      ivy"com.lihaoyi::cask:$cask"
    )

  object test extends Tests {
    def testFramework =("utest.runner.Framework")

    def ivyDeps =
      Agg(
        ivy"com.lihaoyi::utest::$utestVersion"
      )
  }
}