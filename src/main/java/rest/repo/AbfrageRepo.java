package rest.repo;

import org.springframework.data.repository.CrudRepository;
import rest.pojo.AbfStandHausm;

public interface AbfrageRepo extends CrudRepository<AbfStandHausm, Long> {
}
