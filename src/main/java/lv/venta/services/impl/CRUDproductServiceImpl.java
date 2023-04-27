package lv.venta.services.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.services.ICRUDProductService;

@Service
public class CRUDproductServiceImpl implements ICRUDProductService{

	
	private ArrayList<Product> allProducts = new ArrayList<>(Arrays.asList(
			new Product("Watermelon", "Pink", 1.23f, 4),
			new Product("Tomato", "Red", 0.99f, 3),
			new Product("Grapes", "Purple", 12.3f, 4)
			));
	
	@Override
	public void addNewProduct(String title, String description, float price, int quantity) throws Exception {
		//TODO verification with regex title and description
		if(title!=null && description!=null && price>0 &&
				price < 10000 && quantity > 0 && quantity < 100000) {
			boolean isFound = false;
			for(Product temp: allProducts) {
				if(temp.getTitle().equals(title) && temp.getDescription().equals(description)
						&& temp.getPrice()==price) {
					temp.setQuantity(temp.getQuantity() + quantity);
					isFound = true;
					break;
				}
			}
			if(!isFound) {
				Product newProduct = new Product(title, description, price, quantity);
				allProducts.add(newProduct);
			}
			
		}
		else
		{
			throw new Exception("Incorrect params");
		}
		
	}

	@Override
	public ArrayList<Product> retrieveAllProducts() {
		return allProducts;
	}

	@Override
	public Product retrieveProductById(long id) throws Exception {
		if(id > 0) {
			for(Product temp: allProducts) {
				if(temp.getId() == id) {
					return temp;
				}
			}
			throw new Exception("There is not product with this ID");
		}
		else
		{
			throw new Exception("ID need to be positive");
		}
	}

	@Override
	public void updateById(long id, String title, String description, float price, int quantity) throws Exception {
		if(id > 0) {
			if(title!=null && description!=null && price>0 &&
					price < 10000 && quantity >= 0 && quantity < 100000) {
				
				boolean isFound = false;
				for(Product temp: allProducts) {
					if(temp.getId()==id) {
						temp.setTitle(title);
						temp.setDescription(description);
						temp.setPrice(price);
						temp.setQuantity(quantity);
						isFound = true;
						break;
					}
				}
				if(!isFound) {
					throw new Exception("There is not product with this ID");
				}
				
				
			}
			else
			{
				throw new Exception("Incorrect params");
			}
		}
		else
		{
			throw new Exception("ID need to be positive");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		
		Product deletedProduct = retrieveProductById(id);
		allProducts.remove(deletedProduct);
		
		
	}

}