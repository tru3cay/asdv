/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.SP;

public class SPDAO implements DAOInterface<SP> {

    public static SPDAO getInstance() {
        return new SPDAO();
    }

    @Override
    public int insert(SP t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(SP t) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE SP SET tenSP = ?,soLuong=?,gia=?,loaiSP=?,trangThai=? WHERE maSP=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.gettenSP());
            pst.setInt(2, t.getSoLuong());
            pst.setDouble(3, t.getGia());
            pst.setInt(4, t.getTrangThai());
            pst.setString(5, t.getmaSP());
            ketqua = pst.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SPDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketqua;
    }

    @Override
    public int delete(SP t) {
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
    public ArrayList<SP> selectAll() {
        ArrayList<SP> ketQua = new ArrayList<SP>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maSP,tenSP,soLuong,gia,loaiSP,trangThai FROM SP";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String loaiSP = rs.getString("loaiSP");
                int trangThai = rs.getInt("trangThai");
                SP sp = new SP(maSP, tenSP, soLuong, gia, loaiSP, trangThai);
                ketQua.add(sp);
            }
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public SP selectById(String t) {
        SP ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maSP,tenSP,soLuong,gia,loaiSP,trangThai FROM SP WHERE maSP = ?";
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
                ketQua = new SP(maSP, tenSP, soLuong, gia, loaiSP, trangThai);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public int updateSoLuong(String maSP, int soluong) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            //String sql = "INSERT INTO SP (maSP, tenSP, soLuong) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            String sql = "UPDATE SP SET soLuong=? WHERE maSP=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, soluong);
            pst.setString(2, maSP);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public int deleteTrangThai(String maSP){
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            
            String sql = "UPDATE SP SET trangThai=0 WHERE maSP=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maSP);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<SP> selectAllE() {
        ArrayList<SP> ketQua = new ArrayList<SP>();
        ArrayList<SP> ketQuaTonKho = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maSP,tenSP,soLuong,gia,loaiSP,trangThai FROM SP";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String loaiSP = rs.getString("loaiSP");
                int trangThai = rs.getInt("trangThai");
                SP sp = new SP(maSP, tenSP, soLuong, gia, loaiSP, trangThai);
                ketQua.add(sp);
            }
            for (SP SP : ketQua) {
                if (SP.getSoLuong() > 0) {
                    ketQuaTonKho.add(SP);
                }
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQuaTonKho;
    }
    
        public ArrayList<SP> selectAllExist() {
        ArrayList<SP> ketQua = new ArrayList<SP>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maSP,tenSP,soLuong,gia,loaiSP,trangThai FROM SP WHERE trangThai = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String loaiSP = rs.getString("loaiSP");
                int trangThai = rs.getInt("trangThai");
                SP m = new SP(maSP, tenSP, soLuong, gia, loaiSP, trangThai);
                ketQua.add(m);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
        
    public int getSl() {
        int soluong = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM SP WHERE trangThai = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                soluong++;
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return soluong;
    }
}
