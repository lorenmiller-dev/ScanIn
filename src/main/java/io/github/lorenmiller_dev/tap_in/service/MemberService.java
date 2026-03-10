package io.github.lorenmiller_dev.tap_in.service;

import io.github.lorenmiller_dev.tap_in.model.Member;
import io.github.lorenmiller_dev.tap_in.model.Membership;
import io.github.lorenmiller_dev.tap_in.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MemberService {

    /*

     */
    private final MemberRepository memberRepository;

    /*

     */
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*

     */
    public String processTap(String nfcTagId) {
        Optional<Member> memberOpt = memberRepository.findByNfcTagId(nfcTagId);

        // check if member repo is empty
        if (memberOpt.isEmpty()) {
            return "Invalid ID: Member not found.";
        }

        // get member
        Member member = memberOpt.get();

        // Success, update current scan time and save member
        member.setLastScanAt(LocalDateTime.now());
        memberRepository.save(member);
        // print welcome message
        return switch (memberOpt.get().getMembership().getStatus()) {
            case ACTIVE -> "Welcome " + memberOpt.get().getFirstName() + ", Membership Type: " + memberOpt.get().getMembership().getType() + ", Tenure: " + memberOpt.get().getTenureInYears() + " years.";
            case EXPIRED ->  memberOpt.get().getFirstName() + "'s membership has expired.";
            case EXPIRING_SOON ->   memberOpt.get().getFirstName() + "'s membership is expiring soon.";
            case BANNED ->   memberOpt.get().getFirstName() + " is banned. Alert a Supervisor or Manager!";
            case null, default -> "Invalid ID: Member not found. See membership.";
        };
    }
}
