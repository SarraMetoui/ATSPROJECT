package tn.ats.spring.controllers;
import java.io.FileReader;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import tn.ats.spring.entity.Reviews;

import tn.ats.spring.entity.Product;
import tn.ats.spring.repository.ProductRepository;
import tn.ats.spring.service.ProductService;
//import tn.ats.spring.service.ReviewService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ProductController {

	
	    @Autowired
	    ProductService p;

	    @Autowired
	    ProductRepository pr;
//	    
//	    @Autowired
//	    ReviewService r ;
	    
	   
	    
	    
	    @GetMapping("/products")
	    public ResponseEntity<List<Product>> getProducts(){
	        List<Product> products = p.getAllProduct();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }
	    
	    
	    
	    
	    @GetMapping("products/{id}")
	    public Product getProducttById(@PathVariable("id") String id){
	        return p.findProductById(Long.valueOf(id));
	    }
	    
	    @PostMapping("save")
	    public Product save(@RequestBody Product product){
	        return p.save(product);
	    }
	    
	    @GetMapping("fill")
	 public void add() throws IOException, ParseException{

		JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\User\\Documents\\workspace-sts-3.8.4.RELEASE\\ATS\\src\\main\\java\\tn\\ats\\spring\\jsonfiles\\url.json");
	    Object obj = jsonparser.parse(reader);
	    JSONObject empjsonobj= (JSONObject) obj;
	    JSONArray products = (JSONArray)empjsonobj.get("products");
	    Iterator<JSONObject> iterator = products.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            }
        
        for (int i=0;i<(products.size());i++){
            Product product = new Product();

            JSONObject jobjt = (JSONObject) products.get(i);
            String productName = jobjt.get("productName").toString();
            String description = jobjt.get("description").toString();
            long price = (long) jobjt.get("price");
            String category = jobjt.get("category").toString();
            String imageUrl = jobjt.get("imageUrl").toString();
            
//             JSONArray reviews = (JSONArray)jobjt.get("reviews");
////            
//            for (int j=0;j<(reviews.size());j++){
//               Reviews review = new Reviews();
//               JSONObject json = (JSONObject) reviews.get(j);
//              long value = (long)json.get("value");
//              String content = json.get("content").toString(); 
//              review.setValue(value);
//              review.setContent(content);
//              
//           }
  
            
            product.setProductName(productName);
            product.setPrice(price);
            product.setImageUrl(imageUrl);
            product.setDescription(description);
            product.setCategory(category);
           
//            product.setReviews(reviews);
            
            p.save(product);
            
            }
        
	}
	   
@GetMapping("/products/{pageNo}/{pageSize}") 
public List<Product> getPaginated(@PathVariable int pageNo, @PathVariable int pageSize)
{return p.findPaginated(pageNo, pageSize);
}
	
}
