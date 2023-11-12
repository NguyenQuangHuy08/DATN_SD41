package com.example.sd_41.controller.ChuongTrinhGiamGia.GiamGiaGiayTheThao;

import com.example.sd_41.model.ChuongTrinhGiamGiaGiayTheThao;
import com.example.sd_41.model.ChuongTrinhGiamGiaHoaDon;
import com.example.sd_41.repository.HoaDon.ChuongTrinhGiamGia.ChuongTrinhGiamGiaGiayTheThaoRepository;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "ChuongTrinhGiamGiaGiayTheThao")
public class ChuongTrinhGiamGiaGiayTheThaoController {

    @Autowired
    ServletContext context;

    @Autowired
    private ChuongTrinhGiamGiaGiayTheThaoRepository chuongTrinhGiamGiaGiayTheThaoRepository;


    //Todo code list
    @GetMapping("list")
    public String showList(Model model,
                           @RequestParam(name = "pageNum" , required = false, defaultValue = "1") Integer pageNum,
                           @RequestParam(name = "pageSize" , required = false , defaultValue = "6") Integer pageSize
                         ){

        List<ChuongTrinhGiamGiaGiayTheThao> lstSP = chuongTrinhGiamGiaGiayTheThaoRepository.findAll();
        model.addAttribute("lstSP",lstSP);

        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        Page<ChuongTrinhGiamGiaGiayTheThao> page = chuongTrinhGiamGiaGiayTheThaoRepository.findAll(pageable);

        model.addAttribute("totalPage",page.getTotalPages());
        model.addAttribute("listPage",page.getContent());

        return "/ChuongTrinhGiamGia/ChuongTrinhGiamGiaGiayTheThao/list";

    }

    //Todo code create

    @GetMapping("create")
    public String showCreate(Model model){

        model.addAttribute("chuongTrinhGiamGiaGiayTheThao", new ChuongTrinhGiamGiaGiayTheThao());
        return "/ChuongTrinhGiamGia/ChuongTrinhGiamGiaGiayTheThao/create";

    }

    @PostMapping("create")
    public String saveCreate(Model model,
                             @Valid
                             @ModelAttribute("chuongTrinhGiamGiaGiayTheThao") ChuongTrinhGiamGiaGiayTheThao chuongTrinhGiamGiaGiayTheThao,
                             BindingResult result,
                             RedirectAttributes attributes
                            ){

        if(result.hasErrors()){

            return "/ChuongTrinhGiamGia/ChuongTrinhGiamGiaGiayTheThao/create";

        }

        //Check validate

        //Check tên chương trình giảm giá
        if(chuongTrinhGiamGiaGiayTheThao.getTenChuongTrinhGiamGia() == null
                || chuongTrinhGiamGiaGiayTheThao.getTenChuongTrinhGiamGia().isEmpty()
                || chuongTrinhGiamGiaGiayTheThao.getTenChuongTrinhGiamGia().trim().length() ==0){

            model.addAttribute("erCheckTenSanPhamNotTrim","Tên chương trình giảm giá không được để trống!");
            return "/ChuongTrinhGiamGia/ChuongTrinhGiamGiaGiayTheThao/create";

        }

        if (chuongTrinhGiamGiaGiayTheThao.getTenChuongTrinhGiamGia().matches("^\\d.*") ||
                !chuongTrinhGiamGiaGiayTheThao.getTenChuongTrinhGiamGia().matches(".*[a-zA-Z].*")) {
            model.addAttribute("erCheckTenSanPham", "Tên chương trình giảm giá không hợp lệ!, Phải bắt đầu bằng chữ cái đầu tiên!");
            return "/ChuongTrinhGiamGia/ChuongTrinhGiamGiaGiayTheThao/create";
        }

        //Check Phần trăm giảm
        if (chuongTrinhGiamGiaGiayTheThao.getPhanTramGiam() == null
                    || chuongTrinhGiamGiaGiayTheThao.getTenChuongTrinhGiamGia().isEmpty()
                    || chuongTrinhGiamGiaGiayTheThao.getTenChuongTrinhGiamGia().trim().length() == 0) {

                model.addAttribute("erCheckPhanTramGiam", "Phần trăm giảm không được để trống !");
                return "/ChuongTrinhGiamGia/ChuongTrinhGiamGiaGiayTheThao/create";

        }

        try{

            int phanTramGiam = Integer.parseInt(chuongTrinhGiamGiaGiayTheThao.getPhanTramGiam());

            if(phanTramGiam < 5){

                model.addAttribute("erCheckPhanTramGiamNumber","Phần trăm giảm phải lớn hơn hoặc bằng 5");
                return "/ChuongTrinhGiamGia/ChuongTrinhGiamGiaGiayTheThao/create";

            }

        }catch (NumberFormatException e){

             e.printStackTrace();
             model.addAttribute("erCheckPhanTramGiamString","Phần trăm giảm phải là số !");
             return "/ChuongTrinhGiamGia/ChuongTrinhGiamGiaGiayTheThao/create";

        }

        LocalDate ngayBatDau = LocalDate.now();
        LocalDate ngayKetThuc = ngayBatDau.plus(5, ChronoUnit.DAYS);
        LocalDate ngaySua = LocalDate.now();

        String ngayBatDauToDate = ngayBatDau.toString();
        String ngayKetThucToDate = ngayKetThuc.toString();
        String ngaySuaToDate = ngaySua.toString();

        chuongTrinhGiamGiaGiayTheThao.setNgayBatDau(ngayBatDauToDate);
        chuongTrinhGiamGiaGiayTheThao.setNgayKetThuc(ngayKetThucToDate);
        chuongTrinhGiamGiaGiayTheThao.setNgayTao(ngayBatDauToDate);
        chuongTrinhGiamGiaGiayTheThao.setNgaySua(ngaySuaToDate);

        chuongTrinhGiamGiaGiayTheThaoRepository.save(chuongTrinhGiamGiaGiayTheThao);
        attributes.addFlashAttribute("message", "Create chương trình giảm giá giầy thể thao thành công !");

        return "redirect:/ChuongTrinhGiamGiaGiayTheThao/list";

    }

    //Todo code edit
    @GetMapping("edit/{id}")
    public String showEdit(Model model,
                           @PathVariable
                           UUID id){

        ChuongTrinhGiamGiaGiayTheThao chuongTrinhGiamGiaGiayTheThao = chuongTrinhGiamGiaGiayTheThaoRepository.findById(id).orElse(null);

        if(chuongTrinhGiamGiaGiayTheThao == null){

            model.addAttribute("messageFind","Không tìm thấy id có mã: "+id);
            return "/ChuongTrinhGiamGia/ChuongTrinhGiamGiaGiayTheThao/list";

        }

        model.addAttribute("chuongTrinhGiamGiaGiayTheThao", chuongTrinhGiamGiaGiayTheThaoRepository.findById(id).orElse(null));
        return "/ChuongTrinhGiamGia/ChuongTrinhGiamGiaGiayTheThao/edit";

    }



}
