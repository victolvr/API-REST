package me.apirest.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bb_account")
public class BBAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Número da conta é obrigatório")
    @Pattern(regexp = "\\d{8}-\\d", message = "Formato inválido (XXXXXXX-X)")
    private String number;

    
    @NotBlank(message = "Agência é obrigatória")
    @Pattern(regexp = "\\d{4}-\\d", message = "Formato inválido (XXXX-X)")
    private String agency;

    @PositiveOrZero(message = "Saldo não pode ser negativo")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "credit_limit")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal creditLimit = new BigDecimal("2500.00");

    @Enumerated(EnumType.STRING)
    private BBAccountType type = BBAccountType.CORRENTE;

}