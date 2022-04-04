/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.ModeloEnLinea;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author david
 */
public enum Comunicacion {
    CONECTAR_PUSH("conectar"), 
    DESCONECTAR_PUSH("desconectar"), 
    NUEVO_ID_CONEXION("nuevo_id_conexion"),
    OBTENER_FICHERO_ASIENTOS("obtener_fichero_asientos"),
    TEST("test"),
    DISTRIBUIR_ASIENTOS("distribuir_asientos"),
    ASIGNAR_ASIENTO("asignar_asiento"),
    DESASIGNAR_ASIENTO("desasignar_asiento"),
    GENERAR_HOJA_VIAJE("generar_hoja_viaje"),
    OBTENER_LISTA_VIAJES("obtener_lista_viajes"),
    OBTENER_ESTADO_ASIENTOS("obtener_estado_asientos"),
    FIN("fin"),
    OK("ok"),
    NOK("nok");
    
    private String simbolo;
    private static final Pattern regExp = 
            Pattern.compile(CONECTAR_PUSH.toString() + "|" +
                    DESCONECTAR_PUSH.toString() + "|" +
                    NUEVO_ID_CONEXION.toString() + "|" +
                    TEST.toString() + "|" + 
                    FIN.toString() + "|" +
                    OK.toString() + "|" + 
                    NOK.toString());
    
    Comunicacion(String simbolo) {
        this.simbolo = simbolo;
    }
    
    public static Comunicacion nueva(Scanner reader) {
        String token = reader.next(regExp);
        
        if(token.equals(CONECTAR_PUSH.toString())) {
            return CONECTAR_PUSH;
        } else if (token.equals(DESCONECTAR_PUSH.toString())) {
            return DESCONECTAR_PUSH;
        } else if (token.equals(NUEVO_ID_CONEXION.toString())) {
            return NUEVO_ID_CONEXION;
        } else if (token.equals(TEST.toString())) {
            return TEST;
        } else if (token.equals(OK.toString())) {
            return OK;
        } else {
            return NOK;
        }
    }
    
    @Override
    public String toString() {
        return simbolo;
    }
}