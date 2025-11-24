package Bancoprueba;

public class Cuenta {

    private int numero;
    private String titular;
    private double saldo;
    private int rol; // nivel jerárquico 1-5
    // constructor

    public Cuenta(int numero, String titular, double saldo, int rol) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.rol = rol;
    }

    // constructor
    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getRol() {
        return rol;
    }

     // metodos set
     //modifican los valores de la cuenrta 
    public void setTitular(String nuevo) {
        this.titular = nuevo;
    }

    public void setSaldo(double s) {
        this.saldo = s;
    }

    public void setRol(int nuevoRol) {
        this.rol = nuevoRol;
    }
     // metodos para depositar y retirar dinero de la cuenta
     // tiene que ser mayor a 0 el monto y va suamndo el saldo 
    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido. Debe ser mayor a 0.");
            return;
        }
        saldo += monto;
    }
     // verifica que haya fondos suficientes para retirar el monto solicitado
     // si esta bien resta el monto del saldo    
     public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido. Debe ser mayor a 0.");
            return false;
        }
        if (monto > saldo) {
            System.out.println("Fondos insuficientes.");
            return false;
        }
        saldo -= monto;
        return true;
    }
     // imoprime los datos de la cuenta con la informacion
    @Override
    public String toString() {
        return "Cuenta { Num=" + numero +
                ", Titular=" + titular +
                ", Saldo=" + saldo +
                ", Rol=" + rol + " }";
    }
}
