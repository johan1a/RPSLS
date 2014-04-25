

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
      ("rock", "lizard") -> "crushes",
      ("lizard", "rock") -> "crushes",
      ("rock", "scissors") -> "crushes",
      ("scissors", "rock") -> "crushes",
      ("paper", "rock") -> "covers",
      ("rock", "paper") -> "covers",
      ("paper","spock") -> "disproves",
      ("spock", "paper") -> "disproves",
      ("lizard", "paper") -> "eats",
      ("paper", "lizard") -> "eats",
      ("lizard", "spock") -> "poisons",
      ("spock", "lizard") -> "poisons",
      ("scissors", "paper") -> "cut",
      ("paper", "scissors") -> "cut",
      ("scissors", "lizard") -> "decapitate",
      ("lizard", "scissors") -> "decapitate",
      ("spock", "rock") -> "vaporizes",
      ("rock", "spock") -> "vaporizes",
      ("spock", "scissors") -> "smashes",
      ("scissors", "spock") -> "smashes")

    val outcomes = Map(
      ("rock", "lizard") -> 1,
      ("lizard", "rock") -> -1,
      ("rock", "scissors") -> 1,
      ("scissors", "rock") -> -1,
      ("paper", "rock") -> 1,
      ("rock", "paper") -> -1,
      ("paper","spock") -> 1,
      ("spock", "paper") -> -1,
      ("lizard", "paper") -> 1,
      ("paper", "lizard") -> -1,
      ("lizard", "spock") -> 1,
      ("spock", "lizard") -> -1,
      ("scissors", "paper") -> 1,
      ("paper", "scissors") -> -1,
      ("scissors", "lizard") -> 1,
      ("lizard", "scissors") -> -1,
      ("spock", "rock") -> 1,
      ("rock", "spock") -> -1,
      ("spock", "scissors") -> 1,
      ("scissors", "spock") -> -1)


    var playerWins: Int = 0
    var computerWins: Int = 0
    var roundsPlayed: Int = 0
	    
    var exitRequested: Boolean = false


    println("Welcome to Rock Paper Scissors Lizard Spock!")
    println
    println("Enter the number of rounds: ")
    println

    val maxRounds: Int = readLine().toInt

    println("Enter \"exit\" at any time to exit.")
    println
 
    while(roundsPlayed < maxRounds && !exitRequested){	    

	    println("Please enter your move: ")

	    var playerInput = readLine()

	    if(playerInput.toLowerCase() == "exit"){
		exitRequested = true
	    }else{
		    while (!possible.contains(playerInput.toLowerCase())) {
		      playerInput = readLine()
		    }
		    println

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

		    val pair = (playerMove, computerMove.toLowerCase())
		    val action = if(actions.contains(pair)) actions(pair) else ""

		    val playerScore =
		      if (playerMove  == computerMove.toLowerCase()) 0
		      else outcomes(pair)

		    val output: String = playerScore match {
		      case 0 => "Tie"
		      case 1 => playerInput + " " + action + " " + computerMove + ". Player wins!"
		      case -1 => computerMove + " " + action + " " + playerMove + ". Computer wins!"
		    }
		    roundsPlayed += 1
	            if(playerScore == 1){
			 playerWins += 1  		
		    }else if(playerScore == -1){
			computerWins += 1
		    }
		    println(output)
          	    println
		 }

    }

	println("Game Over!")
	println("Score:")
	println("Plarer score: " + playerWins + " (" + 100 * playerWins / roundsPlayed.toFloat + "%)")
	println("Computer score: " + computerWins + " (" + 100 * computerWins / roundsPlayed.toFloat+ "%)")
	val ties = roundsPlayed - playerWins - computerWins
	println("Ties: " + ties + " (" + 100 * ties / roundsPlayed.toFloat + "%)")
	
	val output = 
	if(playerWins > computerWins) "Player Wins!"
	else if(computerWins > playerWins) "Computer Wins!"
	else "Tie!"

	println
	println(output)
  }
}
