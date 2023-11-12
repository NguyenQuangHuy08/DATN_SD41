package com.example.sd_41.controller.Admin;

import com.example.sd_41.model.DinhTanGiay;
import com.example.sd_41.repository.SanPham.AllGiayTheThao.DinhTanGiayRepository;
import com.example.sd_41.service.admin.DinhTanGiayService;
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
@RequestMapping("/dinhTanGiay")
public class DinhTanGiayController {
    @Autowired
    private DinhTanGiayService dinhTanGiayService;
    @Autowired
    private DinhTanGiayRepository dinhTanGiayRepository;


    @GetMapping()
    public String form(){
        return "KieuBuoc/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "num",defaultValue = "0") Integer num) {
        Page<DinhTanGiay> dtgPage = dinhTanGiayRepository.findAll(PageRequest.of(num,3));
        model.addAttribute("list", dtgPage.getContent());
        model.addAttribute("next",num);
        model.addAttribute("totalPages", dtgPage.getTotalPages());
        return "/DinhTanGiay/index";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam("tenDinhTanGiay") String tenDinhTanGiay, Model model) {
        List<DinhTanGiay> searchResults = dinhTanGiayService.searchByTen(tenDinhTanGiay);
        model.addAttribute("list", searchResults);
        return "/DinhTanGiay/index";
    }

    @GetMapping("/view-add")
    public String viewadd(Model model){
        model.addAttribute("dinhTanGiay",new DinhTanGiay());
        return "DinhTanGiay/view-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("dinhTanGiay") @Valid DinhTanGiay dinhTanGiay,
                      BindingResult bindingResult,
                      Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("dinhTanGiay",dinhTanGiay);
            return "/DinhTanGiay/view-add";
        }else {
            dinhTanGiayService.save(dinhTanGiay);
            return "redirect:/dinhTanGiay/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        dinhTanGiayService.delete(id);
        return "redirect:/dinhTanGiay/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model){
        DinhTanGiay dinhTanGiay = dinhTanGiayService.getOne(id);
        model.addAttribute("dinhTanGiay",dinhTanGiay);
        return "DinhTanGiay/detail";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, DinhTanGiay dinhTanGiay){
        dinhTanGiayService.save(dinhTanGiay);
        return "redirect:/dinhTanGiay/hien-thi";
    }

}
