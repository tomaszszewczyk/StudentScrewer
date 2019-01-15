package tomaszszewczyk.studentscrewer.summaries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.easymock.EasyMock.replay;
import static org.junit.jupiter.api.Assertions.*;

class StandardSummaryTest {
    private ISummary tested;

    @BeforeEach
    void init() {
        tested = new StandardSummary();
    }

    @Test
    void test_add_positive() {
        tested.addScore(0, 2);
        tested.addScore(2, 4);
        tested.addScore(2, 4);

        assertEquals(4, tested.getScoredPoints());
        assertEquals(10, tested.getPossiblePoints());
        assertEquals(40, tested.getPercent());
    }

    @Test
    void test_add_positive_zero() {
        tested.addScore(0, 2);
        tested.addScore(0, 4);
        tested.addScore(0, 4);

        assertEquals(0, tested.getScoredPoints());
        assertEquals(10, tested.getPossiblePoints());
        assertEquals(0, tested.getPercent());
    }

    @Test
    void test_add_positive_full() {
        tested.addScore(2, 2);
        tested.addScore(4, 4);
        tested.addScore(4, 4);

        assertEquals(10, tested.getScoredPoints());
        assertEquals(10, tested.getPossiblePoints());
        assertEquals(100, tested.getPercent());
    }

    @Test
    void test_add_scored_bigger_than_possible() {
        assertThrows(RuntimeException.class, () -> tested.addScore(2, 0));
    }

    @Test
    void test_get_percent_from_empty() {
        assertEquals(0, tested.getPercent());
    }

    @Test
    void test_get_mark_with_mock() {
        tested.addScore(2, 2);
        tested.addScore(2, 4);
        tested.addScore(2, 4);

        IMarkStrategy mock_strategy = createMock(IMarkStrategy.class);
        expect(mock_strategy.calculateMark(60)).andReturn(IMarkStrategy.Mark.MARK_3_5);
        replay(mock_strategy);

        assertEquals(IMarkStrategy.Mark.MARK_3_5, tested.getMark(mock_strategy));

        verify(mock_strategy);
    }

    @Test
    void test_get_mark_with_std_mark_strategy() {
        tested.addScore(2, 2);
        tested.addScore(2, 4);
        tested.addScore(2, 4);

        assertEquals(IMarkStrategy.Mark.MARK_3_5, tested.getMark(new StandardMarkStrategy()));
    }
}