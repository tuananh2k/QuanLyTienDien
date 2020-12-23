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
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.ChiSoDienModel;
import models.HoTieuThuModel;
import views.ChiSoDienView;
import views.HomeView;
/**
 *
 * @author ADMIN
 */
public class CapNhatChiSoDienController {
    ChiSoDienModel model;
    ChiSoDienView view;
    private final String[] tableHeaders = {"Mã Khách Hàng", "Mã Tháng", "Chỉ Số Cũ", "Chỉ Số Mới"};
    SQLServerConnect sqlServerConnect;
    Connection connection;
    ListSelectionModel listSelectionModel;
    String maKHSelected="";
    HomeView homeView;
    public CapNhatChiSoDienController(){
        sqlServerConnect = new SQLServerConnect();
        connection = sqlServerConnect.connect();
        view = new ChiSoDienView();
        setHeaderForTable();
        view.getBtnThem().addActionListener(al -> btnThemPerformed());
        view.getBtnSua().addActionListener(al->btnSuaPerfomed());
        view.getBtnReset().addActionListener(al -> btnResetPerformed());
        listSelectionModel = view.getTblBang().getSelectionModel();
        listSelectionModel.addListSelectionListener(listSelectionListener());
        getDataFromDB();
    }
    
    private void setHeaderForTable() {
        view.getDtm().setColumnIdentifiers(tableHeaders);
    }
    
    public void btnThemPerformed() {
        model = view.getModel();
        view.getDtm().addRow(model.toStringArray());
        insertDataDB();
        System.out.println("them clicked");
    }

    private ListSelectionListener listSelectionListener() {
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                try {
                    int selectedRow = listSelectionModel.getMinSelectionIndex();
                    System.out.println("hàng đc chọn: " + selectedRow);
                    maKHSelected = (String) view.getTblBang().getValueAt(selectedRow, 0); // dòng i cột 0
                    showModel(maKHSelected);
                } catch (Exception e) {
                    
                }
                
            }
        };
          return listSelectionListener;
    }
    public void showModel(String maKH)
    {
        
        try {
            String sqlQuery = "Select * from ChiSoDien where maKH like ?";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, maKH);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
            ChiSoDienModel model = getDataFromResultSet(rs);
            view.getTxtMaKH().setText(model.getMaKH());
            view.getTxtMaKH().setEditable(false);
            view.getTxtMaThang().setText(model.getMaThang());
            view.getTxtMaThang().setEditable(false);
            view.getTxtCSC().setText(String.valueOf(model.getChiSoCu()));
            view.getTxtCSM().setText(String.valueOf(model.getChiSoMoi()));
            }
                    ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyThongTinController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ChiSoDienModel getDataFromResultSet(ResultSet rs)
    { 
        ChiSoDienModel capNhatChiSoDienModel =null;
        try {
            String maKH = rs.getString("maKH");
                String maThang = rs.getString("maThang");
                String chiSoMoi = rs.getString("chiSoMoi");
                String chiSoCu = rs.getString("chiSoCu");
                capNhatChiSoDienModel = new ChiSoDienModel(maKH, maThang, Integer.parseInt(chiSoCu), Integer.parseInt(chiSoMoi));
        } catch (SQLException ex) {
            
        }
        return capNhatChiSoDienModel;
    }
    public void getDataFromDB(){
        try {
            view.getDtm().setRowCount(0);
            String sqlQuery = "Select * from chisodien";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiSoDienModel model = getDataFromResultSet(rs);
                view.getDtm().addRow(model.toStringArray());
            }
            view.getTblBang().repaint();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void insertDataDB(){
        try {
            String sql = "insert CHISODIEN\n" +"values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, model.getMaKH());
            ps.setString(2, model.getMaThang());
            ps.setString(3, String.valueOf(model.getChiSoCu()));
            ps.setString(4, String.valueOf(model.getChiSoMoi()));
            int result = ps.executeUpdate();
            if(result==1){
                System.out.println("Thanh cong!");
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void btnResetPerformed() {
        view.reset();
        getDataFromDB();

    }

    private void btnSuaPerfomed() {
        try {
            model = view.getModel();
            System.out.println("ma kh cần sửa : " + maKHSelected);
            System.out.println("Data mới: " + model.toString());
            String sql = "UPDATE [dbo].[CHISODIEN]" +
                    "   SET [chisocu] = ?" +
                    "      ,[chisomoi] = ?" +
                    " WHERE maKH like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, model.getChiSoCu());
            ps.setInt(2, model.getChiSoMoi());
            ps.setString(3, maKHSelected);
            int result = ps.executeUpdate();
            if(result==1){
                System.out.println("Thay doi gia tri thanh cong!");
            }
            getDataFromDB();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CapNhatChiSoDienController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
