package com.example.sd_41.controller.Admin.PhieuGiaoHang;

import com.example.sd_41.model.HoaDon;
import com.example.sd_41.model.KhachHang;
import com.example.sd_41.model.PhieuGiaoHang;
import com.example.sd_41.model.User;
import com.example.sd_41.repository.BanHang.HoaDonRepository;
import com.example.sd_41.repository.KhachHangRepository;
import com.example.sd_41.repository.SanPham.AllGiayTheThao.UserRepository;
import com.example.sd_41.repository.BanHang.PhieuGiaoHangRepository;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller

public class PhieuGiaoHangController {

    @Autowired
    ServletContext context;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private PhieuGiaoHangRepository phieuGiaoHangRepository;

    @GetMapping("PhieuGiaoHang/listPhieuGiaoHang")
    public String listShowViewPhieuGiaoHang(Model model,
                                          HttpSession session,
                                          @RequestParam(name = "tab", required = false, defaultValue = "active") String tab,
                                          @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                          @RequestParam(name = "pageSize", required = false, defaultValue = "3") Integer pageSize) {


        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<PhieuGiaoHang> page = phieuGiaoHangRepository.findAll(pageable);

        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listPage", page.getContent());

        List<Integer> pageNumbers = getPageNumbers(page, pageNum);
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("currentPage", pageNum);

        return "/PhieuGiaoHang/list";
    }

    private List<Integer> getPageNumbers(Page<?> page, int currentPage) {
        List<Integer> pageNumbers = new ArrayList<>();
        int totalPages = page.getTotalPages();
        int startPage, endPage;

        if (totalPages <= 5) {
            startPage = 1;
            endPage = totalPages;
        } else {
            if (currentPage <= 2) {
                startPage = 1;
                endPage = 5;
            } else if (currentPage + 2 >= totalPages) {
                startPage = totalPages - 4;
                endPage = totalPages;
            } else {
                startPage = currentPage - 2;
                endPage = currentPage + 2;
            }
        }

        for (int i = startPage; i <= endPage; i++) {
            pageNumbers.add(i);
        }

        return pageNumbers;
    }
    //Todo code create bảng phiếu giao hàng
    private boolean tenPhieuGiaoHangCheckTrung(String tenPhieuGiaoHang){

        for(PhieuGiaoHang phieuGiaoHang: phieuGiaoHangRepository.findAll()){

            if(phieuGiaoHang.getTenNguoiNhan().equalsIgnoreCase(tenPhieuGiaoHang)){

                return true;//Tên phiếu giao hàng đã tồn tại trong list

            }

        }

        return false;
    }
    //Todo code bảng phiếu giao hàng
    @GetMapping("PhieuGiaoHang/create")
    public String createShow(Model model){

        model.addAttribute("phieuGiaoHang",new PhieuGiaoHang());
        return "/PhieuGiaoHang/create";

    }

    @PostMapping(value = "PhieuGiaoHang/create")
    public String createSavePhieuGiaoHang(Model model,
                                        @Valid
                                        @ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                                        BindingResult result,
                                        RedirectAttributes attributes,
                                        HttpSession session

    ){

        if(result.hasErrors()){

            model.addAttribute("viewEr","Lỗi All");
            return "/PhieuGiaoHang/create";

        }

        //Todo code check

        //Check tên sản phẩm trống
        if(phieuGiaoHang.getTenNguoiNhan() == null
                ||  phieuGiaoHang.getTenNguoiNhan().trim().length() ==0
                ||   phieuGiaoHang.getTenNguoiNhan().isEmpty()){

            model.addAttribute("erTenNguoiNhanIsEmty","Tên người nhận không được để trống !");
            return "/PhieuGiaoHang/create";

        }
        //Check tên sản phẩm nhập kí tự số đầu tiên
        if (phieuGiaoHang.getTenNguoiNhan().matches("^\\d.*") ||
                !phieuGiaoHang.getTenNguoiNhan().matches(".*[a-zA-Z].*")) {
            model.addAttribute("erCheckTenNguoiNhanSo", "Tên người nhận không hợp lệ!, Phải bắt đầu bằng chữ cái đầu tiên!");
            return "/PhieuGiaoHang/create";

        }

        Pattern pattern = Pattern.compile("^[^-0-9].*");
        Matcher matcher = pattern.matcher(phieuGiaoHang.getTenNguoiNhan());

        if (!matcher.matches()) {
            model.addAttribute("erCheckTenNguoiNhanSo", "Tên người nhận không hợp lệ!");
            return "/PhieuGiaoHang/create";
        }



        //Check tên sản phẩm trùng
        if(tenPhieuGiaoHangCheckTrung(phieuGiaoHang.getTenNguoiNhan())){

            model.addAttribute("erCheckTenPhieuGiaoHangTrung","Tên phiếu giao hàng đã có trong list !");
            return "/PhieuGiaoHang/create";

        }


        if(phieuGiaoHang.getPhiShip() == null
                || phieuGiaoHang.getPhiShip().trim().length()==0
                || phieuGiaoHang.getPhiShip().isEmpty()){

            model.addAttribute("erCheckPhiShipIsEmtry","Phí Ship phiếu giao hàng không được để trống !");
            return "/PhieuGiaoHang/create";

        }

        String phiShipFormatted = phieuGiaoHang.getPhiShip().replace(",", "").replace(" ", "");

        try {

            int phiShip = Integer.parseInt(phiShipFormatted);

            if(phiShip < 1000){

                model.addAttribute("erCheckPhiShipNumber","Phí Ship không được là số nguyên âm và phải lớn hơn hoặc bằng 1.000 VNĐ");
                return "/PhieuGiaoHang/create";

            }

            phieuGiaoHang.setPhiShip(String.valueOf(phiShip)); // Lưu giá trị đã xử lý vào đối tượng

        } catch (NumberFormatException e) {
            e.printStackTrace();
            model.addAttribute("erCheckPhiShipSoConertString", "Phí Ship phải là số không được là chữ");
            return "/PhieuGiaoHang/create";
        }

        phieuGiaoHang.setTrangThai(0); //là set trạng thái chưa được kích hoạt
        phieuGiaoHangRepository.save(phieuGiaoHang).getId();
        attributes.addFlashAttribute("messageDone","Create phiếu giao hàng thành công !");

        return "redirect:/PhieuGiaoHang/listPhieuGiaoHang";

    }

    //Todo code update lại phiếu giao hàng

    @RequestMapping(value = "PhieuGiaoHang/update/{id}")
    public String showSavePhieuGiaoHang(
            Model model,
            @PathVariable("id") UUID id,
            //id của giầy thể thao
            @RequestParam("phieuGiaoHang")UUID idPhieuGiaoHang //id của phiếu giao hàng
    ){


        model.addAttribute("phieuGiaoHang",phieuGiaoHangRepository.getPhieuGiaoHangById(id));

        return "/PhieuGiaoHang/update";

    }

    //Todo code giầy thể thao chi tiết
    @PostMapping(value = "PhieuGiaoHang/update/{id}")
    public String showSaveUpdatePhieuGiaoHang(Model model,
                                            @ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                                            RedirectAttributes attributes){

        model.addAttribute("viewMessage","Update dữ liệu phiếu giao hàng thành công !");
        //Check validate cho update
        //Check tên sản phẩm trống
        if(phieuGiaoHang.getTenNguoiNhan() == null
                ||  phieuGiaoHang.getTenNguoiNhan().trim().length() ==0
                ||   phieuGiaoHang.getTenNguoiNhan().isEmpty()){

            model.addAttribute("erTenPhieuGiaoHangIsEmty","Tên phiếu giao hàng không được để trống !");
            return "/PhieuGiaoHang/update";

        }
        //Check tên sản phẩm nhập kí tự số đầu tiên
        if (phieuGiaoHang.getTenNguoiNhan().matches("^\\d.*") ||
                !phieuGiaoHang.getTenNguoiNhan().matches(".*[a-zA-Z].*")) {
            model.addAttribute("erCheckTenNguoiNhanSo", "Tên người nhận không hợp lệ!, Phải bắt đầu bằng chữ cái đầu tiên!");
            return "/PhieuGiaoHang/update";

        }
        // Kiểm tra tên giày thể thao trùng trong danh sách, nhưng loại trường hợp cùng tên với sản phẩm đang cập nhật
        List<PhieuGiaoHang> phieuGiaoHangList = phieuGiaoHangRepository.findAll();
        for (PhieuGiaoHang giay : phieuGiaoHangList) {
            if (giay.getId().equals(phieuGiaoHang.getId())) {

                continue; // Bỏ qua sản phẩm đang cập nhật

            }
            if (giay.getTenNguoiNhan().equalsIgnoreCase(phieuGiaoHang.getTenNguoiNhan())) {

                model.addAttribute("erCheckTenNguoiNhanTrung", "Tên người nhận đã có trong danh sách!");
                return "/PhieuGiaoHang/update";

            }
        }

        //Check giá bán
        if(phieuGiaoHang.getPhiShip() == null
                || phieuGiaoHang.getPhiShip().trim().length()==0
                || phieuGiaoHang.getPhiShip().isEmpty()){

            model.addAttribute("erCheckPhiShipIsEmtry","Phí ship phiếu giao hàng không được để trống !");
            return "/PhieuGiaoHang/update";

        }

        String PhiShipFormatted = phieuGiaoHang.getPhiShip().replace(",", "").replace(" ", "");

        try {

            int phiShip = Integer.parseInt(PhiShipFormatted);

            if(phiShip < 1000){

                model.addAttribute("erCheckPhiShipNumber","Phí ship không được là số nguyên âm và phải lớn hơn hoặc bằng 1.000 VNĐ");
                return "/PhieuGiaoHang/update";

            }

            phieuGiaoHang.setPhiShip(String.valueOf(phiShip)); // Lưu giá trị đã xử lý vào đối tượng

        } catch (NumberFormatException e) {

            e.printStackTrace();
            model.addAttribute("erCheckPhiShipSoConertString", "Phí Ship phải là số không được là chữ");
            return "/PhieuGiaoHang/update";

        }

        phieuGiaoHang.setTrangThai(0);//vẫn để là 0
        phieuGiaoHangRepository.save(phieuGiaoHang);
        attributes.addFlashAttribute("messDoneUpdate","Update dữ liệu thành công !");
        attributes.addFlashAttribute("messageDoneUpdateTrangThai", "Bạn cần tiếp tục tạo thêm thông tin để phiếu giao hàng được hoạt động !");


        return "redirect:/PhieuGiaoHang/update/"+phieuGiaoHang.getId();

    }






//Todo code các model để lưu lại dữ liệu

    @ModelAttribute("khachHang")
    public List<KhachHang> getListKhachHang(){

        return khachHangRepository.findAll();

    }

    @ModelAttribute("user")
    public List<User> getListUser(){

        return userRepository.findAll();

    }

    @ModelAttribute("hoaDon")
    public List<HoaDon> getListHoaDon(){

        return hoaDonRepository.findAll();

    }
}
