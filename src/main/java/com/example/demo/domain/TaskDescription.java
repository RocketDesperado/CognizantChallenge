package com.example.demo.domain;

import com.example.demo.domain.model.task.TaskType;

/**
 * Task Description
 */
public class TaskDescription {

    private TaskDescription() {}

    private static final String FIBONACCI_DESCRIPTION = "Provide Fibonacci algorithm solution for the first 11 outputs. Please, separate every number with one empty space. Output should be trimmed.";

    private static final String IS_PALINDROME_DESCRIPTION = "Check whether given phrase is palyndrome or not using standart libraries. Output should be true or false. The phrase is: WAS IT A CAR OR A CAT I SAW";

    private static final String REVERSE_STRING_DESCRIPTION = "Reverse given String using standart libraries. The String is: YOU_ARE_HIRED";

    /**
     * Provides description by given task type
     * @param taskType
     * @return
     */
    public static String getDescriptionByTaskType(TaskType taskType) {
        String result = "";
        if (taskType == TaskType.FIBONACCI) {
            result = FIBONACCI_DESCRIPTION;
        } else if (taskType == TaskType.IS_PALINDROME) {
            result = IS_PALINDROME_DESCRIPTION;
        } else if (taskType == TaskType.REVERSE_STRING){
            result = REVERSE_STRING_DESCRIPTION;
        }
        return result;
    }
}
