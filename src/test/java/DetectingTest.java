import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DetectingTest {

    @DataProvider(name = "ordynaryDataProvider")
    public Object[][] ordynaryData() {
        return new Object[][]{
                {new Double(3.0), new Double(4.0), new Double(6.0), new Integer(4)},
                {new Double(10.2), new Double(14.8), new Double(21.1), new Integer(4)},
                {new Double(135.7), new Double(77.0), new Double(142.4), new Integer(4)},
        };
    }
    @Test(dataProvider = "ordynaryDataProvider")
    public void ordynaryTest(Double a, Double b, Double c, Integer expected){
        Triangle triangle = new Triangle(a,b,c);
        Assert.assertEquals(triangle.detectTriangle(), (int)expected);
    }

    @DataProvider(name = "equilateralDataProvider")
    public Object[][] equilateralData() {
        return new Object[][]{
                {new Double(1.0), new Double(1.0), new Double(1.0), new Integer(1)},        //ожидается [1] т.к. раносторонний треугольник всегда ранобедренный. Комбинация признаков не требуется.
                {new Double(20.0), new Double(20.0), new Double(20.0), new Integer(1)},
                {new Double(100.0), new Double(100.0), new Double(100.0), new Integer(1)},
        };
    }
    @Test(dataProvider = "equilateralDataProvider")
    public void equilateralTest(Double a, Double b, Double c, Integer expected){
        Triangle triangle = new Triangle(a,b,c);
        Assert.assertEquals(triangle.detectTriangle(), (int)expected);
    }

    @DataProvider(name = "isoscelesDataProvider")
    public Object[][] isoscelesData() {
        return new Object[][]{
                {new Double(3.0), new Double(3.0), new Double(4.0), new Integer(2)},
                {new Double(3.0), new Double(4.0), new Double(3.0), new Integer(2)},
                {new Double(4.0), new Double(3.0), new Double(3.0), new Integer(2)},
        };
    }
    @Test(dataProvider = "isoscelesDataProvider")
    public void isoscelesTest(Double a, Double b, Double c, Integer expected){
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.detectTriangle(), (int)expected);
    }

    @DataProvider(name = "rectangularDataProvider")
    public Object[][] rectangularData() {
        return new Object[][]{
                {new Double(3.0), new Double(4.0), new Double(5.0), new Integer(8)},
                {new Double(4.0), new Double(5.0), new Double(3.0), new Integer(8)},
                {new Double(5.0), new Double(4.0), new Double(3.0), new Integer(8)},
        };
    }
    @Test(dataProvider = "rectangularDataProvider")
    public void rectangularTest(Double a, Double b, Double c, Integer expected){
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.detectTriangle(), (int)expected);
    }

    @DataProvider(name = "combinedDataProvider")
    public Object[][] combinedData() {
        return new Object[][]{
                {new Double(1.3), new Integer(10)},
                {new Double(4.6), new Integer(10)},
                {new Double(18.9), new Integer(10)},
        };
    }
    @Test(dataProvider = "combinedDataProvider")
    public void combinedTest(Double a,  Integer expected){
        Triangle triangle = new Triangle(a, a, Math.sqrt(2*a*a));
        Assert.assertEquals(triangle.detectTriangle(), (int)expected);
    }
}
