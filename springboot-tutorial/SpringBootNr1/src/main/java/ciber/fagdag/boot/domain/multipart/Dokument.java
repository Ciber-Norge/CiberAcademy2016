package ciber.fagdag.boot.domain.multipart;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Dokument {

    public static final String PDF_MIME_TYPE = "application/pdf";

    private String multiPartId;
    private String tittel;
    private String mimeType;

    @JsonIgnore
    private byte[] bytes;


    public String getMultiPartId() {
        return multiPartId;
    }

    public void setMultiPartId(String multiPartId) {
        this.multiPartId = multiPartId;
    }


    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
