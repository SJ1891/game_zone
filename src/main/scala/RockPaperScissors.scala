import scala.io.StdIn.readLine

case class Play(name: String, selection: String)

object RockPaperScissors extends App {

  def readInput(): (Play, Play) = {
    println("Hi Welcome to the world of gaming")

    val listOfPlays: Seq[Play] = for (i <- 1 to 2) yield {
      println("Enter Your Name")
      val player_name: String = readLine()
      val selection = readLine("Choose between Rock,Paper or Scissors: ")
      Play(player_name, selection.toLowerCase)
    }
    val valid = Set("paper", "rock", "scissors")
    if (listOfPlays.map((p: Play) => p.selection).forall(valid.contains)) {
      (listOfPlays.head, listOfPlays(1))
    } else {
      println("Invalid Input")
      throw new RuntimeException("Invalid input")
    }
  }


  def resultChecker(firstPlayer: Play, secondPlayer: Play): String = {
    if (firstPlayer.selection == "rock" && secondPlayer.selection == "scissors" ||
      firstPlayer.selection == "paper" && secondPlayer.selection == "rock" ||
      firstPlayer.selection == "scissors" && secondPlayer.selection == "paper")
      firstPlayer.name
    else if (secondPlayer.selection == "rock" && firstPlayer.selection == "scissors" ||
      secondPlayer.selection == "paper" && firstPlayer.selection == "rock" ||
      secondPlayer.selection == "scissors" && firstPlayer.selection == "paper")
      secondPlayer.name
    else
      "tie"
  }

  val (p1, p2) = readInput()
  val result =resultChecker(p1, p2)
  if (result == "tie")
    println("its a tie")
  else
    println("The Winner is :" +result)
}

