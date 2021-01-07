/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.DanhMucModel;
import views.HomeMainView;

/**
 *
 * @author ADMIN
 */
public class HomeMainController {

    private HomeMainView view;
   
    public HomeMainController() {
        view = new HomeMainView();
        ChuyenManHinhController chuyenManHinhController = new ChuyenManHinhController(view.getJpnView());
        chuyenManHinhController.setDashboard(view.getJpnThongTin(), view.getLabThongTin()); //gọi nút mặc định khi mở view

        List<DanhMucModel> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new DanhMucModel("QuanLyThongTin", view.getJpnThongTin(), view.getLabThongTin()));
        listDanhMuc.add(new DanhMucModel("QuanLyChiSoDien", view.getJpnChiSoDien(), view.getLabChiSoDien()));
        listDanhMuc.add(new DanhMucModel("DanhSachThanhToan", view.getJpnThanhToan(), view.getLabThanhToan()));
        listDanhMuc.add(new DanhMucModel("QuanLyHoaDon", view.getJpnHoaDon(), view.getLabHoaDon()));
        listDanhMuc.add(new DanhMucModel("ThongKeDoanhThu", view.getJpnThongKe(), view.getLabThongKe()));
        chuyenManHinhController.setEvent(listDanhMuc);

        view.getLabLogout().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int i = JOptionPane.showConfirmDialog(view, "Đăng xuất?");
                if (i == 0) {
                    view.dispose();
                    new LoginController();
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
               
            }
        });
    }

    public static void main(String[] args) {
        new HomeMainController();
    }
}
