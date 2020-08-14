package br.com.idonate.iDonate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "redeem")
@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id"})
public class Redeem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_redeem")
    private LocalDateTime dateRedeem;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "quotation_id")
    private Quotation quotation;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    @NotNull
    @Column(name = "value_redeemed")
    private BigDecimal valueRedeemed;

    @Column(name = "value_rate")
    private BigDecimal valueRate;

    @NotNull
    @Min(1)
    @Column(name = "points_redeemed")
    private Integer pointsRedeemed;

    @JsonIgnore
    public Profile getProfile() {
        return this.profile;
    }

    @JsonProperty
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @JsonIgnore
    public Quotation getQuotation() {
        return this.quotation;
    }

    @JsonProperty
    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }

    @JsonIgnore
    public BankAccount getBankAccount() {
        return this.bankAccount;
    }

    @JsonProperty
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}












