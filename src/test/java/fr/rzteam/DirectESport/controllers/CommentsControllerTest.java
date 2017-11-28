///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.rzteam.DirectESport.controllers;
//
//import fr.rzteam.DirectESport.model.Event;
//import fr.rzteam.DirectESport.model.EventRepository;
//import fr.rzteam.DirectESport.model.RequestComment;
//import javax.inject.Inject;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.springframework.ui.Model;
//
///**
// *
// * @author chris
// */
//public class CommentsControllerTest
//{
//    @Inject
//    EventRepository eventRepo;
//    
//    public CommentsControllerTest()
//    {
//    }
//    
//    @BeforeClass
//    public static void setUpClass()
//    {
//    }
//    
//    @AfterClass
//    public static void tearDownClass()
//    {
//    }
//    
//    @Before
//    public void setUp()
//    {
////        //We create an event id=1
////        Event event = new Event("description",Long.parseLong(1+""));
////        eventRepo.save(event);
//    }
//    
//    @After
//    public void tearDown()
//    {
//    }
//
//    /**
//     * Test of updateAllWebsocketClient method, of class CommentsController.
//     */
//    @Test
//    public void testUpdateAllWebsocketClient() {
//        System.out.println("updateAllWebsocketClient");
//        RequestComment request = null;
//        CommentsController instance = new CommentsController();
//        String expResult = "";
//        String result = instance.updateAllWebsocketClient(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//        
//    }
//
////    /**
////     * Test of save method, of class CommentsController.
////     */
////    @Test
////    public void testSave() {
////        System.out.println("save");
////        String text = "A comment test of an event";
////        String id = "1";
////        
////        CommentsController instance = new CommentsController();
////        //We add the comment to this id
////        instance.save(text, id);
////        
////        String result = eventRepo.findOneById(Long.parseLong(1+"")).getDescription();
////        String expResult = text;
////        assertEquals(expResult, result);
////    }
////
////    /**
////     * Test of comment method, of class CommentsController.
////     */
////    @Test
////    public void testComment() {
////        System.out.println("comment");
////        String id = "";
////        Model m = null;
////        CommentsController instance = new CommentsController();
////        String expResult = "";
////        String result = instance.comment(id, m);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//    
//}
