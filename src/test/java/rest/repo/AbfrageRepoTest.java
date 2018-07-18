package rest.repo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import rest.TestHelper;
import rest.pojo.AbfStandHausm;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AbfrageRepoTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AbfrageRepo repo;

    private List<AbfStandHausm> entities;

    @Before
    public void setUp() throws Exception {
        entities = TestHelper.getThreeAbragen();
    }

    @Test
    public void testFindAll() {

        long entitiesInRepoBefore = repo.count();

        entities.forEach(entityManager::persist);

        long entitiesInRepoAfter = repo.count();

        assertThat( (int) (entitiesInRepoAfter - entitiesInRepoBefore), is(entities.size()));

        entities.forEach(entityManager::remove);
    }
}