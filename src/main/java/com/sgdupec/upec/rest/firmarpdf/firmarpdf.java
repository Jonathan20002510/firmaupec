package com.sgdupec.upec.rest.firmarpdf;

import com.sgdupec.upec.rest.modelo.EntradasFirmarpdf;
import com.sgdupec.upec.rest.modelo.SalidasFirmarpdf;
import com.sgdupec.upec.firmarpdf.Funcion_Firmarpdf;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.nio.file.Paths;
import java.util.Base64;


@Path("/Firmarpdf")
public class firmarpdf {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String home() {
        return "Acceso a la firma de documentos. Usa un POST para enviar datos en formato JSON.";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SalidasFirmarpdf getDatos(EntradasFirmarpdf datos) throws Exception {
        // Decodifica los archivos Base64
        byte[] pdfBytes = Base64.getDecoder().decode(datos.getDocumentopdfBase64());
        byte[] p12Bytes = Base64.getDecoder().decode(datos.getArchivop12Base64());
    
        // Guarda los archivos decodificados en rutas temporales
        String pdfFilePath = "C:/Users/Jonathan/Documents/doc/documento.pdf";
        String p12FilePath = "C:/Users/Jonathan/Documents/doc/certificado.p12";
        String signedPdfFilePath = "C:/Users/Jonathan/Documents/doc/documento-signed.pdf"; // Añade esta línea para la ruta del PDF firmado
    
        // Guarda los bytes en archivos
        try {
            java.nio.file.Files.write(Paths.get(pdfFilePath), pdfBytes);
            java.nio.file.Files.write(Paths.get(p12FilePath), p12Bytes);
            
            Funcion_Firmarpdf comprobar = new Funcion_Firmarpdf();
            boolean resultado = comprobar.Invocador(pdfFilePath, p12FilePath, datos.getContrasena(), datos.getPagina(), datos.getH(), datos.getV());
    
            SalidasFirmarpdf salida = new SalidasFirmarpdf();
            if (resultado) {
                // Lee el archivo firmado en Base64
                byte[] signedPdfBytes = java.nio.file.Files.readAllBytes(Paths.get(signedPdfFilePath)); // Cambiado a signedPdfFilePath
                String signedPdfBase64 = Base64.getEncoder().encodeToString(signedPdfBytes);
                salida.setDocFirmadoBase64(signedPdfBase64);
            } else {
                salida.setDocFirmadoBase64(null);
            }
    
            return salida;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al procesar la firma del documento");
        }
    }
}