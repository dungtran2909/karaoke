package fsoft.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Tai on 12/11/2017.
 */

public class Music {
    //@SerializedName("ma")
    private  String ma;
    //@SerializedName("ten")
    private  String ten;
    //@SerializedName("caSi")
    private  String caSi;

    private String loiBH;
    //@SerializedName("thich")
    private  boolean thich;


    @Override
    public String toString() {
        return "Music{" +
                "ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", caSi='" + caSi + '\'' +
                ", thich=" + thich +
                '}';
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCaSi() {
        return caSi;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public String getLoiBH() {
        return loiBH;
    }

    public void setLoiBH(String loiBH) {
        this.loiBH = loiBH;
    }

    public boolean isThich() {
        return thich;
    }

    public void setThich(boolean thich) {
        this.thich = thich;
    }

    public Music(String ma, String ten, String caSi, String loiBH, boolean thich) {
        this.ma = ma;
        this.ten = ten;
        this.caSi = caSi;
        this.loiBH = loiBH;
        this.thich = thich;
    }

    public Music() {
    }
}
