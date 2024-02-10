package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n03.model.domain;


public class FlowerEntity {

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
