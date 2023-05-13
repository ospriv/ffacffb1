package com.ospriv.greencode.web;


import com.ospriv.greencode.dto.Account;
import com.ospriv.greencode.dto.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class TransactionsApiController {

    /**
     * POST /transactions/report
     * Execute report
     * <p>
     * http://localhost:8080/transactions/report
     *
     * @param transaction (required)
     * @return Successful operation (status code 200)
     */

    @PostMapping(value = "/transactions/report", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<Account>> report(@RequestBody List<Transaction> transaction) {
        final Map<String, Account> accounts = new HashMap<>();
        Account creditAccount, debitAccount;
        BigDecimal amount;
        for (Transaction t : transaction) {
            debitAccount = computeAccount(t.getDebitAccount(), accounts);
            creditAccount = computeAccount(t.getCreditAccount(), accounts);
            amount = t.getAmount();
            debitAccount.decrease(amount);
            creditAccount.increase(amount);
        }
        List<Account> result =
                accounts.values().stream().sorted(Comparator.comparing(Account::getAccount)).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }



    private Account computeAccount(String accountKey, Map<String, Account> accounts) {
        Account vAccount;
        if ((vAccount = accounts.get(accountKey)) == null) {
            vAccount = new Account(accountKey);
            accounts.put(accountKey, vAccount);
        }
        return vAccount;
    }


}
