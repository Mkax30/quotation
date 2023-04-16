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
public class Quotation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED)
    private Long id;
    private LocalDate beginningOfInsurance;
    private Double insuredAmount;
    private LocalDate dateOfSigningMortgage;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Customer customer;

    public Quotation(Long id, LocalDate beginningOfInsurance, Double insuredAmount, LocalDate dateOfSigningMortgage, Customer customer) {
        this.id = id;
        this.beginningOfInsurance = beginningOfInsurance;
        this.insuredAmount = insuredAmount;
        this.dateOfSigningMortgage = dateOfSigningMortgage;
        this.customer = customer;
    }

}
