package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.services;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.dto.FlowerDTO;

import java.util.List;

public interface FlowerService {

    void add(FlowerDTO flowerDTO);
    void update(Integer id, String flowerName, String flowerCountry);
    void delete(Integer id);

    FlowerDTO getOne(Integer id);

    List<FlowerDTO> getAll();
}

