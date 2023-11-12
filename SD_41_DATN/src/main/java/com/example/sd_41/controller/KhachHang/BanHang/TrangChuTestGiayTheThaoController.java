//package com.example.sd_41.controller.KhachHang.BanHang;
//
//import com.example.sd_41.model.*;
//import com.example.sd_41.repository.BanHang.GioHangChiTietRepository;
//import com.example.sd_41.repository.BanHang.GioHangRepository;
//import com.example.sd_41.repository.ImageRepository;
//import com.example.sd_41.repository.SanPham.GiayTheThao.GiayTheThaoChiTietRepository;
//import com.example.sd_41.repository.SanPham.GiayTheThao.GiayTheThaoRepository;
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Controller
//public class TrangChuTestGiayTheThaoController {
//
//    @Autowired
//    ServletContext context;
//
//     @Autowired
//     private GiayTheThaoChiTietRepository giayTheThaoChiTietRepository;
//
//     @Autowired
//     private GiayTheThaoRepository giayTheThaoRepository;
//
//     @Autowired
//     private ImageRepository imageRepository;
//
//     @Autowired
//     private GioHangRepository gioHangRepository;
//
//     @Autowired
//     private GioHangChiTietRepository gioHangChiTietRepository;
//
//
//
//    //Todo code view giầy thể thao cho người dùng mua hàng phân trang cho người dùng ở luôn trang index by Giầy thể thao
//
//    @RequestMapping(value = "TrangChu/listGiayTheThao")
//    public String showListViewGiayTheThao(Model model,
//                                          @RequestParam(name = "pageNum",required = false,defaultValue = "1")Integer pageNum,
//                                          @RequestParam(name = "pageSize",required = false,defaultValue = "9")Integer pageSize){
//
//        //Lấy dữ liệu của giầy thể thao
//        //8 hình ảnh trên cùng một trang
//        List<GiayTheThao> lstGiayTheThao = giayTheThaoRepository.findAll();
//        model.addAttribute("lstGiayTheThao",lstGiayTheThao);
//
//        Pageable pageable = PageRequest.of(pageNum-1,pageSize);
//        Page<GiayTheThao> page = giayTheThaoRepository.findAll(pageable);
//
//        //Hiện thông tin sản phẩm
//        model.addAttribute("totalPage",page.getTotalPages());
//        model.addAttribute("listPage",page.getContent());
//
//        //List danh sách các trang để hiện ra giao diện
//
//        List<Integer> pageNumbers = new ArrayList<>();
//        int totalPages = page.getTotalPages();
//        int currentPage = pageNum;
//        int startPage, endPage;
//
//        if (totalPages <= 5) {
//            startPage = 1;
//            endPage = totalPages;
//        } else {
//            if (currentPage <= 3) {
//                startPage = 1;
//                endPage = 5;
//            } else if (currentPage + 2 >= totalPages) {
//                startPage = totalPages - 4;
//                endPage = totalPages;
//            } else {
//                startPage = currentPage - 2;
//                endPage = currentPage + 2;
//            }
//        }
//
//        for (int i = startPage; i <= endPage; i++) {
//            pageNumbers.add(i);
//        }
//
//
//        model.addAttribute("pageNumbers", pageNumbers);
//        model.addAttribute("currentPage", currentPage);
//
//        return "/templates/Users/indexLogin";
//
//    }
//
//    //Todo code list giày thể thao Deals of the Week bên trang chủ
//
//    @RequestMapping(value = "GiayTheThao/listGiayTheThaoDealsOfTheWeek")
//    public String listGiayTheThaoDealsOfTheWeek(Model model,
//                                                @RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
//                                                @RequestParam(value = "pageSize",required = false,defaultValue = "12") Integer pageSize){
//
//        List<GiayTheThaoChiTiet> lstGiayTheThaoDealsOfTheWeek = giayTheThaoChiTietRepository.findAll();
//        model.addAttribute("lstGiayTheThaoDealsOfTheWeek",lstGiayTheThaoDealsOfTheWeek);
//
//        Pageable pageable = PageRequest.of(pageNum-1,pageSize);
//        Page<GiayTheThaoChiTiet> page = giayTheThaoChiTietRepository.findAll(pageable);
//
//        model.addAttribute("totalPage",page.getTotalPages());
//        model.addAttribute("listPage",page.getContent());
//
//
//        return "/templates/Users/index";
//
//    }
//
//    //lấy thông tin sản phẩm của giầy detail thông tin của sản phẩm
//    //Todo code detail thông tin sản phẩm
//    @GetMapping("GiayTheThao/detailThongTinGiayTheThao/{id}")
//    public String detailChiTietGiayTheThao(@PathVariable UUID id, Model model,//id là id của giầy thể thao
//                                           @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
//                                           @RequestParam(value = "pageSize", required = false, defaultValue = "4") Integer pageSize) {
//
//
//        GiayTheThao giayTheThao = giayTheThaoRepository.findById(id).orElse(null);
//        model.addAttribute("giayTheThao", giayTheThao);//Tìm kiếm giầy thể thao
//
//        if (giayTheThao != null) {
//
//            List<GiayTheThaoChiTiet> giayTheThaoChiTiet = giayTheThaoChiTietRepository.findByGiayTheThao(giayTheThao);
//            model.addAttribute("giayTheThaoChiTiet",giayTheThaoChiTiet);
//
//            List<Size> uniqueSizes = new ArrayList<>();
//            List<MauSac> uniqueMauSac = new ArrayList<>();
//
//            for (GiayTheThaoChiTiet chiTiet : giayTheThaoChiTiet) {
//                Size size = chiTiet.getSize();
//
//                if (!uniqueSizes.contains(size)) {
//
//                    uniqueSizes.add(size);
//
//                }
//            }
//
//            for (GiayTheThaoChiTiet chiTiet : giayTheThaoChiTiet){
//
//                MauSac mauSac = chiTiet.getMauSac();
//                if(!uniqueMauSac.contains(mauSac)){
//
//                    uniqueMauSac.add(mauSac);
//                }
//
//            }
//
//            int totalSoLuong = 0;
//
//            for (GiayTheThaoChiTiet chiTiet : giayTheThaoChiTiet) {
//                // Lấy số lượng từ mỗi chi tiết và cộng vào tổng
//                totalSoLuong += Integer.parseInt(chiTiet.getSoLuong());
//
//            }
//
//            // Truyền tổng số lượng vào model
//            model.addAttribute("totalSoLuong", totalSoLuong);
//
//            model.addAttribute("uniqueSizes", uniqueSizes);
//            model.addAttribute("uniqueMauSac", uniqueMauSac);
//
//
//            List<Image> images = imageRepository.findImageByGiayTheThao(giayTheThao);
//            model.addAttribute("listImage", images);
//
//        }
//
//
//
//        //Phân trang dữ liệu
//
//        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
//        Page<GiayTheThao> page = giayTheThaoRepository.findAll(pageable);
//
//        model.addAttribute("totalPage", page.getTotalPages());
//        model.addAttribute("listPage", page.getContent());
//
//        List<Integer> pageNumbers = new ArrayList<>();
//        int totalPages = page.getTotalPages();
//        int currentPage = pageNum;
//        int startPage, endPage;
//
//        if (totalPages <= 5) {
//            startPage = 1;
//            endPage = totalPages;
//        } else {
//            if (currentPage <= 3) {
//                startPage = 1;
//                endPage = 5;
//            } else if (currentPage + 2 >= totalPages) {
//                startPage = totalPages - 4;
//                endPage = totalPages;
//            } else {
//                startPage = currentPage - 2;
//                endPage = currentPage + 2;
//            }
//        }
//
//        for (int i = startPage; i <= endPage; i++) {
//            pageNumbers.add(i);
//        }
//
//        model.addAttribute("pageNumbers", pageNumbers);
//        model.addAttribute("currentPage", currentPage);
//
//        return "/templates/Users/Layouts/Shop/detailGiayTheThao";
//
//    }
//
//
//
//
//    //Todo code giỏ hàng cho giầy thể thao
//    @PostMapping("GiayTheThao/NguoiDung/AddToCart/{id}")
//    public String showAddToCartNguoiDung(Model model,
//                                         HttpSession session,
//                                         RedirectAttributes attributes,
//                                         HttpServletRequest request) {
//        String mauSac = request.getParameter("mauSac");
//        String size = request.getParameter("size");
//        String soLuong = request.getParameter("soLuong");
//        String donGia = request.getParameter("donGia");
//        String idGiayTheThao = request.getParameter("idGiayTheThao");
//        //Chuyển đổi
//        UUID giayTheThaoId = UUID.fromString(idGiayTheThao);
//        UUID sizeId = UUID.fromString(size);
//        UUID mauSacId = UUID.fromString(mauSac);
//        //Tìm kiếm id của giầy thể thao chi tiết
//        UUID idGiayTheThaoChiTiet = giayTheThaoChiTietRepository.findIdByGiayTheThaoAndSizeAndMauSac(giayTheThaoId, sizeId, mauSacId);
//
//        if (idGiayTheThaoChiTiet != null) {
//            UUID idKhachHang = (UUID) session.getAttribute("idKhachHang");
//            GioHang gioHang = gioHangRepository.findByKhachHangId(idKhachHang);
//            GiayTheThaoChiTiet giayTheThaoChiTiet = giayTheThaoChiTietRepository.findByGiayTheThaoAndSizeAndMauSac(giayTheThaoId, sizeId, mauSacId);
//
//            if (gioHang != null) {
//                UUID gioHangId = gioHang.getId();
//                String gioHangIdStr = gioHangId.toString();
//
//                GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
//                gioHangChiTiet.setGioHang(gioHang);
//                gioHangChiTiet.setGiayTheThaoChiTiet(giayTheThaoChiTiet);
//                gioHangChiTiet.setSoLuong(soLuong);
//
//                // Lưu giỏ hàng chi tiết vào cơ sở dữ liệu
//                gioHangChiTietRepository.save(gioHangChiTiet);
//
//                System.out.println("Giỏ hàng ID: " + gioHangIdStr);
//                System.out.println("Màu sắc: " + mauSac);
//                System.out.println("Size: " + size);
//                System.out.println("Số lượng: " + soLuong);
//                System.out.println("Giày thể thao: " + giayTheThaoId);
//                System.out.println("ID của giày thể thao chi tiết: " + idGiayTheThaoChiTiet);//đã có được id của giầy thể thao chi tiết
//
//            }
//
//        } else {
//
//            // Xử lý trường hợp khi không tìm thấy giày thể thao chi tiết
//        }
//
//
//
//        //Tiếp tục cho nó vào giỏ hàng và set vào giỏ hàng chi tiết
//
//
//        return "/templates/Users/Layouts/Shop/gioHangView";
//
//    }
//
//
//
//
//
//}
