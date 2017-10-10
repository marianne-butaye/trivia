
package com.adaptionsoft.games.trivia.runner;

import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;

public class GameRunner {

  private static final int NUMBER_OF_ANSWERS = 9;
  private static final int WRONG_ANSWER = 7;
  private static final int MAXIMUM_ROLL = 5;
  private static final int MINIMUM_ROLL = 1;

  private static boolean noWinners;

  public static void main(String[] args) {
    Game aGame = new Game();
    addPlayers(aGame);

    if (!aGame.isPlayable()) {
      System.out.println("There are not enough players.");
      return;
    }

    Random rand = new Random();
    do {
      aGame.roll(rand.nextInt(MAXIMUM_ROLL) + MINIMUM_ROLL);

      if (rand.nextInt(NUMBER_OF_ANSWERS) == WRONG_ANSWER) {
        aGame.answerWrongly();
      } else {
        noWinners = aGame.answerCorrectlyAndCheckIfNotAWinner();
      }
    } while (noWinners);
  }

  private static void addPlayers(Game aGame) {
    aGame.addPlayer("Chet");
    aGame.addPlayer("Pat");
    aGame.addPlayer("Sue");
  }

}
