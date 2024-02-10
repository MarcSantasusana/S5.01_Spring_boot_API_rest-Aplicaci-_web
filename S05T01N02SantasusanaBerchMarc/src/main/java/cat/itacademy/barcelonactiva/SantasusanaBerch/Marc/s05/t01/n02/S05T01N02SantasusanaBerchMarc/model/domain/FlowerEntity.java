package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class FlowerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer pk_FlowerID;
    private String flowerName;
    private String flowerCountry;

    public FlowerEntity(String flowerName, String flowerCountry)
    {

        this.flowerName = flowerName;
        this.flowerCountry = flowerCountry;


    }

    public FlowerEntity()
    {

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
