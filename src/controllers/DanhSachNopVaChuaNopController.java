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
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import models.HoTieuThuModel;
import views.DanhSachHoTieuThuNopVaChuaNop;
import views.HomeView;

/**
 *
 * @author ADMIN
 */
public class DanhSachNopVaChuaNopController {
    HoTieuThuModel model;
    DanhSachHoTieuThuNopVaChuaNop view;
    private final String[] tableHeaders = {"Mã KH", "Họ tên", "Giới tính", "Ngày sinh", "CMND", "SĐT", "Ngày đăng ký", "Địa chỉ", "Loại điện"};
    SQLServerConnect sqlServerConnect;
    Connection connection;
    HomeView homeView;
    
    public DanhSachNopVaChuaNopController(){
        sqlServerConnect = new SQLServerConnect();
        connection = sqlServerConnect.connect();
        view = new DanhSachHoTieuThuNopVaChuaNop();
        setHeaderForTable();
        getDataDaNop();
        getDataForChuaNop();
    }
    
    private void setHeaderForTable() {
        view.getDtmChuaNop().setColumnIdentifiers(tableHeaders);
        view.getDtmNopTien().setColumnIdentifiers(tableHeaders);
    }

    private void getDataForChuaNop() {
        try {
            view.getDtmChuaNop().setRowCount(0);
            String sql = "select maKH from THONGKE \n" +"where payment = 0";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String maKH = rs.getString("maKH");
                getModelDB(maKH, view.getDtmChuaNop());
            }
            ps.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void getDataDaNop(){
        try {
            view.getDtmNopTien().setRowCount(0);
            String sql = "select maKH from thongke where payment = 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String maKH = rs.getString("maKH");
                getModelDB(maKH, view.getDtmNopTien());
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void getModelDB(String maKH, DefaultTableModel dtm){
        try {
            String sql = "select * from HOTIEUTHU \n where maKH = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maKH);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                HoTieuThuModel model = new HoTieuThuModel(rs.getString("maKH"), rs.getString("hoten"), rs.getString("gioitinh"), sdf.parse(rs.getString("ngaysinh")), rs.getString("cmnd"), rs.getString("sdt"), sdf.parse(rs.getString("ngaydangki")), rs.getString("diachi"), rs.getString("loaidien"));
                dtm.addRow(model.toStringArray());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
