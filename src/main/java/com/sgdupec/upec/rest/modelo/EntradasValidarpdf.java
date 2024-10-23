
package com.sgdupec.upec.rest.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EntradasValidarpdf {
    private String documentoBase64; // Cambiado a Base64
    
    public EntradasValidarpdf() {}

    public EntradasValidarpdf(String documentoBase64) {
        this.documentoBase64 = documentoBase64;
    }

    public String getDocumentoBase64() {
        return documentoBase64;
    }

    public void setDocumentoBase64(String documentoBase64) {
        this.documentoBase64 = documentoBase64;
    }
}
