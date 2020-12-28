package controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JLabel;
import models.DanhMucModel;
import views.QuanLyChiSoDienView;
import views.DanhSachThanhToanView;
import views.QuanLyHoaDonView;
import views.QuanLyThongTinView;
import views.ThongKeDoanhThuView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PhamDoanHieu
 */
public class ChuyenManHinhController {

    private String kindSelected = "";
    private JPanel jpnRoot;
    private List<DanhMucModel> listDanhMuc = null;
    QuanLyThongTinView quanLyThongTinView = new QuanLyThongTinView();
    QuanLyChiSoDienView quanLyChiSoDienView = new QuanLyChiSoDienView();
    DanhSachThanhToanView danhSachThanhToanView = new DanhSachThanhToanView();
    QuanLyHoaDonView quanLyHoaDonView = new QuanLyHoaDonView();
    ThongKeDoanhThuView thongKeDoanhThuView = new ThongKeDoanhThuView();

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.jpnRoot = jpnRoot;
        initController();

    }

    public void initController() {
        new QuanLyThongTinController((QuanLyThongTinView) quanLyThongTinView);
        new QuanLyChiSoDienController((QuanLyChiSoDienView) quanLyChiSoDienView);
        new DanhSachThanhToanController((DanhSachThanhToanView) danhSachThanhToanView);
        new QuanLyHoaDonController((QuanLyHoaDonView) quanLyHoaDonView);
        new ThongKeDoanhThuController((ThongKeDoanhThuView) thongKeDoanhThuView);

    }

    public void setDashboard(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "QuanLyThongTin";
        jpnItem.setBackground(new Color(141, 205, 145));// set màu cho panel khi được chọn
        jlbItem.setBackground(new Color(141, 205, 145));
        JPanel node = quanLyThongTinView;
        new QuanLyThongTinController((QuanLyThongTinView) node);
        jpnRoot.removeAll();
        jpnRoot.setLayout(new BorderLayout());
        jpnRoot.add(node);
        jpnRoot.validate();
        jpnRoot.repaint();
    }

    public void setEvent(List<DanhMucModel> listDanhMuc) {
        this.listDanhMuc = listDanhMuc;
        for (DanhMucModel item : listDanhMuc) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "QuanLyThongTin":
                    node = quanLyThongTinView;
                    break;
                case "QuanLyChiSoDien":
                    node = quanLyChiSoDienView;
                    break;
                case "DanhSachThanhToan":
                    node = danhSachThanhToanView;
                    break;
                case "QuanLyHoaDon":
                    node = quanLyHoaDonView;
                    break;
                case "ThongKeDoanhThu":
                    node = thongKeDoanhThuView;
                    break;
                default:
                    break;
            }
            jpnRoot.removeAll();
            jpnRoot.setLayout(new BorderLayout());
            jpnRoot.add(node);
            jpnRoot.validate();
            jpnRoot.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) { //Được triệu hồi khi chuột trỏ đến
            kindSelected = kind;
            jpnItem.setBackground(new Color(141, 205, 145));
            jlbItem.setBackground(new Color(141, 205, 145));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) { //Được triệu hồi khi một nút chuột ĐÃ được nhấn trên một thành phần.
            jpnItem.setBackground(new Color(141, 205, 145));
            jlbItem.setBackground(new Color(141, 205, 145));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(76, 175, 80));
                jlbItem.setBackground(new Color(76, 175, 80));
            }
        }
    }

    private void setChangeBackground(String kind) { //khi một panel trong menu được chọn
        for (DanhMucModel item : listDanhMuc) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJlb().setBackground(new Color(141, 205, 145));
                item.getJpn().setBackground(new Color(141, 205, 145));
            } else {
                item.getJlb().setBackground(new Color(76, 175, 80));
                item.getJpn().setBackground(new Color(76, 175, 80));
            }
        }
    }
}
