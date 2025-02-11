package modelo;

public class Stock {

	private String company;
	private String description;
	private double initialPrice;
	private double price2002;
	private double price2007;
	private String symbol;
	
	public Stock() { 
		
	}

	public Stock(String company, String description, double initialPrice, double price2002, double price2007,
			String symbol) {
		this.company = company;
		this.description = description;
		this.initialPrice = initialPrice;
		this.price2002 = price2002;
		this.price2007 = price2007;
		this.symbol = symbol;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}

	public double getPrice2002() {
		return price2002;
	}

	public void setPrice2002(double price2002) {
		this.price2002 = price2002;
	}

	public double getPrice2007() {
		return price2007;
	}

	public void setPrice2007(double price2007) {
		this.price2007 = price2007;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "Stock [company=" + company + ", description=" + description + ", initialPrice=" + initialPrice
				+ ", price2002=" + price2002 + ", price2007=" + price2007 + ", symbol=" + symbol + "]";
	}

}
