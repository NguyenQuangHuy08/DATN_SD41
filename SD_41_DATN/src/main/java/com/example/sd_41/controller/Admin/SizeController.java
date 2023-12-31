package com.example.sd_41.controller.Admin;

import com.example.sd_41.model.Size;

import com.example.sd_41.repository.SanPham.AllGiayTheThao.SizeRepository;
import com.example.sd_41.service.admin.SizeService;
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

import java.util.UUID;

@Controller
@RequestMapping("/Size")
public class SizeController {

    @Autowired
    private SizeService sizeService;
    @Autowired
    private SizeRepository sizeRepository;


    @GetMapping()
    public String form() {

        return "Size/index";

    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "num", defaultValue = "0") Integer num) {

        Page<Size> sizePage = sizeRepository.findAll(PageRequest.of(num, 3));
        model.addAttribute("list", sizePage.getContent());
        model.addAttribute("next", num);
        model.addAttribute("totalPages", sizePage.getTotalPages());
        return "/Size/index";

    }
//        @GetMapping("/search")
//        public String searchBySize(@RequestParam("size") Integer size, Model model) {
//            List<Size> searchResults = sizeService.searchBySize(size);
//            model.addAttribute("list", searchResults);
//            return "/Size/index";
//        }

    @GetMapping("/view-add")
    public String viewadd(Model model) {

        model.addAttribute("Size", new Size());
        return "Size/view-add";

    }

    @PostMapping("/add")
    public String add(
            @Valid
            @ModelAttribute("Size") Size size,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {

            System.out.println("Size đang bị lỗi hãy check lại dữ liệu");
            model.addAttribute("Size", size);
            return "/Size/view-add";

        } else {

            sizeService.save(size);
            return "redirect:/Size/hien-thi";

        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        sizeService.delete(id);
        return "redirect:/Size/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable UUID id, Model model) {

        Size size = sizeService.getOne(id);
        model.addAttribute("Size", size);
        return "Size/detail";
    }

    @GetMapping("/update/{id}")
    public String showFormEdit(Model model,
                               @PathVariable UUID id){

        model.addAttribute("Size",sizeRepository.findById(id).orElse(null));
        return "Size/detail";

    }



}