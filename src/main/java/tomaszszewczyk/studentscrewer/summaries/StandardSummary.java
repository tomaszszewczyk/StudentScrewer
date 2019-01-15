package tomaszszewczyk.studentscrewer.summaries;

public class StandardSummary implements ISummary {
    private int scored_points;
    private int possible_points;

    public StandardSummary() {
        scored_points = 0;
        possible_points = 0;
    }

    @Override
    public void addScore(int scored, int possible) {
        if(scored > possible)
            throw new RuntimeException("Cannot score more points than possible");

        scored_points += scored;
        possible_points += possible;
    }

    @Override
    public int getScoredPoints() {
        return scored_points;
    }

    @Override
    public int getPossiblePoints() {
        return possible_points;
    }

    @Override
    public int getPercent() {
        return possible_points != 0 ? (scored_points * 100) / possible_points : 0;
    }

    @Override
    public IMarkStrategy.Mark getMark(IMarkStrategy strategy) {
        IMarkStrategy.Mark calculated_mark = strategy.calculateMark(getPercent());
        return calculated_mark;
    }
}
