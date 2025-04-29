package me.khs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "keyword")
@Getter
@Setter
public class Keyword {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "keyword_id")
	private Long keywordId;
	
	@Column(name = "keyword_name", length = 45, nullable = false)
	private String keywordName;
	
	public Keyword() {}
	
    // toString() 메소드 추가
    @Override
    public String toString() {
        return "Keyword [keywordId=" + keywordId + ", keywordName=" + keywordName + "]";
    }
}
