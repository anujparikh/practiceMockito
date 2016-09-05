package controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import service.CalculatorService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    @InjectMocks
    private MathApplication inputMathApplication = new MathApplication();

    @Mock
    private CalculatorService calculatorService;

    @Test
    public void testAdd() {
        when(calculatorService.add(10.0, 20.0)).thenReturn(30.00);
        when(calculatorService.subtract(20.0,10.0)).thenReturn(10.00);
        Assert.assertEquals(inputMathApplication.add(10.0, 20.0), 30.0, 0);
        Assert.assertEquals(inputMathApplication.add(10.0, 20.0), 30.0, 0);
        Assert.assertEquals(inputMathApplication.add(10.0, 20.0), 30.0, 0);
        Assert.assertEquals(inputMathApplication.subtract(20.0, 10.0),10.0,0.0);
        verify(calculatorService, atLeastOnce()).subtract(20.0, 10.0);
        verify(calculatorService, atLeast(2)).add(10.0, 20.0);
        verify(calculatorService, atMost(3)).add(10.0, 20.0);
        verify(calculatorService, never()).multiply(1.0, 2.0);
    }

    @Test
    public void testAddUsingBDD() {
        //given
        given(calculatorService.add(20.0, 10.0)).willReturn(30.0);

        //when
        double result = calculatorService.add(20.0, 10.0);

        //then
        Assert.assertEquals(30.0, result, 0);
    }
}
