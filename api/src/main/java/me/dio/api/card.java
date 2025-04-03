package me.apirest.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bb_credit_card")
public class BBCreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^\\d{16}$", message = "Número inválido")
    private String number = "**** **** **** 1234";

    @Future(message = "Cartão expirado")
    private LocalDate expirationDate = LocalDate.now().plusYears(3);

    @Pattern(regexp = "^\\d{3}$", message = "CVV inválido")
    private String cvv = "***";

    @Digits(integer = 10, fraction = 2)
    private BigDecimal availableLimit = new BigDecimal("2500.00");

    @Enumerated(EnumType.STRING)
    private BBCardNetwork network = BBCardNetwork.ELO;

}