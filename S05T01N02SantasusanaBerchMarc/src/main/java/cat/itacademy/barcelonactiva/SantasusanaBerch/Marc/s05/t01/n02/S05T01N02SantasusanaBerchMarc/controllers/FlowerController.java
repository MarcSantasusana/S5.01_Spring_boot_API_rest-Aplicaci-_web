package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.controllers;



import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Swagger -> http://localhost:9001/swagger-ui/index.html */

@RestController
@RequestMapping("api/v1/flower")
public class FlowerController {

    private FlowerService flowerService;
    @Autowired
    public FlowerController(FlowerService flowerService)
    {
        this.flowerService = flowerService;
    }

    @GetMapping()
    public String viewHomePage()
    {
        return "Flower home page";
    }

    @PostMapping("/add")
    public ResponseEntity<FlowerDTO> addFlower(@RequestBody FlowerDTO flower)
    {
        flowerService.add(flower);

        return new ResponseEntity(flower, HttpStatus.OK);

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
        return new ResponseEntity("Flower with id " + id + " has been deleted successfully", HttpStatus.OK);

    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlowerDTO> getOneFlower(@PathVariable(name = "id") Integer id)
    {
        FlowerDTO flower = flowerService.getOne(id);

        return new ResponseEntity(flower, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<FlowerDTO> getAllFlowers()
    {
        return flowerService.getAll();
    }
}
