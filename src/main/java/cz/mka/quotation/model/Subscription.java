package cz.mka.quotation.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Quotation quotation;
    private LocalDate startDate;
    private LocalDate validUntil;

    public Subscription(Long id, Quotation quotation, LocalDate startDate, LocalDate validUntil) {
        this.id = id;
        this.quotation = quotation;
        this.startDate = startDate;
        this.validUntil = validUntil;
    }

}
