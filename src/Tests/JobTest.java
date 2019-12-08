package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import java.util.Objects;
import java.util.concurrent.LinkedTransferQueue;

public class JobTest {
    @Test
    public void emptyTest() {
        Assert.assertEquals(true, true);
    }

    private static Job test_Job1;
    private static Job test_Job2;
    private static Job test_Job3;
    private static Job test_Job4;

    @Before
    public void createFakeJob() {
        test_Job1 = new Job("Name", new Employer("Employer"), new Location("Location"), new PositionType("PositionType"), new CoreCompetency("CoreCompetency"));
        test_Job2 = new Job("Name", new Employer("Employer"), new Location("Location"), new PositionType("PositionType"), new CoreCompetency("CoreCompetency"));
    }

    @Test
    public void testSettingJob() {
        Assert.assertFalse(test_Job1.equals(test_Job2));
    }

    @Test
    public void testSettingJobId() {
        Assert.assertFalse(Objects.equals(test_Job1.getId(), test_Job2.getId()));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        test_Job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertTrue(test_Job3.getId() instanceof Integer);
        Assert.assertTrue(test_Job3.getName() instanceof String);
        Assert.assertTrue(test_Job3.getEmployer() instanceof Employer);
        Assert.assertTrue(test_Job3.getLocation() instanceof Location);
        Assert.assertTrue(test_Job3.getPositionType() instanceof PositionType);
        Assert.assertTrue(test_Job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void blankLineBeforeJob() {
        Assert.assertTrue(test_Job1.toString().startsWith("\n"));
    }

    @Test
    public void blankLineAfterJob() {
        Assert.assertTrue(test_Job1.toString().endsWith("\n"));
    }

    @Test
    public void formatJobFieldsOnSeparateLine() {
        Assert.assertEquals("\nID: 14\nName: Name\nEmployer: Employer\nLocation: Location\nPosition Type: PositionType\nCore Competency: CoreCompetency\n", test_Job1.toString());
    }

    @Test
    public void ifEmptyShowDataNotAvailable() {
        test_Job4 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertEquals("Data not available.", test_Job4.getEmployer().toString());
    }
}
