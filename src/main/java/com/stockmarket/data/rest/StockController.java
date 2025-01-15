package com.stockmarket.data.rest;

import com.stockmarket.data.model.Stock;
import com.stockmarket.data.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/{ticker}")
    public Stock getStockByTicker(@PathVariable String ticker) {
        return stockService.findStockByTicker(ticker);
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @PostMapping
    public void saveStock(@RequestBody Stock stock) {
        stockService.saveStock(stock);
    }
}
