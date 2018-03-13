import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SquareTest {

    @DataProvider(name = "positiveSquareDataProvider")
    public Object[][] positiveSquareData() {
        return new Object[][]{
                {new Double(3.0), new Double(4.0), new Double(5.0), new Double(6)},
                {new Double(8), new Double(15), new Double(17), new Double(60)},
                {new Double(7.9), new Double(12.6), new Double(11.1), new Double(43.32773707453461)},
        };
    }
    @Test(dataProvider = "positiveSquareDataProvider")
    public void positiveSquareTest(Double a, Double b, Double c, Double expected){
        Triangle triangle = new Triangle(a,b,c);
        Assert.assertEquals(triangle.getSquare(), expected);
    }

    @DataProvider(name = "negativeSquareDataProvider")
    public Object[][] negativeSquareData() {
        return new Object[][]{
                {new Double(0.0), new Double(2.0), new Double(2.0)},
                {new Double(2.0), new Double(-2.0), new Double(2.0)},
                {new Double(0.0), new Double(0.0), new Double(0.0)},
                {new Double(-2.0), new Double(-3.0), new Double(-4.0)},
                {new Double(1.0), new Double(2.0), new Double(3.0)},
        };
    }
    @Test(expectedExceptions = Exception.class, dataProvider = "negativeSquareDataProvider")
    public void negativeSquareTest(Double a, Double b, Double c){
        Triangle triangle = new Triangle(a,b,c);
        triangle.getSquare();
    }
}
