package lv.venta.services;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IFilteringProduct {

	//public abstract by default
	
	//filter product: price less than X
	ArrayList<Product> filterByPriceLessThan(float priceThreshold) throws Exception;
	
	//filter product: quantity less than X
	ArrayList<Product> filterByQuantityLessThan(int quantityThreshold) throws Exception;
	
	//filter product: sorting
	//TODO asc or desc
	ArrayList<Product> sort();
	
	
}
