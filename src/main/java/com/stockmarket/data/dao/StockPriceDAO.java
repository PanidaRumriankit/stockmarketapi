package com.stockmarket.data.dao;

import com.stockmarket.data.model.StockPrice;
import java.util.List;

public interface StockPriceDAO {
    void save(StockPrice stockPrice);
    List<StockPrice> findByStockId(int stockId);
    StockPrice findByStockIdAndDate(int stockId, String date);
    void deleteByStockId(int stockId);
}
