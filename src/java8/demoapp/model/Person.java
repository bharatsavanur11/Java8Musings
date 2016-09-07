package java8.demoapp.model;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Bharat Savanur on 9/2/2016.
 */
public class Person {

    String personName;

    String personId;

    List<Stock> stocksTraded = new ArrayList<>();

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public List<Stock> getStocksTraded() {
        return stocksTraded;
    }

    public void setStocksTraded(List<Stock> stocksTraded) {
        this.stocksTraded = stocksTraded;
    }
}
