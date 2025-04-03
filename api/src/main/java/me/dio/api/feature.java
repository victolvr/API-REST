package me.apirest.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Adicionado campo ID para JPA
    
    private String icon;
    private String description;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}