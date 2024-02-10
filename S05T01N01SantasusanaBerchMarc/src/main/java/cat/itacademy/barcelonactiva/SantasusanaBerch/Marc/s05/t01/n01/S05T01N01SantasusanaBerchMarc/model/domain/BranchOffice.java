package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BranchOffice {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer pk_BranchOfficeID;
    private String nameBranchOffice;
    private String countryBranchOffice;

    public BranchOffice(String nameBranchOffice, String countryBranchOffice)
    {
        this.nameBranchOffice = nameBranchOffice;
        this.countryBranchOffice = countryBranchOffice;

    }

    public BranchOffice()
    {

    }

    public String getCountryBranchOffice() {
        return countryBranchOffice;
    }

    public void setCountryBranchOffice(String countryBranchOffice) {
        this.countryBranchOffice = countryBranchOffice;
    }

    public String getNameBranchOffice() {
        return nameBranchOffice;
    }

    public void setNameBranchOffice(String nameBranchOffice) {
        this.nameBranchOffice = nameBranchOffice;
    }

    public void setPk_BranchOfficeID(Integer pk_BranchOfficeID) {
        this.pk_BranchOfficeID = pk_BranchOfficeID;
    }

    public Integer getPk_BranchOfficeID() {
        return pk_BranchOfficeID;
    }
}
