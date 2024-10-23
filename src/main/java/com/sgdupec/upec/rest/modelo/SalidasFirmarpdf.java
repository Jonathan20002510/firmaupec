package com.sgdupec.upec.rest.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SalidasFirmarpdf {
    private String docFirmadoBase64; // Cambiado a Base64
    private String docOriginal; // O puedes mantenerlo si lo necesitas

    public SalidasFirmarpdf() {}

    public String getDocFirmadoBase64() {
        return docFirmadoBase64;
    }

    public void setDocFirmadoBase64(String docFirmadoBase64) {
        this.docFirmadoBase64 = docFirmadoBase64;
    }

    public String getDocOriginal() {
        return docOriginal;
    }

    public void setDocOriginal(String docOriginal) {
        this.docOriginal = docOriginal;
    }
}
