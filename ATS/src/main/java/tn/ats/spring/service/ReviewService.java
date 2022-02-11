//package tn.ats.spring.service;
//
//import java.util.List;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import tn.ats.spring.entity.Product;
//import tn.ats.spring.entity.Reviews;
//import tn.ats.spring.repository.ProductRepository;
//import tn.ats.spring.repository.ReviewRepository;
//
//
//
//@Service
//public class ReviewService {
//
//	@Autowired
//	ReviewRepository r;
//	   
//	
//	public Reviews save(Reviews rev) {
//       return r.save(rev);
//   }
//
//    public void save2(List<Reviews> rev) {
//        r.saveAll(rev);}
//    
//    public Iterable<Reviews> list() {
//        return r.findAll();
//    }
//}
