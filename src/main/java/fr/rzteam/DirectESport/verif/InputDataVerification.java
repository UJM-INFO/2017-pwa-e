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
package fr.rzteam.DirectESport.verif;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Contains method to verify inputs send by forms
 */
public class InputDataVerification
{
    
    /**
     * @param text input 
     * @param minLength
     * @param maxLength
     * @return true or false
     */
    public static boolean verifTextLength(String text, int minLength, int maxLength)
    {
        return !(text.length() > maxLength || text.length() < minLength);
    }
    
    /**
     * @param text
     * @return text escaped
     */
    public static String escape(String text)
    {
        return StringEscapeUtils.escapeHtml4(text);
    }
}
