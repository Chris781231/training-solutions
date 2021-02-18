package week15.d02.midlevel;

import java.util.Objects;

public class Question {

    private final String questionText;
    private String answer;
    private int score;
    private Topic topic;


    public Question(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public int getScore() {
        return score;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return questionText + '\n' + answer + ' ' + score + ' ' + topic + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(questionText, question.questionText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionText);
    }
}
