/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.mdparser;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class MarkdownTest {
    
    public MarkdownTest()
    {
    }

    /**
     * Test of parse method, of class Markdown.
     */
    @Test
    public void testParse()
    {
        String markdown = "a";
        String expResult = "<p>a</p>\n";
        String result = Markdown.parse(markdown);
        
        assertEquals(expResult, result);
    }
    
}
