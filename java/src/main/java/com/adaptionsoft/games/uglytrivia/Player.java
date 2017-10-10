package com.adaptionsoft.games.uglytrivia;

public class Player {

  private String name;
  private int place;
  private int purse;
  private boolean inPenaltyBox;

  public Player(String name) {
    this.name = name;
    this.place = 0;
    this.purse = 0;
    this.inPenaltyBox = false;
  }

  public String getName() {
    return name;
  }

  public int getPlace() {
    return place;
  }

  public int getPurse() {
    return purse;
  }

  public boolean isInPenaltyBox() {
    return inPenaltyBox;
  }

  public void move(int roll) {
    place = place + roll;
    if (place > 11)
      place = place - 12;
    System.out.println(name + "'s new location is " + place);
  }

  public void addCoinToPurse() {
    this.purse++;
    System.out.println(name + " now has " + purse + " Gold Coins.");
  }

  public void sendToPenaltyBox() {
    System.out.println(name + " was sent to the penalty box");
    this.inPenaltyBox = true;
  }

  public boolean isPlayerStillNotAWinner() {
    return !(purse == 6);
  }

  @Override
  public String toString() {
    return name;
  }

  public void getOutOfPenaltyBox() {
    System.out.println(name + " is getting out of the penalty box");
    this.inPenaltyBox = false;
  }

  public void stayInPenaltyBox() {
    System.out.println(name + " is not getting out of the penalty box");
  }

}
