/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chris
 */
@Controller
public class SigninController
{
    
    @RequestMapping("/signin")
    public String page()
    {
        return "signin";
    }
    
    @RequestMapping("appLogin")
    public String setSession()
    {
	return "";
    }
}
