package com.example.demo.controller.index;

import com.example.demo.domain.composites.SubmitValueComposite;
import com.example.demo.domain.model.task.Task;
import com.example.demo.domain.model.task.TaskType;
import com.example.demo.service.CognizantChallengeAppSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CognizantChallengeAppCtrl {

    private CognizantChallengeAppSvc cognizantChallengeAppSvc;

    @Autowired
    public CognizantChallengeAppCtrl(CognizantChallengeAppSvc cognizantChallengeAppSvc) {
        this.cognizantChallengeAppSvc = cognizantChallengeAppSvc;
    }

    @GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("submitValue", new SubmitValueComposite());
        modelAndView.addObject("taskList", Arrays.asList(TaskType.values()));
        return modelAndView;
    }

    @PostMapping(value = "/event")
    public String submitValues(@ModelAttribute(value = "submitValue") SubmitValueComposite submitValue) {
        if (!submitValue.getName().isEmpty() && !submitValue.getInputParameter().isEmpty()) {
            cognizantChallengeAppSvc.addPersonWithTask(submitValue);
        }
        return "redirect:";
    }
}
