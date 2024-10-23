import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            question.printQuestion();

            switch (question.getQuestionType()) {
                case SINGLE_CHOICE -> handleSingleChoiceQuestion(scanner, question);
                case MULTIPLE_CHOICE -> handleMultipleChoiceQuestion(scanner, question);
            }
            System.out.println();
        }
        System.out.println("Quiz finished! Your score: " + score + "/" + questions.size());
    }

    private void handleSingleChoiceQuestion(Scanner scanner, Question question) {
        String userInput;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Your answer: ");
            userInput = scanner.nextLine();

            if (isValidInput(userInput, question.getAnswers().size())) {
                // Convert user input to integer value that represents the position of the desired answer in the list.
                int answerIndex = userInput.charAt(0) - 'a';
                //  Declare a variable named selectedAnswer of type Answer; the retrieved answer from the list is assigned to this variable.
                Answer selectedAnswer = question.getAnswers().get(answerIndex);

                if (selectedAnswer.isCorrect()) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect.");
                }
                validInput = true;
            } else {
                System.out.println("Invalid input. Please select a valid option.");
            }
        }
    }

    private void handleMultipleChoiceQuestion(Scanner scanner, Question question) {
        String userInput;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Your answers: ");
            userInput = scanner.nextLine();
            String[] userInputs = userInput.split(" ");

            if (areValidInputs(userInputs, question.getAnswers().size())) {

                Set<Integer> correctAnswers = question.getCorrectAnswers();

                // Convert the array of inputs to set of indices
                Set<Integer> userAnswers = new HashSet<>();
                for (String input : userInputs) {
                    userAnswers.add(input.trim().charAt(0) - 'a');
                }

                if (userAnswers.equals(correctAnswers)) {
                    System.out.println("All correct!");
                    score++;
                } else {
                    System.out.println("Some or all answers were wrong.");
                }
                validInput = true;
            } else {
                System.out.println("Invalid input. Please select valid options.");
            }
        }
    }

    // Method for checking input if the question is SINGLE_CHOICE.
    private boolean isValidInput(String input, int optionsCount) {
        return input.length() == 1 && input.charAt(0) >= 'a' && input.charAt(0) < 'a' + optionsCount;
    }

    // Method for checking inputs if the question is MULTIPLE_CHOICE.
    private boolean areValidInputs(String[] inputs, int optionsCount) {
        for (String input : inputs) {
            input = input.trim();
            if (input.length() != 1 || input.charAt(0) < 'a' || input.charAt(0) >= 'a' + optionsCount) {
                return false;
            }
        }
        return true;
    }
}
