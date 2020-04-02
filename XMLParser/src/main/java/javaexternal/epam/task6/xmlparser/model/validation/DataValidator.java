
package javaexternal.epam.task6.xmlparser.model.validation;

import javaexternal.epam.task6.xmlparser.view.ValidationMessages;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class DataValidator
{
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();

    public void validate(Object object)
    {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if(violations.size() > 0)
        {
            System.err.println(ValidationMessages.VALIDATION_ERROR + object.getClass().getSimpleName());
            for(ConstraintViolation<Object> violation: violations)
            {
                System.err.println(ValidationMessages.INVALID_VALUE_OF_VAR + "\"" +
                        violation.getPropertyPath() + "\": " + violation.getInvalidValue());

                System.err.println(ValidationMessages.ERROR_MSG + violation.getMessage());
                System.out.println();
            }
        }
    }

    public void closeValidatorFactory()
    {
        validatorFactory.close();
    }

}
