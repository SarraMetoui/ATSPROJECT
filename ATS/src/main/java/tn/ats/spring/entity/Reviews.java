package tn.ats.spring.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;



@Entity
public class Reviews implements Serializable{
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long idreview;
	    private long value;
	    private String content;
        
	    public long getIdreview() {
	        return idreview;
	    }
	    public void setIdreview(long idreview) {
	        this.idreview = idreview;
	    }
	    public long getValue() {
	        return value;
	    }
	    public void setValue(long value) {
	        this.value = value;
	    }
	    public String getContent() {
	        return content;
	    }
	    public void setContent(String content) {
	        this.content = content;
	    }
	    
//	    @Override
//	    public String toString() {
//	        return "Reviews{" +
//	                "value=" + value +
//	                ", content='" + content + '\'' +
//	                '}';
//	    }

	    @JsonIgnore
	    @ManyToOne
	    private Product product;
}
