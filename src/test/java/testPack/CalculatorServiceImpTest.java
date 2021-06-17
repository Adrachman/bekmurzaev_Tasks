package testPack;

import calcLogic.CalculatorServiceImpl;
import calcLogic.IOService;
import org.mockito.InOrder;
import static org.mockito.BDDMockito.given;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

public class CalculatorServiceImpTest {

    private CalculatorServiceImpl calculatorService;
    private IOService ioService;
    private InOrder inOrder;

    @BeforeClass
    void setUp(){
        ioService =mock(IOService.class);
        calculatorService = new CalculatorServiceImpl(ioService);
        inOrder = inOrder(ioService);
    }

    @DataProvider
    public Object[][] testEquals() {
        return new Object[][]{
                {2, 2},
                {-1, 1},
                {4, 4},
                {22,11}
        };
    }
    @DataProvider
    public Object[][] testNegativeEquals() {
        return new Object[][]{
                {20,5, 5}
        };
    }
    @DataProvider
    public Object[][] testNegativeEquals1() {
        return new Object[][]{
                {"", 5}
        };
    }

    @Test(dataProvider = "testEquals")
    public void multiplyTest(int d1, int d2){
        calculatorService.multiply(d1,d2);
        inOrder.verify(ioService,times(1)).out(String.format("%d * %d = %d", d1,d2, d1 * d2));
    }

    @Test(dataProvider = "testEquals")
    public void additionTest(int d1,int d2){
        calculatorService.addition(d1,d2);
        inOrder.verify(ioService,times(1)).out(String.format("%d + %d = %d", d1,d2, d1 + d2));
    }

    @Test(dataProvider = "testEquals")
    public void differenceTest(int d1, int d2){
        calculatorService.difference(d1,d2);
        inOrder.verify(ioService,times(1)).out(String.format("%d - %d = %d", d1,d2, d1 - d2));
    }
    @Test(dataProvider = "testEquals")
    public void divisionTest(int d1,int d2){
        calculatorService.division(d1,d2);
        inOrder.verify(ioService,times(1)).out(String.format("%d / %d = %d", d1,d2, d1 / d2));
    }

    //Negative
    @Test(dataProvider = "testNegativeEquals")
    public void multiplyNegativeTest(int d1, int d2,int d3){
        calculatorService.multiply(d1,d2);
        inOrder.verify(ioService,times(0)).out(String.format("%d * %d = %d", d1,d2, d3));
    }

    @Test(dataProvider = "testNegativeEquals")
    public void additionNegativeTest(int d1, int d2,int d3){
        calculatorService.addition(d1,d2);
        inOrder.verify(ioService,times(0)).out(String.format("%d + %d = %d", d1,d2, d3));
    }

    @Test(dataProvider = "testNegativeEquals")
    public void differenceNegativeTest(int d1, int d2,int d3){
        calculatorService.difference(d1,d2);
        inOrder.verify(ioService,times(0)).out(String.format("%d - %d = %d", d1,d2, d3));
    }
    @Test(dataProvider = "testNegativeEquals")
    public void divisionNegativeTest(int d1, int d2,int d3){
        calculatorService.difference(d1,d2);
        inOrder.verify(ioService,times(0)).out(String.format("%d / %d = %d", d1,d2, d3));
    }


//BoundaryValues
    @Test(dataProvider = "testNegativeEquals1")
    public void multiplyBoundaryValuesTest(Object d1, Object d2) {
        if (given(ioService.readString()).willReturn("") == null) {
            Assert.assertThrows(NumberFormatException.class,()->calculatorService.multiply(d1,d2));
        }
    }
    @Test(dataProvider = "testNegativeEquals1")
    public void additionBoundaryValuesTest(Object d1, Object d2) {
        if (given(ioService.readString()).willReturn("") == null) {
            Assert.assertThrows(NumberFormatException.class,()->calculatorService.addition(d1,d2));
        }
    }
    @Test(dataProvider = "testNegativeEquals1")
    public void divisionBoundaryValuesTest(Object d1, Object d2) {
        if (given(ioService.readString()).willReturn("") == null) {
            Assert.assertThrows(NumberFormatException.class,()->calculatorService.division(d1,d2));
        }
    }
    @Test(dataProvider = "testNegativeEquals1")
    public void differenceBoundaryValuesTest(Object d1, Object d2) {
        if (given(ioService.readString()).willReturn("") == null) {
            Assert.assertThrows(NumberFormatException.class,()->calculatorService.difference(d1,d2));
        }
    }
}
