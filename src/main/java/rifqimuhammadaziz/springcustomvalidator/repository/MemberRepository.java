package rifqimuhammadaziz.springcustomvalidator.repository;

import org.springframework.data.repository.CrudRepository;
import rifqimuhammadaziz.springcustomvalidator.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {

    boolean existsMemberByMemberNumber(String memberNumber);

    boolean existsMemberByMemberEmail(String memberEmail);
}
