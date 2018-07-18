package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rest.pojo.AbfStandHausm;
import rest.repo.AbfrageRepo;

@RestController
@RequestMapping(path = "/")
public class MainController {
    private final AbfrageRepo repository;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Autowired
    public MainController(AbfrageRepo repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/")
    public String retrieveWelcomeMessage() {
        return welcomeMessage;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<AbfStandHausm> getAllEntities() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAbfrage(@RequestBody AbfStandHausm abfrage) {

    }
}