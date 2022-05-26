package rifqimuhammadaziz.springcustomvalidator.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

// Custom Annotation
@Target({ElementType.TYPE}) // For Class
@Retention(RetentionPolicy.RUNTIME) // For Running Application
@Documented // Java Documentation
@Constraint(validatedBy = PasswordEqualConstrainValidator.class) // Validator
public @interface PasswordEqualConstrain {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
