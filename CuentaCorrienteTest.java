/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class CuentaCorrienteTest {
    
    public CuentaCorrienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ingresa method, of class CuentaCorriente.
     */
    @Test
    public void testIngresa() {
        System.out.println("ingresa");
        double i = 200;
        CuentaCorriente instance = new CuentaCorriente(300);
        double saldoinicial=instance.getSaldo();
        instance.ingresa(i);
        double saldoFinal=instance.getSaldo();
        assertTrue(saldoFinal==saldoinicial+i);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
        @Test
    public void testIngresa2() {
        System.out.println("ingresa");
        double i = -200;
        CuentaCorriente instance = new CuentaCorriente(300);
        double saldoinicial=instance.getSaldo();
        double saldoFinal=0;
        try{
            instance.ingresa(i);
            System.out.println("Por aqui no puede pasar");
        }catch (Exception e){
            System.out.println("Exepcion en ingresa2: " +e.getMessage());
            saldoFinal=instance.getSaldo();
            assertTrue(saldoFinal==saldoinicial);
        }
        saldoFinal=instance.getSaldo();
        assertTrue(saldoFinal==saldoinicial);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of extrae method, of class CuentaCorriente.
     */
    @Test
    public void testExtraeConSaldoSuficiente() {
        System.out.println("extrae");
        double e = 50.0;
        CuentaCorriente instance = new CuentaCorriente(100);
        try {
        instance.extrae(e);
        System.out.println("Extracción exitosa");
    } catch (Exception ex) {
        fail("No se esperaba una excepción: " + ex.getMessage());
    }

    double saldoFinal = instance.getSaldo();
    double saldoEsperado = 50.0; // 100 - 50 = 50 unidades
    assertEquals(saldoEsperado, saldoFinal, 0.01); // Verifica que el saldo sea el esperado
        
        
//        fail("The test case is a prototype.");
    }
    
    @Test
    public void testExtraeConSaldoInsuficiente() {
    System.out.println("extrae");
    double e = 2000.0; // Intenta extraer 100 unidades
    CuentaCorriente instance = new CuentaCorriente(50.0); // Saldo inicial de 50 unidades

    try {
        instance.extrae(e);
        fail("Se esperaba una excepción de saldo insuficiente");
    } catch (Exception ex) {
        System.out.println("Excepción esperada: " + ex.getMessage());
    }

    double saldoFinal = instance.getSaldo();
    double saldoEsperado = 50.0; // El saldo no debería cambiar
    assertEquals(saldoEsperado, saldoFinal, 0.01); // Verifica que el saldo sea el esperado
    }

    /**
     * Test of estaAlDescubierto method, of class CuentaCorriente.
     */
    @Test
    public void testEstaAlDescubierto() {
        System.out.println("estaAlDescubierto");
        CuentaCorriente instance = new CuentaCorriente(-100);// Saldo inicial negativo, cuenta al descubierto
        boolean expResult = true;// Se espera que la cuenta esté al descubierto
        boolean result = instance.estaAlDescubierto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
        @Test
    public void testNoEstaAlDescubierto() {
        System.out.println("estaAlDescubierto");
        CuentaCorriente instance = new CuentaCorriente(500);// Saldo inicial negativo, cuenta al descubierto
        boolean expResult = false;// Se espera que la cuenta esté al descubierto
        boolean result = instance.estaAlDescubierto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of tranferir method, of class CuentaCorriente.
     */
    @Test
    public void testTransferenciaExitosa() {
    System.out.println("transferir");
    CuentaCorriente origen = new CuentaCorriente(1000.0); // Saldo inicial de la cuenta de origen
    CuentaCorriente destino = new CuentaCorriente(0); // Cuenta de destino sin saldo inicial
    double cantidad = 500.0; // Cantidad a transferir

    try {
        origen.tranferir(destino, cantidad);
        System.out.println("Transferencia exitosa");
    } catch (Exception ex) {
        fail("No se esperaba una excepción: " + ex.getMessage());
    }

    // Verificar que el saldo de la cuenta de origen se redujo y el saldo de la cuenta de destino aumentó
    double saldoOrigenFinal = origen.getSaldo();
    double saldoDestinoFinal = destino.getSaldo();
    double saldoOrigenEsperado = 500.0; // 1000 - 500 = 500 unidades
    double saldoDestinoEsperado = 500.0; // Saldo inicial de destino + cantidad transferida
    assertEquals(saldoOrigenEsperado, saldoOrigenFinal, 0.01);
    assertEquals(saldoDestinoEsperado, saldoDestinoFinal, 0.01);
    }
    
    @Test
    public void testTransferenciaConDestinoNulo() {
    System.out.println("transferir");
    CuentaCorriente origen = new CuentaCorriente(1000.0); // Saldo inicial de la cuenta de origen
    CuentaCorriente destino = null; // Destino nulo
    double cantidad = 500.0; // Cantidad a transferir

    try {
        origen.tranferir(destino, cantidad);
        fail("Se esperaba una excepción de destino nulo");
    } catch (IllegalArgumentException ex) {
        System.out.println("Excepción esperada: " + ex.getMessage());
    }

    // Verificar que el saldo de la cuenta de origen no cambió
    double saldoOrigenFinal = origen.getSaldo();
    double saldoOrigenEsperado = 1000.0; // El saldo no debería cambiar
    assertEquals(saldoOrigenEsperado, saldoOrigenFinal, 0.01);
    }
    
    @Test
    public void testTransferenciaConCantidadNegativa() {
    System.out.println("transferir");
    CuentaCorriente origen = new CuentaCorriente(1000.0); // Saldo inicial de la cuenta de origen
    CuentaCorriente destino = new CuentaCorriente(); // Cuenta de destino sin saldo inicial
    double cantidad = -200.0; // Cantidad de transferencia negativa

    try {
        origen.tranferir(destino, cantidad);
        fail("Se esperaba una excepción de cantidad negativa");
    } catch (IllegalArgumentException ex) {
        System.out.println("Excepción esperada: " + ex.getMessage());
    }

    // Verificar que el saldo de la cuenta de origen no cambió
    double saldoOrigenFinal = origen.getSaldo();
    double saldoOrigenEsperado = 1000.0; // El saldo no debería cambiar
    assertEquals(saldoOrigenEsperado, saldoOrigenFinal, 0.01);

    // Verificar que el saldo de la cuenta de destino no cambió
    double saldoDestinoFinal = destino.getSaldo();
    double saldoDestinoEsperado = 0.0; // El saldo inicial no debería cambiar
    assertEquals(saldoDestinoEsperado, saldoDestinoFinal, 0.01);
    }
    /**
     * Test of toString method, of class CuentaCorriente.
     */
    

}
