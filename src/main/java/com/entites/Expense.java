package com.entites;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private Double amount;
    private String comments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Expense(Long id, String category, Double amount, String comments, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.category = category;
		this.amount = amount;
		this.comments = comments;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Expense [id=" + id + ", category=" + category + ", amount=" + amount + ", comments=" + comments + "]";
	}
	public void setUser(User user) {
		// TODO Auto-generated method stub
		
	}

    // getters and setters
    
    
}

