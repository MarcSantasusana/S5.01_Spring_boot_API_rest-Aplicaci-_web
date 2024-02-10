package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.services.impl;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.exceptions.FlowerAlreadyExistsException;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.exceptions.FlowerNotFoundException;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.repository.FlowerRepository;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.services.FlowerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlowerServiceImpl implements FlowerService {

    private FlowerRepository flowerRepository;

    @Autowired
    public FlowerServiceImpl(FlowerRepository flowerRepository)
    {
        this.flowerRepository= flowerRepository;

    }


    @Override
    public void add(FlowerDTO flowerDTO) {

        String name = flowerDTO.getFlowerName();
        String country = flowerDTO.getFlowerCountry();

        if(flowerRepository.findByFlowerName(name).isPresent())
        {
            throw new FlowerAlreadyExistsException("Branch office with name " + name + " already exists");
        }

        FlowerEntity branchOffice = new FlowerEntity(name, country);

        this.flowerRepository.save(branchOffice);

    }

    @Override
    @Transactional
    public void update(Integer id, String nameBranchOffice, String countryBranchOffice) {

        FlowerEntity branchOffice = flowerRepository.findById(id)
                .orElseThrow(()-> new FlowerNotFoundException("Branch office with id " + id + " is not found"));   ;


        if(nameBranchOffice != null && !nameBranchOffice.isEmpty())
        {
            if(flowerRepository.findByFlowerName(nameBranchOffice).isPresent())
            {
                throw new FlowerAlreadyExistsException("Branch office with name " + nameBranchOffice + " already exists");

            }

            branchOffice.setFlowerName(nameBranchOffice);

        }

        if(countryBranchOffice != null && !countryBranchOffice.isEmpty())
        {
            branchOffice.setFlowerCountry(countryBranchOffice);
        }

    }

    @Override
    public void delete(Integer id) {


        if(!flowerRepository.existsById(id))
        {
            throw new FlowerNotFoundException("Branch office with id " + id + " is not found");
        }


        this.flowerRepository.deleteById(id);

    }

    @Override
    public FlowerDTO getOne(Integer id) {

        return flowerRepository.findById(id)
                .map(flowerEntity -> new FlowerDTO(flowerEntity.getPk_FlowerID(),
                       flowerEntity.getFlowerName(),
                        flowerEntity.getFlowerCountry()
                ))
                .orElseThrow(()-> new FlowerNotFoundException("Branch office with id " + id + " is not found"));
    }

    @Override
    public List<FlowerDTO> getAll() {
        return flowerRepository.findAll()
                .stream()
                .map(flowerEntity -> new FlowerDTO(flowerEntity.getPk_FlowerID(),
                        flowerEntity.getFlowerName(),
                        flowerEntity.getFlowerCountry()
                ) ).collect(Collectors.toList());
    }
}
