package ciber.fagdag.boot.domain.multipart;


import java.util.List;

public class Melding {

    private long meldingId;
    private String mottakerId;
    private MeldingDokument hoveddokument;
    private List<MeldingDokument> vedlegg;
    private String guid;

    public long getMeldingId() {
        return meldingId;
    }

    public void setMeldingId(long meldingId) {
        this.meldingId = meldingId;
    }

    public String getMottakerId() {
        return mottakerId;
    }

    public void setMottakerId(String mottakerId) {
        this.mottakerId = mottakerId;
    }

    public MeldingDokument getHoveddokument() {
        return hoveddokument;
    }

    public void setHoveddokument(MeldingDokument hoveddokument) {
        this.hoveddokument = hoveddokument;
    }

    public List<MeldingDokument> getVedlegg() {
        return vedlegg;
    }

    public void setVedlegg(List<MeldingDokument> vedlegg) {
        this.vedlegg = vedlegg;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

}
