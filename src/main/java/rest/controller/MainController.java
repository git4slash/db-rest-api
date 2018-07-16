package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rest.pojo.AbfStandHausm;
import rest.repo.AbfrageRepo;

@Controller
@RequestMapping(path = "/")
public class MainController {
    @Autowired
    private AbfrageRepo repository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<AbfStandHausm> getAllEntities() {
        return repository.findAll();
    }
}