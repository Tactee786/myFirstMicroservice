package com.tsi.omar.butt.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorTest {

    @Test
    public void testGetActor_id(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(1);
        Assertions.assertEquals(1, testActor.getActor_id(), "id not there.");
    }
    @Test
    public void testSetActor_id(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(1);
        Assertions.assertEquals(1, testActor.getActor_id(), "id not set.");
    }
    @Test
    public void testGetFirst_name(){
        Actor testActor = new Actor("testFName", "testLName");
        Assertions.assertEquals("testFName", testActor.getFirst_name(), "first name not found/set.");
    }
    @Test
    public void testSetFirst_name(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setFirst_name("replacedFName");
        Assertions.assertEquals("replacedFName", testActor.getFirst_name(), "first name not set.");
    }
    @Test
    public void testGetLast_name(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.getLast_name();
        Assertions.assertEquals("testLName", testActor.getLast_name(), "last name not found/set.");
    }
    @Test
    public void testSetLast_name(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setLast_name("replacedLName");
        Assertions.assertEquals("replacedLName", testActor.getLast_name(), "last name not set.");
    }
}
