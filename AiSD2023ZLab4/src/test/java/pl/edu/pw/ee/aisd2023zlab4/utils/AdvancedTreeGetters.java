package pl.edu.pw.ee.aisd2023zlab4.utils;

import java.lang.reflect.Field;
import pl.edu.pw.ee.aisd2023zlab4.services.MapInterface;

public class AdvancedTreeGetters {

    public static int getNumOfElems(MapInterface<?,?> tree) {
        String fieldNumOfElems = "nElems";

        try {
            Field field = tree.getClass().getDeclaredField(fieldNumOfElems);
            field.setAccessible(true);

            int numOfElems = field.getInt(tree);

            return numOfElems;

        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}