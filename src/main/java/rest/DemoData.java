package rest;

import rest.pojo.TableView;

import java.util.Arrays;
import java.util.List;

public class DemoData {
    public static List<TableView> getDemoData() {
        return Arrays.asList(
                new TableView(1, "SomeText"),
                new TableView(2, "SomeText2"),
                new TableView(3, "SomeText3"));
    }
}