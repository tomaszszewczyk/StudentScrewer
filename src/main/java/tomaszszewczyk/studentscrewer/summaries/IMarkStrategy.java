package tomaszszewczyk.studentscrewer.summaries;

public interface IMarkStrategy {
    public enum Mark {
        MARK_2_0,
        MARK_3_0,
        MARK_3_5,
        MARK_4_0,
        MARK_4_5,
        MARK_5_0;

        @Override
        public String toString() {
            switch (this) {
                case MARK_2_0:
                    return "2.0";
                case MARK_3_0:
                    return "3.0";
                case MARK_3_5:
                    return "3.5";
                case MARK_4_0:
                    return "4.0";
                case MARK_4_5:
                    return "4.5";
                case MARK_5_0:
                    return "5.0";
            }
            return "Should not get there";
        }
    }

    ;

    public Mark calculateMark(int percent);
}
