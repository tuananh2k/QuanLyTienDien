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
//        String sql2 = "INSERT INTO [dbo].[HOTIEUTHU]\n" +
//"           ([maKH]\n" +
//"           ,[hoTen]\n" +
//"           ,[CMND]\n" +
//"           ,[diaChi]\n" +
//"           ,[gioiTinh]\n" +
//"           ,[ngaySinh]\n" +
//"           ,[sdt]\n" +
//"           ,[ngayDangKi]\n" +
//"           ,[loaiDien])\n" +
//"     VALUES\n" +
//"           (?\n" +
//"           ,?\n" +
//"           ,?\n" +
//"           ,?\n" +
//"           ,?\n" +
//"           ,?\n" +
//"           ,?\n" +
//"           ,?\n" +
//"           ,?)";
//        PreparedStatement ps2 = connection.prepareStatement(sql2);
//        for(int i=15; i<30; i++)
//        {
//            ps2.setString(1, "KH0"+i);
//            ps2.setString(2, "Khúc Bảo Châu");
//            ps2.setString(3, i%2==0 ?"Nam" : "Nu");
//            ps2.setString(4, "01/01/1992");
//            ps2.setString(5, "045631544");
//            ps2.setString(6, "036977215");
//            ps2.setString(7, "12/12/2012");
//            ps2.setString(8, i%2==0 ? "Ha Tinh" :"Ha Noi");
//            ps2.setString(9, i%2==0 ? "Sản xuất" : "Kinh doanh");
//            ps2.execute();
//            System.out.println(i);
//            
//        }
        
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
