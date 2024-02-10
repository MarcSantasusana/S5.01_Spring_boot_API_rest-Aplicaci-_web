package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.services.impl;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.domain.BranchOffice;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.dto.BranchOfficeDTO;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.exceptions.BranchOfficeAlreadyExistsException;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.exceptions.BranchOfficeNotFoundException;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.repository.BranchOfficeRepository;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.services.BranchOfficeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class BranchOfficeServiceImpl implements BranchOfficeService {

    private BranchOfficeRepository branchOfficeRepository;

    @Autowired
    public BranchOfficeServiceImpl(BranchOfficeRepository branchOfficeRepository)
    {
        this.branchOfficeRepository = branchOfficeRepository;

    }


    @Override
    public void add(BranchOfficeDTO branchOfficeDTO) {

        String name = branchOfficeDTO.getNameBranchOffice();
        String country = branchOfficeDTO.getCountryBranchOffice();

        if(branchOfficeRepository.findByNameBranchOffice(name).isPresent())
        {
            throw new BranchOfficeAlreadyExistsException("Branch office with name " + name + " already exists");
        }

        BranchOffice branchOffice = new BranchOffice(name, country);

        this.branchOfficeRepository.save(branchOffice);

    }

    @Override
    @Transactional
    public void update(Integer id, String nameBranchOffice, String countryBranchOffice) {

     BranchOffice branchOffice = branchOfficeRepository.findById(id)
              .orElseThrow(()-> new BranchOfficeNotFoundException("Branch office with id " + id + " is not found"));   ;


        if(nameBranchOffice != null && !nameBranchOffice.isEmpty())
        {
            if(branchOfficeRepository.findByNameBranchOffice(nameBranchOffice).isPresent())
            {
                throw new BranchOfficeAlreadyExistsException("Branch office with name " + nameBranchOffice + " already exists");

            }

            branchOffice.setNameBranchOffice(nameBranchOffice);

        }

        if(countryBranchOffice != null && !countryBranchOffice.isEmpty())
        {
           branchOffice.setCountryBranchOffice(countryBranchOffice);
        }

    }

    @Override
    public void delete(Integer id) {


        if(!branchOfficeRepository.existsById(id))
        {
            throw new BranchOfficeNotFoundException("Branch office with id " + id + " is not found");
        }


        this.branchOfficeRepository.deleteById(id);

    }

    @Override
    public BranchOfficeDTO getOne(Integer id) {

        return branchOfficeRepository.findById(id)
                .map(branchOffice -> new BranchOfficeDTO(branchOffice.getPk_BranchOfficeID(),
                        branchOffice.getNameBranchOffice(),
                        branchOffice.getCountryBranchOffice()
                ))
                .orElseThrow(()-> new BranchOfficeNotFoundException("Branch office with id " + id + " is not found"));
    }

    @Override
    public List<BranchOfficeDTO> getAll() {
        return branchOfficeRepository.findAll()
                .stream()
                .map(branchOffice -> new BranchOfficeDTO(branchOffice.getPk_BranchOfficeID(),
                        branchOffice.getNameBranchOffice(),
                        branchOffice.getCountryBranchOffice()
                        ) ).collect(Collectors.toList());
    }
}
