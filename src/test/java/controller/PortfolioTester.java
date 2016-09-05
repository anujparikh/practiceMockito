package controller;

import model.Stock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.StockService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PortfolioTester {

    private Portfolio portfolio;
    private StockService stockService;

    @Before
    public void setUp() {
        portfolio = new Portfolio();
        stockService = mock(StockService.class);
        portfolio.setStockService(stockService);
    }

    @Test
    public void testMarketValue() {
        List<Stock> stocks = new ArrayList<>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock microsoftStock = new Stock("2", "Microsoft", 100);
        stocks.add(googleStock);
        stocks.add(microsoftStock);

        portfolio.setStocks(stocks);

        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();
        Assert.assertEquals(100500.0, marketValue, 0.1);
    }

}
