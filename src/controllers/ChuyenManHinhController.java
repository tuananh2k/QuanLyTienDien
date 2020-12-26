package controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JLabel;
import models.DanhMucModel;
import views.ChiSoDienView2;
import views.QuanLyThongTinView2;
import views.ThongKeDoanhThuView2;

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
    private List<DanhMucModel> listDanhMuc=null;
    public ChuyenManHinhController(JPanel jpnRoot) {
        this.jpnRoot = jpnRoot;
    }

    public void setDashboard(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "QuanLyThongTin";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));
        JPanel node = new QuanLyThongTinView2();

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
                        node = new QuanLyThongTinView2();
                        break;
                    case "QuanLyChiSoDien":
                        node = new ChiSoDienView2();
                        break;
                    case "ThongKeDoanhThu":
                        node = new ThongKeDoanhThuView2();
                    // more
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
          public void mousePressed(MouseEvent e) {
               kindSelected = kind;
               jpnItem.setBackground(new Color(96, 100, 191));
               jlbItem.setBackground(new Color(96, 100, 191));
          }

          @Override
          public void mouseReleased(MouseEvent e) {

          }

          @Override
          public void mouseEntered(MouseEvent e) {
              jpnItem.setBackground(new Color(96, 100, 191));
              jlbItem.setBackground(new Color(96, 100, 191));
          }

          @Override
          public void mouseExited(MouseEvent e) {
              if (!kindSelected.equalsIgnoreCase(kind)) {
                    jpnItem.setBackground(new Color(76, 175, 80));
                    jlbItem.setBackground(new Color(76, 175, 80));
              }
          }
    }
    private void setChangeBackground(String kind)
    {
        for(DanhMucModel item: listDanhMuc)
        {
            if(item.getKind().equalsIgnoreCase(kind))
            {
                item.getJlb().setBackground(new Color(96, 100, 191));
                item.getJpn().setBackground(new Color(96, 100, 191));
            }
            else
            {
                item.getJlb().setBackground(new Color(76, 175, 80));
                    item.getJpn().setBackground(new Color(76, 175, 80));
            }
        }
    }
}



