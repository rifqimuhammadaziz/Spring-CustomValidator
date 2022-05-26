package rifqimuhammadaziz.springcustomvalidator.validator;

import rifqimuhammadaziz.springcustomvalidator.dto.MemberRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// Validator for custom annotation
public class PasswordEqualConstraintValidator
        implements ConstraintValidator<PasswordEqualConstraint, Object> {

    /*
    If password & retype password is equals, return is true (valid)
    If password & retype password is not equals, return is false (not valid)
     */
    @Override
    public boolean isValid(Object data, ConstraintValidatorContext constraintValidatorContext) {
        MemberRequest memberRequest = (MemberRequest) data;
        return memberRequest.getMemberPassword().equals(memberRequest.getRetypeMemberPassword());
    }
}
