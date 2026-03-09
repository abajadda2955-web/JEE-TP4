TP Hibernate JPA - Gestion des Salles et Machines

 
 ## Description

Ce Tp est une application Java utilisant Hibernate/JPA pour gérer des entités Salle et Machine avec une base de données MySQL.


## Tests Unitaires

=====1. Test de la classe SalleServiceTest=====

   <img width="764" height="673" alt="6" src="https://github.com/user-attachments/assets/9cd53985-2ab0-4d24-95e6-9d780eca06de" />



Tests exécutés :

    ✅ testCreate() - Création d'une salle

    ✅ testFindById() - Recherche par ID

    ✅ testUpdate() - Mise à jour d'une salle

    ✅ testDelete() - Suppression d'une salle

    ✅ testFindAll() - Liste de toutes les salles


======2. Test de la classe MachineServiceTest=====


<img width="761" height="669" alt="macineService" src="https://github.com/user-attachments/assets/1493d9dc-503e-428f-827f-fcdd122ab523" />


Tests exécutés :

    ✅ testCreate() - Création d'une machine

    ✅ testFindById() - Recherche par ID

    ✅ testUpdate() - Mise à jour d'une machine

    ✅ testDelete() - Suppression d'une machine

    ✅ testFindAll() - Liste de toutes les machines

    ✅ testFindBetweenDate() - Recherche par période de date



=====3. Test de la classe principale Test======
   
<img width="634" height="556" alt="2" src="https://github.com/user-attachments/assets/394df3b2-21dc-4f97-b695-945386e0723b" />

<img width="643" height="393" alt="3" src="https://github.com/user-attachments/assets/ab392b60-69eb-4c66-aa1e-5d11c512ecb2" />

<img width="639" height="542" alt="4" src="https://github.com/user-attachments/assets/d1c0662f-110c-4e3c-b639-994a2cef8848" />

<img width="711" height="527" alt="5" src="https://github.com/user-attachments/assets/cd471fde-b70f-4f22-804d-936113f4fd9c" />



Opérations effectuées :

    ✅ Création de 2 salles (A1, B2)

    ✅ Création de 2 machines associées aux salles

    ✅ Affichage des salles avec leurs machines

    ✅ Test de la méthode findBetweenDate()

