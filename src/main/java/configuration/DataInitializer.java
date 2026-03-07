package configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repository.MemberRepository;

/**
 *
 */
@Component
public class DataInitializer implements CommandLineRunner {

    //
    private final MemberRepository memberRepository;

    // Constructor Injection

    /**
     *
     * @param args incoming main method arguments
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        // create valid active member

        // create valid inactive member

        // create invalid member

        // create banned member


    }
}
