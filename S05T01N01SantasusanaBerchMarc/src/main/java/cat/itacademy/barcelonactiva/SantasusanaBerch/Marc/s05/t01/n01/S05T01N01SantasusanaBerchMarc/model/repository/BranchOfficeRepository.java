package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.repository;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.domain.BranchOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchOfficeRepository extends JpaRepository<BranchOffice, Integer> {

    Optional<BranchOffice> findByNameBranchOffice(String name);
}
