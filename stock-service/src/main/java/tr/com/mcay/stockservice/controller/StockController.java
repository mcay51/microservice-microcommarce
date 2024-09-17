package tr.com.mcay.stockservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.mcay.stockservice.model.Stock;
import tr.com.mcay.stockservice.service.StockService;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {
    private final StockService stockService;
    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }
    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }
    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }
    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        stock.setId(id);
        return stockService.updateStock(stock);
    }
    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
}
