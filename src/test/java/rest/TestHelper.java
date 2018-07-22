package rest;

import org.springframework.context.annotation.Profile;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.stereotype.Component;
import rest.pojo.TableView;

import java.util.Arrays;
import java.util.List;

@Component
@Profile({"test", "development"})
public class TestHelper {
    final public static List<TableView> DEMO_DATA =
            Arrays.asList(
                    new TableView(111, "standort", " strasse", " nr", 99999, "New ort", "Some tel", "tel", "", "Herr", "Mc", "Donald's", "", "tel", "mobile", "privat", "too many fields, the entity is clearly overloaded"),
                    new TableView(222, " standort", " strasse", " nr", 888, "New ort", "Some tel", "te2", "", "Herr", "Burger", "King", "", "tel", "mobile", "privat", "too many fields, the entity is clearly overloaded"),
                    new TableView(333, "standort", " strasse", " nr", 777, "New ort", "Some tel", "te3", "", "Herr", "Burger", "King", "", "tel", "mobile", "privat", "too many fields, the entity is clearly overloaded")
            );
}