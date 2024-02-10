package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n03.model.services.impl;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n03.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n03.model.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FlowerServiceImpl implements FlowerService {

    private final WebClient webclient;


    @Autowired
    public FlowerServiceImpl(WebClient.Builder builder)
    {
        this.webclient = builder.baseUrl("http://localhost:9001/api/v1/flower").build();
    }


    @Override
    public FlowerDTO getOne(Integer id) {

      return  webclient.get()
                .uri("/getOne/" + id)
                .retrieve()
                .bodyToMono(FlowerDTO.class)
                .block();

    }


    @Override
    public List<FlowerDTO> getAll() {
        return webclient.get()
                .uri("/getAll")
                .retrieve()
                .bodyToFlux(FlowerDTO.class)
                .collectList()
                .block();
    }

    @Override
    public void add(FlowerDTO flowerDTO) {

        webclient.post()
                .uri("/add")
                .bodyValue(flowerDTO)
                .retrieve()
                .bodyToMono(FlowerDTO.class)
                .block();



    }

    @Override
    public void update(Integer id, String flowerName, String flowerCountry) {

        //FlowerDTO flowerDTO = new FlowerDTO(id, flowerName, flowerCountry);

        webclient.put()
                .uri("/update?id="+id+"&name="+flowerName+"&country="+flowerCountry)
                .retrieve()
                .bodyToMono(FlowerDTO.class)
                .subscribe();
    }

    @Override
    public void delete(Integer id) {

        webclient.delete()
                .uri("/delete/{id}", id)
                .retrieve()
                .bodyToMono(FlowerDTO.class)
                .subscribe();

    }


}
