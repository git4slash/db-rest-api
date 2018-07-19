package rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.pojo.TableView;

public interface TableViewRepository extends JpaRepository<TableView, Long> {
}
