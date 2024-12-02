package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); //저장
    Optional<Member> findById(Long id); //id로 회원 찾기
    Optional<Member> findByName(String name);   //이름으로 찾기
    List<Member> findAll(); //모든 리스트 찾기
}
