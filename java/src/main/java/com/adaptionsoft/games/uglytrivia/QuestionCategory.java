package com.adaptionsoft.games.uglytrivia;

public enum QuestionCategory {

  POP(0), SCIENCE(1), SPORTS(2), ROCK(3);

  private int number;

  private QuestionCategory(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public static QuestionCategory getByPlace(int place) {
    for (QuestionCategory category : QuestionCategory.values()) {
      if (place % 4 == category.getNumber())
        return category;
    }
    return null;
  }

}
