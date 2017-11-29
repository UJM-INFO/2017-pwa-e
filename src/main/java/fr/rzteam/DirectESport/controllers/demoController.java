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

	
        Article a1 = new Article("Titre de l'article","Pas d'idée ...","http://www.develop-online.net/cimages/8912a1d9e678bb3ea1d8811dc9a29267.jpg");
        Article a2 = new Article("Qui va gagner le trophée des pineur ?", "La compétition est enfin lancée ! Qui de Pineur Alpha, pinoir, puneur, pineur escalier ou encore Malaise Man va remporter le titre ?","http://www.develop-online.net/cimages/8912a1d9e678bb3ea1d8811dc9a29267.jpg");
        Article a3 = new Article("Clément, petite pute ?", "La question que tout le monde se pose. Clément Colin, appelé familièrement Petite Pute, aurait démenti toute forme de prostitution. Affaire à suivre...","http://www.develop-online.net/cimages/8912a1d9e678bb3ea1d8811dc9a29267.jpg");
        Article a4 = new Article("Christopher remporte le prix du meilleur maçon !", "Sa famille était réunie. José, Manuel, Rui, tout trois chemise ouverte sur leur torse poilu, la larme à l'oeil quand leur petit frère souleva le parpaings en or, synonyme de meilleur maçon de la région. Quel beau moment d'émotion...","http://www.develop-online.net/cimages/8912a1d9e678bb3ea1d8811dc9a29267.jpg");
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
	
	
	
	
        return "redirect:/home";
    }
    
}
