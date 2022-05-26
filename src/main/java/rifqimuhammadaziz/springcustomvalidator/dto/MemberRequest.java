package rifqimuhammadaziz.springcustomvalidator.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRequest { // From client to endpoint
    private String memberNumber;
    private String memberName;
    private String memberEmail;
    private String memberPassword;
    private String retypeMemberPassword;
}
