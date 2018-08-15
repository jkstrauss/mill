import mill.Agg
import mill.scalalib._
import ammonite.ops._
import mill.define.Sources

trait JUnitTests extends TestModule{
  def testFrameworks = Seq("com.novocode.junit.JUnitFramework")
  def ivyDeps = Agg(ivy"com.novocode:junit-interface:0.11")
}

object core extends JavaModule{
  object test extends Tests with JUnitTests
}
object app extends JavaModule{
  def moduleDeps = Seq(core)
  object test extends Tests with JUnitTests
}

object test extends mill.Module {
  def abc = T.sources { millSourcePath/'abc }
}
