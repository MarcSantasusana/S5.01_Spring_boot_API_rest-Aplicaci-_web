package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n03.controllers;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n03.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n03.model.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("api/v1/flower")
public class FlowerController {

    private FlowerService flowerService;
    private WebClient.Builder webClientBuilder;

    @Autowired
    public FlowerController(FlowerService flowerService, WebClient.Builder webClientBuilder)
    {
        this.flowerService = flowerService;
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping()
    public String viewHomePage()
    {
        return "Flower home page";
    }



    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlowerDTO> getOneFlower(@PathVariable(name = "id") Integer id)
    {
        FlowerDTO flower = flowerService.getOne(id);

        return new ResponseEntity(flower, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<FlowerDTO> getAllFlowers()
    {
        List<FlowerDTO> flowerList = flowerService.getAll();

        return new ResponseEntity(flowerList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<FlowerDTO> addFlower(@RequestBody FlowerDTO flower)
    {
        flowerService.add(flower);

        return new ResponseEntity("A new flower has been added successfully", HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<FlowerDTO> updateFlower(@RequestParam Integer id,
                                                  @RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String country)
    {


        flowerService.update(id, name, country);
        return new ResponseEntity("Flower with id " + id + " has been updated successfully", HttpStatus.OK);


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FlowerDTO> deleteFlower(@PathVariable(name = "id") Integer id)
    {

       flowerService.delete(id);
        return new ResponseEntity("Flower with id: " + id + " has been deleted successfully", HttpStatus.OK);

    }

}