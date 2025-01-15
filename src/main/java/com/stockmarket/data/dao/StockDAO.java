package com.stockmarket.data.dao;

import com.stockmarket.data.model.Stock;
import java.util.List;

public interface StockDAO {
    Stock findByTicker(String ticker);
    List<Stock> findAll();
    void save(Stock stock);
    void update(Stock stock);
    void delete(String ticker);
}
