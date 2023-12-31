package com.example.sd_41.controller.KhachHang;

import com.example.sd_41.model.GioHang;
import com.example.sd_41.model.KhachHang;
import com.example.sd_41.repository.BanHang.GioHangRepository;
import com.example.sd_41.repository.KhachHangRepository;
import com.example.sd_41.service.KhachHangService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class KhachHangController {

    @Autowired
    ServletContext context;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private GioHangRepository gioHangRepository;

    @GetMapping("/KhachHang/list")
    public String listShowViewMauSac(Model model,
                                     HttpSession session,
                                     @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize
    ) {

        //Todo code tab trạng thái và phân trang
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<KhachHang> page = khachHangRepository.findAll(pageable);
        //listPage sẽ dùng cho trạng thái giầy thể thao kích hoạt hay chưa
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listPage", page.getContent());

        List<Integer> pageNumbers = getPageNumbers(page, pageNum);
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("currentPage", pageNum);


        // Lấy danh sách giày thể thao từ cơ sở dữ liệu
        List<KhachHang> listPageFind = khachHangRepository.findAll();
        model.addAttribute("listPageFind", listPageFind);

        return "/KhachHang/list";
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


    //Todo code đăng ký tài khoản khách hàng
    @RequestMapping(value = "/KhachHang/view-create")
    public String create(Model model){

        model.addAttribute("khachHang", new KhachHang());

        return "/templates/Users/Layouts/DangNhap/Register";

    }

    @RequestMapping(value = "/KhachHang/create")
    public String create(@Valid
                         @ModelAttribute("khachHang") KhachHang khachHang,
                         BindingResult result,
                         Model model,
                         RedirectAttributes attributes,
                         HttpSession session){

        System.out.println(khachHang.getNgaySinh());
        if (result.hasErrors()){

            return "/templates/Users/Layouts/DangNhap/Register";

        }


        if (khachHang.getTenKhachHang() == null || khachHang.getTenKhachHang().isEmpty() || khachHang.getTenKhachHang().trim().length()==0){
            model.addAttribute("tenKhachHangNotNull", "Tên khách hàng không được để trống");

            return "/templates/Users/Layouts/DangNhap/Register";

        }

        if (khachHang.getTenKhachHang().matches("^\\d.*") || !khachHang.getTenKhachHang().matches(".*[a-zA-Z].*")){
            model.addAttribute("tenKhachHangHopLe", "Tên khách hàng không hợp lệ");

            return "/templates/Users/Layouts/DangNhap/Register";

        }

        if (khachHang.getEmail() == null || khachHang.getEmail().isEmpty() || khachHang.getEmail().trim().length()==0){
            model.addAttribute("emailNotNull", "Email không được để trống");

            return "/templates/Users/Layouts/DangNhap/Register";

        }


        if (khachHang.getMatKhau() == null || khachHang.getMatKhau().isEmpty() || khachHang.getMatKhau().trim().length()==0){
            model.addAttribute("matKhauNotNull", "Mật khẩu không được để trống");

            return "/templates/Users/Layouts/DangNhap/Register";

        }

        if (khachHang.getDiaChi() == null || khachHang.getDiaChi().isEmpty() || khachHang.getDiaChi().trim().length()==0){
            model.addAttribute("diaChiNotNull", "Địa chỉ không được để trống");

            return "/templates/Users/Layouts/DangNhap/Register";

        }

        if (khachHang.getDiaChi().matches("^\\d.*") || !khachHang.getDiaChi().matches(".*[a-zA-Z].*")){
            model.addAttribute("diaChiHopLe", "Địa chỉ không hợp lệ");

            return "/templates/Users/Layouts/DangNhap/Register";

        }

        //Todo code image cho khach hang


        LocalDate ngayTao = LocalDate.now();
        LocalDate ngaySua = LocalDate.now();

        String ngayTaoDate = ngayTao.toString();
        String ngaySuaDate = ngaySua.toString();

        khachHang.setNgaySua(ngayTaoDate);
        khachHang.setNgaySua(ngaySuaDate);

        khachHangRepository.save(khachHang);

        //Tạo mới giỏ hàng cho khách hàng luôn
        GioHang gioHang = new GioHang();
        gioHang.setKhachHang(khachHang);
        session.setAttribute("gioHang",gioHang);
        gioHangRepository.save(gioHang);
        attributes.addFlashAttribute("message", "Đăng kí tài khoản thành công");

        return "redirect:/KhachHang/loginViewDangNhap";

    }

    //Todo code edit khách hàng
    @RequestMapping("/KhachHang/edit/{id}")
    public String edit(Model model, @PathVariable UUID id){
        KhachHang khachHang = khachHangRepository.findById(id).orElse(null);

        if (khachHang == null){
            model.addAttribute("messageFind", "Không tìm thấy khách hàng có id: "+id);
            return "/KhachHang/list";
        }

        model.addAttribute("khachHang", khachHangRepository.findById(id));
        return "/KhachHang/edit";
    }

    //Todo code xóa khách hàng
    @RequestMapping("/KhachHang/delete/{id}")
    public String delete(@PathVariable("id") KhachHang khachHang){
        khachHangRepository.delete(khachHang);
        return "redirect:/KhachHang/list";
    }

    @GetMapping("KhachHang/search")
    public String searchCoGiay(@RequestParam(value = "tenKhachHang", required = false) String tenKhachHang, Model model) {
        List<KhachHang> listPageFind;
        if (tenKhachHang != null) {
            listPageFind = khachHangService.findKhachHang(tenKhachHang);
            model.addAttribute("listPageFind", listPageFind);
            if (!listPageFind.isEmpty()) {
                model.addAttribute("messageFindDone", "Tìm thấy dữ liệu");
            } else {
                model.addAttribute("messageFindError", "Không tìm thấy dữ liệu");
            }
        } else {
            model.addAttribute("messageFind", "Bạn hãy nhập tên khách hàng muốn tìm kiếm!");
        }
        return "/KhachHang/list";
    }

    @ModelAttribute("tenKhachHang")
    public List<KhachHang> getListTenKhachHang() {
        return khachHangRepository.findAll();
    }

    @ModelAttribute("email")
    public List<KhachHang> getListEmail() {
        return khachHangRepository.findAll();
    }

    @ModelAttribute("gioiTinh")
    public List<KhachHang> getListGioiTinh() {
        return khachHangRepository.findAll();
    }

    @ModelAttribute("soDienThoai")
    public List<KhachHang> getListSoDienThoai() {
        return khachHangRepository.findAll();
    }

    @ModelAttribute("diaChi")
    public List<KhachHang> getListDiaChi() {
        return khachHangRepository.findAll();
    }


    //Todo code update login
    @GetMapping("KhachHang/loginViewDangNhap")
    public String loginKhachHang(Model model){

        model.addAttribute("khachHang", new KhachHang());
        return "/templates/Users/Layouts/DangNhap/Login";

    }

    //Todo code log login
    @GetMapping("/KhachHang/showSweetAlertLoginSuccess")
    public String showSweetAlertLogLogin() {

        return "/templates/Users/Layouts/Log/DangNhapLog";

    }

    //Todo code check login
    @PostMapping("KhachHang/loginViewDangNhap")
    public String checkLoginKhachHang(Model model,
                                      @ModelAttribute("khachHang")KhachHang khachHang,
                                      @Valid
                                      BindingResult result,
                                      HttpSession session){

        if(result.hasErrors()){

            System.out.println("Đăng nhập thất bại !");
            model.addAttribute("messErLogin","Đăng nhập thất bại");

            return "/templates/Users/Layouts/DangNhap/Login";

        }

        KhachHang khachHangData =  khachHangRepository.findByEmailAndMatKhau(khachHang.getEmail(),khachHang.getMatKhau());

        //Đăng nhập thành công

        if(khachHangData != null){

            UUID idKhachHang = khachHangData.getId(); //tìm kiếm mã khách hàng

            session.setAttribute("khachHangLog",khachHangData);
            session.setAttribute("idKhachHang",idKhachHang);//Lưu lại mã trong quá trình làm việc

//            return "redirect:/TrangChu/listGiayTheThao";
            return "redirect:/KhachHang/showSweetAlertLoginSuccess";


        }

        model.addAttribute("erLogLogin","Email hoặc mật khẩu không đúng !");
        System.out.println("Lỗi dữ liệu !");
        return "/templates/Users/Layouts/DangNhap/Login";

    }




    //Todo code đăng xuất tài khoản khách hàng
    @GetMapping("KhachHang/dangXuat")
    public String logout(Model model,
                         HttpSession session,
                         RedirectAttributes attributes){

     session.invalidate();//Hủy toàn bộ quá trình phiên làm việc
     attributes.addFlashAttribute("messageLogout","Đăng xuất tài khoản thành công !");

        return "redirect:/KhachHang/loginViewDangNhap";

    }




}
