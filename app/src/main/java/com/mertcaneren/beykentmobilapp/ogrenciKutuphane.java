package com.mertcaneren.beykentmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toolbar;
import java.util.List;
public class ogrenciKutuphane extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView maramakutusu;
    private ListView mListe;


    String[] AramaListesi = {"1984 - George Orwell", "Hayvan Çiftliği - George Orwell","Nutuk - Mustafa Kemal Atatürk","Hababam - Rıfat Ilgaz", "Ali - Cin Alinin Maceraları","Alex - Biografi","Şeker Portakalı - Jose Mauro Da Vasconcelos" , "Küçük Prens - Antonie De Saint Exupary", "Bilinmeyen Bir Kadının Mektubu - Stefan Zwieg", "Olağan Üstü Bir gece - Stefan Zweig" , " Kürk Mantolu Madonna - Sabahattin Ali", "Beyaz Zambaklar Ülkesinde - Grigory Petrov" , "Yabancı -Albert Camus" , "Satranç - Stefan Zweig" , "Sapiens - Yuval Noah Hariri" , "Fareler ve İnsanlar - John Steinback","Sineklerin Tanrısı - William Golding","Kırmızı Pazartesi - Gabriel Garcia Marquez","Otomatik Portakal - Anthony Burgress" , "Tutunamayanlar - Oğuz Atay" , "İçimizdeki Şeytan - Sabahattin Ali" , "Yüzyıllık Yalnızlık - Gabriel Garcia Marquez" , "Kırmızı Saçlı Kadın - Orhan Pamuk" , "Kuyucaklı Yusuf - Sabahattin Ali" , "Aylak Adam - Yusuf Atılgan" , "Başlangıç - Dan Brown" ,"Aklından Bir Sayı Tut - John Verdon" , "Kırmızı Saçlı Kadın - Orhan Pamuk" , "Uçurtma Avcısı - Khaled Hosseini", "Türklerin Tarihi - İlber Ortaylı" , "Beyaz Gemi - Cengiz Aytmatov" , "Olasılıksız - Adam Fawer" , "İçimizdeki Şeytan - Sabahattin Ali" , "Fahreneit 451 -Ray Bradbury" , "Kuyuacaklı Yusuf - Sabahattin Ali" , "Sırça Köşk - Sabahattin Ali " , "Amok Koşucusu - Stefan Zweig" , "Korku -  Stefan Zweig" , "Değirmen - Sabahattin Ali" , "Mecburiyet - Stefan Zweig" , "Dönüşüm - Franz Kafka" , "Geçmişe Yolculuk - Stefan Zweig" , "Lyon da Düğün - Stefan Zweig" , "Yeni Dünya - Sabahattin Ali"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_kutuphane);

        maramakutusu = (SearchView) findViewById(R.id.aramaKutusu);
        mListe =(ListView) findViewById(R.id.liste);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1, AramaListesi);
        mListe.setAdapter(adapter);
        mListe.setTextFilterEnabled(true);
        setupArama();

    }

    private void setupArama(){
        maramakutusu.setIconifiedByDefault(false);
        maramakutusu.setOnQueryTextListener(this);
        maramakutusu.setSubmitButtonEnabled(true);

    }

    @Override
    public boolean onQueryTextSubmit(String query)
    {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText)
    {
        if(TextUtils.isEmpty(newText))
        {
            mListe.clearTextFilter();
        }
        else{
            mListe.setFilterText(newText);
        }
        return true;
    }



}
