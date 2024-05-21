package com.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.Repository.ExpenseRepository;
import com.entites.Expense;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense saveExpense(Expense expense) {
        expense.setCreatedAt(LocalDateTime.now());
        expense.setUpdatedAt(LocalDateTime.now());
        return ((CrudRepository<Expense, Long>) expenseRepository).save(expense);
    }

    public List<Expense> getAllExpenses(Long userId) {
        return expenseRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    public Expense updateExpense1(Long id, Expense updatedExpense) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setCategory(updatedExpense.getCategory());
        expense.setAmount(updatedExpense.getAmount());
        expense.setComments(updatedExpense.getComments());
        expense.setUpdatedAt(LocalDateTime.now());
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

	public Expense updateExpense(Long id, Expense expense) {
		// TODO Auto-generated method stub
		return null;
	}
}

