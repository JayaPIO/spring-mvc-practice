package com.jaya.springMVC_learning.services;

import com.jaya.springMVC_learning.models.Member;
import com.jaya.springMVC_learning.models.UserPrinciple;
import com.jaya.springMVC_learning.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username);

        if (member == null) {
            System.out.println("member not found");
            throw new UsernameNotFoundException("member not found");
        }
        return new UserPrinciple(member);
    }
}
