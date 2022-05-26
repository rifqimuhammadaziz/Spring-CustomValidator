package rifqimuhammadaziz.springcustomvalidator.validator;

import org.springframework.beans.factory.annotation.Autowired;
import rifqimuhammadaziz.springcustomvalidator.repository.MemberRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// Validator for MemberNumber (String)
public class NumberUniqueConstraintValidator implements ConstraintValidator<NumberUniqueConstraint, String> {

    @Autowired
    private MemberRepository memberRepository;

    /*
    If member number exists, return is false (invalid)
    If member number not exists, return is true (valid)
     */

    @Override
    public boolean isValid(String memberNumber, ConstraintValidatorContext constraintValidatorContext) {
        return !memberRepository.existsMemberByMemberNumber(memberNumber);
    }
}
