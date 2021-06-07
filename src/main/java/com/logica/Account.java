package com.logica;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Account {

    private long saldo;
    private long balanceTotal = 0;
    private LocalDate fecha;

    ArrayList<Account> mov = new ArrayList<>();

    public long obtenerSaldo() {
        return saldo;
    }

    public void recibirSaldo(long saldo) {
        this.saldo = saldo;
    }

    public LocalDate obtenerFecha() {
        return fecha;
    }

    public void definirFechaMovimiento(LocalDate fecha) {
        this.fecha = fecha;
    }

    public long obtenerBalanceTotal() {
        return balanceTotal;
    }

    public void definirBalanceTotal(long balanceTotal) {
        this.balanceTotal = balanceTotal;
    }

    public Account() {
    }

    public void deposito(long monto, String fechaDeposito) {
        Account c = new Account();
        c.recibirSaldo(monto);
        c.definirFechaMovimiento(formatoFecha(fechaDeposito));
        c.definirBalanceTotal(this.balanceTotal+=monto);
        mov.add(c);
    }

    public void retiro(int montoRetiro, String fechaRetiro){
        if (saldoTotal(montoRetiro) == true)
            deposito(-(montoRetiro), fechaRetiro);
    }

    public void extractoBancario() {
        System.out.println("   Fecha        Movimiento       Balance");
        for(int i = 0; i< mov.size(); i++) {
            this.saldo += mov.get(i).obtenerSaldo();
            System.out.println(mov.get(i).obtenerFecha() + "        " + mov.get(i).obtenerSaldo()+"           "+mov.get(i).obtenerBalanceTotal());
        }
    }

    public LocalDate formatoFecha(String fecha){

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaLocal = LocalDate.parse(fecha,df);
        return fechaLocal;
    }

    private boolean saldoTotal(long monto){
        long balance = this.balanceTotal - monto;
        if(balance >= 0)
            return true;
        return false;
    }

}
