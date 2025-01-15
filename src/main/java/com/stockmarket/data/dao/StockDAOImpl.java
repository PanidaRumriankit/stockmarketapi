package com.stockmarket.data.dao;

import com.stockmarket.data.model.Stock;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StockDAOImpl implements StockDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Stock findByTicker(String ticker) {
        return em.createQuery("FROM Stock WHERE ticker = :ticker", Stock.class)
                 .setParameter("ticker", ticker)
                 .getSingleResult();
    }

    @Override
    public List<Stock> findAll() {
        return em.createQuery("FROM Stock", Stock.class).getResultList();
    }

    @Override
    public void save(Stock stock) {
        em.persist(stock);
    }

    @Override
    public void update(Stock stock) {
        em.merge(stock);
    }

    @Override
    public void delete(String ticker) {
        Stock stock = findByTicker(ticker);
        if (stock != null) {
            em.remove(stock);
        }
    }
}
