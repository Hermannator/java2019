package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	private List<StockListener> stockListeners;
	private String ticker;
	private double price;
	public Stock(String ticker, double price) {
		stockListeners = new ArrayList<>();
		this.ticker = ticker;
		setPrice(price);
	}
	public String getTicker() {return ticker;}
	public double getPrice() {return price;}
	public void setPrice(double price) {
		if(price <= 0) {
			throw new IllegalArgumentException("Price must be more than 0.");
		}else {
			double 
			oldPrice = this.price;
			this.price = price;
			for(StockListener listener : stockListeners) {
				listener.stockPriceChanged(this,oldPrice,price);
			}
		}
	}
	public void addStockListener(StockListener stockListener) {
		stockListeners.add(stockListener);
	}
	public void removeStockListener(StockListener stockListener) {
		stockListeners.remove(stockListener);
	}
}
