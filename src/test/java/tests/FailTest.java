package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailTest {
    @Test(enabled = false)
    public void shouldFail() {
        Assert.assertEquals(5, 3);
    }
}
