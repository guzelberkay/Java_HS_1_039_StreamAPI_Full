package com.berkay;

public class Satis {
    String uruaAdi;
    Integer satisFiyati;

    public Satis(String uruaAdi, Integer satisFiyati) {
        this.uruaAdi = uruaAdi;
        this.satisFiyati = satisFiyati;
    }

    public String getUruaAdi() {
        return uruaAdi;
    }

    public void setUruaAdi(String uruaAdi) {
        this.uruaAdi = uruaAdi;
    }

    public Integer getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(Integer satisFiyati) {
        this.satisFiyati = satisFiyati;
    }
}

