package pl.qa.selenium.data.converter;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import pl.qa.selenium.data.persistence.model.User;

public class UserTestDataConverter implements ArgumentConverter {
    @Override
    public User convert(Object o, ParameterContext parameterContext) throws ArgumentConversionException {
        String[] arguments = ((String) o).split(",");
        User user = new User();
        user.setFirstName(arguments[0]);
        user.setSureName(arguments[1]);
        return user;
    }
}
