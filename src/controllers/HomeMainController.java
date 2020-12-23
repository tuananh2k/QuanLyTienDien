/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.HomeMainView;
import views.QuanLyHoaDonView;
import views.QuanLyThongTinView;

/**
 *
 * @author ADMIN
 */
public class HomeMainController {
    private  HomeMainView view;
    private QuanLyThongTinController controller;
    private QuanLyThongTinView view1;
    
    public HomeMainController(){
        view = new HomeMainView();
        view.getLabThongTin().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                view1 = new QuanLyThongTinView();
                view.getJpnView().add(view1);
//                controller = new QuanLyThongTinController();
//                view.setVisible(false);
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
