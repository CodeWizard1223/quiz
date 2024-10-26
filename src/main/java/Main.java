import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Welcome to the Quiz game!
                You can choose between biology quiz (select '1'),
                geography quiz (select '2') or exit (select '0').
                Each quiz has 3 questions with 4 options (a - d).
                Choose one or multiple options with keys a, b, c, d.
                Don't forget to put space between your answers (example: 'a b c').
                If the particular quiz has finished, you'll have a choice to exit the game,
                or continue to the other quiz.
                Have fun and good luck.""");

        // Initialize biology quiz
        List<Question> biologyQuestions = new ArrayList<>();
        biologyQuestions.add(new Question("Which of the following are parts of the human brain?",
                QuestionType.MULTIPLE_CHOICE, List.of(
                new Answer("Cerebrum", true),
                new Answer("Cerebellum", true),
                new Answer("Medulla oblongata", true),
                new Answer("Thalamus", true)
        )));

        biologyQuestions.add(new Question("Which of the following organs is known as the body's second brain?",
                QuestionType.SINGLE_CHOICE, List.of(
                new Answer("Heart", false),
                new Answer("Gut", true),
                new Answer("Liver", true),
                new Answer("Lungs", true)
        )));

        biologyQuestions.add(new Question("Which of the following bones are found in the human arm?",
                QuestionType.MULTIPLE_CHOICE, List.of(
                new Answer("Humerus", true),
                new Answer("Radius", true),
                new Answer("Femur", false),
                new Answer("Ulna", true)
        )));

        Quiz biologyQuiz = new Quiz(biologyQuestions);

        // Initialize geography quiz
        List<Question> geographyQuestions = new ArrayList<>();
        geographyQuestions.add(new Question("Which countries are known for having the most pyramids?",
                QuestionType.MULTIPLE_CHOICE, List.of(
                new Answer("Egypt", true),
                new Answer("Sudan", true),
                new Answer("Mexico", false),
                new Answer("Greece", false)
        )));

        geographyQuestions.add(new Question("Which country has a unicorn as a national symbol?",
                QuestionType.SINGLE_CHOICE, List.of(
                new Answer("Scotland", true),
                new Answer("China", false),
                new Answer("India", false),
                new Answer("Wales", false)
        )));

        geographyQuestions.add(new Question("Which of the following are considered part of the Seven Wonders of the World?",
                QuestionType.MULTIPLE_CHOICE, List.of(
                new Answer("Great Wall of China", true),
                new Answer("Machu Picchu", true),
                new Answer("Stonehenge", false),
                new Answer("Taj Mahal", true)
        )));

        Quiz geographyQuiz = new Quiz(geographyQuestions);

        QuizManager quizManager = new QuizManager(biologyQuiz, geographyQuiz);
        quizManager.start();
    }
}
