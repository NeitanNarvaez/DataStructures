package Banco;

/*
 * Clase Cuenta - modelo básico de una cuenta bancaria
 */
public class Cuenta {
    private int numero;
    private String titular;
    private double saldo;

    public Cuenta(int numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setTitular(String nuevoTitular) {
        this.titular = nuevoTitular;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido.");
            return;
        }
        saldo += monto;
        System.out.println("Depósito realizado. Nuevo saldo: " + saldo);
    }

    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido.");
            return false;
        }
        if (monto > saldo) {
            System.out.println("Fondos insuficientes.");
            return false;
        }
        saldo -= monto;
        System.out.println("Retiro realizado. Nuevo saldo: " + saldo);
        return true;
    }

    @Override
    public String toString() {
        return "Cuenta { Num: " + numero + " | Titular: " + titular + " | Saldo: " + saldo + " }";
    }
}
