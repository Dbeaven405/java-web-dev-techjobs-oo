package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class JobTest {


    @Test
    public void testSettingJobId(){
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        int testJob1Increment = testJob1.getId() + 1;
        assertTrue(testJob1Increment == testJob2.getId());
    }


    //***THIS TEST IS FAILING*********
    @Test
    public void testJobConstructorSetsAllFields(){
      Job testJobFull = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(Integer.class.isInstance(testJobFull.getId()));
        assertEquals("Product tester",testJobFull.getName());
        assertTrue(testJobFull.getName() instanceof String);
        assertEquals("ACME", testJobFull.getEmployer().toString());
        assertTrue(testJobFull.getEmployer() instanceof Employer);
        assertEquals("Desert", testJobFull.getLocation().toString());
        assertTrue(testJobFull.getLocation() instanceof Location);
        assertEquals("Quality control", testJobFull.getPositionType().toString());
        assertTrue(testJobFull.getPositionType() instanceof PositionType);
        assertEquals("Persistence", testJobFull.getCoreCompetency().toString());
        assertTrue(testJobFull.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job testJobFull = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job testJobFull2 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertFalse(testJobFull.equals(testJobFull2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJobFull = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        char firstChar = testJobFull.toString().charAt(0);
        char lastChar = testJobFull.toString().charAt(testJobFull.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJobFull = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"),new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String expectedOutcome = "ID:  " + testJobFull.getId() + "\n" +
                "Name:  " + "Product tester" + '\n' +
                "Employer:  " + "ACME" + '\n' +
                "Location:  " + "Desert" + '\n' +
                "Position Type:  " + "Quality control" + '\n' +
                "Core Competency:  " + "Persistence";
        assertEquals(expectedOutcome, testJobFull.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJobFull = new Job("", new Employer(""),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String expectedOutcome = "ID:  " + testJobFull.getId() + "\n" +
                "Name:  " + "Data not available" + '\n' +
                "Employer:  " + "Data not available" + '\n' +
                "Location:  " + "Desert" + '\n' +
                "Position Type:  " + "Quality control" + '\n' +
                "Core Competency:  " + "Persistence";
        assertEquals(expectedOutcome, testJobFull.toString());
    }
}