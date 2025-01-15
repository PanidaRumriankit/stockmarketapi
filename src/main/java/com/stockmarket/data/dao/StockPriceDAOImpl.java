package com.stockmarket.data.dao;

import com.stockmarket.data.model.StockPrice;
import com.stockmarket.data.dao.StockPriceDAO;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StockPriceDAOImpl implements StockPriceDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(StockPrice stockPrice) {
        em.persist(stockPrice);
    }

    @Override
    public List<StockPrice> findByStockId(int stockId) {
        return em.createQuery("FROM StockPrice WHERE stock_id = :stockId", StockPrice.class)
                .setParameter("stockId", stockId)
                .getResultList();
    }

    @Override
    public StockPrice findByStockIdAndDate(int stockId, String date) {
        return em.createQuery("FROM StockPrice WHERE stock_id = :stockId AND date = :date", StockPrice.class)
                .setParameter("stockId", stockId)
                .setParameter("date", date)
                .getSingleResult();
    }

    @Override
    public void deleteByStockId(int stockId) {
        em.createQuery("DELETE FROM StockPrice WHERE stock_id = :stockId")
                .setParameter("stockId", stockId)
                .executeUpdate();
    }
}
