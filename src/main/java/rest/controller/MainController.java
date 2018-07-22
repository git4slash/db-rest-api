package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import rest.exceptions.EntityNotFoundException;
import rest.pojo.TableView;
import rest.repo.TableViewRepository;

@RestController
@RequestMapping(path = "${app.address.api}")
public class MainController {
    private final TableViewRepository repository;

    @Value("${about_service}")
    private String aboutService;

    @Autowired
    public MainController(TableViewRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "${app.address.suffix.about_service}")
    public String getInfoAboutService() {
        return aboutService;
    }

    @GetMapping(path = "${app.address.suffix.all}")
    public @ResponseBody Iterable<TableView> getAllEntities() {
        return repository.findAll();
    }

    @GetMapping(path = "${app.address.suffix.entity}/{id}")
    public @ResponseBody TableView getById(@PathVariable long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(" with id=" + id));
    }

    @PatchMapping(path = "${app.address.suffix.entity}/{id}")
    public TableView updateById(@PathVariable long id, @RequestBody TableView receivedEntity) {
        receivedEntity.setId(id);
        return repository.save(receivedEntity);
    }
}