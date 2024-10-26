import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question {

    private String question;
    private QuestionType questionType;
    private List<Answer> answers;

    public Question(String question, QuestionType questionType, List<Answer> answers) {
        this.question = question;
        this.questionType = questionType;
        this.answers = answers;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    // Method for getting the indices of correct answers
    public Set<Integer> getCorrectAnswers() {
        Set<Integer> correctAnswers = new HashSet<>();
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).isCorrect()) {
                correctAnswers.add(i);
            }
        }
        return correctAnswers;
    }

    public void printQuestionType() {
        switch (questionType) {
            case SINGLE_CHOICE -> System.out.println("(This is a single-choice question.)");
            case MULTIPLE_CHOICE -> System.out.println("(This is a multiple-choice question.)");
        }
    }

    public void printAnswers() {
        char option = 'a';
        for (Answer answer : answers) {
            System.out.println(option + ". " + answer.getAnswer());
            option++;
        }
    }

    public void printQuestion () {
        System.out.println(question);
        printQuestionType();
        printAnswers();
    }
}

