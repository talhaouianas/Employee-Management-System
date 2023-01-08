# Employee-Management-System
Employee Management System using Spring Boot, Spring Security, Spring Data JPA with MySQL database, Angular, Docker <br>
Open this file, to know how to run this code<br><br>
[Employee Management System instructions.pdf](https://github.com/talhaouianas/Employee-Management-System/files/9541524/Employee.Management.System.instructions.pdf)

1- créer une BD sous le nom "jeewaeducation" pour stocker les informations des employées dans votre système de gestion de base de données.<br><br>

2- Importer le projet dans Intelij ou SpringTool<br>
Exécuter le projet, il va être démarré dans le port 9000 <br><br>

3- Pour la partie de déploiement:<br>
Tout d'abord, créez un fichier jar de votre application Spring Boot à l'aide de la commande<br>
‘ ./mvn clean package’ <br>
Executer application avec mvn <br>
Ouvrir le terminal dans le chemin de projet <br>
Exécuter les commandes : <br>
docker build -f Employee-Management-System.jar . <br>
docker run -p 9090:9000 Employee-Management-System..jar <br>
Pour créer et démarrer les conteneurs du projet, exécutez la commande suivante : <br>
docker-compose up <br>

Enjoy with our Application :)
