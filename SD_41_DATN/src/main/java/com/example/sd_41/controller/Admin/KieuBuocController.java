package com.example.sd_41.controller.Admin;

import com.example.sd_41.model.KieuBuoc;
import com.example.sd_41.repository.SanPham.AllGiayTheThao.KieuBuocRepository;
import com.example.sd_41.service.admin.KieuBuocService;
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
@RequestMapping("/kieuBuoc")
public class KieuBuocController {
    @Autowired
    private KieuBuocService kieuBuocService;
    @Autowired
    private KieuBuocRepository kieuBuocRepository;


    @GetMapping()
    public String form(){
        return "KieuBuoc/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "num",defaultValue = "0") Integer num) {
        Page<KieuBuoc> kieuBuocPage = kieuBuocRepository.findAll(PageRequest.of(num,3));
        model.addAttribute("list", kieuBuocPage.getContent());
        model.addAttribute("next",num);
        model.addAttribute("totalPages", kieuBuocPage.getTotalPages());
        return "/KieuBuoc/index";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam("tenKieuBuoc") String tenKieuBuoc, Model model) {
        List<KieuBuoc> searchResults = kieuBuocService.searchByTen(tenKieuBuoc);
        model.addAttribute("list", searchResults);
        return "/KieuBuoc/index";
    }

    @GetMapping("/view-add")
    public String viewadd(Model model){
        model.addAttribute("kieuBuoc",new KieuBuoc());
        return "KieuBuoc/view-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("kieuBuoc") @Valid KieuBuoc kieuBuoc,
                      BindingResult bindingResult,
                      Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("kieuBuoc",kieuBuoc);
            return "/KieuBuoc/view-add";
        }else {
            kieuBuocService.save(kieuBuoc);
            return "redirect:/kieuBuoc/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        kieuBuocService.delete(id);
        return "redirect:/kieuBuoc/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model){
        KieuBuoc kieuBuoc = kieuBuocService.getOne(id);
        model.addAttribute("kieuBuoc",kieuBuoc);
        return "KieuBuoc/detail";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id,KieuBuoc kieuBuoc){
        kieuBuocService.save(kieuBuoc);
        return "redirect:/kieuBuoc/hien-thi";
    }

}
