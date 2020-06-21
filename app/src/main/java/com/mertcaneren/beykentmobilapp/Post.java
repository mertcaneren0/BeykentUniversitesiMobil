package com.mertcaneren.beykentmobilapp;

public class Post {

    public String id;
    public String ogrenci_ad;
    public String ogrenci_soyad,ders1sinif,ders2sinif,ders3sinif,ders4sinif,ders5sinif;
    public String ders1,ders1not1,ders1not2,ders2,ders2not1,ders2not2,ders3,ders3not1,ders3not2,ders4,ders4not1,ders4not2,ders5,
            ders5not1,ders5not2,devamsizlik,ders1sinav,ders2sinav,ders3sinav,ders4sinav,ders5sinav;
    public String ders1devamsizlik,ders2devamsizlik,ders3devamsizlik,ders4devamsizlik,ders5devamsizlik;
    public String bildirim;

    public Post() {

    }

    public Post(String id, String ogrenci_ad, String ogrenci_soyad, String ders1sinif, String ders2sinif, String ders3sinif, String ders4sinif, String ders5sinif, String ders1, String ders1not1,
                String ders1not2, String ders2, String ders2not1, String ders2not2, String ders3, String ders3not1, String ders3not2, String ders4, String ders4not1, String ders4not2, String ders5,
                String ders5not1, String ders5not2, String devamsizlik, String ders1sinav, String ders2sinav, String ders3sinav, String ders4sinav, String ders5sinav, String ders1devamsizlik, String
                        ders2devamsizlik, String ders3devamsizlik, String ders4devamsizlik, String ders5devamsizlik,String bildirim) {
        this.id = id;
        this.ogrenci_ad = ogrenci_ad;
        this.ogrenci_soyad = ogrenci_soyad;
        this.ders1sinif = ders1sinif;
        this.ders2sinif = ders2sinif;
        this.ders3sinif = ders3sinif;
        this.ders4sinif = ders4sinif;
        this.ders5sinif = ders5sinif;
        this.ders1 = ders1;
        this.ders1not1 = ders1not1;
        this.ders1not2 = ders1not2;
        this.ders2 = ders2;
        this.ders2not1 = ders2not1;
        this.ders2not2 = ders2not2;
        this.ders3 = ders3;
        this.ders3not1 = ders3not1;
        this.ders3not2 = ders3not2;
        this.ders4 = ders4;
        this.ders4not1 = ders4not1;
        this.ders4not2 = ders4not2;
        this.ders5 = ders5;
        this.ders5not1 = ders5not1;
        this.ders5not2 = ders5not2;
        this.devamsizlik = devamsizlik;
        this.ders1sinav = ders1sinav;
        this.ders2sinav = ders2sinav;
        this.ders3sinav = ders3sinav;
        this.ders4sinav = ders4sinav;
        this.ders5sinav = ders5sinav;
        this.ders1devamsizlik = ders1devamsizlik;
        this.ders2devamsizlik = ders2devamsizlik;
        this.ders3devamsizlik = ders3devamsizlik;
        this.ders4devamsizlik = ders4devamsizlik;
        this.ders5devamsizlik = ders5devamsizlik;
        this.bildirim=bildirim;
    }

    public String getBildirim() {
        return bildirim;
    }

    public void setBildirim(String bildirim) {
        this.bildirim = bildirim;
    }

    public String getDers1sinif() {
        return ders1sinif;
    }

    public void setDers1sinif(String ders1sinif) {
        this.ders1sinif = ders1sinif;
    }

    public String getDers2sinif() {
        return ders2sinif;
    }

    public void setDers2sinif(String ders2sinif) {
        this.ders2sinif = ders2sinif;
    }

    public String getDers3sinif() {
        return ders3sinif;
    }

    public void setDers3sinif(String ders3sinif) {
        this.ders3sinif = ders3sinif;
    }

    public String getDers4sinif() {
        return ders4sinif;
    }

    public void setDers4sinif(String ders4sinif) {
        this.ders4sinif = ders4sinif;
    }

    public String getDers5sinif() {
        return ders5sinif;
    }

    public void setDers5sinif(String ders5sinif) {
        this.ders5sinif = ders5sinif;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getDers1devamsizlik() {
        return ders1devamsizlik;
    }

    public void setDers1devamsizlik(String ders1devamsizlik) {
        this.ders1devamsizlik = ders1devamsizlik;
    }

    public String getDers2devamsizlik() {
        return ders2devamsizlik;
    }

    public void setDers2devamsizlik(String ders2devamsizlik) {
        this.ders2devamsizlik = ders2devamsizlik;
    }

    public String getDers3devamsizlik() {
        return ders3devamsizlik;
    }

    public void setDers3devamsizlik(String ders3devamsizlik) {
        this.ders3devamsizlik = ders3devamsizlik;
    }

    public String getDers4devamsizlik() {
        return ders4devamsizlik;
    }

    public void setDers4devamsizlik(String ders4devamsizlik) {
        this.ders4devamsizlik = ders4devamsizlik;
    }

    public String getDers5devamsizlik() {
        return ders5devamsizlik;
    }

    public void setDers5devamsizlik(String ders5devamsizlik) {
        this.ders5devamsizlik = ders5devamsizlik;
    }

    public String getOgrenci_ad() {
        return ogrenci_ad;
    }

    public String getOgrenci_soyad() {
        return ogrenci_soyad;
    }

    public void setOgrenci_soyad(String ogrenci_soyad) {
        this.ogrenci_soyad = ogrenci_soyad;
    }

    public void setOgrenci_ad(String ogrenci_ad) {
        this.ogrenci_ad = ogrenci_ad;
    }

    public String getDers1() {
        return ders1;
    }

    public void setDers1(String ders1) {
        this.ders1 = ders1;
    }

    public String getDers1not1() {
        return ders1not1;
    }

    public void setDers1not1(String ders1not1) {
        this.ders1not1 = ders1not1;
    }

    public String getDers1not2() {
        return ders1not2;
    }

    public void setDers1not2(String ders1not2) {
        this.ders1not2 = ders1not2;
    }

    public String getDers2() {
        return ders2;
    }

    public void setDers2(String ders2) {
        this.ders2 = ders2;
    }

    public String getDers2not1() {
        return ders2not1;
    }

    public void setDers2not1(String ders2not1) {
        this.ders2not1 = ders2not1;
    }

    public String getDers2not2() {
        return ders2not2;
    }

    public void setDers2not2(String ders2not2) {
        this.ders2not2 = ders2not2;
    }

    public String getDers3() {
        return ders3;
    }

    public void setDers3(String ders3) {
        this.ders3 = ders3;
    }

    public String getDers3not1() {
        return ders3not1;
    }

    public void setDers3not1(String ders3not1) {
        this.ders3not1 = ders3not1;
    }

    public String getDers3not2() {
        return ders3not2;
    }

    public void setDers3not2(String ders3not2) {
        this.ders3not2 = ders3not2;
    }

    public String getDers4() {
        return ders4;
    }

    public void setDers4(String ders4) {
        this.ders4 = ders4;
    }

    public String getDers4not1() {
        return ders4not1;
    }

    public void setDers4not1(String ders4not1) {
        this.ders4not1 = ders4not1;
    }

    public String getDers4not2() {
        return ders4not2;
    }

    public void setDers4not2(String ders4not2) {
        this.ders4not2 = ders4not2;
    }

    public String getDers5() {
        return ders5;
    }

    public void setDers5(String ders5) {
        this.ders5 = ders5;
    }

    public String getDers5not1() {
        return ders5not1;
    }

    public void setDers5not1(String ders5not1) {
        this.ders5not1 = ders5not1;
    }

    public String getDers5not2() {
        return ders5not2;
    }

    public void setDers5not2(String ders5not2) {
        this.ders5not2 = ders5not2;
    }

    public String getDevamsizlik() {
        return devamsizlik;
    }

    public void setDevamsizlik(String devamsizlik) {
        this.devamsizlik = devamsizlik;
    }

    public String getDers1sinav() {
        return ders1sinav;
    }

    public void setDers1sinav(String ders1sinav) {
        this.ders1sinav = ders1sinav;
    }

    public String getDers2sinav() {
        return ders2sinav;
    }

    public void setDers2sinav(String ders2sinav) {
        this.ders2sinav = ders2sinav;
    }

    public String getDers3sinav() {
        return ders3sinav;
    }

    public void setDers3sinav(String ders3sinav) {
        this.ders3sinav = ders3sinav;
    }

    public String getDers4sinav() {
        return ders4sinav;
    }

    public void setDers4sinav(String ders4sinav) {
        this.ders4sinav = ders4sinav;
    }

    public String getDers5sinav() {
        return ders5sinav;
    }

    public void setDers5sinav(String ders5sinav) {
        this.ders5sinav = ders5sinav;
    }


    public String ad()
    {
        return this.ogrenci_ad;
    }
    public String soyad()
    {
        return this.ogrenci_soyad;
    }
    public String ders1()
    {
        return this.ders1;
    }
    public String ders1not1()
    {
        return this.ders1not1;
    }
    public String ders1not2()
    {
        return this.ders1not2;
    }
    public String ders1sinav()
    {
        return this.ders1sinav;
    }
    public String ders2()
    {
        return this.ders2;
    }
    public String ders2not1()
    {
        return this.ders2not1;
    }
    public String ders2not2()
    {
        return this.ders2not2;
    }
    public String ders2sinav()
    {
        return this.ders2sinav;
    }
    public String ders3()
    {
        return this.ders3;
    }
    public String ders3not1()
    {
        return this.ders3not1;
    }
    public String ders3not2()
    {
        return this.ders3not2;
    }
    public String ders3sinav()
    {
        return this.ders3sinav;
    }
    public String ders4()
    {
        return this.ders4;
    }
    public String ders4not1()
    {
        return this.ders4not1;
    }
    public String ders4not2()
    {
        return this.ders4not2;
    }
    public String ders4sinav()
    {
        return this.ders4sinav;
    }
    public String ders5()
    {
        return this.ders5;
    }
    public String ders5not1()
    {
        return this.ders5not1;
    }
    public String ders5not2()
    {
        return this.ders5not2;
    }
    public String ders5sinav()
    {
        return this.ders5sinav;
    }
    public String devamsizlik()
    {
        return this.devamsizlik;
    }

    public String ders1devamsizlik()
    {
        return this.ders1devamsizlik;
    }
    public String ders2devamsizlik()
    {
        return this.ders2devamsizlik;
    }
    public String ders3devamsizlik()
    {
        return this.ders3devamsizlik;
    }
    public String ders4devamsizlik()
    {
        return this.ders4devamsizlik;
    }
    public String ders5devamsizlik()
    {
        return this.ders5devamsizlik;
    }

    public String ders1sinif()
    {
        return this.ders1sinif;
    }
    public String ders2sinif()
    {
        return this.ders2sinif;
    }
    public String ders3sinif()
    {
        return this.ders3sinif;
    }
    public String ders4sinif()
    {
        return this.ders4sinif;
    }
    public String ders5sinif()
    {
        return this.ders5sinif;
    }

    public String bildirim()
    {
        return this.bildirim;
    }




    /*public String getKullaniciId() {
                return id;
            }

            public void setKullaniciId(String kullaniciId) {
                this.id = kullaniciId;
            }

            public String getÖğrenci_ad() {
                return ogrenci_ad;
            }

            public void setÖğrenci_ad(String öğrenci_ad) {

                this.ogrenci_ad = öğrenci_ad;
            }*/
}
