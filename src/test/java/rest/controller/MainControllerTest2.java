package rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import rest.Application;
import rest.DemoData;
import rest.pojo.TableView;
import rest.repo.TableViewRepository;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class MainControllerTest2 {

    @Value("${app.address.api}")
    private String apiAddress;

    @Value("${app.address.suffix.entity}")
    private String entitySuffix;

    @Value("${app.address.suffix.all}")
    private String allSuffix;

    private MediaType contentType =
            new MediaType(MediaType.APPLICATION_JSON.getType(),
                          MediaType.APPLICATION_JSON.getSubtype(),
                          Charset.forName("utf8"));

    private MockMvc mvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private List<TableView> testEntities;

    @Autowired
    private TableViewRepository repository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    @Qualifier("mappingJackson2HttpMessageConverter")
    void setConverters(HttpMessageConverter<?> converters) {

        this.mappingJackson2HttpMessageConverter =
                Stream.of(converters)
                        .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                        .findAny()
                        .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setUp() throws Exception {
        this.mvc = webAppContextSetup(webApplicationContext).build();

        this.repository.deleteAllInBatch();

        testEntities = DemoData.getDemoData();

        this.repository.saveAll(testEntities);
    }

    @Test
    public void isNotFound() throws Exception {
        mvc.perform(get(apiAddress + entitySuffix + "/" + testEntities.size() + 1))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getOneEntity()throws Exception {
        TableView testEntity = testEntities.get(0);

        mvc.perform(get(apiAddress + entitySuffix + "/" + 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.intern", is(testEntity.getIntern())))
                .andExpect(jsonPath("$.standort", is(testEntity.getStandort())));
    }

//    @Test
//    public void getAll() throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//
//        mvc.perform(get(apiAddress + allSuffix))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("$", hasSize(testEntities.size())))
//                .andExpect(jsonPath("$[0]", is(mapper.writeValueAsString(testEntities.get(0)))));
//    }
//    @After
//    public void tearDown() throws Exception {
//
//    }
}
