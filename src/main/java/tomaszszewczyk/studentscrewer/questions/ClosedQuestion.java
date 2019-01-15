package tomaszszewczyk.studentscrewer.questions;

import tomaszszewczyk.studentscrewer.summaries.ISummary;

import java.util.ArrayList;
import java.util.List;

public class ClosedQuestion extends OpenQuestion {
    private List<String> possible_answers = new ArrayList<>();

    @Override
    public void addAnswer(String new_answer) {
        if(possible_answers.stream().anyMatch(str -> str.equalsIgnoreCase(new_answer.trim())))
            super.addAnswer(new_answer);
    }

    public void addPossibleAnswer(String answer) {
        possible_answers.add(answer);
    }

    @Override
    public String getText() {
        String result = getOneLiner();
        char count = 'a';

        for(String option : possible_answers) {
            result = String.format("%s\n\t%c. %s", result, count, option);
            count++;
        }

        return result;
    }
}
