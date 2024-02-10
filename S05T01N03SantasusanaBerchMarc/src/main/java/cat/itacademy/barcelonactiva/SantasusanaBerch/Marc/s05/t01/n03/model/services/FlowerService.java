package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n03.model.dto.FlowerDTO;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FlowerService {

    FlowerDTO getOne(Integer id);

    List<FlowerDTO> getAll();

    void add(FlowerDTO flowerDTO);

    void update(Integer id, String flowerName, String flowerCountry);

    void delete(Integer id);

}
