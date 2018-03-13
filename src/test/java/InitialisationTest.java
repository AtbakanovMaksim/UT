import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InitialisationTest {

    @DataProvider(name = "initialisationDataProvider")
    public Object[][] initialisationData() {
        return new Object[][]{
                {new Double(2.0), new Double(3.0), new Double(4.0), "", true},
                {new Double(2.2), new Double(3.3), new Double(4.4), "", true},
                {new Double(0.0), new Double(2.0), new Double(2.0), "a<=0", false},     //a=0
                {new Double(-2.0), new Double(2.0), new Double(2.0), "a<=0", false},    //a<0
                {new Double(2.0), new Double(0.0), new Double(2.0), "b<=0", false},     //b=0
                {new Double(2.0), new Double(-2.0), new Double(2.0), "b<=0", false},    //b<0
                {new Double(2.0), new Double(2.0), new Double(0.0), "c<=0", false},     //c=0
                {new Double(2.0), new Double(2.0), new Double(-2.0), "c<=0", false},    //c<0
                {new Double(0.0), new Double(0.0), new Double(0.0), "a<=0", false},     //a=b=c=0
                {new Double(-2.0), new Double(-3.0), new Double(-4.0), "a<=0", false},  //a<0 && b<0 && c<0
                {new Double(1.0), new Double(2.0), new Double(3.0), "a+b<=c", false},   //a+b=c
                {new Double(1.0), new Double(3.0), new Double(2.0), "a+c<=b", false},   //a+c=b
                {new Double(3.0), new Double(1.0), new Double(2.0), "b+c<=a", false},   //b+c=a
                {new Double(1.0), new Double(2.0), new Double(4.0), "a+b<=c", false},   //a+b<c
                {new Double(1.0), new Double(4.0), new Double(2.0), "a+c<=b", false},   //a+c<b
                {new Double(4.0), new Double(1.0), new Double(2.0), "b+c<=a", false},   //b+c<a
        };
    }
    @Test(dataProvider = "initialisationDataProvider")
    public void initialisationTest(Double a, Double b, Double c, String message, boolean isCreatable){
        Triangle triangle = new Triangle(a,b,c);
        Assert.assertEquals(triangle.checkTriangle(), isCreatable);
        Assert.assertEquals(triangle.getMessage(), message);
    }
}
