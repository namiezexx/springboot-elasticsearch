package com.example.es.controller;

import com.example.es.entity.Users;
import com.example.es.repository.UsersRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final UsersRepository usersRepository;

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    public MemberController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping()
    public List<Users> getMembers() {
        log.info("call getMember");
        return usersRepository.findAll();
    }

    @GetMapping("/exception")
    public String throwException() throws Exception {
        log.info("call throwException");
        throw new RuntimeException("이건 에러입니다.");
    }

    @PostConstruct
    public void initData() {
        Users user = new Users();
        user.setUsername("이재석");
        usersRepository.save(user);

        user = new Users();
        user.setUsername("김아름");
        usersRepository.save(user);

        user = new Users();
        user.setUsername("이우진");
        usersRepository.save(user);

        user = new Users();
        user.setUsername("이우찬");
        usersRepository.save(user);

        user = new Users();
        user.setUsername("홍길동");
        usersRepository.save(user);
    }

}
