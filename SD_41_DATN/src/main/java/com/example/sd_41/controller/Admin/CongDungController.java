package com.example.sd_41.controller.Admin;

import com.example.sd_41.model.CongDung;
import com.example.sd_41.repository.SanPham.AllGiayTheThao.CongDungRepository;
import com.example.sd_41.service.admin.CongDungService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/congDung")
public class CongDungController {
    @Autowired
    private CongDungService congDungService;
    @Autowired
    private CongDungRepository congDungRepository;


    @GetMapping()
    public String form(){
        return "CongDung/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "num",defaultValue = "0") Integer num) {
        Page<CongDung> congDungPage = congDungRepository.findAll(PageRequest.of(num,3));
        model.addAttribute("list", congDungPage.getContent());
        model.addAttribute("next",num);
        model.addAttribute("totalPages", congDungPage.getTotalPages());
        return "/CongDung/index";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam("tenCongDung") String tenCongDung, Model model) {
        List<CongDung> searchResults = congDungService.searchByTen(tenCongDung);
        model.addAttribute("list", searchResults);
        return "/CongDung/index";
    }

    @GetMapping("/view-add")
    public String viewadd(Model model){
        model.addAttribute("congDung",new CongDung());
        return "CongDung/view-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("congDung") @Valid CongDung congDung,
                      BindingResult bindingResult,
                      Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("congDung",congDung);
            return "/CongDung/view-add";
        }else {
            congDungService.save(congDung);
            return "redirect:/congDung/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        congDungService.delete(id);
        return "redirect:/congDung/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model){
        CongDung congDung = congDungService.getOne(id);
        model.addAttribute("congDung",congDung);
        return "CongDung/detail";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, CongDung congDung){
        congDungService.save(congDung);
        return "redirect:/congDung/hien-thi";
    }

}

