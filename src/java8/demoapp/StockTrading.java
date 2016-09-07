package java8.demoapp;

import java8.demoapp.model.Person;
import java8.demoapp.model.Stock;
import java8.demoapp.model.TransactionType;
import java8.demoapp.service.PersonService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bharat Savanur on 9/5/2016.
 */
public class StockTrading {

    public static void main(String []args){

        Stock s1 = new Stock("STOCK_A",10,12.10, TransactionType.BUY);
        Stock s2 = new Stock("STOCK_B",8,14.10, TransactionType.BUY);
        Stock s3 = new Stock("STOCK_C",12,8.10, TransactionType.SELL);
        Stock s4 = new Stock("STOCK_A",3,21.10, TransactionType.SELL);
        Stock s5 = new Stock("STOCK_D",11,7.10, TransactionType.BUY);
        Stock s6 = new Stock("STOCK_C",21,21.10, TransactionType.SELL);

        Person p1 = new Person();
        p1.setPersonName("PersonA");
        p1.getStocksTraded().add(s1);
        p1.getStocksTraded().add(s3);
        p1.getStocksTraded().add(s5);

        Person p2 = new Person();
        p2.setPersonName("PersonB");
        p1.getStocksTraded().add(s2);
        p1.getStocksTraded().add(s4);
        p1.getStocksTraded().add(s6);

        PersonService service = new PersonService();
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);

        System.out.println(service.totalTypesOfStocksBeingTraded(personList));



    }
}
