package com.logica;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Account {

    private long saldo = 0;
    private LocalDate fecha;

    ArrayList<Account> mov = new ArrayList<>();

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Account() {
    }


    public void deposito(long monto, String fechaDeposito) {
        Account c = new Account();
        c.setSaldo(monto);
        c.setFecha(formatoFecha(fechaDeposito));
        mov.add(c);
    }

    public void retiro(int montoRetiro, String fechaRetiro){
        if (saldoTotal(montoRetiro) == true)
            deposito(-(montoRetiro), fechaRetiro);
    }

    public void extractoBancario() {
        System.out.println("   Fecha        Movimiento       Balance");
        for(int i = 0; i< mov.size(); i++) {
            this.saldo += mov.get(i).getSaldo();
            System.out.println(mov.get(i).getFecha() + "        " + mov.get(i).getSaldo());
        }
    }


    public LocalDate formatoFecha(String fecha){

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaLocal = LocalDate.parse(fecha,df);
        return fechaLocal;
    }

    private long calcularSaldo(){

        for(int i = 0; i< mov.size(); i++)
            this.saldo += mov.get(i).getSaldo();
        return this.saldo;
    }

    private boolean saldoTotal(long monto){
        long balance = this.saldo - monto;
        if(balance > 0)
            return true;
        return false;
    }
}
