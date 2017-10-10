package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Questions {

  private static final int NUMBER_OF_QUESTIONS = 50;
  LinkedList<String> popQuestions = new LinkedList<>();
  LinkedList<String> scienceQuestions = new LinkedList<>();
  LinkedList<String> sportsQuestions = new LinkedList<>();
  LinkedList<String> rockQuestions = new LinkedList<>();

  public void populate() {
    for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
      popQuestions.addLast(createPopQuestion(i));
      scienceQuestions.addLast(createScienceQuestion(i));
      sportsQuestions.addLast(createSportsQuestion(i));
      rockQuestions.addLast(createRockQuestion(i));
    }
  }

  private String createSportsQuestion(int index) {
    return "Sports Question " + index;
  }

  private String createScienceQuestion(int index) {
    return "Science Question " + index;
  }

  private String createPopQuestion(int index) {
    return "Pop Question " + index;
  }

  public String createRockQuestion(int index) {
    return "Rock Question " + index;
  }

  public void askQuestion(int place) {
    QuestionCategory category = currentCategory(place);
    if (category.equals(QuestionCategory.POP))
      System.out.println(popQuestions.removeFirst());
    if (category.equals(QuestionCategory.SCIENCE))
      System.out.println(scienceQuestions.removeFirst());
    if (category.equals(QuestionCategory.SPORTS))
      System.out.println(sportsQuestions.removeFirst());
    if (category.equals(QuestionCategory.ROCK))
      System.out.println(rockQuestions.removeFirst());
  }

  private QuestionCategory currentCategory(int place) {
    QuestionCategory category = QuestionCategory.getByPlace(place);
    System.out.println("The category is " + category);
    return category;
  }
}
