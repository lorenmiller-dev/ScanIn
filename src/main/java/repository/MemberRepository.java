package repository;

import model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // Repository Methods

    /**
     * JpaRepository gives access to methods like save(), deleteById(), findAll(), and findById() automatically.
     *
     * Optional<Member> is a container instead of returning Null, returns empty box.
     *
     * @Repository let's Spring manage and translate any database errors into spring errors.
     */
    Optional<Member> findByNfcTagId(String nfcTagId);
}
