package tomaszszewczyk.studentscrewer.questions;

import tomaszszewczyk.studentscrewer.summaries.ISummary;

public class OpenQuestion implements IQuestion {
    private int points_to_score;
    private String content;
    private String answer;

    @Override
    public void setNoPoints(int points) {
        points_to_score = points;
    }

    @Override
    public void addContent(String text) {
        content = text;
    }

    @Override
    public void addAnswer(String new_answer) {
        answer = new_answer.trim();
    }

    @Override
    public void checkAnswer(String new_answer, ISummary summary) {
        if (answer.compareToIgnoreCase(new_answer.trim()) == 0)
            summary.addScore(points_to_score, points_to_score);
        else
            summary.addScore(0, points_to_score);
    }

    @Override
    public String getOneLiner() {
        return String.format("[%d pkt] %s", points_to_score, content);
    }

    @Override
    public String getText() {
        return getOneLiner();
    }
}
