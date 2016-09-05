package controller;

import lombok.Data;
import model.Stock;
import service.StockService;

import java.util.List;

@Data
public class Portfolio {
    private StockService stockService;
    private List<Stock> stocks;

    public double getMarketValue() {
        double marketValue = 0.00;
        for (Stock stock : stocks) {
            marketValue += stockService.getPrice(stock) * stock.getQuantity();
        }
        return marketValue;
    }
}
