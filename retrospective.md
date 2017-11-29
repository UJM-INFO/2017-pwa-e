# Retrospective

## Objectif

Notre objectif d'origine était de créer un site qui permet de commenter des evenements d'eSport en direct avec l'affichage du score en direct, et un fil de commentaire du commentateur qui s'actualise dynamiquement.

Le projet maintenant fini, nous sommes content d’avoir pu atteindre nos objectifs, avec même des bonus mais nous regrettons de ne pas avoir davantage de temps pour ajouter des fonctionnalités.

## Les difficultés rencontrées 

#### La mise en place des websocket:
On a du essayer plusieurs librairies pour faire ceci, dont certaines nécessitent d’installer un gestionnaire comme WebPack, on a perdu une journée de travail là dessus, avant de trouver une solution qu’on a adapté à Vue.js

#### La connexion
Il a fallu du temps afin de comprendre avec les docs et le code des cours comment marche et comment se servir de Spring Security, la connexion, l’inscription, accéder aux information des utilisateurs etc.

#### L’adaptation aux changement de taille d’écran
A cause de propriétés des éléments bootstrap incompatible les changements que nous voulions faire, nous avons du changer en profondeur le style pour la barre de navigation, et faire en sorte qu’elle ai un affichage correcte.

## Ce qu’on a appris

### Christopher JEAMME
* Me servir mieux de bootstrap
* Me servir de Vue.js
* Faire des websockets
* Utiliser Spring
* Utiliser des fonctionnalités de NetBeans tel que le débogueur, l’analyse du Javadoc, la génération de test JUnit


### Dimitri BRUYERE
* Utiliser Spring
* Utiliser Bootstrap 
* Utiliser Thymeleaf
* Un peu de Vue.js même si j’ai peu pratiqué
* Apprendre à me servir efficacement de Netbeans
 
### Clément COLIN
* Spring
* Vue.js
* Thymeleaf
* JPA
* Notions de notre utilisation des websockets

## Points positifs et négatifs

### Points positifs 

* Utilisation de git
* Affichage dynamique des commentaires et statistiques grâce aux websockets
* Bonne séparation des tâches

### Points à améliorer

* Prévoir à l’avance le squelette du programme    
* Prévoir l’automatisation des tests
