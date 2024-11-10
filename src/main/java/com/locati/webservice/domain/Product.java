package com.locati.webservice.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.locati.webservice.domain.enums.ProductType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUCT")
	private Long id;
	
	private String name;
	
	private Double price;
	
	private Integer type;
	
	private Long inStock;
	
	private Long minStock;
	
	@ManyToMany
	@JsonManagedReference
	@JoinTable(name = "PRODUCT_CATEGORY", joinColumns = @JoinColumn(name = "ID_PRODUCT"), inverseJoinColumns = @JoinColumn(name = "ID_CATEGORY"))
	private List<Category> categories = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> itens = new HashSet<>();

	public Product() {}
	
	public Product(Long id, String name, Double price, Integer type, Long inStock, Long minStock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.inStock = inStock;
		this.minStock = minStock;
	}
	
	public Product(Long id, String name, Double price, ProductType type, Long inStock, Long minStock) {
		this(id, name, price, type.getCod(), inStock, minStock);
	}
	
	@JsonIgnore
	public List<Order> getOrders() {
		List<Order> orders = new ArrayList<>();
		
		for (OrderItem item : itens) {
			orders.add(item.getOrder());
		}
		
		return orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public ProductType getType() {
		return ProductType.fromCode(type);
	}

	public void setType(ProductType type) {
		this.type = type.getCod();
	}
	
	public Long getInStock() {
		return inStock;
	}

	public void setInStock(Long inStock) {
		this.inStock = inStock;
	}

	public Long getMinStock() {
		return minStock;
	}

	public void setMinStock(Long minStock) {
		this.minStock = minStock;
	}
	
	public Set<OrderItem> getItens() {
		return itens;
	}
	
	public void setItens(Set<OrderItem> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

}
