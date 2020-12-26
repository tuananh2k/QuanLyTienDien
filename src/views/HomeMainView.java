/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.ChuyenManHinhController;
import java.util.List;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.DanhMucModel;

/**
 *
 * @author ADMIN
 */
public class HomeMainView extends javax.swing.JFrame {

    /**
     * Creates new form HomeMain
     */
    public HomeMainView() {
        setTitle("QUẢN LÝ TIỀN ĐIỆN");
        ImageIcon iconForm = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\QuanLyTienDien\\src\\icons\\icon_home.png");
        setIconImage(iconForm.getImage());
        initComponents();
        
        ChuyenManHinhController chuyenManHinhController = new ChuyenManHinhController(jpnView);
        chuyenManHinhController.setDashboard(jpnThongTin, labThongTin);
        
        List<DanhMucModel> listDanhMuc =  new ArrayList<>();
        listDanhMuc.add(new DanhMucModel("QuanLyThongTin", jpnThongTin, labThongTin));
        listDanhMuc.add(new DanhMucModel("QuanLyChiSoDien", jpnChiSoDien, labChiSoDien));
        listDanhMuc.add(new DanhMucModel("ThongKeDoanhThu", jpnThongKe, labThongKe));
        chuyenManHinhController.setEvent(listDanhMuc);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
    public JLabel getLabThongTin(){
        return labThongTin;
    }
    public JPanel getJpnView(){
        return jpnView;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnThongTin = new javax.swing.JPanel();
        labThongTin = new javax.swing.JLabel();
        jpnChiSoDien = new javax.swing.JPanel();
        labChiSoDien = new javax.swing.JLabel();
        jpnDanhSachThanhToan = new javax.swing.JPanel();
        labThanhToan = new javax.swing.JLabel();
        jpnQuanLyHoaDon = new javax.swing.JPanel();
        labQuanLy = new javax.swing.JLabel();
        jpnThongKe = new javax.swing.JPanel();
        labThongKe = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnMenu.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setBackground(new java.awt.Color(255, 51, 51));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_home.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ TIỀN ĐIỆN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnThongTin.setBackground(new java.awt.Color(76, 175, 80));
        jpnThongTin.setMinimumSize(new java.awt.Dimension(0, 90));

        labThongTin.setFont(new java.awt.Font("Candara", 0, 20)); // NOI18N
        labThongTin.setForeground(new java.awt.Color(255, 255, 255));
        labThongTin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labThongTin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/quan_Li.png"))); // NOI18N
        labThongTin.setText("QUẢN LÝ THÔNG TIN");

        javax.swing.GroupLayout jpnThongTinLayout = new javax.swing.GroupLayout(jpnThongTin);
        jpnThongTin.setLayout(jpnThongTinLayout);
        jpnThongTinLayout.setHorizontalGroup(
            jpnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnThongTinLayout.setVerticalGroup(
            jpnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnChiSoDien.setBackground(new java.awt.Color(76, 175, 80));
        jpnChiSoDien.setMinimumSize(new java.awt.Dimension(0, 90));
        jpnChiSoDien.setPreferredSize(new java.awt.Dimension(0, 90));

        labChiSoDien.setFont(new java.awt.Font("Candara", 0, 20)); // NOI18N
        labChiSoDien.setForeground(new java.awt.Color(255, 255, 255));
        labChiSoDien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labChiSoDien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cap_nhat.png"))); // NOI18N
        labChiSoDien.setText("CẬP NHẬT CHỈ SỐ ĐIỆN");

        javax.swing.GroupLayout jpnChiSoDienLayout = new javax.swing.GroupLayout(jpnChiSoDien);
        jpnChiSoDien.setLayout(jpnChiSoDienLayout);
        jpnChiSoDienLayout.setHorizontalGroup(
            jpnChiSoDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnChiSoDienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labChiSoDien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnChiSoDienLayout.setVerticalGroup(
            jpnChiSoDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnChiSoDienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labChiSoDien, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jpnDanhSachThanhToan.setBackground(new java.awt.Color(76, 175, 80));
        jpnDanhSachThanhToan.setMinimumSize(new java.awt.Dimension(0, 90));
        jpnDanhSachThanhToan.setPreferredSize(new java.awt.Dimension(0, 90));

        labThanhToan.setFont(new java.awt.Font("Candara", 0, 20)); // NOI18N
        labThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        labThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/thanh_toan.png"))); // NOI18N
        labThanhToan.setText("DANH SÁCH THANH TOÁN");

        javax.swing.GroupLayout jpnDanhSachThanhToanLayout = new javax.swing.GroupLayout(jpnDanhSachThanhToan);
        jpnDanhSachThanhToan.setLayout(jpnDanhSachThanhToanLayout);
        jpnDanhSachThanhToanLayout.setHorizontalGroup(
            jpnDanhSachThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDanhSachThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnDanhSachThanhToanLayout.setVerticalGroup(
            jpnDanhSachThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDanhSachThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jpnQuanLyHoaDon.setBackground(new java.awt.Color(76, 175, 80));
        jpnQuanLyHoaDon.setMinimumSize(new java.awt.Dimension(0, 90));
        jpnQuanLyHoaDon.setPreferredSize(new java.awt.Dimension(0, 90));

        labQuanLy.setFont(new java.awt.Font("Candara", 0, 20)); // NOI18N
        labQuanLy.setForeground(new java.awt.Color(255, 255, 255));
        labQuanLy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labQuanLy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hoa_don.png"))); // NOI18N
        labQuanLy.setText("QUẢN LÝ HOÁ ĐƠN");

        javax.swing.GroupLayout jpnQuanLyHoaDonLayout = new javax.swing.GroupLayout(jpnQuanLyHoaDon);
        jpnQuanLyHoaDon.setLayout(jpnQuanLyHoaDonLayout);
        jpnQuanLyHoaDonLayout.setHorizontalGroup(
            jpnQuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQuanLyHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labQuanLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnQuanLyHoaDonLayout.setVerticalGroup(
            jpnQuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQuanLyHoaDonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jpnThongKe.setBackground(new java.awt.Color(76, 175, 80));
        jpnThongKe.setMinimumSize(new java.awt.Dimension(0, 90));
        jpnThongKe.setPreferredSize(new java.awt.Dimension(0, 90));

        labThongKe.setFont(new java.awt.Font("Candara", 0, 20)); // NOI18N
        labThongKe.setForeground(new java.awt.Color(255, 255, 255));
        labThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/thong_ke.png"))); // NOI18N
        labThongKe.setText("THỐNG KÊ DOANH THU");

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/thoat.png"))); // NOI18N
        btnLogout.setText("Log Out");

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnChiSoDien, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
            .addComponent(jpnDanhSachThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
            .addComponent(jpnQuanLyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
            .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnChiSoDien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnDanhSachThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQuanLyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1049, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new HomeMainView();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jpnChiSoDien;
    private javax.swing.JPanel jpnDanhSachThanhToan;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnQuanLyHoaDon;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel jpnThongTin;
    private javax.swing.JPanel jpnView;
    private javax.swing.JLabel labChiSoDien;
    private javax.swing.JLabel labQuanLy;
    private javax.swing.JLabel labThanhToan;
    private javax.swing.JLabel labThongKe;
    private javax.swing.JLabel labThongTin;
    // End of variables declaration//GEN-END:variables
}
