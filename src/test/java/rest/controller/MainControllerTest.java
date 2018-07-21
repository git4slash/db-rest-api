package rest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import rest.Application;
import rest.TestHelper;
import rest.pojo.TableView;
import rest.repo.TableViewRepository;

import java.nio.charset.Charset;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class MainControllerTest {

    @Value("${app.address.api}")
    private String apiAddress;

    @Value("${app.address.suffix.entity}")
    private String entitySuffix;

    @Value("${app.address.suffix.all}")
    private String allSuffix;

    @Value("${about_service}")
    private String aboutServiceMessage;

    @Value("${app.address.suffix.about_service}")
    private String aboutServiceSuffix;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
                                                  MediaType.APPLICATION_JSON.getSubtype(),
                                                  Charset.forName("utf8"));

    private MockMvc mvc;

    private List<TableView> savedEntitiesList;

    @Autowired
    private TableViewRepository repository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        this.mvc = webAppContextSetup(webApplicationContext).build();

        this.repository.deleteAllInBatch();

        List<TableView> demoEntitiesList = TestHelper.getDemoData();

        this.savedEntitiesList = this.repository.saveAll(demoEntitiesList);
    }

    @Test
    public void givenUrlToWebRestApi_whenRequestIsExecuted_then200IsReceived_and_ResponseContentTypeIsJson() throws Exception {

        // Given
        String apiUrl = apiAddress + allSuffix;

        // When
        mvc.perform(get(apiUrl))

        // Then
                .andDo(print())
                .andExpect(content().contentType(contentType));
    }

    @Test
    public void givenInfoAboutServiceUrl_whenRequestIsExecuted_thenResponseContentIsCorrect() throws Exception {

        // Given
        String infoUrl = apiAddress + aboutServiceSuffix;

        // When
        mvc.perform(get(infoUrl))

        // Then
                .andExpect(jsonPath("$", is(aboutServiceMessage)));
    }

    @Test
    public void givenNonExistEntityUrl_whenEntityIsRetrieved_then404IsReceived() throws Exception {

        // Given
        int idxAfterLastInRepo = (int) repository.count() + 1;
        String nonExistEntityUrl = apiAddress + entitySuffix + "/" + idxAfterLastInRepo;

        //When
        mvc.perform(get(nonExistEntityUrl))

        //Then
                .andExpect(status().isNotFound());
    }

    @Test
    public void givenTableViewEntityExistsUrl_whenTableViewEntityInformationIsRetrieved_thenRetrievedInformationIsCorrect()throws Exception {

        // Given
        TableView tableViewEntity = savedEntitiesList.get(0);
        String existingTableViewEntityUrl = apiAddress + entitySuffix + "/" + tableViewEntity.getId();

        // When
        mvc.perform(get(existingTableViewEntityUrl))

        //Then
                .andExpect(jsonPath("$.intern", is(tableViewEntity.getIntern())))
                .andExpect(jsonPath("$.standort", is(tableViewEntity.getStandort())));
    }

    @Test
    public void givenGetAllEntitiesUrl_whenRequestIsPerformed_thenRetrievedInformationIsArrayTypeAndContainsCorrectData() throws Exception {

        // Given
        String getAllEntitiesUrl = apiAddress + allSuffix;

        // When
        mvc.perform(get(getAllEntitiesUrl))

        // Then
                // retrieved info is collection/array type and has size parameter with the correct value
                .andExpect(jsonPath("$", hasSize(savedEntitiesList.size())))
                // first entity
                .andExpect(jsonPath("$[0].id", is(savedEntitiesList.get(0).getId().intValue())))
                .andExpect(jsonPath("$[0].intern", is(savedEntitiesList.get(0).getIntern())))
                .andExpect(jsonPath("$[0].standort", is(savedEntitiesList.get(0).getStandort())))
                // second entity
                .andExpect(jsonPath("$[1].id", is(savedEntitiesList.get(1).getId().intValue())))
                .andExpect(jsonPath("$[1].intern", is(savedEntitiesList.get(1).getIntern())))
                .andExpect(jsonPath("$[1].standort", is(savedEntitiesList.get(1).getStandort())))
                // third entity
                .andExpect(jsonPath("$[2].id", is(savedEntitiesList.get(2).getId().intValue())))
                .andExpect(jsonPath("$[2].intern", is(savedEntitiesList.get(2).getIntern())))
                .andExpect(jsonPath("$[2].standort", is(savedEntitiesList.get(2).getStandort())));

    }
}
