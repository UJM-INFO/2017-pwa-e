# Auto-Evaluation

## Temps consacré

Nous estimons avoir tous travaillé une cinquantaine d'heures sur ce projet.

## Parties travaillés

* Clément Colin : 
    * Gestion de la connexion, Thymeleaf, Controllers, Vue.js
* Dimitri Bruyère :
    * Gestion de la connexion, Thymeleaf, Controllers, Style des pages
* Christopher Jeamme :
    * Thymeleaf, Vue.js, Style des pages, Controllers, WebSocket

## Bonnes pratiques

### Au sujet de git:
- commit/push souvent, pour ne pas avoir peur de faire des changements

20/20 : 
Chacun de nous a fait des commits à chaque fois qu’il travaillait sur une partie. Nous avons réalisé des commits atomiques afin de repérer facilement les changements.

* utiliser des messages de commit qui décrivent le changement et surtout la raison du changement

15/20 : 
Nous n’avions pas pris consciences de ce point quand on effectuait les premiers commits, mais nous l’avons fait quasiment tout le temps après. Les commits étant conseillé d’être sous une certaine limite de caractère, nous n’avons pas pu détaillé à chaque fois mais il y a sauf exception toujours le minimum. De plus, nous utilisons des préfixes de commit (feat, fix, refact, doc …) pour encore plus de clarté.

* utiliser des messages en anglais

    * 16/20 :
A partir du moment où nous avons su qu’il fallait le faire nous l’avons toujours fait.

* ne pas commiter les fichiers générés (utiliser un .gitignore de façon à ce que git status soit propre)

    * 20/20 : 
Un gitignore a été mis dès le début.

* écrire les documents demandés en markdown (.md) pour qu'ils s'affichent correctement dans github.

    * 20/20 : 
Vous pouvez juger par vous même sur ce document

### Au sujet de votre code:
* écrire votre code en anglais

    * 20/20 : 
Le code est entièrement en anglais, seuls les éléments du site affichés sont en français

* indenter/formater votre code correctement

    * 18/20 :
Il est possible que quelques balises HTML pourraient être mieux indentées pour une meilleure visibilité, mais dans l’ensemble le code est indenté proprement.

* ne pas mélanger espaces et tabulations (idéalement, ne pas utiliser de tabulations)

    * 20/20 : 
Nous utilisons toujours des tabulations de 4 espaces pour indenter notre code.

* garder votre code propre: pas de variables globales/statiques, choisir des noms correctement (packages, classes, etc), suivre les conventions (e.g., java convention), utiliser des constantes pour les valeurs constantes, ...

    * 16/20 :
Nous pensons avoir respecté les conventions dans l’ensemble.

### Vous écrivez du logiciel donc :

* tester beaucoup et souvent

    * 16/20 : 
A chaque nouvelle fonctionnalité, nous testons soit sur l’interface web, soit dans la console.

* automatiser les tests qui peuvent l'être

    * 5/20 :
Nous avons essayé d’utiliser JUnit pour automatiser certains tests mais nous nous y sommes pris trop tard, par conséquent nous ne l’avons pas réellement utilisé mais seulement découvert.


* documenter comment utiliser, compiler, tester et lancer votre projet

    * 15/20 : 
Le ficher README.md explique comment utiliser notre projet.

* documenter comment comprendre et reprendre votre projet

    * 16/20 : 
Nous avons essayé de commenter au maximum notre code afin qu’il soit facilement compréhensible par un développeur n’ayant pas participé au projet. Nous utilisons des noms de variables explicites de façon à ce que même les parties de code pas forcément commentées soient compréhensibles.
