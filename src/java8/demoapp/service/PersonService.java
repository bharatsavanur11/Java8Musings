package java8.demoapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java8.demoapp.model.Person;
import java8.demoapp.model.Stock;
import java8.demoapp.model.TransactionType;

/**
 * Calculates Person specific data manipulations.
 * Created by Bharat Savanur on 9/5/2016.
 */
public class PersonService {

    public Integer totalStocksSold(Person p){
              return p.getStocksTraded().stream()
                                  .filter(filterByTransactionType(TransactionType.SELL))
                                  .map(stock-> stock.getQuantity()).reduce(0,(x1,x2)-> x1+x2 );


    }

	private Predicate<? super Stock> filterByTransactionType(TransactionType type) {
		return stock->stock.getTransType()== type;
	}

    public Double totalValueOfStocksHeld(Person p){
      return  p.getStocksTraded().stream()
                                  .map(stock->stock.getStockPrice()*stock.getQuantity())
                                  .reduce(0.0,(x1,x2)-> x1+x2 );
    }


    public Map<String,Integer> totalTypesOfStocksBeingTraded(List<Person> personList){
       return personList.stream().map(person->person.getStocksTraded())
                  .flatMap(stock->stock.stream())
                  .collect(Collectors.groupingBy(Stock::getStockName,
                            Collectors.summingInt(Stock::getQuantity)));
    }
    
    public Map<String,Double> getTotalValueByPersonName(List<Person> personList){
    	
    	List<CompletableFuture<Double>> allFutures = new ArrayList<>();
    	personList.forEach(person->{
    		CompletableFuture<Double> cfp = CompletableFuture.supplyAsync(()->getValueOfPerson(person));	//Optional thread Pool is recommended.
    		allFutures.add(cfp);
    	});
    	
    	
    	
    	return null;
    }

	private Double getValueOfPerson(Person person) {
		return person.getStocksTraded().stream().mapToDouble(stock->stock.getStockPrice()*stock.getQuantity()).sum();
	}


}
