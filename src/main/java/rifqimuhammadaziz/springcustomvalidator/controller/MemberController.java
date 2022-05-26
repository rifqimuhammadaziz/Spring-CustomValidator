package rifqimuhammadaziz.springcustomvalidator.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springcustomvalidator.dto.MemberRequest;
import rifqimuhammadaziz.springcustomvalidator.dto.MemberResponse;
import rifqimuhammadaziz.springcustomvalidator.dto.ResponseData;
import rifqimuhammadaziz.springcustomvalidator.entity.Member;
import rifqimuhammadaziz.springcustomvalidator.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<?>> create(@RequestBody MemberRequest memberRequest) {
        ResponseData<MemberResponse> responseData = new ResponseData<>();
        Member member = modelMapper.map(memberRequest, Member.class); // from memberRequest to Member
        member = memberRepository.save(member);

        responseData.setStatus(true);
        responseData.getMessages().add("Member successfully saved!");
        responseData.setPayload(modelMapper.map(member, MemberResponse.class)); // from member to MemberResponse
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponseData<List<MemberResponse>>> findAll() {
        ResponseData<List<MemberResponse>> response = new ResponseData<>();
        List<MemberResponse> listMember = new ArrayList<>();

        // findAll return is List, then convert to MemberResponse (response without password)
        memberRepository.findAll().forEach(member -> {
            listMember.add(modelMapper.map(member, MemberResponse.class));
        });

        response.setStatus(true);
        response.setPayload(listMember);
        return ResponseEntity.ok(response);
    }
}
