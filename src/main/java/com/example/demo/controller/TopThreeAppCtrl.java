package com.example.demo.controller;

import com.example.demo.domain.model.person.Person;
import com.example.demo.service.CognizantChallengeAppSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TopThreeAppCtrl {

    private CognizantChallengeAppSvc cognizantChallengeAppSvc;

    @Autowired
    public TopThreeAppCtrl(CognizantChallengeAppSvc cognizantChallengeAppSvc) {
        this.cognizantChallengeAppSvc = cognizantChallengeAppSvc;
    }

    @GetMapping(value="/topThree")
    public ModelAndView topThree() {
        ModelAndView modelAndView = new ModelAndView("topThree");
        List<Person> personList = cognizantChallengeAppSvc.getAllPersons();
        modelAndView.addObject("personsAndTasks", personList);
        return modelAndView;
    }

}
