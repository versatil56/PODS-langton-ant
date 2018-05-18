package example

import org.scalatestplus.play.PlaySpec

class HelloSpec extends PlaySpec  {
  "The Hello object" should {
    "Test" when {
      "say hello" in {
        Hello.greeting mustBe("hello")
      }
    }
  }
}
