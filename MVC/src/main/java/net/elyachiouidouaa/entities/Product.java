package net.elyachiouidouaa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
/**
 * Classe Entity représentant un produit dans le système.
 * Est mappée à une table en base de données via JPA.
 */
@Entity // Indique que cette classe est une entité JPA (sera persistée en base de données)
@NoArgsConstructor // Génère un constructeur sans arguments (requis par JPA)
@AllArgsConstructor // Génère un constructeur avec tous les champs
@Getter // Génère automatiquement les getters pour tous les champs
@Setter // Génère automatiquement les setters pour tous les champs
@ToString // Génère automatiquement la méthode toString()
@Builder // Permet d'utiliser le pattern Builder pour créer des instances
public class Product {

    @Id // Marque ce champ comme clé primaire
    @GeneratedValue // La valeur est auto-générée par la base de données
    private Long id;

    @NotEmpty // Validation : le champ ne doit pas être null ni vide
    @Size(min = 3, max = 50) // Validation : longueur entre 3 et 50 caractères
    private String name; // Nom du produit

    @Min(0) // Validation : la valeur doit être >= 0
    private double price; // Prix unitaire du produit

    @Min(1) // Validation : la valeur doit être >= 1
    private double quantity; // Quantité disponible du produit
}