package pro.sky.question.course.work.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.question.course.work.domain.Question;
import pro.sky.question.course.work.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get/{amount}")

    public Collection<Question> getCollection(@PathVariable("amount") Integer amount) {
        return examinerService.getQuestion(amount);
    }
}
