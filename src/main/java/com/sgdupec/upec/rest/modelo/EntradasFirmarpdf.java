package com.sgdupec.upec.rest.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EntradasFirmarpdf {
    private String documentopdfBase64; // Cambiado a Base64
    private String archivop12Base64; // Cambiado a Base64
    private String contrasena;
    private int pagina;
    private int h;
    private int v;

    public EntradasFirmarpdf(String documentopdfBase64, String archivop12Base64, String contrasena, int pagina, int ubicacionHorizontal, int ubicacionVertical) {
        this.documentopdfBase64 = documentopdfBase64;
        this.archivop12Base64 = archivop12Base64;
        this.contrasena = contrasena;
        this.pagina = pagina;
        this.h = ubicacionHorizontal;
        this.v = ubicacionVertical;
    }

    public EntradasFirmarpdf() {}

    // Getters y Setters
    public String getDocumentopdfBase64() {
        return documentopdfBase64;
    }

    public void setDocumentopdfBase64(String documentopdfBase64) {
        this.documentopdfBase64 = documentopdfBase64;
    }

    public String getArchivop12Base64() {
        return archivop12Base64;
    }

    public void setArchivop12Base64(String archivop12Base64) {
        this.archivop12Base64 = archivop12Base64;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}
