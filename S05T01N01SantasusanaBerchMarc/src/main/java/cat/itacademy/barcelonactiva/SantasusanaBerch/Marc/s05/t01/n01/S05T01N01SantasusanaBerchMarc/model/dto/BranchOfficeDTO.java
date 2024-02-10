package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.dto;


import java.util.ArrayList;
import java.util.List;

public class BranchOfficeDTO {


    private Integer pk_BranchOfficeID;
    private String nameBranchOffice;
    private String countryBranchOffice;
    private String typeBranchOffice;

    private static List<String> EUCountries;

    public BranchOfficeDTO(Integer pk_BranchOfficeID, String nameBranchOffice, String countryBranchOffice)
    {
        this.pk_BranchOfficeID = pk_BranchOfficeID;
        this.nameBranchOffice = nameBranchOffice;
        this.countryBranchOffice = countryBranchOffice;
        initializeEUCountries();
        setTypeBranchOffice();

    }

    public BranchOfficeDTO()
    {

    }


    private static void initializeEUCountries()
    {
        EUCountries = new ArrayList<>(List.of("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic",
                "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy",
                "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania",
                "Slovakia", "Slovenia", "Spain", "Sweden"));
    }

    public  void setTypeBranchOffice()
    {

        boolean exists = EUCountries.stream().anyMatch(element -> element.equals(countryBranchOffice));

        if(exists)
        {
            this.typeBranchOffice = "EU";
        }
        else
        {
            this.typeBranchOffice = "No EU";
        }



    }

    public String getTypeBranchOffice() {
        return typeBranchOffice;
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

    public Integer getPk_BranchOfficeID() {
        return pk_BranchOfficeID;
    }

    public void setPk_BranchOfficeID(Integer pk_BranchOfficeID) {
        this.pk_BranchOfficeID = pk_BranchOfficeID;
    }

    @Override
    public String toString()
    {
        return "Id: " + pk_BranchOfficeID + "\n" +
            "Name: " + nameBranchOffice + "\n" +
            "Country: " + countryBranchOffice + "\n" +
            "Type: " + typeBranchOffice + "\n";
    }

}
