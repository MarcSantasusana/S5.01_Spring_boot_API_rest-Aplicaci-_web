package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.controllers;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.dto.BranchOfficeDTO;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.services.BranchOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("api/v1/branchOffice")
public class BranchOfficeController {

    private BranchOfficeService branchOfficeService;
    @Autowired
    public BranchOfficeController(BranchOfficeService branchOfficeService)
    {
        this.branchOfficeService = branchOfficeService;
    }

    @GetMapping()
    public String viewHomePage()
    {
        return "/pages/home";
    }

    @PostMapping("/save")
    public String addBranchOffice(@ModelAttribute BranchOfficeDTO branchOfficeDTO)
    {
        branchOfficeService.add(branchOfficeDTO);

        return "redirect:/api/v1/branchOffice/getAll";

    }

    @GetMapping("/add")
    public String getAddPage(Model model)
    {
        BranchOfficeDTO branchOfficeDTO = new BranchOfficeDTO();

        model.addAttribute("title", "Add a new branch office");
        model.addAttribute("newBranchOffice", branchOfficeDTO);

        return "/pages/addBranchOffice";

    }

    @PostMapping("/edit")
    public String updateBranchOffice(@ModelAttribute BranchOfficeDTO branchOfficeDTO)
    {
        Integer id = branchOfficeDTO.getPk_BranchOfficeID();
        String name = branchOfficeDTO.getNameBranchOffice();
        String country = branchOfficeDTO.getCountryBranchOffice();


        branchOfficeService.update(id, name, country);

        return "redirect:/api/v1/branchOffice/getAll";
    }

    @GetMapping("/update")
    public String getUpdatePage(Model model)
    {
        BranchOfficeDTO branchOfficeDTO = new BranchOfficeDTO();

        model.addAttribute("title", "Update one branch office");
        model.addAttribute("updatedBranchOffice", branchOfficeDTO);

        return "/pages/updateBranchOffice";


    }

    @GetMapping("/delete")
    public String getDeletePage(Model model)
    {

        BranchOfficeDTO branchOfficeDTO = new BranchOfficeDTO();

        model.addAttribute("title","Delete one branch office");
        model.addAttribute("branchOffice",branchOfficeDTO);

        return "/pages/deleteBranchOffice";

    }

    @GetMapping("/delete/{id}")
    public String deleteBranchOffice(@PathVariable(name = "id") Integer id)
    {
        branchOfficeService.delete(id);


        return "redirect:/api/v1/branchOffice/getAll";

    }

    @PostMapping("/deleteOne")
    public String getBranchOfficeDelete(@ModelAttribute BranchOfficeDTO branchOfficeDTO)
    {
        Integer id = branchOfficeDTO.getPk_BranchOfficeID();

        return "redirect:/api/v1/branchOffice/delete/" + id;

    }

    @GetMapping("/getOne/{id}")
    public String showBranchOffice(@PathVariable(name = "id") Integer id, Model model)
    {
        BranchOfficeDTO branchOfficeDTO = branchOfficeService.getOne(id);

        model.addAttribute("title", "Get one branch office");
        model.addAttribute("branchOffice", branchOfficeDTO);


            return "/pages/showBranchOffice";


    }

    @PostMapping("/showOne")
    public String getOneBranchOffice(@ModelAttribute BranchOfficeDTO branchOfficeDTO)
    {
        Integer id = branchOfficeDTO.getPk_BranchOfficeID();

        return "redirect:/api/v1/branchOffice/getOne/" + id;

    }

    @GetMapping("/getOne")
    public String getGetOnePage(Model model)
    {
        BranchOfficeDTO branchOfficeDTO = new BranchOfficeDTO();

        model.addAttribute("title", "Get one branch office");
        model.addAttribute("branchOffice", branchOfficeDTO);

        return "/pages/getOneBranchOffice";


    }

    @GetMapping("/getAll")
    public String getAllBranchOffices(Model model)
    {
        List<BranchOfficeDTO> branchOfficeList = branchOfficeService.getAll();

        model.addAttribute("title", "List of all branch offices");
        model.addAttribute("branchOfficeList", branchOfficeList);

        return "/pages/getAllBranchOffices";
    }
}
