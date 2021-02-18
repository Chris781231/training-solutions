package week15.d02.midlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz {

    public static final String fileName = "kerdesek.txt";
    private final List<Question> questions = new ArrayList<>();

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.fillQuestionsFromFile();
        System.out.println("1. " + quiz.findQuestionsByTopic(Topic.MAGYAR) + "\n");
        System.out.println("2. " + quiz.getQuestionByRandom(new Random()) + "\n");
        Map<Topic, List<Question>> topicListMap = quiz.sortQuestionsByTopic();
        System.out.println("3. " + topicListMap.get(Topic.KEMIA) + "\n");
        System.out.println("4. " + quiz.findMaxScoreByTopic());
    }

    public void fillQuestionsFromFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Quiz.class.getResourceAsStream(fileName)))) {
            String[] rawQuestion = new String[2];
            int lineCount = 0;
            while ((rawQuestion[lineCount] = reader.readLine()) != null) {
                if (lineCount == 0) {
                    lineCount++;
                } else {
                    processQuestion(rawQuestion);
                    lineCount = 0;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    public List<String> findQuestionsByTopic(Topic topic) {
        List<String> result = new ArrayList<>();

        for (Question question : questions) {
            if (question.getTopic() == topic) {
                result.add(question.getQuestionText());
            }
        }

        return result;
    }

    public Question getQuestionByRandom(Random rnd) {
        return questions.get(rnd.nextInt(questions.size()));
    }

    public Map<Topic, List<Question>> sortQuestionsByTopic() {
        Map<Topic, List<Question>> result = new HashMap<>();

        for (Question question : questions) {
            if (!result.containsKey(question.getTopic())) {
                result.put(question.getTopic(), new ArrayList<>());
            }
            result.get(question.getTopic()).add(question);
        }

        return result;
    }

    public Topic findMaxScoreByTopic() {
        Topic topicOfMaxScore = null;
        int maxScore = Integer.MIN_VALUE;
        Map<Topic, Integer> topicScores = new HashMap<>();

        createEmptyTopicScoresByTopic(topicScores);

        for (Map.Entry<Topic, List<Question>> entry : sortQuestionsByTopic().entrySet()) {
            for (Question question : entry.getValue()) {
                int newScore = topicScores.get(question.getTopic()) + question.getScore();
                topicScores.replace(question.getTopic(), newScore);

                if (newScore > maxScore) {
                    maxScore = newScore;
                    topicOfMaxScore = question.getTopic();
                }
            }
        }

        return topicOfMaxScore;
    }

    private void createEmptyTopicScoresByTopic(Map<Topic, Integer> topicScores) {
        for (Topic topic : Topic.values()) {
            topicScores.put(topic, 0);
        }
    }

    private void processQuestion(String[] rawQuestion) {
        Question question = new Question(rawQuestion[0]);
        String[] parts = rawQuestion[1].split(" ");
        question.setAnswer(parts[0]);
        question.setScore(Integer.parseInt(parts[1]));
        switch (parts[2]) {
            case "tortenelem" -> question.setTopic(Topic.TORTENELEM);
            case "foldrajz" -> question.setTopic(Topic.FOLDRAJZ);
            case "matematika" -> question.setTopic(Topic.MATEMATIKA);
            case "magyar" -> question.setTopic(Topic.MAGYAR);
            case "kemia" -> question.setTopic(Topic.KEMIA);
            default -> throw new IllegalArgumentException("Invalid topic");
        }
        questions.add(question);
    }
}
