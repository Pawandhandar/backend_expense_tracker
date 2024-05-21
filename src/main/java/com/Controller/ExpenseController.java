package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Services.ExpenseService;
import com.entites.Expense;
import com.entites.User;

import jakarta.persistence.Entity;
@Entity
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense, Authentication authentication) {
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        expense.setUser(user);
        return expenseService.saveExpense(expense);
    }

    @GetMapping
    public List<Expense> getAllExpenses(Authentication authentication) {
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        return expenseService.getAllExpenses(user.getId());
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}
