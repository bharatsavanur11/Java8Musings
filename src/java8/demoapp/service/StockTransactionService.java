package java8.demoapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java8.demoapp.model.Person;
import java8.demoapp.model.Stock;
import java8.demoapp.model.TransactionType;

/**
 * Created by Bharat Savanur on 9/5/2016.
 */
public class StockTransactionService {
	
   public static Predicate<? super Stock> stockNamePredicate(String stockName){
		 return stock->stock.getStockName().equals(stockName);
	 }

    public  List<Stock> filterStocks(List<Person> personList, String stockName){
    	List<Stock> filteredStocks = new ArrayList<>();
    	personList.forEach((person)->{
  			filteredStocks.addAll(person.getStocksTraded().stream().filter(stockNamePredicate(stockName)).collect(Collectors.toList()));
    	});
        return filteredStocks;
    }

    public void trade(Person p, String stockName, Integer quantity, Double price, TransactionType transactionType){
            Stock s1 = new Stock(stockName,quantity,price,transactionType);
            p.getStocksTraded().add(s1);
    }
}
