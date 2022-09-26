package lt.bit.spring_web.classes;

import lt.bit.spring_web.db.KontaktasDB;
import lt.bit.spring_web.db.ZmogusDb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Run {

    private static final String ZMONES_FILE_PATH =
            "src/main/resources/data/zmones.txt";

    private static final String KONTAKTAI_FILE_PATH =
            "src/main/resources/data/kontaktai.txt";

    public static void main(String[] args) throws IOException {

//        ArrayList<Zmogus> zmones = new ArrayList<>();
//
//        zmones.add(new Zmogus("Tadas", "Tadauskas", 40.0F));
//        zmones.add(new Zmogus("Lukas", "Lukauskas", 35.0F));
//        zmones.add(new Zmogus("Domas", "Domantas", 28.0F));
//        zmones.add(new Zmogus("Tedis", "Tedauskas", 30.0F));
//
//        List<Zmogus> zmogusList;
//        ZmogusDb list = new ZmogusDb();
////        list.writeToFileFromArrayList(zmones, new File(ZMONES_FILE_PATH));
////        ArrayList<Zmogus> retrievedZmogus = getArrayListFromFile(new File(ZMONES_FILE_PATH));
////        retrievedZmogus.forEach(zmogus -> System.out.println(zmogus));
//        for (Zmogus zmogus:list.getArrayListFromFile(new File(ZMONES_FILE_PATH))) {
//            System.out.println(zmogus);
//        }
//        System.out.println("--------------------------------------");
//
////        Zmogus z=new Zmogus(5,"Saulius","Sauliukas",22.0F);
////        list.zmogusUpdate(z,new File(ZMONES_FILE_PATH));
////        list.zmogusDelete(3,new File(ZMONES_FILE_PATH));
//
//        list.getOne(2,new File(ZMONES_FILE_PATH));
//
//        System.out.println("--------------------------");
//
//        for (Zmogus zmogus:list.getArrayListFromFile(new File(ZMONES_FILE_PATH))) {
//            System.out.println(zmogus);
//        }

        List<Kontaktas> kontaktai = new ArrayList<>();
        KontaktasDB kontaktasDB = new KontaktasDB();
        kontaktai = kontaktasDB.getArrayListFromFile(new File(KONTAKTAI_FILE_PATH));
        for (Kontaktas kont : kontaktai){
            System.out.println(kont);
        }
        System.out.println("------------------");
        kontaktai = kontaktasDB.getKontaktaiByZmogus(4,new File(KONTAKTAI_FILE_PATH));
        for (Kontaktas kont : kontaktai){
            System.out.println(kont);
        }

    }
}
//Failas, kuriame saugomi zmones
//formatas:
//    viena eilute - vienas zmogus;
//    id [TAB] vardas [TAB] pavarde [TAB] amzius [ENTER]
//
//web programa (spring):
//    parodo duomenis is failo
//    galima prideti nauja zmogu
//    galima redaguoti esama zmogu
//    galima istrinti esama zmogu
//
//    (*)galima parodyti sarasa surusiuota pagal varda arba pavarde
//    (*)galima filtruoti pagal vardo ir/arba pavardes dali
