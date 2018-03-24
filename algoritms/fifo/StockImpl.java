package algoritms.fifo;

public class StockImpl implements Stock {
    private Double price;
    private Double salePrice;

    public StockImpl(Double price) {
        super();
        this.price = price;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void accept(VisitorExchange v) {
        v.visit(this);

    }
}
