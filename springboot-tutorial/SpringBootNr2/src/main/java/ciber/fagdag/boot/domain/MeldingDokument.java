package ciber.fagdag.boot.domain;


import java.io.InputStream;

public class MeldingDokument extends Dokument {

    private String multiPartId;
    private String tittel;
    private String mimeType;
    private transient InputStream dokumentStream;

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

    public InputStream getDokumentStream() {
        return dokumentStream;
    }

    public void setDokumentStream(InputStream dokumentStream) {
        this.dokumentStream = dokumentStream;
    }

}
