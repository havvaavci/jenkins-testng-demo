package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailTest {
    @Test
    public void shouldFail() {
        Assert.assertEquals(5, 3);
    }
}
