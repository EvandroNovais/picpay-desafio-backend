package com.eontecnologia.picpaydesafiobackend.transaction;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {
  private final TransactionService transactionService;

  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @PostMapping
  public Transaction createTransaction(@RequestParam Transaction transaction) {
    return transactionService.create(transaction);
  }

  @GetMapping
  public List<Transaction> getTransactions() {
    return transactionService.listTransactions();
  }

}
