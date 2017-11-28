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

import fr.rzteam.DirectESport.model.Player;
import fr.rzteam.DirectESport.model.PlayerRepository;
import fr.rzteam.DirectESport.model.PlayerRole;
import fr.rzteam.DirectESport.model.Team;
import fr.rzteam.DirectESport.model.TeamRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for team page / operations
 */
@Controller
public class TeamController
{

    @Inject
    TeamRepository teamRepo;

    @Inject
    PlayerRepository playerRepo;

    /**
     * We redirect to the team page if the id is set, otherwise we redirect to
     * the team menu
     *
     * @param id Id of the article we want
     * @param m The model to exchange data with Thymeleaf
     * @return return the template "teamMenu" or "team"
     */
    @RequestMapping("/team")
    public String teamMenu(@RequestParam(value = "id", required = false) String id, Model m)
    {
        try
        {
            if ("undefined".equals(id) || teamRepo.findOneById(Long.parseLong(id)) == null)
            {
                List<Team> list = teamRepo.findAll();
                m.addAttribute("teams", list);
                List<Player> listplayerAdc = playerRepo.findManyByRoles(PlayerRole.ADC);
                m.addAttribute("playersAdc", listplayerAdc);
                List<Player> listplayerCoach = playerRepo.findManyByRoles(PlayerRole.Coach);
                m.addAttribute("playersCoach", listplayerCoach);

                List<Player> listplayerSupport = playerRepo.findManyByRoles(PlayerRole.Support);
                m.addAttribute("playersSupport", listplayerSupport);
                List<Player> listplayerTop = playerRepo.findManyByRoles(PlayerRole.Top);
                m.addAttribute("playersTop", listplayerTop);
                List<Player> listplayerMid = playerRepo.findManyByRoles(PlayerRole.Mid);
                m.addAttribute("playersMid", listplayerMid);
                List<Player> listplayerJungle = playerRepo.findManyByRoles(PlayerRole.Jungle);
                m.addAttribute("playersJungle", listplayerJungle);
                return "teamMenu";
            }
        }
        catch (NumberFormatException | NullPointerException e)
        {
            List<Team> list = teamRepo.findAll();
            m.addAttribute("teams", list);
            List<Player> listplayerAdc = playerRepo.findManyByRoles(PlayerRole.ADC);
            m.addAttribute("playersAdc", listplayerAdc);
            List<Player> listplayerCoach = playerRepo.findManyByRoles(PlayerRole.Coach);
            m.addAttribute("playersCoach", listplayerCoach);

            List<Player> listplayerSupport = playerRepo.findManyByRoles(PlayerRole.Support);
            m.addAttribute("playersSupport", listplayerSupport);
            List<Player> listplayerTop = playerRepo.findManyByRoles(PlayerRole.Top);
            m.addAttribute("playersTop", listplayerTop);
            List<Player> listplayerMid = playerRepo.findManyByRoles(PlayerRole.Mid);
            m.addAttribute("playersMid", listplayerMid);
            List<Player> listplayerJungle = playerRepo.findManyByRoles(PlayerRole.Jungle);
            m.addAttribute("playersJungle", listplayerJungle);
            return "teamMenu";
        }

        m.addAttribute("id", id);
        m.addAttribute("team", teamRepo.findOneById(Long.parseLong(id + "")));
        m.addAttribute("player", teamRepo.findManyById(Long.parseLong(id + "")));
        return "team";
    }

    /**
     * Receiving the order to add a team
     *
     * @param teamname Name of the team
     * @param history Biographie
     * @param idadc
     * @param idsupport
     * @param idmid
     * @param idjungle
     * @param idtop
     * @param idcoach
     * @return Redirection to "/team"
     */
    @RequestMapping(value = "/add_team", method = RequestMethod.POST)
    public String addteam(@RequestParam("teamname") String teamname,
            @RequestParam("history") String history,
            @RequestParam("adc") String idadc,
            @RequestParam("support") String idsupport,
            @RequestParam("mid") String idmid,
            @RequestParam("jungle") String idjungle,
            @RequestParam("top") String idtop,
            @RequestParam("coach") String idcoach)
    {

        Player adc = playerRepo.findOneById(Long.parseLong(idadc + ""));
        Player mid = playerRepo.findOneById(Long.parseLong(idmid + ""));
        Player top = playerRepo.findOneById(Long.parseLong(idtop + ""));
        Player jgl = playerRepo.findOneById(Long.parseLong(idjungle + ""));
        Player sup = playerRepo.findOneById(Long.parseLong(idsupport + ""));
        Player coach = playerRepo.findOneById(Long.parseLong(idcoach + ""));
        List<Player> plist = new ArrayList<>();
        plist.add(adc);
        plist.add(mid);
        plist.add(top);
        plist.add(jgl);
        plist.add(sup);
        plist.add(coach);
        Team newteam = new Team(teamname, history, plist);
        teamRepo.save(newteam);

        return "redirect:/team";

    }

}
