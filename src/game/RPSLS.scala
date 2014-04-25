

import scala.util.Random

object RPSLS {

    val possible: List[String] = List[String](
      "rock",
      "paper",
      "lizard",
      "scissors",
      "spock")

	val outcomes: List[String] = List("Tie","Win","Win","Lose","Lose")

	def attack(a:String, b:String):String = {
		outcomes(scala.math.abs((possible.indexOf(a)-possible.indexOf(b) % 5)))
	}


  def main(args: Array[String]): Unit = {




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

		    val outcome = attack(playerMove, computerMove.toLowerCase())
		    
		    val action = actions((playerMove.toLowerCase(), computerMove.toLowerCase()))
		    val output: String = outcome match {
		      case "Tie" => "Tie"
		      case "Win" => playerInput + " " + action + " " + computerMove + ". Player wins!"
		      case "Lose" => computerMove + " " + action + " " + playerMove + ". Computer wins!"
		    }
		   
		     roundsPlayed += 1
	            if(outcome == "Win"){
			 playerWins += 1  		
		    }else if(outcome == "Lose"){
			computerWins += 1
		    }
		    println(output)
          	    println
		 }

    }

	println("Game Over!")
	println("Score:")
	println("Player score: " + playerWins + " (" + playerWins / 100.0 + "%)")
	println("Computer score: " + computerWins)
	println("Player score: " + playerWins + " (" + playerWins / 100.0 + "%)")
	println("Ties: " + (roundsPlayed - playerWins - computerWins))
	
	val output = 
	if(playerWins > computerWins) "Player Wins!"
	else if(computerWins > playerWins) "Computer Wins!"
	else "Tie!"

	println
	println(output)
  }
}
