package rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import rest.Helper;
import rest.exceptions.EntityNotFoundException;
import rest.exceptions.FieldOrSetterNotFoundException;
import rest.pojo.TableView;
import rest.repo.TableViewRepository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestController
@RequestMapping(path = "${app.address.api}")
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
    private static final String LABEL = MainController.class.getSimpleName();

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

    @Deprecated
    @PatchMapping(path = "${app.address.suffix.entity}/{id}")
    public TableView updateById(@PathVariable long id, @RequestBody TableView receivedEntity) {
        receivedEntity.setId(id);
        return repository.save(receivedEntity);
    }

    @PatchMapping("${app.address.suffix.entity}/{id}/set")
    @ResponseBody
    public TableView setParam(@PathVariable long id, @RequestParam String param, @RequestParam String value) {
        LOGGER.debug("{}.setParam(id : {}, param : {}, value : {})", LABEL, id, param, value);

        // obtaining link to entity in repo
        TableView linkToExistingEntity = repository.getOne(id);

        Helper.updateEntity(linkToExistingEntity, param, value).orElseThrow(() -> new FieldOrSetterNotFoundException(param));

        return repository.save(linkToExistingEntity);
    }
}