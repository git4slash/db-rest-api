package rest.repo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import rest.TestHelper;
import rest.pojo.TableView;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TableViewRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TableViewRepository repo;

    private List<TableView> demoEntities;

    @Before
    public void setUp() throws Exception {
        demoEntities = TestHelper.DEMO_DATA;
    }

    @Test
    public void givenDemoEntities_whenEntityManagerPersists_thenRepositoryReturnsRightSizeAndInformationIsCorrect() {

        // Given
        long entitiesInRepoBefore = repo.count();

        // When
        List<TableView> savedEnteties = repo.saveAll(demoEntities);

        // Then
        assertThat(repo.count() - entitiesInRepoBefore, is( (long) demoEntities.size()));
        savedEnteties.forEach(
                entity -> assertThat(entityManager.find(TableView.class, entity.getId()), is(entity))
        );
    }
}