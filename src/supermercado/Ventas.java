/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Bryan Lopez Avila
 */
public class Ventas {
    /*
        Creamos las variables donde almacenaremos los datos de entrada, se escogió un Hashmap por la facilidad de almacenar
        valores de key y value,
    */
    private Map contado = new HashMap();
    private Map credito = new HashMap();
    private Map cuotas = new HashMap();
    
    /*
        Variables encargadas de almacenar la información e imprimirla
    */
    float totalContado = 0, totalCredito = 0, totalCuotas = 0, totalCommission = 0;
    int totalVentasC = 0;
    
    /*
    * Función encargada de calcular la comisión de cada venta
    * @param totalAmount El primer parametro recibe el total de la venta
    * @param totalAmount El segundo parametro recibe el tipo de venta
    */
    public float commission(float totalAmount, int type){
        int commision = 5;
        if (type == 2) {
            commision = 3;
        }else if(type == 3){
            commision = 2;
        }
        
        return (totalAmount * commision)/100;
    }
    
    /*
    * Función encargada de almacenar los datos en los hashmap
    * @param totalAmount El primer parametro recibe el total de la venta
    * @param totalAmount El segundo parametro recibe el tipo de venta
    */
    public void addCustom(float totalAmount, int type){
        float commision_all = this.commission(totalAmount, type);
        
        if (type == 1) {
            contado.put(totalAmount, commision_all);
        }else if (type == 2){
            credito.put(totalAmount, commision_all);
        }else {
            cuotas.put(totalAmount, commision_all);
        }
    }
    
    /*
    * Función encargada de realizar todos los procesos de sumas y totales
    */
    public void results(){
        totalVentasC = contado.size();
        float c = 0, cr = 0, co = 0;
        float cm = 0;
        Iterator it;
        
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                it = contado.keySet().iterator();
                while(it.hasNext()){
                    Float key = (Float) it.next();
                    c += key;
                    cm += (Float) contado.get(key);
                }
                this.totalContado = c;
            }else if(i == 1){
                it = credito.keySet().iterator();
                while(it.hasNext()){
                    Float key = (Float) it.next();
                    cr += key;
                    cm += (Float) credito.get(key);
                }
                this.totalCredito = cr;
            }else {
                it = cuotas.keySet().iterator();
                while(it.hasNext()){
                    Float key = (Float) it.next();
                    co += key;
                    cm += (Float) cuotas.get(key);
                }
                this.totalCuotas = co;
            }
        }

        this.totalCommission = cm;
    }
    
    /*
    * Función encargada de Imprimir los datos requeridos
    */
    public void result(){
        System.out.println("Monto total de ventas de contado: " + totalContado);
        System.out.println("Monto total de ventas realizadas por tarjeta de crédito: " + totalCredito);
        System.out.println("Monto total de ventas realizadas a cuotas: " + totalCuotas);
        System.out.println("Número total de ventas realizadas de contados: " + totalVentasC);
        System.out.println("Monto total de todas las comisiones: " + totalCommission);
    }
}
