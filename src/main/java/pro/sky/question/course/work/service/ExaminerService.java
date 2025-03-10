package pro.sky.question.course.work.service;

import pro.sky.question.course.work.domain.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);
}
