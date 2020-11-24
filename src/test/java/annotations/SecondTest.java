package annotations;

import org.testng.annotations.Test;

public class SecondTest {

    @Test(groups = {"firstGroup"})
    public void firstTest() {
        System.out.println("first test " + this.getClass().getName());
    }
    @Test(groups = {"secondGroup"})
    public void secondTest() {
        System.out.println("second test " + this.getClass().getName());
    }
    @Test(dependsOnGroups = {"firstGroup","secondGroup"}, priority = 1)
    public void thirdTest() {
        System.out.println("third test " + this.getClass().getName());
    }
    @Test(priority = 3)
    public void fourthTest() {
        System.out.println("fourth test " + this.getClass().getName());
    }
}
