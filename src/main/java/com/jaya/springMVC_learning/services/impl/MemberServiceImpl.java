package com.jaya.springMVC_learning.services.impl;

import com.jaya.springMVC_learning.dto.MemberDTO;
import com.jaya.springMVC_learning.models.Member;
import com.jaya.springMVC_learning.repositories.MemberRepository;
import com.jaya.springMVC_learning.services.MemberService;
import com.jaya.springMVC_learning.utility.DtoToEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * adding user into db
     *
     * @param memberDto
     */
    @Override
    @Transactional
    public void addUser(MemberDTO memberDto) {
        try {
            if (memberDto == null) {
                throw new IllegalArgumentException("MemberDTO cannot be null");
            }

            Member member = DtoToEntity.memberDtoToEntity(memberDto);
            member.setPassword(passwordEncoder.encode(memberDto.getPassword()));
            memberRepository.save(member);

            System.out.println("User added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage()); // we can use logger also, but we haven't studied it yet.
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error occurred while adding user: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
