package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.exceptions.EntityNotFoundException;
import rest.pojo.TableView;
import rest.repo.TableViewRepository;

@RestController
@RequestMapping(path = "${app.address.api}")
public class MainController {
    private final TableViewRepository repository;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Autowired
    public MainController(TableViewRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/info")
    public String retrieveWelcomeMessage() {
        return welcomeMessage;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<TableView> getAllEntities() {
        return repository.findAll();
    }

    @GetMapping(path = "/${app.address.suffix.entity}/{id}")
    public @ResponseBody TableView getById(@PathVariable long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(" with id=" + id));
    }

    @PatchMapping(path = "/${app.address.suffix.entity}/{id}")
    public TableView updateById(@PathVariable long id, @RequestBody TableView receivedEntity) {
        // Retrieving reference to object in db (without fetching it from db)
        TableView dbEntity = repository.getOne(id);
        // Updating existing obj with received data
        dbEntity.updateWith(receivedEntity);
        return repository.save(dbEntity);
    }
}