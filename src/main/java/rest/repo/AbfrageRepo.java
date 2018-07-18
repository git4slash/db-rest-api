package rest.repo;

import org.springframework.data.repository.CrudRepository;
import rest.pojo.AbfStandHausm;

import java.util.Optional;

public interface AbfrageRepo extends CrudRepository<AbfStandHausm, Long> {
}
