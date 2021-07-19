package com.example.demo.service;

import static com.example.demo.domain.model.task.TaskType.*;
import static com.example.demo.domain.model.task.TaskOutputSolution.*;
import static com.example.demo.domain.model.task.ResultStatus.*;

import com.example.demo.domain.model.task.ResultStatus;
import com.example.demo.domain.model.task.TaskType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CognizantChallengeAppSvcHelper {

    public ResultStatus defineResultStatus(TaskType taskType, String output) {
        if (taskType == FIBONACCI) {
            return output.equals(FIBONACCI_SOLUTION) ? SUCCESS : FAILED;
        } else if (taskType == BINARY_SEARCH) {
            return output.equals(BINARY_SEARCH_SOLUTION) ? SUCCESS : FAILED;
        } else {
            return ResultStatus.UNDEFINED;
        }
    }

}
