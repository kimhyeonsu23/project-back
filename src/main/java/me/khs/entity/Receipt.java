package me.khs.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "receipt")
public class Receipt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "receipt_id")
	private Long receiptId;
	
	@Column(nullable = false, length = 45, name = "shop_name")
	private String shopName;
	
	@Column(nullable = false, name = "total_price")
	private int totalPrice = 0;
	
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;
	
	@OneToOne
	@JoinColumn(name = "keywordId", nullable = false)
	private Keyword keyword;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@Column(nullable = false, name = "is_deleted")
	private Boolean isDeleted;
	
	public Receipt() {}
	
	@Override
    public String toString() {
        return " Receipt{ " +
                " receiptId =" + receiptId +
                ", shopName ='" + shopName + '\'' +
                ", totalPrice ='" + totalPrice + '\'' +
                ", userId ='" + (user != null ? user.getUserId() : null) + '\'' +
                ", keywordId =" + (keyword != null ? keyword.getKeywordId() : null) +
                ", date =" + date+
                ", isDeleted " + isDeleted +
                '}';
	}
	
	/*@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Product> product;*/
	

}
