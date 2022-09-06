package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product Tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Product Tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       // assertNotEquals(job4.getEmployer().getValue(), job5.getEmployer().getValue());
// expect job4 not to equal job5
       assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job6 = new Job("Product Tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // hardcode a string that looks like what we expect (does job6 string equal what we created?)
        String expectedString = "\n" + "ID: " + job6.getId() + "\n" +
                "Name: Product Tester" + "\n" +
                "Employer: ACME" + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence" + "\n";
        String actualString = job6.toString();
        assertEquals(expectedString, actualString);

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job7 = new Job("", new Employer(""),new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence" ));

        String expectedString = "\n" + "ID: " + job7.getId() + "\n" +
                "Name: Data not available" + "\n" +
                "Employer: Data not available" + "\n" +
                "Location: Data not available" + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence" + "\n";
        String actualString = job7.toString();
        assertEquals(expectedString, actualString);
    }
}
