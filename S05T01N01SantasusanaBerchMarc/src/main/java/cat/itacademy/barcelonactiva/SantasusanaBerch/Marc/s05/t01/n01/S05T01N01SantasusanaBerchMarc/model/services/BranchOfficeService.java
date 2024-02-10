package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.services;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.dto.BranchOfficeDTO;

import java.util.List;


public interface BranchOfficeService {

    void add(BranchOfficeDTO branchOfficeDTO);
    void update(Integer id, String nameBranchOffice, String CountryBranchOffice);
    void delete(Integer id);

    BranchOfficeDTO getOne(Integer id);

    List<BranchOfficeDTO> getAll();
}
