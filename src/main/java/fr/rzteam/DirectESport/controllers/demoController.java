/*
 *      _____   _                   _            _____                      _   
 *     |  __ \ (_) Website Project | |          / ____|                    | |  
 *     | |  | | _  _ __  ___   ___ | |_    ___ | (___   _ __    ___   _ __ | |_ 
 *     | |  | || || '__|/ _ \ / __|| __|  / _ \ \___ \ | '_ \  / _ \ | '__|| __|
 *     | |__| || || |  |  __/| (__ | |_  |  __/ ____) || |_) || (_) || |   | |_ 
 *     |_____/ |_||_|   \___| \___| \__|  \___||_____/ | .__/  \___/ |_|    \__|
 *                                                     | |                                                                                              
 *  ----Authors----                                    |_| 
 * Dimitri BRUYERE
 * Clément COLIN
 * Christopher JEAMME
 *  ---------------
 */
package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.CommentRepository;
import fr.rzteam.DirectESport.model.EventRepository;
import fr.rzteam.DirectESport.model.UserRepository;
import javax.inject.Inject;
import fr.rzteam.DirectESport.model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to add some demo data to the server
 */
@Controller
public class demoController
{
    @Inject
    UserRepository userRepo;
    @Inject
    EventRepository eventRepo;
    @Inject
    CommentRepository commentRepo;
    @Inject
    TeamRepository teamRepo;
    @Inject
    ArticleRepository articleRepo;
    @Inject
    PlayerRepository playerRepo;
    @Inject
    CompetitionRepository competitionRepo;
    @Inject
    StatsRepository statsRepo;
    /**
     * Demo data
     */
    @RequestMapping("/demo")
    public String demo()
    {
        List<String> roles = new ArrayList<>();
        roles.add("ADMIN");
        roles.add("EDITOR");
        roles.add("USER");
        User user1 = new User("admin", "Administrateur", roles, "$2a$10$cGONBnlF98pG2tLYV5GcfODgvLEbeMlRm1z/4yjpG.pRQ4SoP8nd6"/*=pass*/, "admin@rzteam.fr");
        userRepo.save(user1);
        
	Article a1 = new Article("Venez vivre la finale du Challenge France !","L'événement Challenge France : Project touche à sa fin et dans quelques jours, la Webedia Esport Arena accueillera la grande finale de la compétition. Envie de rencontrer les joueurs et de vivre l’évènement avec nous ? C’est possible, et nous vous proposons aujourd’hui de tenter de gagner vos places !\n" +
"\n" +
"Depuis près d’un mois, vous avez suivi avec nous les prémices de ce que cette huitième saison peut offrir, guidés par les combats des meilleures équipes françaises. Aujourd’hui il n’en reste plus que deux et vendredi 1er décembre, Gamers Origin et Millenium livreront l’ultime Best ot 5 pour s’emparer du titre !\n" +
"challenge france\n" +
"\n" +
"La finale se déroulera en région parisienne à Levallois, au cœur de la Webedia Esport Arena où un show se tiendra tout au long de la soirée. Sur place, le cast sera assuré par les commentateurs O'Gaming. Vous pourrez rencontrer des Rioters mais aussi des influenceurs comme Gob, Doigby et différents streamers Solary ! À côté de l'arène, un cocktail vous sera proposé dans une ambiance intimiste pour profiter et discuter au mieux de la compétition et de cette nouvelle saison.","https://eu.lolesports.com/darkroom/940/02ba5281d28007c313c5c424b5e170c7:2ea8a4bec64c7fd0049e0368db59ad81");
        
	
	Article a2 = new Article("La présaison vue de la voie du haut", "Entre refonte complète des runes et maîtrises et rééquilibrages variés, la présaison apporte – forcément – son lot de changements dans la méta, que ce soit en file individuelle ou en équipe. Si les tanks restent au sommet de la voie du haut, ce ne sont pas tout à fait les mêmes qu'il y a deux mois. Ils sont, de plus, accompagnés par de nouveaux prétendants à la domination du nord de la carte. Petit tour d'horizon, vu du dessus.\n" +
"\n" +
"Fin de saison, changements en pagaille ou non, une chose ne change pas sur la voie du haut depuis plusieurs mois : les tanks restent toujours aussi fort, comme nous le confirment en chœur Arthur « Brosak » Lesueur et Damien « Shemek » Soulagnet. Le joueur de Gentside Esports et celui de GamersOrigin notent toutefois l'arrivée d'une nouvelle trinité au sommet de la méta. Ornn, Shen et Maokai dominent aujourd'hui le haut de la carte, en particulier en équipe.\n" +
"Ornn\n" +
"\n" +
"Le dieu forgeron forge sa légende sur la voie du haut.\n" +
"\n" +
"Tous trois présentent deux avantages clairs : une force intrinsèque non négligeable et une grande capacité à rester le temps nécessaire sur leur voie. Pour ne rien gâcher, ils sont également « forts sur la carte et lors des combats d'équipe », résume Brosak. Ornn a en particulier su s'imposer au fil des patchs comme un incontournable. Non seulement il a une excellente tenue de voie et n'a que très peu besoin de revenir à la base grâce à son passif – qui lui permet d'acheter de l'équipement sans passer par la boutique – mais bénéficie en plus de « la meilleure engage du jeu », s'exclame le joueur de Gentside. « C'est le meilleur champion actuellement : il a des contrôles, des dégâts, de la résistance, une énorme initiative, il a trop de tout », renchérit Shemek.\n" +
"\n" +
"Juste derrière le Dieu de la forge volcanique, on retrouve donc deux anciens de la ligue, qu'il est difficile de départager. Tant Brosak que Shemek hésitent un temps, avant de les placer à égalité dans leur classement personnel. Shen se distingue comme toujours par son ultime, sa capacité à être n'importe où dès qu'on a besoin de lui. Attention toutefois, c'est un champion qui est meilleur en équipe, avec un jeu coordonné, qu'en file individuelle. Maokai, quant à lui, profite à plein de sa capacité à survivre indéfiniment sur sa voie.\n" +
"Derrière la trinité, les suiveurs s'empilent\n" +
"Gangplank\n" +
"\n" +
"Gangplank, le retour du fléau des mers !\n" +
"\n" +
"En dehors de cette solide trinité, de nombreux champions font leur retour ou leur apparition. C'est le cas de Gangplank , remis au goût du jour par la présaison et la rune Kleptomancie, qui permet de gagner un peu d'or et de portée d'attaque, mais surtout de récupérer aléatoirement des consommables. Avec elle, le pirate « abuse de son A », explique Brosak, D'après Shemek, le champion est pourtant « même fort même sans la Kleptomancie. L'effet de mode passé, les joueurs ont réalisé qu'il avait toujours été puissant ». Quoiqu'il en soit, pour Brosak, « c'est vraiment très fort, mais le champion est facile à sortir de sa voie ». Lui le voit « bien en équipe, mais seulement face à certaines compositions, contre des champions assez passifs au top et dans la jungle ».\n" +
"\n" +
"Parmi ceux qui en profitent pour revenir sur le devant de la scène, on retrouve aussi Rumble, toujours très fort contre les tanks. Le champion apprécie particulièrement la force actuelle de la pénétration magique, explicable par la disparition des runes de résistance magique. Panthéon – sorti avec succès par Andrea « Katare » Suchodolski lors de la victoire de Solary contre Asus Rog – repointe également le bout de sa lance, grâce à sa capacité à dominer son vis-à-vis dès les premiers instants de la partie et à son ultime, jamais inutile. Pas avare de conseils, Shemek s'attend enfin à retrouver Poppy, Urgot, voire Lissandra ou même Teemo (en file individuelle, rassurez-vous, ou pas) face à lui dans les prochaines semaines, alors que Brosak apprécie Yorick. Les deux joueurs ont d'ailleurs sorti Poppy et Yorick l'un contre l'autre, dimanche 19 novembre au Challenge France, un match remporté par Gamers Origin.\n" +
"Les runes tanks changent la donne\n" +
"\n" +
"Au-delà des effets de mode, ces évolutions de la méta top s'expliquent évidemment aussi par la refonte des runes et maîtrises. Tanks oblige, l'arbre volonté est le plus employé par les compétiteurs du Challenge France.\n" +
"Volonté et inspiration\n" +
"\n" +
"Un exemple de page de runes pour un tank sur la voie du haut.\n" +
"\n" +
"Le toplaner de Gentside y voit deux runes fondamentales particulièrement intéressantes à son poste. La Poigne de l'immortel « pour tous les champions qui combattent d'abord à l’auto-attaque » et l'Après-coup, particulièrement efficace sur les champions avec de forts contrôles, puisque non seulement elle leur apporte des dégâts mais qu'en plus l'efficacité de cette rune augmente avec les points de vie accumulés. Il est toutefois impossible d'avoir les deux, il faut donc choisir en fonction de son champion mais aussi de son adversaire direct. Dans tous les cas, ces deux runes rendent l'arbre vert plus rentable que d'autres plus agressifs. Brosak apprécierait d'ailleurs « peut-être une augmentation de la puissance des arbres précision et domination ».\n" +
"\n" +
"Dans le reste de l'arbre, plusieurs choix s'offrent au toplaner avisé. Démolition s'améliore en fonction des points de vie maximum et peut faire très mal aux tours adverses, tandis que fontaine de vie remplace bien la force des âges. Enfin, si le choix d'une rune sur la troisième branche est situationnel, Shemek souligne que Second souffle – qui rend des points de vie après avoir subi une attaque – est quasi incontournable sur la dernière branche.\n" +
"Deuxième arbre, l'embarras du choix\n" +
"\n" +
"La question se complique un peu au moment de choisir un arbre secondaire. Brosak montre une vraie préférence pour l'inspiration. Il trouve le marché du futur « génial sur Ornn » et les chaussures magiques lui apparaissent un choix évident sur de nombreux champions. Il sélectionne ensuite « soit la livraison de biscuit pour encore accentuer la tenue de voie soit le chronomètre du timing parfait », pour préparer l'ange gardien ou le Zhonya.\n" +
"\n" +
"Shemek, au contraire, privilégie « la plupart du temps l'arbre sorcellerie pour la mana » qu'apporte le ruban régénérateur et, pour certains matchs, « l'arbre précision avec triomphe et légende : ténacité », les deux permettant – encore une fois – de rester en vie le plus longtemps possible. Il trouve l'inspiration « sympa, mais globalement moins forte que sorcellerie ».\n" +
"Dominer sa voie avant tout\n" +
"\n" +
"Les capitaines de leurs équipes respectives se retrouvent en revanche dans leur analyse de la méta dans son ensemble. Vous l'aurez compris, la phase initiale de rencontre des joueurs sur leur voie est singulièrement importante en ce moment. Mais elle ne constitue pas une fin en soi. Il s'agit surtout de prendre le contrôle sur son opposant pour agir ailleurs sur la carte, que ce soit grâce à un ultime global (Shen, Panthéon, Gangplank) ou par sa contribution aux combats d'équipe (Ornn, Maokai). Comme le résume Brosak, qui voit là le cœur du jeu actuel, le but est de forcer son adversaire à retourner à la base pour prendre l'ascendant et « agir en cinq contre quatre ou exploiter un avantage par rapport à la téléportation ». A ses yeux, pas de doute, « c'est vraiment une des clés pour remporter la victoire en ce moment ».","https://eu.lolesports.com/darkroom/1265/322bd2f8ef1c57627b946cd412cfbdd5:c9285046ae11d76fa301970e54f9ec34/shen-skin-official-artwork");
        
	Article a3 = new Article("La voie du milieu à l'aube de la saison 8", "Pas le temps de niaiser ! Les championnats du monde sont à peine terminés que la compétition a déjà repris. Et nous avons de la chance, puisque c’est le fleuron de la scène française qui s’affronte depuis vendredi dernier dans un Challenge France à la hauteur des attentes. L’occasion de jeter un œil aux premiers matches joués sur le nouveau patch de présaison ; aujourd’hui, nous nous intéressons à la voie du milieu.\n" +
"\n" +
"Changement ambitieux et profond, la refonte du système de runes et de maîtrises a de quoi perturber. Si un temps d’adaptation sera nécessaire pour évaluer précisément les héros les plus favorisés par ces changements, et pour équilibrer ces nouvelles compétences, les six équipes participant au Challenge France n’ont pas eu ce luxe et ont dû se lancer dans la bataille rapidement. Nous avons pu interroger deux midlaners du tournoi : Jérémy « Eika » Valdenaire (Team LDLC), et Scott « Tonerre » Menard (GamersOrigin). Voici leurs impressions.\n" +
"Champions, le grand ménage… ou pas ?\n" +
"\n" +
"Lors des championnats du monde, différentes stratégies ont été employées par les équipes, mais parmi les personnages fréquemment utilisés, nous retrouvions notamment Galio. Que tout le monde se réjouisse, le Colosse a définitivement quitté la midlane, et ce patch marque le véritable retour des mages, voire, temporairement, des assassins, bien que les avis divergent à leur sujet. Selon Tonerre, « tout n’est pas encore clair au sujet des runes, mais les assassins et les mages à gros dégâts semblent en profiter. Je ne serais pas surpris de voir des héros un peu exotiques faire leur apparition. » Malgré une excellente prestation sur Fizz face à Solary, Eika se montre lui plus mesuré : « Avec le nouveau Zhonya, les assassins vont devenir de plus en plus situationnels. Il est déjà difficile d’en jouer dans l’état actuel des choses, alors à l’avenir… ».\n" +
"Gravelord_Azir\n" +
"\n" +
"De retour des enfers, c'est bien Azir qui s'impose comme l'une des références sur la midlane en cette présaison, avec 93% de présence.\n" +
"\n" +
"Parmi les retours au premier plan, on peut surtout noter celui de Corki, qui n’a certes jamais vraiment été mis de côté, mais qui voit sa popularité exploser grâce à la rune Kleptomancie : conséquence, 5 bans et 6 sélections sur un total de 15 parties jouées. Syndra et Ryze reprennent eux aussi des couleurs, avec 53 % et 27 % de présence respectivement. Mais l’arrivée la plus remarquée est sans conteste celle d’Azir : avec 10 bans, 4 sélections et 3 victoires, l’Empereur de Shurima inquiète toutes les équipes tant les nouvelles runes semblent accélérer sa montée en puissance, sans oublier la forte pression qu’il peut exercer en début de partie.\n" +
"\n" +
"Un dernier revenant à évoquer est Viktor, utilisé par Eika, qui nous justifie ce choix : « Le gros coup dur subi par Viktor il y a déjà quelques mois était l'augmentation du prix de la première évolution du cœur Hextech, qui était passé de 1000 à 1250 pièces d’or. Grâce à la rune permettant au joueur de contracter une dette, ce problème est quasiment annulé, et Viktor peut à nouveau nettoyer les vagues de sbires relativement tôt. Pour cette raison, je pense qu’il devrait réapparaître régulièrement. »\n" +
"Nouvelles runes : premiers choix pour les joueurs pros\n" +
"\n" +
"C'est évidemment la grande attraction de cette reprise, et nous avons pu observer les premières tendances. Sans grande surprise, l'arbre Sorcellerie est assez populaire, avec quelques subtilités. Dans l'ensemble, l'invocation d'Aery est favorisée sur les mages classiques tels que Ryze ou Orianna ; Azir, Syndra, Orianna, ou encore Cassiopeia ont eux (elles) aussi été joué(e)s au moins une fois avec cette rune fondamentale, ce qui semble confirmer sa puissance dans la plupart des situations. Au niveau de la rune majeure, le Ruban de mana est plébiscité grâce à la régénération de mana qu'il confère ; malgré quelques rares apparitions, le Chapeau Ultime ne semble pas convenir aux joueurs, qui choisissent un renforcement de leur début de partie plutôt qu'un atout se révélant en milieu ou fin de partie.\n" +
"ChineseCorki\n" +
"\n" +
"Six sélections pour cinq victoires, et cinq bans en parallèle : grâce à la Kleptomancie, Corki est la plus grosse menace sur la voie du milieu en ce moment.\n" +
"\n" +
"L'arbre Sorcellerie est parfois combiné avec l'arbre Inspiration, qui grâce à son Timing Parfait permet notamment d'accélérer la récupération du Sablier de Zhonya. Certains joueurs plus agressifs lui préfèrent le soin conféré par Goût du Sang, et la vitesse de déplacement octroyée par Chasseur Acharné, que l'on retrouve toutes deux dans l'arbre Domination. D'ailleurs, s'il est rare de voir un midlaner s'orienter vers l'arbre Inspiration comme arbre principal – hormis sur Corki, comme nous l'expliquions plus haut, qui profite parfaitement de la Kleptomancie - la Domination est l'alternative la plus populaire à la Sorcellerie. Les assassins tels que Zed, Fizz, LeBlanc ou même Ahri bénéficient pleinement de l'électrocution, mais ce choix a également été fait sur Syndra, qui nous rappelle qu'un saut n'est pas nécessaire pour désintégrer une cible.\n" +
"\n" +
"Le dernier arbre à parfois être employé est bien sûr « Précision », dont le Tempo Mortel sied parfaitement à Azir, ou Lucian, apparu une fois dans le tournoi. L'augmentation de la vitesse d'attaque dont peut bénéficier l'Empereur de Shurima est la raison pour laquelle nous évoquions son début de partie beaucoup plus efficace ; les joueurs ont d'ailleurs complètement délaissé la Dent de Nashor, jusque-là considérée comme indispensable sur le champion, au profit d'achats plus classiques comme le Morellonomicon et le Sceptre de Rylai. L'assouplissement du choix d'objets sur Azir est sans conteste l'une des raisons expliquant la priorité dont il est l'objet depuis le début du tournoi.\n" +
"Le rôle du midlaner en 2018\n" +
"\n" +
"A partir des changements constatés, il faut maintenant se demander comment la voie du milieu va s’articuler autour des autres rôles. « Je pense que les nouvelles runes sont assez équilibrées : Aery est assez efficace, combinée à Brûlure pour les champions disposant de sorts mono-cibles, comme Kassadin ou Viktor, mais aussi sur les champions à bouclier, par exemple Karma, Lulu ou Orianna. Électrocution est un bon atout pour les champions agressifs voués à assassiner une cible (Syndra, Fizz ou encore Zed), et la Kleptomancie profite surtout à Corki. Beaucoup d’approches semblent donc viables », selon Eika. Si les mages auxquels nous sommes habitués depuis plusieurs années devraient conserver une popularité élevée – Syndra, Orianna, Ryze – nous pouvons espérer voir les équipes exploiter les multiples possibilités offertes par le nouveau système de runes pour créer des situations très spécifiques ouvrant la porte à des champions moins courants.\n" +
"LDLC_GamersOrigin_Week1\n" +
"\n" +
"Tonerre a opté pour une Syndra dominatrice, qui a fait souffrir le Lucian de Eika. Toutefois, c'est la Team LDLC qui a remporté ce match.\n" +
"\n" +
"Pour Tonerre, les choses risquent plutôt de suivre la tendance observée depuis le milieu de l’année : « Je pense que le rôle du midlaner sera de gérer le début et le milieu de partie, afin de permettre à son tireur d’évoluer tranquillement, et de lui déléguer le gros du travail en fin de partie. » S’il s’agit bien sûr d’un schéma auquel on est habitué, les tireurs infligeant généralement beaucoup plus de dégâts que les autres rôles dans les dernières phases de jeu, il ne faut pas enterrer les situations de 1-3-1, moins fréquentes depuis quelques temps, mais qui permettent toujours aux équipes de rester dans un match malgré une composition à la croissance plus faible que celle de leurs opposants.\n" +
"\n" +
"Alors finalement, beaucoup de bruit pour rien ? Tous ces changements ne feraient-ils finalement pas bouger les choses de façon aussi radicale que d’autres patches de présaison au fil des ans ? N’oublions pas qu’après huit ans de compétition, il est plus difficile de créer du renouveau, chaque champion ou presque ayant eu son heure de gloire. La réapparition de Viktor ou Azir, par exemple, ne doit pas passer inaperçue, et illustre une véritable rupture avec la méta des championnats du monde. D’autre part, le Challenge France nous fournit certes quelques indicateurs, mais nous n’en sommes qu’aux balbutiements du League of Legends version 2018. Le retour aux affaires des meilleures équipes du monde devrait nous permettre de voir ces modifications d’un nouvel œil, et, peut-être, de découvrir d’agréables surprises.\n" +
"\n" +
"Quel changement apporté par le patch 7.22 jugez-vous le plus intéressant ? Quels champions espérez-vous voir revenir sur la voie du milieu ?","https://eu.lolesports.com/darkroom/1265/b0038e5a3d80538de441bd2ab26ab669:bd8ab680d5f31eab28c216d36a8d3426");
        Article a4 = new Article("Solary : Le seul plafond qu’on a, c’est celui que l’on se fixe ", "Entre conseils avisés et ambiance de franche camaraderie, ils se sont construit une audience fidèle, qu’ils divertissent sept jours sur sept. Mais au-delà de leur activité d’animateur, les joueurs de Solary sont avant tout avides de compétition. C’est particulièrement le cas de Wakz et Caëlan, qui évoluent en duo sur la voie du bas et avec qui nous avons pu échanger. L’occasion de mieux les connaître.\n" +
"\n" +
"Des six participants du Challenge France, Solary sort évidemment du lot. Pas que cette équipe soit meilleure que les autres, pas qu’elle soit plus ancienne, pas qu’elle se soit qualifiée différemment, mais parce qu’elle est différente, intrinsèquement. \n" +
"\n" +
"Une équipe professionnelle comme Fnatic s’entraîne dans l’ombre, travaille sur ses stratégies en veillant à ce qu’elles ne soient pas analysées par ses adversaires. L’objectif premier de Fnatic est la compétition. S’entraîner pour gagner, jouer pour remplir les armoires de trophées. À leur échelle, les équipes du Challenge France appliquent le même processus. Mais pas Solary. Quand Solary s’entraîne, c’est en diffusant aussi bien son jeu que la communication entre ses joueurs, sans aucun filtre, laissant à ses adversaires tout le loisir de s’informer pour préparer aux mieux les rencontres. Si on était sur The Witcher 3, on dirait que la difficulté a été réglée sur « Marche de la mort ». \n" +
"Jeu et locaux en chantier\n" +
"\n" +
"Heureusement, en ce moment « tout le monde est un peu dans le flou » souligne César « Wakz » Hugues. La faute au chamboulement annuel de la présaison. Par la suite, il précise : « C’est à notre avantage. On peut jouer de ça pour mettre les équipes en danger et aller chercher des games ». Pour l’instant, les résultats ne sont pas au rendez-vous. Solary pointe, seul, en position de lanterne rouge. Mais on retrouve ce que nous a décrit le carry AD : une victoire face à l’un des favoris, GamersOrigin, et des parties qui auraient pu tourner autrement. \n" +
"Caëlan, Wakz et Chap à la Paris Games Week - Photo Corbier\n" +
"\n" +
"Caëlan, Wakz et Chap à la Paris Games Week - Photo Corbier\n" +
"\n" +
"Outre les conditions de préparation singulières, la récente actualité de l’équipe a également joué en sa défaveur. « Ce qui nous a surtout manqué, c’est que l’on a trop peu joué en équipe sur les deux derniers mois, nous explique Romain « Caëlan » Albesa. Il y a eu le lancement du projet Solary, les travaux. Certains n’ont pas joué du tout pendant un mois. Ça rend les choses plus complexes ». ","https://eu.lolesports.com/darkroom/1265/677197242f5466b9d4b7fc72d757b251:4e32438a4a27822497265e0716d98a78");
        articleRepo.save(a1);
        articleRepo.save(a2);
        articleRepo.save(a3);
        articleRepo.save(a4);
	
	
	
	Player p1 = new Player("Christian tiensuu","Sleeping", PlayerRole.Top, 22, "Gnar", "La ROG SCHOOL est un projet initié par Asus afin de dénicher les petites pépites françaises. Cette année, la promotion guidée par le coach Louis-Victor « Mephisto » Legendre a eu quelques difficultés dans les compétitions françaises, malgré une mention honorable aux play-offs des Underdogs. En position d’outsiders, les jeunes talents d’Asus ROG souhaitent surprendre les grosses écuries. ");
	Player p2 = new Player("Cantoursna An","NJI", PlayerRole.Jungle, 18, "Sejuani", "#17 KDA au challenge france");
	Player p3 = new Player("Quentin Viguie","Zeph", PlayerRole.Mid, 19, "Azir", "#19 KDA au challenge france");
	Player p4 = new Player("Alan Roger","Tiger", PlayerRole.ADC, 22, "Jhin", "Tiger est un habitué de la scène française. Il a débuté dans la faille de l'invocateur sur la toplane, jusqu'a la saison 3 ou il change pour s'épanouir en tant qu'AD Carry. Rapidement, il se classe parmi les meilleurs et obtient le rang de Challenger. Titularisé dans de nombreuses équipes françaises telles que LDLC ou aAa, c'est sous les couleurs d'Infamous et de PCS qu'il remporte ses premiers titres. Il s'est aussi illustré sur de nombreux podiums avec ses coéquipiers de Punchline. C'est aujourd'hui avec l'équipe Glorious qu'il va tenter de soulever la coupe.");
	Player p5 = new Player("Philippe Castellano","Broua", PlayerRole.Support, 21, "Leona", "#27 KDA au challenge france");
	
	Player p6 = new Player("Damien Soulagnet","Shemek", PlayerRole.Top, 21, "Shen", "Capitaine exigeant des E-Corp Glorious, Shemek est une figure bien connue du circuit français. Son aventure dans le monde compétitif a commencé à la Lyon e-Sport en 2015. Il a ensuite enchaîné les bons résultats au sein de diverses structures telles que Punchline, Infamous, Imaginary Gaming, aAa ou PCS.\n" +
"\n" +
"Aujourd’hui, il commence une nouvelle aventure avec l'équipe Gamers Origin, dont le niveau individuel des joueurs et leurs expériences seront des atouts majeurs. ");
	Player p7 = new Player("Daniel Subicz","Bluerzor", PlayerRole.Jungle, 18, "Nidalee", "Le jungler des Gamers Origin arrive tout droit de Hongrie, où il a joué chez Wonder Stag e-Sport. L'équipe a notamment participé aux qualifiers des Challengers Series en 2016 mais n'a malheureusement pas su prendre l'avantage. En rejoignant cette nouvelle structure, Bluerzor vise un titre de champion de France et donc une nouvelle participation aux Challenger Series.\n" +
"\n" +
"De niveau Challenger sur les différentes serveurs européens, cette compétition lui permet de briller auprès d'une communauté qui ne le connaît pas encore !");
	Player p8 = new Player("Scott Menard","Tonerre", PlayerRole.Mid, 19, "Syndra", "Tonerre est un joueur de League of Legends depuis la saison 2. C'est sous les couleurs de l'équipe PCS qu'il fera son entrée en compétition nationale, lors de la DreamHack 2015. Par la suite, il s'est entraîné en soloQ et a rejoint de nombreuses équipes européennes. Son ascension au meilleur niveau français se fera avec l'équipe Lamasticrew, qui participa notamment à la DreamHack France.\n" +
"\n" +
"Avec sa nouvelle équipe GamersOrigin et leur qualification au Challenge France, il revient à son meilleur niveau sur le devant de la scène.");
	Player p9 = new Player("Augusta Ruplys","Toaster", PlayerRole.ADC, 18, "Ezreal", "#5 KDA au challenge france");
	Player p10 = new Player("Raphael Crabbe","Targamas", PlayerRole.Support, 17, "Braum", "Malgré son jeune âge, Targamas est un support qui joue régulèrement au niveau Master ou Challenger. Il affectionne particulièrement des champions qui permettent d'attraper ses adversaires pour ne leur laisser aucune chance.\n" +
"\n" +
"Zyra, Bard ou Tresh seront ses choix de prédilection pour briller au sein de sa nouvelle équipe Gamers Origin.");
	
	Player p11 = new Player("Arthur Lesueur","Brosak", PlayerRole.Top, 21, "Ornn", "Capitaine de l’équipe et toplaner, Brosak commence à briller dès la Lyon e-Sport #6 où une honorable 8ème place lui donne le goût des compétitions en LANs. Représentant ensuite la communauté LoLFR notamment aux côtés de Hans Sama, Brosak fait ses armes avant de rejoindre E-Corp fin 2014.\n" +
"\n" +
"Depuis cette date, on retrouve les E-Corp sur la plupart des compétitions françaises, de mieux en mieux placés. Pour sa deuxième participation au Challenge France, Brosak est déterminé à montrer la progression de son équipe et de ses coéquipiers, qu'il motive régulièrement à se dépasser.");
	Player p12 = new Player("Nikola Zrinjki","Xani", PlayerRole.Jungle, 20, "Xin Zhao", "#21 KDA au challenge france");
	Player p13 = new Player("Lucas Fayard","Saken", PlayerRole.Mid, 19, "Azir", "Saken évolue depuis la saison 2 sur la midlane, son rôle de prédilection. Atteignant le rang Master en saison 5 avec plus de 300 LP, il réussi également de bonnes performances récemment sur de nombreux tournois français. Un joueur très à l'aise sur des mages (Viktor, Aurelion Sol, Azir...) qui espère faire ses preuves sur les compétitions nationales.");
	Player p14 = new Player("Muammer Bay","Murmel", PlayerRole.ADC, 20, "Varus", "#20 KDA au challenge france");
	Player p15 = new Player("Jean Medzadourian","Trayton", PlayerRole.Support, 19, "Leona", "Joueur de League of Legends depuis des années, ce n’est qu’en janvier 2016 que TraYtoN s'est lancé dans le grand bain de la compétition en équipe. Grâce à une 3ème place lors de l’Ynov LoL Cup, un tournoi réservé aux lycéens, le virus de l’e-sport s’est emparé de lui. On a pu ensuite le retrouver sur des compétitions majeures du pays, comme les Lyon e-Sport ou les Gamers Assembly.\n" +
"\n" +
"Aujourd’hui au sein d’E-Corp Gentle et du haut de ses 400 LP en Master, il est prêt à montrer son niveau aux midlaner adverses, notamment sur une Ahri qu'il maîtrise parfaitement.");
	
	Player p16 = new Player("Aymeric Garçon","Darlik", PlayerRole.Top, 20, "Shen", "#7 KDA au challenge france");
	Player p17 = new Player("Stefan Pereira","Nerroh", PlayerRole.Jungle, 21, "Jarvan IV", "Débutant sa carrière en saison 3 avec l'équipe Punchline eSport Club et en compagnie de Nisqy, Nerroh met un premier pied dans le circuit des LAN françaises. Suite à cette expérience, les deux joueurs et amis sont recrutés par Infamous puis Melty Esport Club où ils rencontrent Kirdos. Le trio devient très vite redoutable et les victoires s'enchainent.\n" +
"Depuis, Nerroh continue seul son parcours sur la scène professionnelle française et européenne. Il a notamment pu participer à deux reprises aux Challenger Series (Summer Split 2016 & Qualifier Spring Split 2017). Aujourd'hui, c'est sous les couleurs de la Team-LDLC qu'il vise le titre de champion au Challenge France 2017. ");
	Player p18 = new Player("Marcel Wiederhofer","Scarlet", PlayerRole.Mid, 19, "Corki", "#6 KDA au challenge france");
	Player p19 = new Player("Matus Jakubcik","Neon", PlayerRole.ADC, 19, "Xayah", "#9 KDA au challenge france");
	Player p20 = new Player("Christophe Van Oudheusden","Kaas", PlayerRole.Support, 20, "Braum", "#26 KDA au challenge france");
	
	Player p21 = new Player("Andrea Suchodolski","Katare", PlayerRole.Top, 20, "Cho'gath", "#15 KDA au challenge france");
	Player p22 = new Player("Alexis Barret","Chap", PlayerRole.Jungle, 21, "Xin Zhao", "#23 KDA au challenge france");
	Player p23 = new Player("Alexis Barrachin","Melon", PlayerRole.Mid, 21, "Leblanc", "Melon est un jeune joueur et streamer chez Eclypsia. Il a débuté sa carrière sur la midlane pour des équipes telles que \"1m90/90kg\", \"Aeria\" ou encore \"Pulse\". Ses experiences en équipe lui ont permis de participer à de nombreux événements et de se faire connaitre sur la scène pour ses actions étonnantes et décisives. Actuellement Master et fort de son entrainement sur Aurelion Sol, Jayce et Orianna, il va tenter de jouer un rôle clé pour ses coéquipiers lors du Challenge France.");
	Player p24 = new Player("Cesar Hugues","Wakz", PlayerRole.ADC, 24, "Tristana", "Wakz commence la compétition en saison 3 en tant que midlaner. Il décide ensuite de changer de poste et passe ADC pour rejoindre l'équipe Hyperia avec laquelle il obtient de bons résultats. Suite au recrutement de son manager, Wakz rejoint Melty. Avec ses nouveaux équipiers Wakz gagne son premier grand tournoi lors de la Dreamhack France 2016. Motivés par ce résultat l'équipe tente la qualification Challenger Series mais s'incline en phase de groupe avec 2 victoires pour 3 défaites. Chose rare pour un ADC, Wakz est très actif avec ses co-équipiers. Il n'hésite pas à donner les informations prendre le rôle du shot caller lorsqu'il sent une opportunité.\n" +
"\n" +
"Il est ensuite contacté par Eclypsia pour devenir streamer à temps plein. Changement radical de carrière qu'il accepte mais la fièvre de la compétition le rattrape déjà et avec ses coéquipiers et amis, ils créent Eclypsia eSport qui compte bien montrer à tous que les streamers sont aussi compétitifs !");
	Player p25 = new Player("Romain Albesa","Caelan", PlayerRole.Support, 21, "Rakan", "Joueur passionné et coach pour diverses équipes depuis 4 ans, Caëlan a joué dans de nombreuses équipes françaises (notamment Melty) et a pu entrainer plusieurs équipes occidentales (coach jungle pour Team Liquid par exemple). Challenger au poste de jungler pendant deux saisons, il change il y a un mois pour devenir support avec l'équipe Eclypsia eSport. Il profite d'une belle synergie avec son co-équipier Wakz mais un petit mois d'entrainement suffira-t-il pour rivaliser avec les autres bot lane de la compétition ? Finaliste du Challenge France 2014 avec Infamous, il a soif de revanche. Il espère bien prouver qu'il a le niveau pour accrocher les meilleures équipes françaises.");
	
	Player p26 = new Player("Bor Jersan","Kektz", PlayerRole.Top, 22, "Shen", "Durant la saison 1, Kektz découvre League of Legends et tombe amoureux du jeu, choisissant le rôle de toplaner. En 2015, le joueur slovène intègre l'école de formation Fnatic Academy pour ensuite jouer en tant que remplaçant dans l'équipe A.\n" +
"Il passera ensuite par plusieurs structures de haut niveau turques ou allemandes et jouera la saison 2017 en compagnie des joueurs de la Team-LDLC. Son expérience de jeu et de la stratégie apporte à l'équipe une carte supplémentaire à jouer pour se démarquer et viser le titre de champion.");
	Player p27 = new Player("Duncan Marquet","Skeanz", PlayerRole.Jungle, 17, "Lee sin", "Nouveau venu sur la scène compétitive, Skeanz a fait ses début au sein de la \"Team E2G\". Il rejoint Grobill en septembre 2016 et se révèle être une valeur montante dans la jungle. Il a rapidement su se créer une réputation de jungler agressif qui aime mettre de la pression dès le début de partie.\n" +
"\n" +
"Performant en parties classées, avec un niveau Challenger, il compte également prouver sa valeur sur la scène du Challenge France et pourquoi pas sur celle des Challenger Series.");
	Player p28 = new Player("Jeremy Valdenaire","Eika", PlayerRole.Mid, 22, "Viktor", "Eika est un joueur professionnel parmis les meilleurs midlaner d'Europe. Joueur de League of Legends depuis la saison 1, il a appris petit à petit les mécaniques du jeu, améliorant son rang à chaque saison.\n" +
"Depuis la saison 4, il joue au niveau Challenger et début 2015, il rejoint l'équipe Team Nevo qui participe au tournoi qualificatif des Challenger Series. S'imposant contre l'équipe espagnole Gamers2, cette dernière sera tout de même qualifiée en Challenger Series et le recrutera pour le split. L'équipe finira 4e et ne parviendra pas à se qualifier pour les LCS.\n" +
"Cependant, le jeu et les performances d'Eika lui ont permis d'être repéré par une équipe de niveau supérieur : Elements. Il jouera l'intégralité du LCS Spring Split 2016 sous leurs couleurs et terminera son année 2016 avec la Team-Huma. Il rejoint Team-LDLC pour ce début d'année 2017 et vise de nouveaux objectifs.\n" +
"Eika est donc un joueur de grande expérience à surveiller, qui fera de la midlane du Challenge France son terrain de jeu !");
	Player p29 = new Player("Jus Marusic","Crowniee", PlayerRole.ADC, 19, "Ashe", "Crownie est un jeune joueur au style de jeu très agressif, fait pour suprendre ses ennemis. Ses préférences vont vers des champions comme Lucian, Tristana ou Ezreal, connus pour leur forte mobilité.\n" +
"Actuellement Challenger, le milieu compétitif ne lui est pas inconnu. Il a déjà participé à de grands tournois, notamment en Allemagne où il avait remporté le Dr Pepper AllStar Tournament. Un joueur à suivre qui compte bien briller lors du Challenge France.");
	Player p30 = new Player("Amaury Minguerche","Moopz", PlayerRole.Support, 20, "Braum", "Dès le début de la saison 1, Moopz s'est investi sur League of Legends. Une transistion réussie puisqu'il atteignit le rang de n°1 du classement européen, avec Morgana et Sion, ses deux champions préférés de l'époque. Un résultat qui lui permit de rejoindre l'équipe Sypher en 2012, un équipe belge ayant participé aux IEM New-York.\n" +
"Par la suite, Moopz a joué dans de nombreuses teams en Challenger Series comme SK Gaming, mousesport, SUPA HOT CREW et même remplaçant en LCS de l'équipe française Vitality. Il joue aujourd'hui support dans la Team-LDLC et a participé à la précédente édition du Challenge France. Il revient déterminé à porter son équipe vers la victoire.");
	
	
	playerRepo.save(p1);
        playerRepo.save(p2);
        playerRepo.save(p3);
	playerRepo.save(p4);
	playerRepo.save(p5);
	playerRepo.save(p6);
	playerRepo.save(p7);
	playerRepo.save(p8);
	playerRepo.save(p9);
	playerRepo.save(p10);
	playerRepo.save(p11);
	playerRepo.save(p12);
	playerRepo.save(p13);
	playerRepo.save(p14);
	playerRepo.save(p15);
	playerRepo.save(p16);
	playerRepo.save(p17);
	playerRepo.save(p18);
	playerRepo.save(p19);
	playerRepo.save(p20);
	playerRepo.save(p21);
	playerRepo.save(p22);
	playerRepo.save(p23);
	playerRepo.save(p24);
	playerRepo.save(p25);
	playerRepo.save(p26);
	playerRepo.save(p27);
	playerRepo.save(p28);
	playerRepo.save(p29);
	playerRepo.save(p30);
        
        List<Player> list1 = new ArrayList<>();
        List<Player> list2 = new ArrayList<>();
        List<Player> list3 = new ArrayList<>();
        List<Player> list4 = new ArrayList<>();
        List<Player> list5 = new ArrayList<>();
        List<Player> list6 = new ArrayList<>();
	
	list1.add(p1);
	list1.add(p2);
	list1.add(p3);
	list1.add(p4);
	list1.add(p5);
	
	list2.add(p6);
	list2.add(p7);
	list2.add(p8);
	list2.add(p9);
	list2.add(p10);
	
	list3.add(p11);
	list3.add(p12);
	list3.add(p13);
	list3.add(p14);
	list3.add(p15);
	
	list4.add(p16);
	list4.add(p17);
	list4.add(p18);
	list4.add(p19);
	list4.add(p20);
	
	list5.add(p21);
	list5.add(p22);
	list5.add(p23);
	list5.add(p24);
	list5.add(p25);
	
	list6.add(p26);
	list6.add(p27);
	list6.add(p28);
	list6.add(p29);
	list6.add(p30);
	
	Team newteam1 = new Team("ROG", "La ROG SCHOOL est un projet initié par Asus afin de dénicher les petites pépites françaises. Cette année, la promotion guidée par le coach Louis-Victor « Mephisto » Legendre a eu quelques difficultés dans les compétitions françaises, malgré une mention honorable aux play-offs des Underdogs. En position d’outsiders, les jeunes talents d’Asus ROG souhaitent surprendre les grosses écuries. ", list1);
	teamRepo.save(newteam1);
	
	Team newteam2 = new Team("Gamers Origin","Lyon Esports, Gamers Assembly, Montpellier Esports Show, Underdogs...cette année, l’équipe clairement brillé. Malgré une faute de parcours lors de la Dreamhack, l’équipe Gamers Origin s’est vite hissé parmi les toutes meilleures équipes françaises et arrive ici en tant que sérieux prétendant au titre.\n" +
"\n" +
"Avec le souvenir du troisième place décrochée lors de la précédente édition du Challenge France, cette fois-ci les Gamers Origin ne comptent pas s’en tenir à cette place du podium ! ", list2);
	teamRepo.save(newteam2);
	
	Team newteam3 = new Team("Gentside","Nouveau né de la compétition française, les Gentside n’ont pas tardé à faire parler d’eux. Soutenus par le média du même nom, l’entreprise accompagnait Beyond The Rift sur les routes des LANs françaises jusqu’ici.\n" +
"\n" +
"Ici, la nouvelle structure passe aux choses sérieuses et le Gentside Esports Club comptent bien embrasser pleinement la compétition. Qualifié via le tournoi de promotion au Challenge France dans lequel ils ont vaincu Lunary, équipe soeur de Solary, et les Pandas Roux, l’équipe n’est pas pour autant à sous-estimer. ", list3);
	teamRepo.save(newteam3);
	
	Team newteam4 = new Team("Millenium","Millenium est la structure triple championne de France en titre, malgré les changements de joueurs à chaque édition. Tantôt fondée sur des talents français (on peut penser à Djoko et Hans Sama passé par l'écurie Millenium), tantôt sur des apports étrangers (comme au Challenge France février 2017), l'équipe Millenium a toujours su performer lors des CF. Avec encore une fois une nouvelle line-up prometteuse, mais peut-être moins favorite qu'auparavant avec la montée en puissance des concurrents team LDLC et GamersOrigin, Millenium saura-t-il conserver le titre ? ", list4);
	teamRepo.save(newteam4);
	
	Team newteam5 = new Team("Solary", "Solary, c’est un groupe de cinq amis qui officiait précédemment chez Eclypsia. S’ils font partie aujourd’hui des personnalités les plus appréciées du streaming français, ce sont aussi des joueurs talentueux qui ont fait leurs preuves lors des plus grandes LANs françaises cette année.\n" +
"\n" +
"Souhaitant se distinguer des autres équipes, Solary n’hésite pas à diffuser la communication entre les joueurs lors de leurs matchs, permettant ainsi de conserver ce côté “animateur” que les joueurs apprécient tant. Après un parcours en dents de scie en compétition sous la bannière d’Eclypsia, le nouveau collectif souhaite profiter de leur récente libération pour prouver leur talent compétitif sur ce Challenge France. ", list5);
	teamRepo.save(newteam5);
	
	Team newteam6 = new Team("LDLC","L’équipe est présente dans le top3 de la scène française depuis quelques années maintenant et ne compte pas s’en tenir là. Malgré un échec face à RedBull pour intégrer les Challenger Series, Jérémy « Eika » Valdenaire et ses hommes ont traversé de nombreux changements de rosters dans le but de trouver le parfait collectif.\n" +
"Dans cette optique, le vétéran de la scène française et internationale, Bora « YellOwStaR » Kim a fait son entrée au sein de l’équipe en tant que coach. LDLC a d’ailleurs récemment remporté le tournoi Clash of Nations avec la star française à ses côtés et nous découvrirons bientôt si cela les aidera à récupérer leur couronne du Challenge France laissée en 2016. ", list6);
	teamRepo.save(newteam6);
	
	Competition competition = new Competition(new Date(), "ChallengeFrance");
	competition.getTeams().add(newteam1);
	competition.getTeams().add(newteam2);
	competition.getTeams().add(newteam3);
	competition.getTeams().add(newteam4);
	competition.getTeams().add(newteam5);
        competitionRepo.save(competition);
	
	Stats stats1 = new Stats();
	Stats stats2 = new Stats();
	Stats stats3 = new Stats();
	Stats stats4 = new Stats();
	statsRepo.save(stats1);
	statsRepo.save(stats2);
	statsRepo.save(stats3);
	statsRepo.save(stats4);
	
	Event e1 = new Event("Quart de finale", new Date(), newteam1, newteam2, 0,3,stats1,stats2,Long.parseLong("1"));
	Event e2 = new Event("Demi-finale", new Date(), newteam3, newteam4, 0,1,stats3,stats4,Long.parseLong("1"));
	
	eventRepo.save(e1);
	eventRepo.save(e2);
        return "redirect:/home";
    }
    
}
