package com.tsi.omar.butt.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActorTest {

    @Test
    void testGetActor_id(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActorId(1);
        Assertions.assertEquals(1, testActor.getActorId(), "id not there.");
    }
    @Test
    void testSetActor_id(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActorId(1);
        Assertions.assertEquals(1, testActor.getActorId(), "id not set.");
    }
    @Test
    void testGetFirst_name(){
        Actor testActor = new Actor("testFName", "testLName");
        Assertions.assertEquals("testFName", testActor.getFirstName(), "first name not found/set.");
    }
    @Test
    void testSetFirst_name(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setFirstName("replacedFName");
        Assertions.assertEquals("replacedFName", testActor.getFirstName(), "first name not set.");
    }
    @Test
    void testGetLast_name(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.getLastName();
        Assertions.assertEquals("testLName", testActor.getLastName(), "last name not found/set.");
    }
    @Test
    void testSetLast_name(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setLastName("replacedLName");
        Assertions.assertEquals("replacedLName", testActor.getLastName(), "last name not set.");
    }
}
