package tomaszszewczyk.studentscrewer.summaries;

public interface ISummary {
    public void addScore(int scored, int possible);

    public int getScoredPoints();

    public int getPossiblePoints();

    public int getPercent();

    public IMarkStrategy.Mark getMark(IMarkStrategy strategy);
}
