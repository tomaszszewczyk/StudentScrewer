package tomaszszewczyk.studentscrewer.questions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import tomaszszewczyk.studentscrewer.summaries.ISummary;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OpenQuestionTest {
    private ISummary summary_mock;
    private IQuestion question;

    @BeforeEach
    void init() {
        summary_mock = mock(ISummary.class);
        question = new OpenQuestion();
    }

    @Test
    void test_correct_answer() {
        question.setNoPoints(10);
        question.addContent("What's the color of the sky?");
        question.addAnswer("Blue");

        summary_mock.addScore(10, 10);
        replay(summary_mock);

        question.checkAnswer("Blue", summary_mock);

        verify(summary_mock);
    }

    @Test
    void test_correct_answer_not_trimmed() {
        question.setNoPoints(10);
        question.addContent("What's the color of the sky?");
        question.addAnswer("Blue");

        summary_mock.addScore(10, 10);
        replay(summary_mock);

        question.checkAnswer("   Blue    ", summary_mock);

        verify(summary_mock);
    }

    @Test
    void test_correct_answer_not_matching_case() {
        question.setNoPoints(10);
        question.addContent("What's the color of the sky?");
        question.addAnswer("Blue");

        summary_mock.addScore(10, 10);
        replay(summary_mock);

        question.checkAnswer("BLUE", summary_mock);

        verify(summary_mock);
    }

    @Test
    void test_wrong_answer() {
        question.setNoPoints(10);
        question.addContent("What's the color of the sky?");
        question.addAnswer("Blue");

        summary_mock.addScore(0, 10);
        replay(summary_mock);

        question.checkAnswer("Red", summary_mock);

        verify(summary_mock);
    }
}