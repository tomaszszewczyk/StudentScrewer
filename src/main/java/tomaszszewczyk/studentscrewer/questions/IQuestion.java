package tomaszszewczyk.studentscrewer.questions;

import tomaszszewczyk.studentscrewer.summaries.ISummary;

public interface IQuestion {
    public void setNoPoints(int points);

    public void addContent(String text);

    public void addAnswer(String answer);

    public void checkAnswer(String answer, ISummary summary);

    public String getOneLiner();

    public String getText();
}
