package com.stockmarket.data.service;

import com.stockmarket.data.model.Stock;
import com.stockmarket.data.dao.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockDAO stockDAO;

    public Stock findStockByTicker(String ticker) {
        return stockDAO.findByTicker(ticker);
    }

    public List<Stock> getAllStocks() {
        return stockDAO.findAll();
    }

    public void saveStock(Stock stock) {
        stockDAO.save(stock);
    }
}
