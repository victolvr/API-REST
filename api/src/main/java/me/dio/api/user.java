package me.apirest.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome completo é obrigatório")
    @Size(min = 5, max = 100, message = "Nome deve conter entre 5 e 100 caracteres")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private BBAccount account;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_features")
    private List<BBFeature> features;

    @Embedded
    private PixConfig pixConfig = new PixConfig(
        "https://img.bb.com.br/pix-icon.png",
        "PIX Instantâneo"
    );

    @Embedded
    private PaymentConfig paymentConfig = new PaymentConfig(
        "https://img.bb.com.br/pagamento-icon.png",
        "Pagamento de Contas"
    );

    @Embedded
    private TransferConfig transferConfig = new TransferConfig(
        "https://img.bb.com.br/transfer-icon.png",
        "Transferências Bancárias"
    );

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private BBCreditCard card;

    @OneToOne(cascade = CascadeType.ALL)
    private BBNews news;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}