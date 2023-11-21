package com.listbuilder.listbuilder.controllers;

import com.listbuilder.listbuilder.models.Unit;
import com.listbuilder.listbuilder.models.data.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ListController {

    @Autowired
    private UnitRepository unitRepository;


    @GetMapping("/")
    public String index(Model model) {

        List<Unit> units = (List<Unit>) unitRepository.findAll();
        int totalPoints = 0;

        for (Unit unit : units) {
           int cost = unit.getCost();
           totalPoints += cost;
        }

        model.addAttribute("unit", new Unit());
        model.addAttribute("unitList", unitRepository.findAll());
        model.addAttribute("pointsTotal", totalPoints);

        return "list-view";
    }

    @PostMapping
    public String addUnit(@ModelAttribute Unit newUnit, Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "list-view";
        }
        else {
            unitRepository.save(newUnit);
        }
        return "redirect:";

    }
}
