package rifqimuhammadaziz.springcustomvalidator.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberResponse { // Response data from api
    private Long id;
    private String memberNumber;
    private String memberName;
    private String memberEmail;
}
