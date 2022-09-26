package lt.bit.spring_web.db;

import lt.bit.spring_web.classes.Kontaktas;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class KontaktasDB {

    private static final List<Kontaktas> kontaktai = new ArrayList<>();

    public static List<Kontaktas> getListOfKontaktai() {
        return kontaktai;
    }

    public Kontaktas getOne(Integer id, File outputFile) throws IOException {
        KontaktasDB kontaktasDB = new KontaktasDB();
        if (id == null) {
            throw new NullPointerException("Kontakto id privalomas");
        }
        for (Kontaktas kontaktas : kontaktasDB.getArrayListFromFile(outputFile)) {
            if (id.equals(kontaktas.getKontId())) {
                System.out.println("kontaktas kurio ieskom: " + kontaktas);
                return kontaktas;
            }
        }
        throw new IllegalArgumentException("Kontaktas nerastas");
    }

    public List<Kontaktas> getKontaktaiByZmogus(Integer id, File outputFile) throws IOException {
        KontaktasDB kontaktasDB = new KontaktasDB();
        List<Kontaktas> reikalingiKontaktai = new ArrayList<>();
        if (id == null) {
            throw new NullPointerException("Zmogaus id privalomas");
        }
        for (Kontaktas kontaktas : kontaktasDB.getArrayListFromFile(outputFile)) {
            if (id.equals(kontaktas.getZmId())) {
                reikalingiKontaktai.add(kontaktas);
            }
        }
        return reikalingiKontaktai;
    }

    public void addKontaktas(Kontaktas kontaktas, File outputFile) throws IOException {
        String formattedString = "";

        for (Kontaktas k : kontaktai) {
            formattedString += String.format("%d %d %s %s \n", k.getKontId(), k.getZmId(), k.getTipas(), k.getReiksme());
        }
        formattedString += String.format("%d %d %s %s \n", kontaktas.getKontId(), kontaktas.getZmId(), kontaktas.getTipas(), kontaktas.getReiksme());

        FileUtils.writeStringToFile(outputFile, formattedString, StandardCharsets.UTF_8, true);

    }

    public void kontaktasUpdate(Kontaktas k, File outputFile) throws IOException {
        String formattedString = "";
        KontaktasDB kontaktasDB = new KontaktasDB();
        if (k == null) {
            throw new NullPointerException("Kontaktas privalomas");
        }
        for (Kontaktas kontaktas : kontaktasDB.getArrayListFromFile(outputFile)) {
            if (kontaktas.getKontId().equals(k.getKontId())) {
                formattedString += String.format("%d %d %s %s \n", k.getKontId(), k.getZmId(), k.getTipas(), k.getReiksme());
            } else {
                formattedString += String.format("%d %d %s %s \n", kontaktas.getKontId(), kontaktas.getZmId(), kontaktas.getTipas(), kontaktas.getReiksme());
            }
        }
        FileUtils.writeStringToFile(outputFile, formattedString, StandardCharsets.UTF_8, false);
    }

    public void kontaktasDelete(Integer id, File outputFile) throws IOException {
        String formattedString = "";
        KontaktasDB kontaktasDB = new KontaktasDB();
        if (id == null) {
            throw new NullPointerException("Kontakto id privalomas");
        }
        for (Kontaktas kontaktas : kontaktasDB.getArrayListFromFile(outputFile)) {
            if (id.equals(kontaktas.getKontId())) {
                System.out.println("trinam kontakta:" + kontaktas);
            } else {
                formattedString += String.format("%d %d %s %s \n", kontaktas.getKontId(), kontaktas.getZmId(), kontaktas.getTipas(), kontaktas.getReiksme());
            }
        }
        FileUtils.writeStringToFile(outputFile, formattedString, StandardCharsets.UTF_8, false);
    }

    public ArrayList<Kontaktas> getArrayListFromFile(File outputFile) throws IOException {

        String textFromFile = FileUtils.readFileToString(outputFile, StandardCharsets.UTF_8);
        String[] lines = textFromFile.split("\n");

        ArrayList<Kontaktas> kontaktai = new ArrayList<>();

        for (String line : lines) {
            String[] attributes = line.split(" ");

            Kontaktas kontaktas = new Kontaktas(
                    Integer.valueOf(attributes[0].trim()),
                    Integer.valueOf(attributes[1].trim()),
                    (attributes[2].trim()),
                    (attributes[3].trim()));
            kontaktai.add(kontaktas);
            if (kontaktas.getKontId() >= Kontaktas.nextId) {
                Kontaktas.nextId = kontaktas.getKontId() + 1;
            }
        }
        return kontaktai;
    }

    public Integer getZmogusByKontaktas(Integer id, File outputFile) throws IOException {
        Integer zmId = null;
        KontaktasDB kontaktasDB = new KontaktasDB();
        if (id == null) {
            throw new NullPointerException("Kontakto id privalomas");
        }
        for (Kontaktas kontaktas : kontaktasDB.getArrayListFromFile(outputFile)) {
            if (id.equals(kontaktas.getKontId())) {
                zmId = kontaktas.getZmId();
                System.out.println("Zmogus atitinkantis pagal kontakta turi id: " + zmId);
            }
        }
        return zmId;
    }

}
