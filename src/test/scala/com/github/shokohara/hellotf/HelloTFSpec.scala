package com.github.shokohara.hellotf

import org.scalatest.{FreeSpec, Matchers}

class HelloTFSpec extends FreeSpec with Matchers {

  "HelloTF" - {
    HelloTF.hello shouldBe "Hello from 1.3.0"
  }
}
