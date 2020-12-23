/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.HomeView;

/**
 *
 * @author PhamDoanHieu
 */
public class HomeController {
    private HomeView view;
    private QuanLyThongTinController quanlyThongTinController;
    public HomeController() {
        this.view = new HomeView();
        view.getBtnQuanLyThongTin().addActionListener((ae) -> {
            quanlyThongTinController = new QuanLyThongTinController();
            view.setVisible(false);
        });
        view.getBtnCapNhat().addActionListener((ae) -> {
            new CapNhatChiSoDienController();
            view.setVisible(false);
        });
        view.getBtnDSThanhToan().addActionListener(al ->{
            new DanhSachNopVaChuaNopController();
            view.setVisible(false);
        });
        view.getBtnThongKeTongDoanhThu().addActionListener(al ->{
            new ThongKeDoanhThuController();
            view.setVisible(false);
        });
        view.getBtnQuanLyHoaDon().addActionListener(al->{ 
            new QuanLyHoaDonController();
            view.setVisible(false);
        });
        view.getBtnLogout().addActionListener(al ->{
            new LoginController();
            view.dispose();
        });
    }
    
}
