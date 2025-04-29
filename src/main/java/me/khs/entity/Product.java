package me.khs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@ManyToOne
	@JoinColumn(name = "receiptId", nullable = false)
	private Receipt receipt;
	
	@Column(nullable = false, name = "product_price")
	private int productPrice = 0;
	
	@Column(nullable = false, length = 50, name = "product_name")
	private String productName;
	
	public Product() {}
	
	public String toString() {
        return " Product{ " +
                " productId =" + productId +
                ", receiptId ='" + (receipt != null ? receipt.getReceiptId() : null) + '\'' +
                ", productPrice ='" + productPrice + '\'' +
                ", productName = " + productName +
                '}';
	}
	
}
