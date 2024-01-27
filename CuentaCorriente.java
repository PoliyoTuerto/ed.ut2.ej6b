/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2;

/**
 *
 * @author Anselmo
 */
public class CuentaCorriente {

    private double saldo;
    private static int contador = 0;
    public static final double descubiertoMaximo = 1000;
    public static final double operacionMaxima = 1000;

    private int id;
    private String titular;

    public CuentaCorriente() {
        this("desconocido", 0);
    }

    public CuentaCorriente(String t, double saldo) {
        titular = t;
        this.saldo = saldo;
        this.id = ++contador;
    }

    public CuentaCorriente(double saldo) {
        this("desconocido", saldo);
    }

    public void ingresa(double i) {
        if (i < 0) {
            throw new IllegalArgumentException("El parámetro de ingresar no puede ser negativo");
        }
        if (i > operacionMaxima) {
            throw new IllegalArgumentException("No se puede ingresa más de " + operacionMaxima);
        }
        saldo += i;
    }

    public void extrae(double e) throws IllegalArgumentException {
        if (e < 0) {
            throw new IllegalArgumentException("El parámetro de extraer no puede ser negativo");
        }
        if (e > operacionMaxima) {
            throw new IllegalArgumentException("No se puede extraer más de " + operacionMaxima);
        }

        if (e > saldo + descubiertoMaximo) {
            throw new IllegalArgumentException("No se pùede sacar más de lo que hay");
        } else {
            saldo -= e;
        }
    }

    public boolean estaAlDescubierto() {
        return (saldo < 0);
    }

    public void tranferir(CuentaCorriente destino, double cantidad) {
        
        if (destino==null) {
            throw new IllegalArgumentException("Cuenta corriente es nula");
        }else{
            this.extrae(cantidad);
            destino.ingresa(cantidad);
        }
        

    }

    public String toString() {
        return "Cuenta nº " + id + ", titular: " + titular + ", saldo=" + saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    /**
     * @param aTitular the titular to set
     */
    public void setTitular(String aTitular) {
        titular = aTitular;
    }

}
