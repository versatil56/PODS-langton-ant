package example

import org.scalatestplus.play.PlaySpec

class HelloSpec extends PlaySpec  {


  "A world" should {

    val world  = World(10,12)

    "contain a single ant positioned in the middle" in {
        world.ant.antPosition mustBe (5,5)
    }
    "contain a single ant facing north" in {
      world.ant.antDirection mustBe North
    }
    "contain an ant that can move" when {

      "placed on a black square facing North" which {

        "turns left to face West" in {

          val x = world.ant.square.x
          val y = world.ant.square.y

          world.ant.move mustBe Ant(Square("White", x, y), West)

        }

      }

    }
    "contain squares to walk on" in {
      world.squares.length mustBe 10
      world.squares(0).length mustBe 12
    }

    "contain an Ant" which {
      "can get the colour of the square it is currently on" in {
        world.ant.checkColour mustBe "Black"
      }
    }
  }

}

case class Square(colour:String = "Black", x: Int, y: Int)

case class World(width: Int, height: Int, ant: Ant) {
  val squares: Array[Array[Square]] = Array.ofDim[Square](width, height)

}

case class Ant(square: Square, orientation: Orientation) {

  def antPosition: (Int, Int) = (square.x, square.y)
  def antDirection: Orientation = North

  def move: Ant = {
    val color = if(square.colour == "Black") {
      "White"
    }else{
      "Black"
    }
    this.copy(Square(color, square.x, square.y), West)
  }

  def checkColour: String = square.colour
}

object World {
  def apply(width: Int, height: Int): World = World(width, height, Ant())
}

object Ant {
  def apply() : Ant = Ant(Square("Black", 5,5),North)
}

sealed trait Orientation

case object North extends Orientation
case object South extends Orientation
case object East extends Orientation
case object West extends Orientation

