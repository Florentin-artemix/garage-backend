# 🚗 garage-backend

API RESTful en Java (Spring Boot) pour gérer un garage automobile : machines, techniciens, travaux, entretiens et interventions.  
Ce projet est le backend d'une application de gestion destinée aux garages, avec persistance dans une base de données PostgreSQL.

---

## 📚 Table des matières

- [🔧 Fonctionnalités](#-fonctionnalités)
- [🚀 Démarrage rapide](#-démarrage-rapide)
- [🧪 Exemples d'appels API](#-exemples-dappels-api)
- [🧱 Architecture du projet](#-architecture-du-projet)
- [👨‍💻 Contribuer](#-contribuer)
- [📄 Licence](#-licence)
- [👤 Auteur](#-auteur)

---

## 🔧 Fonctionnalités

- Gestion des **machines** (type, modèle, immatriculation, statut…)
- Gestion des **techniciens**
- Suivi des **travaux** effectués (durée, preuve photo…)
- Historique des **entretiens** et **interventions**
- Intégration PostgreSQL (via Spring Data JPA)
- Encodage des images en base64
- Architecture modulaire avec DTOs, services et contrôleurs

---

## 🚀 Démarrage rapide

### Prérequis

- Java 21
- Maven
- PostgreSQL
- IDE : IntelliJ IDEA recommandé

### Étapes

```bash
# Cloner le projet
git clone https://github.com/Florentin-artemix/garage-backend.git
cd garage-backend

# Configurer la base de données PostgreSQL
# Exemple : garage, user=postgres, password=1234

# Modifier le fichier src/main/resources/application.properties :
spring.datasource.url=jdbc:postgresql://localhost:5432/garage
spring.datasource.username=postgres
spring.datasource.password=1234

# Compiler et lancer
./mvnw spring-boot:run
