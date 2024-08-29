package controller;

import dao.SPDAO;
import java.util.ArrayList;
import model.SP;

/**
 *
 * @author sinh
 */
public class SearchProduct {

    public static SearchProduct getInstance() {
        return new SearchProduct();
    }

    public ArrayList<SP> searchTatCa(String text) {
        ArrayList<SP> result = new ArrayList<>();
        ArrayList<SP> arsp = SPDAO.getInstance().selectAllExist();
        for (var sp : arsp) {
            if (sp.getTrangThai() == 1) {
                if (sp.getmaSP().toLowerCase().contains(text.toLowerCase()) || sp.gettenSP().toLowerCase().contains(text.toLowerCase())) {
                    result.add(sp);
                }
            }
        }
        return result;
    }

    public ArrayList<SP> searchmaSP(String text) {
        ArrayList<SP> result = new ArrayList<>();
        ArrayList<SP> arsp = SPDAO.getInstance().selectAllExist();
        for (var sp : arsp) {
            if (sp.getTrangThai() == 1) {
                if (sp.getmaSP().toLowerCase().contains(text.toLowerCase())) {
                    result.add(sp);
                }
            }
        }
        return result;
    }

    public ArrayList<SP> searchtenSP(String text) {
        ArrayList<SP> result = new ArrayList<>();
        ArrayList<SP> arsp = SPDAO.getInstance().selectAllExist();
        for (var sp : arsp) {
            if (sp.getTrangThai() == 1) {
                if (sp.gettenSP().toLowerCase().contains(text.toLowerCase())) {
                    result.add(sp);
                }
            }
        }
        return result;
    }
    
    public ArrayList<SP> searchloaiSP(String text) {
        ArrayList<SP> result = new ArrayList<>();
        ArrayList<SP> arsp = SPDAO.getInstance().selectAllExist();
        for (var sp : arsp) {
            if (sp.getTrangThai() == 1) {
                if (sp.getloaiSP().toLowerCase().contains(text.toLowerCase())) {
                    result.add(sp);
                }
            }
        }
        return result;
    }

    public ArrayList<SP> searchSoLuong(String text) {
        ArrayList<SP> result = new ArrayList<>();
        ArrayList<SP> arsp = SPDAO.getInstance().selectAllExist();
        for (var sp : arsp) {
            if (sp.getTrangThai() == 1) {
                if (text.length() != 0) {
                    if (sp.getSoLuong() > Integer.parseInt(text)) {
                        result.add(sp);
                    }
                } else {
                    result.add(sp);
                }
            }
        }
        return result;
    }

    public ArrayList<SP> searchDonGia(String text) {
        ArrayList<SP> result = new ArrayList<>();
        ArrayList<SP> arsp = SPDAO.getInstance().selectAllExist();
        for (var sp : arsp) {
            if (sp.getTrangThai() == 1) {

                if (text.length() != 0) {
                    if (sp.getGia() > Integer.parseInt(text)) {
                        result.add(sp);
                    }
                }
                else {
                    result.add(sp);
                }
            } 
        }
        return result;
    }


    public ArrayList<SP> searchDaXoa(String text) {
        ArrayList<SP> result = new ArrayList<>();
        ArrayList<SP> arsp = SPDAO.getInstance().selectAll();
        for (var sp : arsp) {
            if (sp.getTrangThai() == 0) {
                if (sp.getmaSP().toLowerCase().contains(text.toLowerCase())) {
                    result.add(sp);
                }
            }
        }
        return result;
    }

    public SP searchId(String text) {
        SP result = new SP();
        ArrayList<SP> arsp = SPDAO.getInstance().selectAllExist();
        for (var sp : arsp) {
            if (sp.getmaSP().toLowerCase().contains(text.toLowerCase())) {
                return sp;
            }
        }
        return null;
    }
}
