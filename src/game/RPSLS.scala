package game

import scala.util.Random

object RPSLS {

  def main(args: Array[String]): Unit = {

    val possible: List[String] = List[String](
      "rock",
      "paper",
      "lizard",
      "scissors",
      "spock")

    val actions = Map(
      "01" -> "crushes",
      "02" -> "crushes",
      "10" -> "covers",
      "14" -> "disproves",
      "21" -> "eats",
      "24" -> "poisons",
      "31" -> "cut",
      "32" -> "decapitate",
      "40" -> "vaporizes",
      "43" -> "smashes")

    println("Please enter your move: ")

    var playerInput = readLine()

    while (!possible.contains(playerInput.toLowerCase())) {
      playerInput = readLine()
    }

    val playerMove = playerInput.toLowerCase()

    val computerMove: String = Random.nextInt(5) match {
      case 0 => "Rock"
      case 1 => "Paper"
      case 2 => "Lizard"
      case 3 => "Scissors"
      case 4 => "Spock"
    }

    println("Player picks: " + playerInput + ".")
    println("Computer picks: " + computerMove + ".")
    println

    val playerIndex: Int = possible.indexOf(playerMove.toLowerCase())
    val computerIndex: Int = possible.indexOf(computerMove.toLowerCase())

    val key = playerIndex + "" + computerIndex
    val action = if (actions.contains(key)) actions(key) else ""

    val playerScore =
      if (playerIndex == computerIndex) 0
      else if (action != "") 1
      else -1

    val output: String = playerScore match {
      case 0 => "Tie"
      case 1 => playerInput + " " + action + " " + computerMove
      case -1 => computerMove + " " + action + " " + playerMove
    }

    println(output)

  }
}