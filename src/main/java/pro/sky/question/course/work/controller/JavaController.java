package pro.sky.question.course.work.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.question.course.work.domain.Question;
import pro.sky.question.course.work.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {

    private final QuestionService service;

    public JavaController(QuestionService questionService) {
        this.service = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);

    }

    @GetMapping("/remove")
                public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
            return service.remove(new Question(question, answer));
    }

    @GetMapping() public Collection<Question> removeQuestion() {
        return service.getAll();
    }

}

