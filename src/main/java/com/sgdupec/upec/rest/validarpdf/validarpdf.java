
package com.sgdupec.upec.rest.validarpdf;

import com.sgdupec.upec.rest.certificados.certificados;
import com.sgdupec.upec.rest.modelo.EntradasValidarpdf;
import com.sgdupec.upec.rest.modelo.SalidasValidarpdf;
import com.sgdupec.upec.validarpdf.Funcion_Validarpdf;
import java.security.KeyStoreException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.nio.file.Paths;
import java.util.Base64;

@Path("/Validarpdf")
public class validarpdf {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String home() {
        return "API de validación de PDF está funcionando correctamente. Usa POST para validar un PDF en Base64.";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<SalidasValidarpdf> getDatos(EntradasValidarpdf datos) throws KeyStoreException, Exception {
        System.out.println("Recibiendo documento en Base64...");

        // Decodifica el archivo Base64
        byte[] pdfBytes = Base64.getDecoder().decode(datos.getDocumentoBase64());
        
        // Guarda el archivo decodificado en la ruta temporal
        String pdfFilePath = "C:/Users/Jonathan/Documents/doc/documento-validar.pdf";
        
        try {
            java.nio.file.Files.write(Paths.get(pdfFilePath), pdfBytes);
            
            // Llama a la función que valida el PDF
            Funcion_Validarpdf comprobar = new Funcion_Validarpdf();
            certificados firmas = new certificados();
            firmas.Encerar();
            
            List<SalidasValidarpdf> salida = null;
            
            // Valida el archivo PDF en la ruta temporal
            if (comprobar.Invocador(pdfFilePath)) {
                salida = firmas.getListado();
            }

            return salida;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al procesar la validación del documento");
        }
    }
}
