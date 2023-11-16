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
        public String form(){
            return "Size/index";
        }

        @GetMapping("/hien-thi")
        public String hienThi(Model model, @RequestParam(name = "num",defaultValue = "0") Integer num) {
            Page<Size> sizePage = sizeRepository.findAll(PageRequest.of(num,3));
            model.addAttribute("list", sizePage.getContent());
            model.addAttribute("next",num);
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
        public String viewadd(Model model){
            model.addAttribute("size",new Size());
            return "Size/view-add";
        }

        @PostMapping("/add")
        public String add(@ModelAttribute("size") @Valid Size size,
                          BindingResult bindingResult,
                          Model model){

            if(bindingResult.hasErrors()){
                model.addAttribute("size",size);
                return "/Size/view-add";
            }else {
                int size1 = Integer.parseInt(size.getSize());

                size.setSize(Integer.toString(size1));
                sizeService.save(size);
                return "redirect:/Size/hien-thi";
            }
        }

        @GetMapping("/delete/{id}")
        public String delete(@PathVariable UUID id){
            sizeService.delete(id);
            return "redirect:/Size/hien-thi";
        }

        @GetMapping("/detail/{id}")
        public String detail(@PathVariable UUID id, Model model){
            Size size = sizeService.getOne(id);
            model.addAttribute("size",size);
            return "Size/detail";
        }

        @PostMapping("/update/{id}")
        public String update(@PathVariable("id") UUID id,Size size){
            sizeService.save(size);
            return "redirect:/Size/hien-thi";
        }

    }
