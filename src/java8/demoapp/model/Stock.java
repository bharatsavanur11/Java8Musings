package java8.demoapp.model;

/**
 *
 * Created by Bharat Savanur on 9/4/2016.
 */
public class Stock {

    private String stockName; // assuming this is unique.
    private Double stockPrice;
    private String symbol;
    private Integer quantity;
    private TransactionType transType;

    /**
     *
     * @param stockName
     * @param quantity
     * @param price
     * @param transactionType
     */
    public Stock(String stockName, Integer quantity, Double price, TransactionType transactionType) {
        this.stockName=stockName;
        this.quantity=quantity;
        this.stockPrice=price;
        this.transType=transactionType;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TransactionType getTransType() {
        return transType;
    }

    public void setTransType(TransactionType transType) {
        this.transType = transType;
    }
}
