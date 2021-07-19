package com.example.demo.controller.topthree;

import com.example.demo.domain.composites.TopThreeModelComposite;
import com.example.demo.domain.model.person.Person;
import com.example.demo.domain.model.task.ResultStatus;
import com.example.demo.domain.model.task.Task;
import com.example.demo.domain.model.task.TaskType;
import com.example.demo.service.CognizantChallengeAppSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class TopThreeAppCtrl {

    private CognizantChallengeAppSvc cognizantChallengeAppSvc;

    private TopThreeAppCtrlHelper topThreeAppCtrlHelper;

    @Autowired
    public TopThreeAppCtrl(CognizantChallengeAppSvc cognizantChallengeAppSvc, TopThreeAppCtrlHelper topThreeAppCtrlHelper) {
        this.cognizantChallengeAppSvc = cognizantChallengeAppSvc;
        this.topThreeAppCtrlHelper = topThreeAppCtrlHelper;
    }

    @GetMapping(value = "/topThree")
    public ModelAndView topThree() {
        ModelAndView modelAndView = new ModelAndView("topThree");
        List<Person> personList = cognizantChallengeAppSvc.getAllPersons();
        List<TopThreeModelComposite> modelCompositeList = topThreeAppCtrlHelper.topThreeModelCompositeList(personList);
        modelAndView.addObject("personsAndTasks", modelCompositeList);
        return modelAndView;
    }





}
