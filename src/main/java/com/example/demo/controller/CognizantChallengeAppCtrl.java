package com.example.demo.controller;

import com.example.demo.domain.composites.SubmitValueComposite;
import com.example.demo.domain.model.task.Task;
import com.example.demo.service.CognizantChallengeAppSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CognizantChallengeAppCtrl {

    private CognizantChallengeAppSvc cognizantChallengeAppSvc;

    @Autowired
    public CognizantChallengeAppCtrl(CognizantChallengeAppSvc cognizantChallengeAppSvc) {
        this.cognizantChallengeAppSvc = cognizantChallengeAppSvc;
    }

    @GetMapping(value="/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Task> taskList = cognizantChallengeAppSvc.getAllTasks();

        // hardcoded value by default
        Task task = taskList.stream().filter(x -> "Fibonacci".equals(x.getTaskName())).findFirst().get();

        SubmitValueComposite valueComposite = new SubmitValueComposite();
        valueComposite.setDescription(task.getDescription());
        modelAndView.addObject("submitValue", valueComposite);
        modelAndView.addObject("taskList", taskList);
        return modelAndView;
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public String submitValues(@ModelAttribute(value = "submitValue") SubmitValueComposite submitValue) {
        if (submitValue.getName() != null && submitValue.getInputParameter() != null) {
            cognizantChallengeAppSvc.addPersonWithTask(submitValue);
        }
        return "redirect:";
    }
}
