package tn.ats.spring.repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.ats.spring.entity.Product;


@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
   
}
