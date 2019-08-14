package com.rizkasalma.planet;

import java.util.ArrayList;

public class Planetisi {
    public static String [][] isi = new String[][]{
            {"Merkurius","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Mercury_in_color_-_Prockter07-edit1.jpg/800px-Mercury_in_color_-_Prockter07-edit1.jpg","Planet yang memiliki waktu revolusi tercepat dalam tata surya","Jarak planet dari matahari : 57 juta kilometer"},
            {"Venus","https://upload.wikimedia.org/wikipedia/commons/e/e5/Venus-real_color.jpg","Planet dengan rata-rata suhu tertinggi dalam tata surya","Jarak planet dari matahari : 108 juta kilometer"},
            {"Bumi","https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/The_Earth_seen_from_Apollo_17.jpg/800px-The_Earth_seen_from_Apollo_17.jpg","Merupakan satu-satunya planet yang dihuni makhluk hidup","Jarak planet dari matahari : 150 juta kilometer"},
            {"Mars","https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/OSIRIS_Mars_true_color.jpg/220px-OSIRIS_Mars_true_color.jpg","Mars memiliki warna kemerah-merahan sehingga dijuluki Planet Merah","Jarak planet dari matahari : 230 juta kilometer"},
            {"Jupiter","https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Jupiter_and_its_shrunken_Great_Red_Spot.jpg/800px-Jupiter_and_its_shrunken_Great_Red_Spot.jpg","Merupakan planet terbesar dalam tata surya","Jarak planet dari matahari : 778 juta kilometer"},
            {"Saturnus","https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Saturn_from_Cassini_Orbiter_%282004-10-06%29.jpg/800px-Saturn_from_Cassini_Orbiter_%282004-10-06%29.jpg","Dijuluki planet terindah karena cincinnya yang indah","Jarak planet dari matahari : 1,4 miliar kilometer"},
            {"Uranus","https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Uranus2.jpg/800px-Uranus2.jpg","Memiliki 27 satelit alami","Jarak planet dari matahari : 3 miliar kilometer"},
            {"Neptunus","https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Neptune.jpg/596px-Neptune.jpg","Merupakan planet terdingin dengan rata-rata suhu terendah dalam tata surya","Jarak planet dari matahari : 4,5 miliar kilometer"}

    };
    public static ArrayList<Planet> getListData(){
        Planet planetarium = null;
        ArrayList<Planet> list = new ArrayList<>();
        for (String [] isidata  : isi){
            planetarium= new Planet();
            planetarium.setNama(isidata[0]);
            planetarium.setPhoto(isidata[1]);
            planetarium.setDes(isidata[2]);
            planetarium.setJarak(isidata[3]);

            list.add(planetarium);
        }
        return list;
    }
}
