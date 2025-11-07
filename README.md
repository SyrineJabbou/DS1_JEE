# 🛍️ ShopApp — Application de Vente en Ligne avec Spring Boot

## 🧩 Présentation Générale
**ShopApp** est une application web de gestion de ventes en ligne développée avec **Spring Boot** et connectée à une base de données **MySQL**.  
Elle permet à un administrateur de gérer les produits, les clients et les commandes via des **API REST** testées avec **Postman**.  
L’objectif principal est de proposer une solution simple, modulaire et évolutive pour la digitalisation des petites boutiques.

---

## ⚙️ Technologies Utilisées
| Technologie | Rôle |
|--------------|------|
| **Spring Boot 3.5.7** | Framework principal pour le backend |
| **Spring Data JPA** | Gestion des entités et opérations CRUD |
| **MySQL** | Base de données relationnelle |
| **Maven** | Gestionnaire de dépendances |
| **Lombok** | Réduction du code répétitif |
| **Postman** | Test et validation des endpoints |
| **Eclipse / Spring Tools Suite** | Environnement de développement |
| **Git & GitHub** | Gestion de version et hébergement du code |

---

## 🏗️ Architecture du Projet
shop-application-2/
│
├── src/
│ ├── main/java/com/esb/shop/
│ │ ├── controller/ → Gère les requêtes REST (ProductController, CustomerController…)
│ │ ├── model/ → Contient les entités JPA (Product, Customer, Order, etc.)
│ │ ├── repository/ → Interfaces JPA Repository
│ │ ├── service/ → Contient la logique métier
│ │ └── exception/ → Gestion des erreurs personnalisées
│ │
│ └── resources/
│ ├── application.properties
│ └── data.sql / schema.sql (optionnel)
│
├── pom.xml → Configuration Maven et dépendances
└── README.md

---

## 📦 Fonctionnalités Principales
- 🔹 CRUD complet sur les produits  
- 🔹 Gestion des clients  
- 🔹 Création et suivi des commandes  
- 🔹 Communication JSON via Postman  
- 🔹 Connexion MySQL via `application.properties`  
- 🔹 Validation des champs (annotations Jakarta Validation)

---

## 🔌 Exemple d’Endpoints REST

| Méthode | Endpoint | Description |
|----------|-----------|--------------|
| `GET` | `/api/products` | Liste tous les produits |
| `GET` | `/api/products/{id}` | Récupère un produit par ID |
| `POST` | `/api/products` | Ajoute un produit |
| `PUT` | `/api/products/{id}` | Met à jour un produit |
| `DELETE` | `/api/products/{id}` | Supprime un produit |
| `GET` | `/api/customers` | Liste tous les clients |
| `POST` | `/api/orders` | Crée une commande |
| `GET` | `/api/orders/{id}` | Affiche les détails d’une commande |

---

## 🗃️ Configuration Base de Données
Dans `src/main/resources/application.properties` :
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/shop_db
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
server.port=8080
