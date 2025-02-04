package pet.store.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
@Entity
@Data
public class petStore {
	// Fields
	@Id
	@GeneratedValue
	  private int petStoreId;         
	    private String petStoreName;    
	    private String petStoreAddress; 
	    private String petStoreCity;    
	    private String petStoreState;   
	    private String petStoreZip;     
	    private String petStorePhone;   

	    // Relationships
	    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
	    @EqualsAndHashCode.Exclude
	    @ToString.Exclude
	    private Set<employee> employees;  
	    @EqualsAndHashCode.Exclude
	    @ToString.Exclude
	    @ManyToMany(cascade = CascadeType.PERSIST)
	    @JoinTable(name = "pet_store_customer", joinColumns = @JoinColumn(name = "pet_store_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
	    private Set<customer> customers;   
}
