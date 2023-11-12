package com.example.sd_41.controller.Admin;

import com.example.sd_41.model.ChatLieu;

import com.example.sd_41.repository.SanPham.AllGiayTheThao.ChatLieuRepository;
import com.example.sd_41.service.admin.ChatLieuService;
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
@RequestMapping("/chatLieu")
public class ChatLieuController {
    @Autowired
    private ChatLieuService chatLieuService;
    @Autowired
    private ChatLieuRepository chatLieuRepository;


    @GetMapping()
    public String form(){
        return "ChatLieu/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "num",defaultValue = "0") Integer num) {
        Page<ChatLieu> clPage = chatLieuRepository.findAll(PageRequest.of(num,3));
        model.addAttribute("list", clPage.getContent());
        model.addAttribute("next",num);
        model.addAttribute("totalPages", clPage.getTotalPages());
        return "/ChatLieu/index";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam("tenChatLieu") String tenChatLieu, Model model) {
        List<ChatLieu> searchResults = chatLieuService.searchByTen(tenChatLieu);
        model.addAttribute("list", searchResults);
        return "/ChatLieu/index";
    }

    @GetMapping("/view-add")
    public String viewadd(Model model){
        model.addAttribute("chatLieu",new ChatLieu());
        return "ChatLieu/view-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("chatLieu") @Valid ChatLieu chatLieu,
                      BindingResult bindingResult,
                      Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("chatLieu",chatLieu);
            return "/ChatLieu/view-add";
        }else {
            chatLieuService.save(chatLieu);
            return "redirect:/chatLieu/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        chatLieuService.delete(id);
        return "redirect:/chatLieu/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model){
        ChatLieu chatLieu = chatLieuService.getOne(id);
        model.addAttribute("chatLieu",chatLieu);
        return "ChatLieu/detail";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id,ChatLieu chatLieu){
        chatLieuService.save(chatLieu);
        return "redirect:/chatLieu/hien-thi";
    }


}
