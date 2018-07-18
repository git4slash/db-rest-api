package rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rest.DemoData;
import rest.pojo.AbfStandHausm;
import rest.repo.AbfrageRepo;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {

    private MockMvc mvc;

    @Mock
    private AbfrageRepo repository;

    @InjectMocks
    private MainController mainController;

    private JacksonTester<AbfStandHausm> jsonAbfStandHausm;
    private List<AbfStandHausm> testEntities;

    @Before
    public void setUp() throws Exception {
        // Initializing JacksonTester - little bit magic
        JacksonTester.initFields(this, new ObjectMapper());

        // MockMvc standalone approach
        mvc = MockMvcBuilders.standaloneSetup(mainController)
                .setControllerAdvice(new MainExceptionHandler())
                .addFilter(new MainFilter())
                .build();

        testEntities = DemoData.getDemoData();
    }

    // TODO write test's to main controller
    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
//        long repoSizeBeforeSave = repository.count();
//        AbfStandHausm testEntity = repository.save(testEntities.get(0));
//
//        Optional<AbfStandHausm> optional = repository.findById(3L);

//        System.out.printf("result present: %b, and: %s", optional.isPresent(), optional.get());
//        AbfStandHausm retrievedEntity = optional.get();
//        assertThat(retrievedEntity.getIntern(), is(testEntity.getIntern()));
//        assertThat(retrievedEntity.getStandort(), is(testEntity.getStandort()));

    }

    @After
    public void tearDown() throws Exception {
    }
}
