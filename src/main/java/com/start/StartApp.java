package com.start;

import com.logica.Account;

import java.text.ParseException;
import java.util.Date;

public class StartApp {

    public static void main(String[] args) throws ParseException {
        Account cuenta = new Account();
        cuenta.deposito(10000, "01/10/2021");
        cuenta.deposito(20000, "01/10/2021");
        cuenta.deposito(30000, "01/10/2021");
        cuenta.retiro(50000, "12/12/2021");
        cuenta.extractoBancario();
    }

}
