package com.example.demo.service;

import static com.example.demo.domain.model.task.TaskType.*;
import static com.example.demo.domain.AnswerSheet.*;
import static com.example.demo.domain.model.task.ResultStatus.*;

import com.example.demo.domain.model.task.ResultStatus;
import com.example.demo.domain.model.task.TaskType;
import org.springframework.stereotype.Service;

@Service
public class CognizantChallengeAppSvcHelper {

    public ResultStatus defineResultStatus(TaskType taskType, String output) {
        if (taskType == FIBONACCI) {
            return output.equals(FIBONACCI_ANSWER) ? SUCCESS : FAILED;
        } else if (taskType == IS_PALINDROME) {
            return output.equals(IS_PALINDROME_ANSWER) ? SUCCESS : FAILED;
        } else if (taskType == REVERSE_STRING) {
            return output.equals(REVERSE_STRING_ANSWER) ? SUCCESS : FAILED;
        } else {
            return UNDEFINED;
        }
    }

}
