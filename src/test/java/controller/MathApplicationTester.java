package controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.CalculatorService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MathApplicationTester {

    private MathApplication inputMathApplication;
    private CalculatorService calculatorService;

    @Before
    public void setUp() {
        inputMathApplication = new MathApplication();
        calculatorService = mock(CalculatorService.class);
        inputMathApplication.setCalcService(calculatorService);
    }

    @Test
    public void testAdd() {
        when(calculatorService.add(10.0, 20.0)).thenReturn(30.00);
        Assert.assertEquals(inputMathApplication.add(10.0, 20.0), 30.0, 0);
    }
}
