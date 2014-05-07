package algoritms.fifo;

public class VisitorExchangeImpl implements VisitorExchange{
	private Double result = new Double(0);
	public void visit(Stock s) {
		result += ((StockImpl) s).getPrice() - ((StockImpl) s).getSalePrice();
	}
	public Double getResult() {
		return result;
	}
}
