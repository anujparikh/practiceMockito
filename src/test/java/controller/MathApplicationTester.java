package controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import service.CalculatorService;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    @InjectMocks
    private MathApplication inputMathApplication = new MathApplication();

    @Mock
    private CalculatorService calculatorService;

    @Test
    public void testAdd() {
        when(calculatorService.add(10.0, 20.0)).thenReturn(30.00);
        Assert.assertEquals(inputMathApplication.add(10.0, 20.0), 30.0, 0);
    }
}
