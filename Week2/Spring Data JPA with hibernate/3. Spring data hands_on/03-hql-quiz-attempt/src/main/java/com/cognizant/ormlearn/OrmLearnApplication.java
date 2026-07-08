package com.cognizant.ormlearn;

import com.cognizant.ormlearn.entity.Attempt;
import com.cognizant.ormlearn.entity.AttemptQuestion;
import com.cognizant.ormlearn.entity.Option;
import com.cognizant.ormlearn.service.AttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static AttemptService attemptService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        attemptService = context.getBean(AttemptService.class);

        testGetAttemptDetail();
    }

    public static void testGetAttemptDetail() {
        LOGGER.info("Start");

        int userId = 1;
        int attemptId = 1;
        Attempt attempt = attemptService.getAttempt(userId, attemptId);
        LOGGER.debug("Attempt:{}", attempt);

        // Sort questions by attempt_question id so the output order is stable
        List<AttemptQuestion> attemptQuestions = attempt.getAttemptQuestions().stream()
                .sorted(Comparator.comparingInt(AttemptQuestion::getId))
                .collect(Collectors.toList());

        for (AttemptQuestion aq : attemptQuestions) {
            System.out.println(aq.getQuestion().getText());

            // Options the user selected for this attempt_question
            Set<Integer> selectedOptionIds = aq.getAttemptOptions().stream()
                    .map(ao -> ao.getOption().getId())
                    .collect(Collectors.toSet());

            // All options for this question, in a stable order
            List<Option> options = aq.getQuestion().getOptions().stream()
                    .sorted(Comparator.comparingInt(Option::getId))
                    .collect(Collectors.toList());

            int index = 1;
            for (Option option : options) {
                boolean selected = selectedOptionIds.contains(option.getId());
                System.out.printf("%d) %-12s %-6s %s%n", index, option.getText(), option.getScore(), selected);
                index++;
            }
            System.out.println();
        }

        LOGGER.info("End");
    }
}
