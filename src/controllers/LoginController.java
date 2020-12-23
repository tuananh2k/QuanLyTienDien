/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Config.SQLServerConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import models.LoginModel;
import views.HomeView;
import views.LoginView;

/**
 *
 * @author PhamDoanHieu
 */
public class LoginController {

    LoginView loginView;
    LoginModel loginModel;
    HomeView homeView;
    SQLServerConnect sqlServerConnect;
    Connection connection;

    public LoginController() {
        this.loginView = new LoginView();
        sqlServerConnect = new SQLServerConnect();
        connection = sqlServerConnect.connect();
        loginView.getBtnDangNhap().addActionListener((ae) -> btnDangNhapPerformed());

    }

    public void btnDangNhapPerformed() {
        loginModel = loginView.getModel();
        boolean validate = false;
        if (!loginModel.isEmpty()) {
            if (loginValidator(loginModel.getTaiKhoan(), loginModel.getMatKhau())) {
                HomeController homeController = new HomeController();
                loginView.dispose();
                JOptionPane.showMessageDialog(homeView, "Xin chào " + loginModel.getTaiKhoan());
            }
        } else
            JOptionPane.showMessageDialog(loginView, "Chưa điền tài khoản!");
    }

    boolean loginValidator(String username, String password) {
        boolean loginValidate = false;
        try {
            System.out.println("login...");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from TAIKHOAN");
            while (rs.next()) {
                if (rs.getString("tai_khoan").equals(username)) {
                    if (rs.getString("mat_khau").equals(password)) {
                        System.out.println("login success");
                        loginValidate = true;
                        break;
                    } else {
                        JOptionPane.showMessageDialog(homeView, "Mật khẩu sai!");
                    }
                } else {
                    JOptionPane.showMessageDialog(homeView, "Tên tài khoản sai!");
                }

            }
            //sqlServerConnect.disconnect();

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("loi sql");
        }
        return loginValidate;
    }
}
