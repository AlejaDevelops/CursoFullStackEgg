/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.Scanner;
/**
 *
 * @author diego
 */
public class CrearUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

try {
            URL dataPersonas = new URL("https://randomuser.me/api/?results=10");//Crea 10 usuarios
//            URLConnection urlCon = dataPersonas.openConnection();
            HttpURLConnection conexion = (HttpURLConnection) dataPersonas.openConnection();
            conexion.setRequestMethod("GET");
            conexion.connect();
            
            int codigoRespuesta = conexion.getResponseCode();
            
            if (codigoRespuesta != 200) {
                System.out.println(codigoRespuesta);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner input = new Scanner(dataPersonas.openStream());

                while (input.hasNext()) {
                    informationString.append(input.nextLine());
                }

                input.close();

                System.out.println(informationString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

