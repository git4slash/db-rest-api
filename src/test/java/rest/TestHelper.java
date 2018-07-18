package rest;

import rest.pojo.AbfStandHausm;

import java.util.Arrays;
import java.util.List;

public class TestHelper {
    public static List<AbfStandHausm> getThreeAbragen() {
        return Arrays.asList(
                new AbfStandHausm(1, "SomeText"),
                new AbfStandHausm(2, "SomeText2"),
                new AbfStandHausm(3, "SomeText3"));
    }
}
