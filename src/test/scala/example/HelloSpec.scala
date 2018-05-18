package example

import org.scalatestplus.play.PlaySpec

class HelloSpec extends PlaySpec  {


  "A world" should {

    val world  = World(10,10)

    "contain a single ant positioned in the middle" in {
        world.ant.antPosition mustBe (5,5)
    }
    "contain a single ant facing north" in {
      world.ant.antDirection mustBe North
    }
    "contain an ant that can move forward" in {
      world.ant.move mustBe Ant(6, 5, North)
    }
  }
}

case class World(width: Int, height: Int, ant: Ant) {

}

case class Ant(x: Int, y: Int, orientation: Orientation) {

  def antPosition: (Int, Int) = (x, y)
  def antDirection: Orientation = North

  def move: Ant = this.copy(x + 1, y, orientation)

}

object World {
  def apply(width: Int, height: Int): World = World(width, height, Ant())
}

object Ant {
  def apply() : Ant = Ant(5,5,North)
}

sealed trait Orientation

case object North extends Orientation
case object South extends Orientation
case object East extends Orientation
case object West extends Orientation

