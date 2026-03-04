package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * FAQ
 * 1. What is a constructor?
 * A constructor is like a recipe, you can't have it randomly floating around, you need to `construct` it. It is a special
 * block of code called the exact moment you use the `new` keyword.
 *
 * 2. Why use `private` variables?
 * We make variables private to protect data. If something is public anything can change at random crashing the application.
 * Private variables hide behind a wall, only way is to access is controlled access points (getters and setters).
 *
 * 3. What is encapsulation?
 * Encapsulation bundles data and methods into a single unit, such as a class, restricting access to interal private
 * components. Encapsulation = control. Objects can only be changed if you allow them to.
 *
 * 4. Why do we use @NoArgsConstructor and @AllArgsConstructor
 * @NoArgsConstructor: The JPA doesn't know how to fill a complex constructor. It first creates an "empty" object
 * then takes the data from the setter and fill it one by one. If not provided the database engine will break.
 * @AllArgsConstructor: Creates a version where you can provide all the data at once instead of creating an empty
 * object and typing set x amount of times. ex. Member myNewMember = new Member(1L, "NFC-123", "Loren", true, now).
 *
 */

@Entity // marker indicated this class is an entity and mapped to a database table.
@Table(name = "members") // marker to name table "members" in DB.
@Getter @Setter // Lombok commands, auto creates hidden code keeping files clean and short.
@NoArgsConstructor // Creates constructor w/ no arguments, w/out empty constructor JPA throws NDCF error and won't start.
@AllArgsConstructor // Creates constructor w/ every field, can create test object in one line.
public class Member{

    @Id // Marks as primary key, every "member" must have a unique ID number.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Don't need to manually increment, database handles that.
    private Long id;


    @Column(unique = true) // Safeguard, no two people can have same nfcTagId.
    private String nfcTagId;

    private String firstName;
    private String lastName;
    private int membershipTenure; // in years
    private boolean hasExecutiveMembership = false;
    private boolean businessMembership = false;
    private boolean membershipActive = true;
    private boolean membershipExpiresSoon = false;
    private boolean banned = false;
    private LocalDateTime lastScan;
}