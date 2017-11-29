# DirectESport

## Vue d'ensemble

DirectESport est un site de commentaire en direct d'évenements eSport en direct avec un affichage du score en direct, et un fil de commentaires du commentateur qui s'actualise automatiquement. Il propose un système d’inscription/connexion sécurisé, et permet aux utilisateurs de réagir sur des articles postés par des éditeurs. 

### Les utilisateurs

Il y a 3 types d’utilisateurs : 
* USER : Le rôle de base quand on s’inscrit sur le site. L'avantage d'un USER par rapport à un utilisateur non connecté est le fait de pouvoir réagir aux articles en postant des commentaires.
* EDITOR : Il s’agit en quelques sortes de journalistes. Les éditeurs peuvent créer des articles, des compétitions, ajouter des équipes aux compétitions, créer des équipes, créer des matchs à l’intérieur de compétitions, et il peuvent aussi commenter en direct les matchs (les commentaires sont affichés en temps réel chez les autres utilisateurs du site). Ils ont également la possibilité de supprimer des compétitions, matchs ou équipes.
* ADMIN : En plus d’avoir les mêmes droits qu’un EDITOR, un administrateur a accès à une page d’administration depuis laquelle il peut changer le rôle d’un utilisateur. Il peut par exemple faire passer un utilisateur sérieux et pertinent comme éditeur ou à l’inverse réduire le rôle d’un éditeur à simple utilisateur.

Le site est tout à fait accessible à des personnes non connectés. Ils peuvent lire les articles et également suivre les résumés des matchs en temps réel.

### Les pages

Sur toutes les pages du site, la barre de navigation est présente, ainsi que les boutons pour consulter le profil et se déconnecter si on est connecté, ou pour s'incrire ou se connecter si on n'est pas connectés.

Sur la page d’accueil de notre site, on retrouve les derniers articles qui viennent d’être publiés. Un simple clique sur l'article permet d'afficher l'article en intégralité, sous les articles, on retrouve les commentaires (qu'on peut ajouter en étant connectés).

En ce qui concerne la page des directs, les stats du match et les commentaires sont édités par l'éditeur, et affichés automatiquement chez l'utilisateur, sans qu'il n'ait besoin de recharcher la fenêtre.

## Instructions de lancement/compilation

Pour ajouter les données du sites, allez sur l’adresse /demo. 
Vous pouvez créer un compte auquel cas vous serez identifié en tant qu’utilisateur, mais si vous désirez avoir les fonctionnalités administrateur, vous pouvez vous connecter avec le login : **admin** et le mot de passe : **pass** 

## Architecture du projet
Notre projet respecte une architecture Modèle-Vue-Contrôleur. Nous utilisons Spring, Thymeleaf et Vue.js.

## Code externe

- Bootstrap
    * HTML/CSS/JS Framework
    * https://github.com/twbs/bootstrap
    * Licence MIT
- jQuery
    * JS Library
    * https://github.com/jquery/jquery
    * Licence MIT
- Flexmark-java
    * Markdown parser
    * https://github.com/vsch/flexmark-java
    * Licence BSD-2-Clause
- Font-Awesome
    * Icons intégrables facilement dans le code
    * http://fontawesome.io/license/
    * Licence MIT
- Stomp.js
    * Protocol de message utilisé pour les échanges Websocket
    * https://github.com/jmesnil/stomp-websocket
    * Licence Apache 2.0
- Sock.js
    * Librairie JS pour communiquer par Websocket
    * https://github.com/sockjs/sockjs-client
    * Licence MIT
