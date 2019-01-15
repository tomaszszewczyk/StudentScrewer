package tomaszszewczyk.studentscrewer.summaries;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StandardMarkStrategyTest {
    private StandardMarkStrategy tested;

    @BeforeAll
    void init() {
        tested = new StandardMarkStrategy();
    }

    @Test
    void TestCalculateMark_2_0() {
        assertEquals(IMarkStrategy.Mark.MARK_2_0, tested.calculateMark(-100));
        assertEquals(IMarkStrategy.Mark.MARK_2_0, tested.calculateMark(0));
        assertEquals(IMarkStrategy.Mark.MARK_2_0, tested.calculateMark(40));
        assertEquals(IMarkStrategy.Mark.MARK_2_0, tested.calculateMark(49));
    }

    @Test
    void TestCalculateMark_3_0() {
        assertEquals(IMarkStrategy.Mark.MARK_3_0, tested.calculateMark(50));
        assertEquals(IMarkStrategy.Mark.MARK_3_0, tested.calculateMark(55));
        assertEquals(IMarkStrategy.Mark.MARK_3_0, tested.calculateMark(59));
    }

    @Test
    void TestCalculateMark_3_5() {
        assertEquals(IMarkStrategy.Mark.MARK_3_5, tested.calculateMark(60));
        assertEquals(IMarkStrategy.Mark.MARK_3_5, tested.calculateMark(65));
        assertEquals(IMarkStrategy.Mark.MARK_3_5, tested.calculateMark(69));
    }

    @Test
    void TestCalculateMark_4_0() {
        assertEquals(IMarkStrategy.Mark.MARK_4_0, tested.calculateMark(70));
        assertEquals(IMarkStrategy.Mark.MARK_4_0, tested.calculateMark(75));
        assertEquals(IMarkStrategy.Mark.MARK_4_0, tested.calculateMark(79));
    }

    @Test
    void TestCalculateMark_4_5() {
        assertEquals(IMarkStrategy.Mark.MARK_4_5, tested.calculateMark(80));
        assertEquals(IMarkStrategy.Mark.MARK_4_5, tested.calculateMark(85));
        assertEquals(IMarkStrategy.Mark.MARK_4_5, tested.calculateMark(89));
    }

    @Test
    void TestCalculateMark_5_0() {
        assertEquals(IMarkStrategy.Mark.MARK_5_0, tested.calculateMark(90));
        assertEquals(IMarkStrategy.Mark.MARK_5_0, tested.calculateMark(95));
        assertEquals(IMarkStrategy.Mark.MARK_5_0, tested.calculateMark(100));
    }

}