package com.schewe.dualisbot.application;

import com.schewe.dualisbot.domain.dualis.entities.Attempt;
import com.schewe.dualisbot.domain.dualis.entities.Exam;
import com.schewe.dualisbot.domain.dualis.entities.Module;
import com.schewe.dualisbot.domain.dualis.interfaces.ModuleMatcher;

import java.util.List;
import java.util.stream.Collectors;

public class EntityMatcher implements ModuleMatcher {

    public static void matchModules(List<Module> modules, List<Attempt> attempts, List<Exam> exams){
        for(Attempt attempt : attempts) {
            attempt.setExams(exams.stream().filter(exam ->
                    exam.getModuleId().equals(attempt.getModuleId()) &&
                    exam.getAttemptNumber().getNumber() == attempt.getNumber().getNumber()
            ).collect(Collectors.toList()).toArray(new Exam[0]));
        }
        for(Module module : modules) {
            module.setAttempts(attempts.stream().filter(attempt ->
                    attempt.getModuleId().equals(module.getModuleId())
            ).collect(Collectors.toList()).toArray(new Attempt[0]));
        }
    }

}
