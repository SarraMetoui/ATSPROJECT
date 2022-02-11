package tn.ats.spring.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.ats.spring.entity.Product;
import tn.ats.spring.entity.Reviews;
import tn.ats.spring.repository.ProductRepository;



@Service
public class ProductService {
       
	@Autowired
	ProductRepository p;
	

    
	  public Product save(Product prod) {
	        return p.save(prod);
	    }
  
	    public void save(List<Product> prod) {
	        p.saveAll(prod);
	    }
	    
	    
	    public List<Product> getAllProduct() {
	    	return (List<Product>) p.findAll();
	    }
	    public Product findProductById(long id) {
	    	return p.findById(id).orElse(new Product());
	    }
//	    
	    
	    public List<Product> findPaginated(int pageNo, int pageSize) {
	    	Pageable paging = PageRequest.of(pageNo, pageSize);
	    	Page<Product> pagedResult =p.findAll(paging);
	    	return pagedResult.toList();
	    }
}
