package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Game {

  private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
  List<Player> players = new ArrayList<>();
  Questions questions = new Questions();
  Player currentPlayer = null;

  public Game() {
    questions.populate();
  }

  public boolean isPlayable() {
    return (players.size() >= MINIMUM_NUMBER_OF_PLAYERS);
  }

  public void addPlayer(String playerName) {
    Player player = new Player(playerName);
    players.add(player);

    System.out.println(playerName + " was added");
    System.out.println("They are player number " + players.size());

    if (currentPlayer == null) {
      currentPlayer = players.get(0);
    }
  }

  public void roll(int roll) {
    System.out.println(currentPlayer + " is the current player");
    System.out.println("They have rolled a " + roll);

    if (currentPlayer.isInPenaltyBox()) {
      if (isEven(roll)) {
        currentPlayer.getOutOfPenaltyBox();
        playCurrentTurn(roll);
      } else {
        currentPlayer.stayInPenaltyBox();
      }
    } else {
      playCurrentTurn(roll);
    }
  }

  private boolean isEven(int roll) {
    return roll % 2 != 0;
  }

  private void playCurrentTurn(int roll) {
    currentPlayer.move(roll);
    questions.askQuestion(currentPlayer.getPlace());
  }

  public boolean answerCorrectlyAndCheckIfNotAWinner() {
    boolean notYetAWinner = true;
    if (!currentPlayer.isInPenaltyBox()) {
      System.out.println("Answer was correct!!!!");
      currentPlayer.addCoinToPurse();
      notYetAWinner = currentPlayer.isPlayerStillNotAWinner();
    }
    switchToNextPlayer();
    return notYetAWinner;
  }

  private void switchToNextPlayer() {
    int currentPlayerNumber = players.indexOf(currentPlayer);
    currentPlayerNumber++;
    if (currentPlayerNumber == players.size())
      currentPlayerNumber = 0;
    currentPlayer = players.get(currentPlayerNumber);
  }

  public void answerWrongly() {
    System.out.println("Question was incorrectly answered");
    currentPlayer.sendToPenaltyBox();
    switchToNextPlayer();
  }

}
