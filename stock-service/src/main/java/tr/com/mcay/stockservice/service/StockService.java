package tr.com.mcay.stockservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.mcay.stockservice.model.Stock;
import tr.com.mcay.stockservice.repository.StockRepository;

import java.util.List;

@Service
public class StockService {
    private final StockRepository stockRepository;
    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }
    public Stock updateStock(Stock stock) {
        return stockRepository.save(stock);
    }
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
