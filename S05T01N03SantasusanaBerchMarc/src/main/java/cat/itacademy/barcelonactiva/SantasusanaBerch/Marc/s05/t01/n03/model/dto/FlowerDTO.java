package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n03.model.dto;

import java.util.ArrayList;
import java.util.List;

public class FlowerDTO {

    private Integer pk_FlowerID;
    private String flowerName;
    private String flowerCountry;
    private String flowerType;
    private static List<String> EUCountries;

   public FlowerDTO(Integer pk_FlowerID, String flowerName, String flowerCountry )
   {
        this.pk_FlowerID = pk_FlowerID;
        this.flowerName = flowerName;
        this.flowerCountry = flowerCountry;
        initializeEUCountries();
        setFlowerType();

    }

    public FlowerDTO()
    {

    }

    private static void initializeEUCountries()
    {
        EUCountries = new ArrayList<>(List.of("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic",
                "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy",
                "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania",
                "Slovakia", "Slovenia", "Spain", "Sweden"));
    }

    public String getFlowerType() {
        return flowerType;
    }

    public  void setFlowerType()
    {

        boolean exists = EUCountries.stream().anyMatch(element -> element.equals(flowerCountry));

        if(exists)
        {
            this.flowerType = "EU";
        }
        else
        {
            this.flowerType = "No EU";
        }

    }

    public Integer getPk_FlowerID() {
        return pk_FlowerID;
    }

    public void setPk_FlowerID(Integer pk_FlowerID) {
        this.pk_FlowerID = pk_FlowerID;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getFlowerCountry() {
        return flowerCountry;
    }

    public void setFlowerCountry(String flowerCountry) {
        this.flowerCountry = flowerCountry;
    }
}
