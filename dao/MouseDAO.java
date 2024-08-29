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
import model.Mouse;

/**
 *
 * @author Tran Nhat Sinh
 */
public class MouseDAO implements DAOInterface<Mouse> {

    public static MouseDAO getInstance() {
        return new MouseDAO();
    }

    @Override
    public int insert(Mouse t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO SP (maSP, tenSP, soLuong,gia,loaiSP,trangThai) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getmaSP());
            pst.setString(2, t.gettenSP());
            pst.setInt(3, t.getSoLuong());
            pst.setDouble(4, t.getGia());
            pst.setString(5, "Mouse");
            pst.setInt(6, t.getTrangThai());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(Mouse t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE SP SET maSP=?, tenSP=?, soLuong=?, gia=?,loaiSP = ?,trangThai = ? WHERE maSP= ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getmaSP());
            pst.setString(2, t.gettenSP());
            pst.setInt(3, t.getSoLuong());
            pst.setDouble(4, t.getGia());
            pst.setString(5, "Mouse");
            pst.setInt(6, t.getTrangThai());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(Mouse t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM MayTinh WHERE maSP=? ";
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
    public ArrayList<Mouse> selectAll() {
        ArrayList<Mouse> ketQua = new ArrayList<Mouse>();
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
                Mouse mouse = new Mouse(maSP, tenSP, soLuong, gia, loaiSP,trangThai);
                ketQua.add(mouse);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public Mouse selectById(String t) {
        Mouse ketQua = null;
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
                ketQua = new Mouse(maSP, tenSP, soLuong, gia, loaiSP, trangThai);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
}
