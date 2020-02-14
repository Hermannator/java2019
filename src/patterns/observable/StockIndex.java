package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public class StockIndex implements StockListener {
	private String name;
	private double index;
	List<Stock> stocks;
	public StockIndex(String name, Stock... stocks) {
		this.name = name;
		this.stocks = new ArrayList<>();
		for(Stock stock : stocks) {
			addStock(stock);
		}
	}
	public String getName() {return name;}
	public double getIndex() {return index;}
	public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
		index += newValue - oldValue;
	}
	public void addStock(Stock stock) {
		if(stocks.contains(stock)) {
			return;
		}
		stocks.add(stock);
		stock.addStockListener(this);
		index += stock.getPrice();
	}
	public void removeStock(Stock stock) {
		if(!stocks.contains(stock)) {
			return;
		}
		stocks.remove(stock);
		stock.removeStockListener(this);
		index -= stock.getPrice();
	}
}
