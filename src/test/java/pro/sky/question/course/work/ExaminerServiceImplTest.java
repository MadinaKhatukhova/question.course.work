package pro.sky.question.course.work;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.question.course.work.domain.Question;
import pro.sky.question.course.work.exceptions.NotExistException;
import pro.sky.question.course.work.service.ExaminerServiceImpl;
import pro.sky.question.course.work.constants.ServiceConstants;
import pro.sky.question.course.work.service.JavaQuestionService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void getQuestionCorrect() {

        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(ServiceConstants.RANDOM_QUESTION);
        when(javaQuestionServiceMock.getAll()).thenReturn(Collections.unmodifiableSet(ServiceConstants.RANDOM_SET));

        Set<Question> expected = new HashSet<>(Set.of(ServiceConstants.RANDOM_QUESTION));

        assertIterableEquals(Collections.unmodifiableSet(expected), out.getQuestion(1));
    }

    @Test
    void getQuestionInCorrect() {
        when(javaQuestionServiceMock.getAll()).thenReturn(Collections.unmodifiableSet(ServiceConstants.RANDOM_SET));

        assertThrows(NotExistException.class, () -> out.getQuestion(2));
    }
}
