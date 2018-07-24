package rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rest.pojo.TableView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.stream.Stream;

public class Helper {
    private static final Logger LOGGER = LoggerFactory.getLogger(Helper.class);
    private static final String LABEL = Helper.class.getSimpleName();

    /**
     * This method updated param in updatedEntity using corresponding setter (uses java reflection)
     * @param updatedEntity - entity to update
     * @param param - field name in updatedEntity to update
     * @param value - new value
     * @return Optional.or(true) if action performed and Optional.ofNullable(null) if not
     */
    public static Optional<Boolean> updateEntity(TableView updatedEntity, String param, String value){

        Optional<Boolean> result = Optional.ofNullable(null);

        final String setterName = "set" + param.substring(0, 1).toUpperCase() + param.substring(1).toLowerCase();

        try {
            // Using java reflection api we:
            // searching for method
            Method desiredSetter = Stream.of(TableView.class.getMethods())
                    // with set+Param name and one parameter
                    .filter(method ->
                            method.getName().matches(setterName) &&
                                    method.getParameterCount() == 1)
                    // assuming that we have nur one setter for each parameter
                    .findFirst()
                    .orElseThrow(NoSuchMethodException::new);

            // getting type of setter parameter value to correct type
            Class<?> setterParameterType = desiredSetter.getParameterTypes()[0];
            LOGGER.debug("{}.updateEntity(), desired method name : {}, parameter type : {}",
                    LABEL, setterName, setterParameterType.getSimpleName());

            // invoking method
            if (setterParameterType.getSimpleName().matches(String.class.getSimpleName()))
                desiredSetter.invoke(updatedEntity, value);
            else if (setterParameterType.getSimpleName().matches(Integer.class.getSimpleName()))
                desiredSetter.invoke(updatedEntity, Integer.parseInt(value));
            result = Optional.of(true);
            return result;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
