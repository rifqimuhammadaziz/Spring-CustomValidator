package rifqimuhammadaziz.springcustomvalidator.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

// Custom Annotation
@Target({ElementType.TYPE}) // For Class
@Retention(RetentionPolicy.RUNTIME) // For Running Application
@Documented // Java Documentation
@Constraint(validatedBy = PasswordEqualConstraintValidator.class) // Validator
public @interface PasswordEqualConstraint {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
