package lt.bit.spring_web.controllers;

import lt.bit.spring_web.classes.Kontaktas;
import lt.bit.spring_web.db.KontaktasDB;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KontaktasController {

    private static final String KONTAKTAI_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\zmones_spring_web\\src\\main\\resources\\data\\kontaktai.txt";

    @GetMapping("kontaktai")
    public ModelAndView kontaktaiList() throws IOException {
        KontaktasDB kontaktasDB = new KontaktasDB();
        List<Kontaktas> list = kontaktasDB.getArrayListFromFile(new File(KONTAKTAI_FILE_PATH));
        ModelAndView mav = new ModelAndView("kontaktai");
        mav.addObject("kontaktai", list);
        return mav;
    }

    @GetMapping("kontaktas/{kontId}")
    public ModelAndView showKontaktas(@PathVariable("kontId") Integer id) throws IOException {
        KontaktasDB kontaktasDB = new KontaktasDB();
        Kontaktas kontaktas = kontaktasDB.getOne(id, new File(KONTAKTAI_FILE_PATH));
        ModelAndView mav = new ModelAndView("kontaktas");
        mav.addObject("kontaktas", kontaktas);
        return mav;
    }

    @GetMapping("zmogus/{zmId}/kontaktai")
    public ModelAndView kontaktaiListByZmogus(@PathVariable("zmId") Integer id) throws IOException {
        KontaktasDB kontaktasDB = new KontaktasDB();
        List<Kontaktas> list = kontaktasDB.getKontaktaiByZmogus(id, new File(KONTAKTAI_FILE_PATH));
        ModelAndView mav = new ModelAndView("kontaktai");
        mav.addObject("kontaktai", list);
        return mav;
    }

    @PostMapping("zmogus/{zmId}/saveKont/{kontId}")
    public ModelAndView saveKont(

            @PathVariable(value = "kontId", required = false) Integer kontId,
            @PathVariable("zmId") Integer zmId,
            @RequestParam("tipas") String tipas,
            @RequestParam("reiksme") String reiksme
    ) throws IOException {
        ModelAndView mav;
        KontaktasDB kontaktasDB = new KontaktasDB();
        List<Kontaktas> list = new ArrayList<>();
        if (kontId == null) {
            Kontaktas k = new Kontaktas(zmId, tipas, reiksme);
            kontaktasDB.addKontaktas(k, new File(KONTAKTAI_FILE_PATH));
            list = kontaktasDB.getKontaktaiByZmogus(zmId, new File(KONTAKTAI_FILE_PATH));
            mav = new ModelAndView("kontaktai");
            mav.addObject("kontaktai", list);
        } else {
            Kontaktas k = new Kontaktas(kontId, zmId, tipas, reiksme);
            kontaktasDB.kontaktasUpdate(k, new File(KONTAKTAI_FILE_PATH));
            list = kontaktasDB.getKontaktaiByZmogus(zmId, new File(KONTAKTAI_FILE_PATH));
            mav = new ModelAndView("kontaktai");
            mav.addObject("kontaktai", list);
        }
        return mav;
    }

    @PostMapping("zmogus/{zmId}/saveKont")
    public ModelAndView saveNewKont(

            @PathVariable(value = "kontId", required = false) Integer kontId,
            @PathVariable("zmId") Integer zmId,
            @RequestParam("tipas") String tipas,
            @RequestParam("reiksme") String reiksme
    ) throws IOException {
        ModelAndView mav;
        KontaktasDB kontaktasDB = new KontaktasDB();
        List<Kontaktas> list = new ArrayList<>();
        if (kontId == null) {
            Kontaktas k = new Kontaktas(zmId, tipas, reiksme);
            kontaktasDB.addKontaktas(k, new File(KONTAKTAI_FILE_PATH));
            list = kontaktasDB.getKontaktaiByZmogus(zmId, new File(KONTAKTAI_FILE_PATH));
            mav = new ModelAndView("kontaktai");
            mav.addObject("kontaktai", list);
        } else {
            Kontaktas k = new Kontaktas(kontId, zmId, tipas, reiksme);
            kontaktasDB.kontaktasUpdate(k, new File(KONTAKTAI_FILE_PATH));
            list = kontaktasDB.getKontaktaiByZmogus(zmId, new File(KONTAKTAI_FILE_PATH));
            mav = new ModelAndView("kontaktai");
            mav.addObject("kontaktai", list);
        }
        return mav;
    }

    @GetMapping("zmogus/{zmId}/kontNew")
    public ModelAndView newRecordKont(
    ) throws IOException {
        ModelAndView mav;
        mav = new ModelAndView("kontaktasnew");
        return mav;
    }

    @GetMapping("kontaktas/{kontId}/delete")
    public ModelAndView deleteKont(@PathVariable("kontId") Integer id) throws IOException {
        ModelAndView mav;
        List<Kontaktas> list = new ArrayList<>();
        KontaktasDB kontaktasDB = new KontaktasDB();
        Integer zmId = kontaktasDB.getZmogusByKontaktas(id,new File(KONTAKTAI_FILE_PATH));
        kontaktasDB.kontaktasDelete(id, new File(KONTAKTAI_FILE_PATH));
        list = kontaktasDB.getKontaktaiByZmogus(zmId, new File(KONTAKTAI_FILE_PATH));
        mav = new ModelAndView("kontaktai");
        mav.addObject("kontaktai", list);
        return mav;
    }
}
