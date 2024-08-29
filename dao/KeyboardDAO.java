/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Keyboard;

/**
 *
 * @author Tran Nhat Sinh
 */
public class KeyboardDAO implements DAOInterface<Keyboard> {

    public static KeyboardDAO getInstance() {
        return new KeyboardDAO();
    }

    @Override
    public int insert(Keyboard t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO SP (maSP, tenSP, soLuong,gia,loaiSP,trangThai) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getmaSP());
            pst.setString(2, t.gettenSP());
            pst.setInt(3, t.getSoLuong());
            pst.setDouble(4, t.getGia());
            pst.setString(5, "Keyboard");
            pst.setInt(6, t.getTrangThai());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thêm được " + t.getmaSP(),"Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
    }

    @Override
    public int update(Keyboard t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE SP SET maSP=?, tenSP=?, soLuong=?, gia=?,loaiSP = ?,trangThai = ? WHERE maSP= ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getmaSP());
            pst.setString(2, t.gettenSP());
            pst.setInt(3, t.getSoLuong());
            pst.setDouble(4, t.getGia());
            pst.setString(5, "Keyboard");
            pst.setInt(6, t.getTrangThai());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(Keyboard t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM SP WHERE maSP=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getmaSP());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Keyboard> selectAll() {
        ArrayList<Keyboard> ketQua = new ArrayList<Keyboard>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM SP";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String loaiSP = rs.getString("loaiSP");
                int trangThai = rs.getInt("trangThai");
                Keyboard kb = new Keyboard(maSP, tenSP, soLuong, gia, loaiSP,trangThai);
                ketQua.add(kb);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public Keyboard selectById(String t) {
        Keyboard ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM SP WHERE maSP=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String loaiSP = rs.getString("loaiSP");
                int trangThai = rs.getInt("trangThai");
                //Laptop(String kichThuocMan, String dungLuongPin, String maSP, String tenSP, int soLuong, double gia, String tenCpu, String ram, String loaiSP, String cardManHinh, String Rom)
                ketQua = new Keyboard(maSP, tenSP, soLuong, gia, loaiSP, trangThai);
            }
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public boolean isKeyboard(String id) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM SP WHERE maSP= ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            String tl = null;
            while (rs.next()) {
                tl = rs.getString("loaiSP");
            }
            if (tl.equals("Keyboard")) {
                return true;
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }
}
