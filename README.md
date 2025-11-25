## Activité Pratique N°3 - Spring MVC avec Thymeleaf
### Gestion de Produits - Application Web
### Introduction
Cette application Web permet de gérer des produits via une interface intuitive et sécurisée.
Elle est développée avec Spring Boot, Spring Data JPA, Hibernate, Thymeleaf, et Spring Security.

L’application inclut les opérations suivantes :
- Création, lecture, mise à jour et suppression de produits (CRUD)
- Recherche et filtrage de produits
- Validation des formulaires
- Interface responsive grâce à Bootstrap
  
Technologies utilisées :
- Java 17
- Spring Boot
- Spring Data JPA & Hibernate
- Thymeleaf
- Spring Security
- H2 Database (tests) & MySQL (production)
- Lombok
- Spring Validation
- Bootstrap
## Résultats de l’exécution :
### 1- Créer l'entité JPA Product
L’entité Product représente un produit dans l’application. 
Elle est mappée à la table products en base de données.
  
id : clé primaire auto-générée

name : nom du produit (non null)

price : prix du produit (non null)

description : description détaillée du produit

quantity : quantité disponible (non null)

- Annotations utilisées
  
@Entity : définit la classe comme une entité JPA

@Table(name = "products") : nom de la table en base de données

@Id et @GeneratedValue : clé primaire auto-générée

@Column : contraintes sur les colonnes

Lombok : @Data, @NoArgsConstructor, @AllArgsConstructor, @Builder pour simplifier le code

<img width="1918" height="1078" alt="image" src="https://github.com/user-attachments/assets/760df47c-af5b-4b2c-9007-874240a61a63" />

<img width="1918" height="975" alt="image" src="https://github.com/user-attachments/assets/70ba96d3-ad87-431f-a21c-d3e0d81042fa" />

### 2- Créer l'interface ProductRepository basée sur Spring Data :

### ProductRepository

L’interface ProductRepository permet d’accéder aux données des produits dans la base de données.

Pas besoin d’implémenter manuellement les méthodes CRUD : Spring Data JPA les génère automatiquement.

Hérite de JpaRepository, ce qui fournit automatiquement toutes les opérations CRUD :

- save() : ajouter ou mettre à jour un produit

- findById() : récupérer un produit par son ID

- findAll() : lister tous les produits

- deleteById() : supprimer un produit

Type de l’entité : Product

Type de la clé primaire : Long

<img width="1918" height="1077" alt="image" src="https://github.com/user-attachments/assets/b0c3332b-2fb1-4135-8c94-66ba06e48e4f" />

### 3- Tester la couche DAO

<img width="1918" height="1012" alt="2" src="https://github.com/user-attachments/assets/c33be765-44af-4e13-a5cc-7ee7212c3518" />

### 4- Désactiver la protection par défaut de spring security

Pour faciliter le développement et tester l’application, la protection par défaut de Spring Security a été désactivée temporairement.
Cela permet d’accéder librement aux pages de l’application, notamment à la console H2.

Accès à la console H2

Après avoir désactivé la sécurité, la console H2 est accessible à l’adresse suivante :
http://localhost:8094/h2-console

<img width="1918" height="1021" alt="3" src="https://github.com/user-attachments/assets/0dfd3286-d9c0-49c4-bd13-8a0be927dbf2" />

### 5- Contrôleur Spring MVC et vues Thymeleaf

Le contrôleur Spring MVC gère les interactions entre l’utilisateur et l’application.
Les vues sont créées avec Thymeleaf et stylisées avec Bootstrap pour une interface claire et responsive.

### Fonctionnalités couvertes :

- Afficher la liste des produits :

La page principale (/products) affiche tous les produits présents dans la base.

Les produits sont affichés sous forme de tableau avec leurs détails (nom, prix, quantité, description).

- Supprimer un produit :

Chaque produit dans la liste comporte un bouton Supprimer.

L’utilisateur peut supprimer un produit directement depuis la liste.

- Template basé sur Thymeleaf Layout et Bootstrap :

Utilisation d’un layout commun pour toutes les pages (header, footer, menu).

Styles Bootstrap pour rendre l’interface moderne et responsive.

- Saisir et ajouter un produit avec validation :

Formulaire pour ajouter un nouveau produit (/products/new).

Validation des champs via Spring Validation :

- Nom et prix obligatoires

- Quantité non négative

- Description facultative, longueur maximale définie

### Sécurisation de l’application avec Spring Security

Pour protéger l’accès aux pages de l’application, Spring Security est utilisé.

### 1- Authentification

L’utilisateur doit se connecter pour accéder aux fonctionnalités sensibles (ajout, modification, suppression).

Une page de connexion est fournie automatiquement par Spring Security ou personnalisée avec Thymeleaf.

Rôles disponibles

### ADMIN

Accès complet à l’application

Peut ajouter, modifier et supprimer des produits

 - Page de connexion (login) :

<img width="1918" height="1020" alt="image" src="https://github.com/user-attachments/assets/5a642ac3-60b1-4bad-abb9-da98e37218aa" />

<img width="1918" height="1020" alt="image" src="https://github.com/user-attachments/assets/aae4bb86-a0bd-4373-8d43-35eeb95c38fd" />

 - Ajouter un produit :
   
<img width="1918" height="1021" alt="image" src="https://github.com/user-attachments/assets/0e8ca0e0-5827-4a6d-8fce-2b0268c46079" />

<img width="1918" height="1017" alt="image" src="https://github.com/user-attachments/assets/1dad5074-f1af-4c48-a6a3-fc97b345ff69" />

### USER

Accès limité

Peut seulement consulter la liste des produits
 - Page de connexion (login) :

<img width="1918" height="1017" alt="image" src="https://github.com/user-attachments/assets/1a832a0a-074e-46cf-91c1-660e9790abd8" /> 

<img width="1918" height="1011" alt="image" src="https://github.com/user-attachments/assets/230f3e3e-65ed-48c0-96f0-05735ce37b9e" />

### Conclusion

Cette application Web illustre la puissance de Spring Boot, Spring Data JPA, Hibernate, Thymeleaf et Spring Security pour créer une solution complète de gestion de produits.

Elle permet de :

- gérer efficacement les produits avec toutes les opérations CRUD,

- sécuriser l’accès grâce à une authentification et des rôles (USER et ADMIN),

- fournir une interface utilisateur moderne et responsive avec Thymeleaf et Bootstrap,

- valider les formulaires et faciliter le développement avec H2 et MySQL.

Ce TP constitue une bonne base pour comprendre le développement d’applications Web sécurisées en Java et peut être enrichi avec des fonctionnalités supplémentaires selon les besoins.




