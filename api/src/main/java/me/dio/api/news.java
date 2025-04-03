package me.apirest.domain.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bb_news")
public class BBNews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bannerUrl = "https://img.bb.com.br/news-banner.png";
    
    @Column(length = 500)
    private String headline = "Banco do Brasil: Taxas especiais para empréstimos consignados!";
    
    private LocalDate publicationDate = LocalDate.now();
    
    @Enumerated(EnumType.STRING)
    private BBNewsCategory category = BBNewsCategory.CREDITO;
}