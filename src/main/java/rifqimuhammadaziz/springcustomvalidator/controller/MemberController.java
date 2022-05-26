package rifqimuhammadaziz.springcustomvalidator.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springcustomvalidator.dto.MemberRequest;
import rifqimuhammadaziz.springcustomvalidator.dto.MemberResponse;
import rifqimuhammadaziz.springcustomvalidator.dto.ResponseData;
import rifqimuhammadaziz.springcustomvalidator.entity.Member;
import rifqimuhammadaziz.springcustomvalidator.repository.MemberRepository;
import rifqimuhammadaziz.springcustomvalidator.utility.ErrorParsingUtility;

import javax.validation.Valid;
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
    public ResponseEntity<ResponseData<?>> create(@Valid @RequestBody MemberRequest memberRequest, Errors errors) {
        ResponseData<MemberResponse> responseData = new ResponseData<>();

        // Checking Errors
        if (errors.hasErrors()) {
            responseData.setStatus(false);
            responseData.setMessages(ErrorParsingUtility.parse(errors));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        try {
            Member member = modelMapper.map(memberRequest, Member.class); // from memberRequest to Member
            member = memberRepository.save(member);

            responseData.setStatus(true);
            responseData.getMessages().add("Member successfully saved!");
            responseData.setPayload(modelMapper.map(member, MemberResponse.class)); // from member to MemberResponse
            return ResponseEntity.ok(responseData);
        } catch (Exception exception) {
            responseData.setStatus(false);
            responseData.getMessages().add(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }


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
