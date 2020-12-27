/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Config.SQLServerConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import models.ThongKeTongDoanhThuModel;
import views.ThongKeDoanhThuView;

/**
 *
 * @author ADMIN
 */
public class ThongKeDoanhThuController {

    SQLServerConnect sqlServerConnect;
    Connection connection;
    ThongKeDoanhThuView view;
    ThongKeTongDoanhThuModel model;

    public ThongKeDoanhThuController(ThongKeDoanhThuView view) {
        this.view = view;
        sqlServerConnect = new SQLServerConnect();
        connection = sqlServerConnect.connect();
        getData();
        tinhTongDoanhThu();
        view.getBtnTim().addActionListener(al -> timTheoMaThang());
    }

    private void getData() {
        try {
            String sql = "select * from tongdoanhthu";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeTongDoanhThuModel model = new ThongKeTongDoanhThuModel(rs.getString("mathang"), rs.getString("maKH"), rs.getString("mahd"), rs.getInt("tien"));
                view.getDtm().addRow(model.toStringAraay());
            }
        } catch (Exception e) {
        }
    }

    private void tinhTongDoanhThu() {
        try {
                int tong = 0;
                int length = view.getTbl().getRowCount();
                for(int i=0; i<length; i++){
                    tong += Double.parseDouble((String) view.getTbl().getValueAt(i, 3)); //lay gia tri tien ở các row
                }
                view.setTongTien(String.valueOf(tong));
        } catch (Exception e) {
        }
    }

    private void timTheoMaThang() {
        try {
            String mathang = view.getTxtMaThang().getText();
            if(!mathang.isEmpty()) {
                String sql = "select * from tongdoanhthu where mathang = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, mathang);
                ResultSet rs = ps.executeQuery();
                view.getDtm().setRowCount(1);
                if (rs.next() == false) {
                    JOptionPane.showMessageDialog(view, "Không tìm thấy mã tháng: " + mathang);
                } else {
                    while (rs.next()) {
                        ThongKeTongDoanhThuModel model = new ThongKeTongDoanhThuModel(rs.getString("mathang"), rs.getString("maKH"), rs.getString("mahd"), rs.getInt("tien"));
                        view.getDtm().addRow(model.toStringAraay());
                    }
                }
                tinhTongDoanhThu();
            } else{
                JOptionPane.showMessageDialog(view, "Trống!");
            }
        } catch (Exception e) {
        }
    }
}
