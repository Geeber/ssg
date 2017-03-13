package com.kevinlitwack.ssg

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class HelloWorldSpec extends Specification {

  "HelloWorld Unit Test" should {
    true must beTrue
  }
}
