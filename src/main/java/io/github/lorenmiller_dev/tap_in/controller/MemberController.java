package io.github.lorenmiller_dev.tap_in.controller;

import io.github.lorenmiller_dev.tap_in.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/tap/{nfcTagId}")
    public String tapIn(@PathVariable String nfcTagId) {
        return memberService.processTap(nfcTagId);
    }
}