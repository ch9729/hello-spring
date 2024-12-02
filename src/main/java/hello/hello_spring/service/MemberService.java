package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {   //회원가입(같은 이름은 중복이 안된다.)
        validateDDuplicateMember(member);   //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }


    private void validateDDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> { //null이 아니라 값이 있으면
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<Member> findMembers() { // 전체 회원 조회
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {    //회원 아이디로 한명 찾기
        return memberRepository.findById(memberId);
    }
}
