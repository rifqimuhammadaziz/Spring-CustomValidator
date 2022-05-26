package rifqimuhammadaziz.springcustomvalidator.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class MemberRequest { // From client to endpoint

    @NotEmpty(message = "Number is required")
    @Size(min = 3, max = 5, message = "Number length must be 3 to 5 character")
    @Pattern(regexp = "MB[0-9]+", message = "Number must be start with \'MB\'")
    private String memberNumber;

    @NotEmpty(message = "Name is required")
    private String memberName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email is invalid")
    private String memberEmail;

    @NotEmpty(message = "Password is required")
    private String memberPassword;
    private String retypeMemberPassword;
}
