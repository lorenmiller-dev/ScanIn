package io.github.lorenmiller_dev.tap_in.configuration;

import io.github.lorenmiller_dev.tap_in.model.Member;
import io.github.lorenmiller_dev.tap_in.model.Membership;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import io.github.lorenmiller_dev.tap_in.repository.MemberRepository;

/**
 *
 */
@Component
public class DataInitializer implements CommandLineRunner {

    //
    private final MemberRepository memberRepository;

    // Constructor Injection, Spring gives this class access to your repository.
    public DataInitializer(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     *
     * @param args incoming main method arguments
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        try {
            if (memberRepository.count() == 0) {
                System.out.println("Database currently has " + memberRepository.count() + " members. Loading test members...");

                // create valid active member
                Member john = new Member();
                john.setNfcTagId("TEST-123");
                john.setFirstName("John");
                john.setLastName("Doe");
                john.setTenureInYears(5);
                john.setMembership(new Membership(Membership.Type.BUSINESS_GOLD, Membership.Status.ACTIVE));

                // create valid inactive member
                Member jane = new Member();
                jane.setNfcTagId("EXPIRED-123");
                jane.setFirstName("Jane");
                jane.setLastName("Smith");
                jane.setTenureInYears(0);
                jane.setMembership(new Membership(Membership.Type.EXECUTIVE, Membership.Status.EXPIRED));

                // create banned member
                Member loren = new Member();
                loren.setNfcTagId("BANNED-123");
                loren.setFirstName("Loren");
                loren.setLastName("Miller");
                loren.setMembership(new Membership(Membership.Type.NULL, Membership.Status.BANNED));

                // save test member cases to database
                memberRepository.save(john);
                memberRepository.save(jane);
                memberRepository.save(loren);

                // success print statement
                System.out.println("Successfully saved 3 test members to database");
                System.out.println("✅ Successfully saved test members");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Database table not ready yet. Hibernate is likely still creating it.");
        }
    }
}
