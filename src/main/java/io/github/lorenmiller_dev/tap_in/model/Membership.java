package io.github.lorenmiller_dev.tap_in.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Membership {

    //
    @Enumerated(EnumType.STRING)
    private Type type;

    //
    @Enumerated(EnumType.STRING)
    private Status status;

    //
    public enum Type {EXECUTIVE, GOLD, BUSINESS_GOLD, BUSINESS_EXECUTIVE, NULL}
    public enum Status {ACTIVE, BANNED, EXPIRED, EXPIRING_SOON}
}
