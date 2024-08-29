/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.WritePDF;
import dao.AccountDAO;
import dao.ChiTietPhieuNhapDAO;
import dao.ChiTietPhieuXuatDAO;
import dao.SPDAO;
import dao.NhaCungCapDAO;
import dao.PhieuNhapDAO;
import dao.PhieuXuatDAO;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.ChiTietPhieu;
import model.Phieu;
import model.PhieuNhap;
import model.PhieuXuat;

/**
 *
 * @author Tran Nhat Sinh con lon
 */
public class CTThongKe extends javax.swing.JDialog {

    /**
     * Creates new form CTPhieuDialog
     */
    private ThongKeForm parent;

    public CTThongKe(javax.swing.JInternalFrame parent, javax.swing.JFrame owner, boolean modal) {
        super(owner, modal);
        this.parent = (ThongKeForm) parent;
        initComponents();
        setLocationRelativeTo(null);
        Phieu pn = this.parent.findPhieu();
        labelMaPhieu.setText(pn.getMaPhieu());
        labelNguoiTao.setText(AccountDAO.getInstance().selectById(pn.getNguoiTao()).getFullName());
        labelTongTien.setText(this.parent.getFormatter().format(pn.getTongTien()) + "đ");
        labelThoiGianTao.setText(this.parent.getFormatDate().format(pn.getThoiGianTao()));
        loadDataToTableProduct();
        setWidthTable();
    }

    public void setWidthTable() {
        tblChiTietPhieu.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblChiTietPhieu.getColumnModel().getColumn(1).setPreferredWidth(10);
        tblChiTietPhieu.getColumnModel().getColumn(2).setPreferredWidth(250);
    }

    public void loadDataToTableProduct() {
        try {
            DefaultTableModel tblCTPhieumd = (DefaultTableModel) tblChiTietPhieu.getModel();
            tblCTPhieumd.setRowCount(0);
            Phieu pn = this.parent.findPhieu();
            String check = pn.getMaPhieu();
            if (check.contains("PX")) {
                ArrayList<ChiTietPhieu> CTPhieu = ChiTietPhieuXuatDAO.getInstance().selectAll(check);
                for (int i = 0; i < CTPhieu.size(); i++) {
                    tblCTPhieumd.addRow(new Object[]{
                        i + 1,
                        CTPhieu.get(i).getmaSP(),
                        SPDAO.getInstance().selectById(CTPhieu.get(i).getmaSP()).gettenSP(),
                        CTPhieu.get(i).getSoLuong(),
                        parent.getFormatter().format(CTPhieu.get(i).getDonGia()) + "đ",
                        parent.getFormatter().format(CTPhieu.get(i).getDonGia() * CTPhieu.get(i).getSoLuong()) + "đ"
                    });
                }
            } else {
                ArrayList<ChiTietPhieu> CTPhieu = ChiTietPhieuNhapDAO.getInstance().selectAll(check);
                for (int i = 0; i < CTPhieu.size(); i++) {
                    tblCTPhieumd.addRow(new Object[]{
                        i + 1,
                        CTPhieu.get(i).getmaSP(),
                        SPDAO.getInstance().selectById(CTPhieu.get(i).getmaSP()).gettenSP(),
                        CTPhieu.get(i).getSoLuong(),
                        parent.getFormatter().format(CTPhieu.get(i).getDonGia()) + "đ",
                        parent.getFormatter().format(CTPhieu.get(i).getDonGia() * CTPhieu.get(i).getSoLuong()) + "đ"
                    });
                }
            }

        } catch (Exception e) {
        }
    }

    public ArrayList<Phieu> getPhieuAll() {
        ArrayList<Phieu> result = new ArrayList<>();
        ArrayList<PhieuNhap> conten1 = PhieuNhapDAO.getInstance().selectAll();
        ArrayList<PhieuXuat> conten2 = PhieuXuatDAO.getInstance().selectAll();
        for (PhieuNhap phieuNhap : conten1) {
            String maPhieu = phieuNhap.getMaPhieu();
            Timestamp thoiGianTao = phieuNhap.getThoiGianTao();
            String nguoiTao = phieuNhap.getNguoiTao();
            double tongTien = phieuNhap.getTongTien();
            Phieu ac = new Phieu(maPhieu, thoiGianTao, nguoiTao, tongTien);
            result.add(ac);
        }
        for (PhieuXuat phieuXuat : conten2) {
            String maPhieu = phieuXuat.getMaPhieu();
            Timestamp thoiGianTao = phieuXuat.getThoiGianTao();
            String nguoiTao = phieuXuat.getNguoiTao();
            double tongTien = phieuXuat.getTongTien();
            Phieu ac = new Phieu(maPhieu, thoiGianTao, nguoiTao, tongTien);
            result.add(ac);
        }
        return result;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietPhieu = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelTongTien = new javax.swing.JLabel();
        labelMaPhieu = new javax.swing.JLabel();
        labelNguoiTao = new javax.swing.JLabel();
        labelThoiGianTao = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnExportPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi tiết phiếu");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CHI TIẾT PHIẾU ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel2.setText("Mã phiếu: ");

        tblChiTietPhieu.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        tblChiTietPhieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã máy", "Tên máy", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tblChiTietPhieu);

        jLabel4.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel4.setText("Người tạo:");

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel5.setText("Thời gian tạo:");

        labelTongTien.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        labelTongTien.setText("...đ");

        labelMaPhieu.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        labelMaPhieu.setText("jLabel7");

        labelNguoiTao.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        labelNguoiTao.setText("jLabel7");

        labelThoiGianTao.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        labelThoiGianTao.setText("jLabel7");

        jLabel7.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel7.setText("TỔNG TIỀN:");

        btnExportPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_pdf_25px.png"))); // NOI18N
        btnExportPDF.setText("Xuất PDF");
        btnExportPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(labelMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(labelNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(labelTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExportPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(21, 21, 21))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(labelThoiGianTao, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(451, 451, 451))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(labelMaPhieu)
                    .addComponent(labelNguoiTao))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelThoiGianTao))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labelTongTien)
                    .addComponent(btnExportPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportPDFActionPerformed
        // TODO add your handling code here:
        WritePDF writepdf = new WritePDF();
        writepdf.writePhieuNhap(this.parent.findPhieu().getMaPhieu());
    }//GEN-LAST:event_btnExportPDFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CTThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CTThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CTThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CTThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelMaPhieu;
    private javax.swing.JLabel labelNguoiTao;
    private javax.swing.JLabel labelThoiGianTao;
    private javax.swing.JLabel labelTongTien;
    private javax.swing.JTable tblChiTietPhieu;
    // End of variables declaration//GEN-END:variables
}
