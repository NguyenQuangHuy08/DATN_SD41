package com.example.sd_41.controller.Admin;

import com.example.sd_41.model.User;

import com.example.sd_41.repository.SanPham.AllGiayTheThao.UserRepository;

import com.example.sd_41.service.admin.UserService;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping()
    public String form(){
        return "User/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "num",defaultValue = "0") Integer num) {
        Page<User> userPage = userRepository.findAll(PageRequest.of(num,3));
        model.addAttribute("list", userPage.getContent());
        model.addAttribute("next",num);
        model.addAttribute("totalPages", userPage.getTotalPages());
        return "/User/index";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam("ten") String ten, Model model) {
        List<User> searchResults = userService.searchByTen(ten);
        model.addAttribute("list", searchResults);
        return "/User/index";
    }
    @GetMapping("/loc")
    public String loc(@RequestParam("trangThai") Integer trangThai, Model model) {
        List<User> searchResults = userService.searchByTrangThai(trangThai);
        model.addAttribute("list", searchResults);
        return "/User/index";
    }

    @GetMapping("/view-add")
    public String viewadd(Model model){
        model.addAttribute("user",new User());
        return "User/view-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("user") @Valid User user,
                      BindingResult bindingResult,
                      Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("user",user);
            return "/User/view-add";
        }else {
            userService.save(user);
            return "redirect:/user/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        userService.delete(id);
        return "redirect:/user/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model){
        User user = userService.getOne(id);
        model.addAttribute("user",user);
        return "User/detail";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id,User user){
        userService.save(user);
        return "redirect:/user/hien-thi";
    }

}
