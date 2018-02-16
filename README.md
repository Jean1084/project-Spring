# project-wemanity
Projet SpringFramework et SpringMVC recrutement wemanity

Ceci est une petite application n-tier de gestion d'utilasateurs.

J'ai utilisé:
 - Monteur de production "Gradle"
 - IDE IntelliJ
 - SpringFramework 
 - Le projet est divisé en 2 modules mod-persistence et mod-webmvc
 --Le mod-persistence contient le package persistence qui gère l'intégralité du modèle "métiers".
   Dans ce module aussi grace au service de gestion des dépendances de gradle j'implémente 
   - Hibernate
   - Spring (contexte, data, orm, transaction)
   - Guava
   - j'ai choisi MySQL mais ça pouvait etre n'importe quel SGBDR
   - J'ai choisi TestNG
  --Le mod-webmvc contient un package qui gere les controllers et les servlets
    Dans ce module pareil grace au fichier de configuration de Gradle le build.gradle j'implémente 
    SpringMVC et les fichiers JSP pour la vue.
    
   
   

