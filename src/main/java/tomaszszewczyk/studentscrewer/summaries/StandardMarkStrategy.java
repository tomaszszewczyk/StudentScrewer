package tomaszszewczyk.studentscrewer.summaries;

public class StandardMarkStrategy implements IMarkStrategy {

    public Mark calculateMark(int percent) {
        if(isInRange(percent, 50, 60))
            return Mark.MARK_3_0;
        else if(isInRange(percent, 60, 70))
            return Mark.MARK_3_5;
        else if(isInRange(percent, 70, 80))
            return Mark.MARK_4_0;
        else if(isInRange(percent, 80, 90))
            return Mark.MARK_4_5;
        else if(percent >= 90)
            return Mark.MARK_5_0;
        else
            return Mark.MARK_2_0;
    }

    private boolean isInRange(int x, int lower, int upper) {
        return x >= lower && x < upper;
    }
}
