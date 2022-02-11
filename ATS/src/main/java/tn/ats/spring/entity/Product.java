package tn.ats.spring.entity;
import javax.persistence.*;


import java.io.Serializable;



@Entity
public class Product implements Serializable {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idproduct;
    private String productName;
    private String description;
    private long price;
    private String category;
    
//    public java.util.List<Reviews> getReviews() {
//		return reviews;
//	}
//	public void setReviews(java.util.List<Reviews> reviews) {
//		this.reviews = reviews;
//	}

	private String imageUrl;
    
    public long getIdproduct() {
        return idproduct;
    }
    public void setIdproduct(long idproduct) {
        this.idproduct = idproduct;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    @Override
    public String toString() {
        return "Produit{" +
                "idproduct=" + idproduct +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
               ", reviews=" + reviews +
                '}';
    }
    
    @OneToMany(mappedBy="product")
    private java.util.List<Reviews> reviews;
}
