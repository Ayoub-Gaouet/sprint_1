package com.ayoub.avions.controllers;

import com.ayoub.avions.entities.Avion;
import com.ayoub.avions.service.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AvionController{
    @Autowired
    AvionService avionService;
    @RequestMapping("/showCreate")
    public String showCreate()
    {
        return "createAvion";
    }

    @RequestMapping("/saveAvion")
    public String saveAvion(@ModelAttribute("avion") Avion avion,
                              @RequestParam("date") String date,
                              ModelMap modelMap) throws ParseException
    {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        avion.setDateCreation(dateCreation);

        Avion saveAvion = avionService.saveAvion(avion);
        String msg ="Avion enregistré avec Id "+saveAvion.getIdAvion();
        modelMap.addAttribute("msg", msg);
        return "createAvion";
    }
    @RequestMapping("/ListeAvions")
    public String listeAvions(ModelMap modelMap,
                                @RequestParam (name="page",defaultValue = "0") int page,
                                @RequestParam (name="size", defaultValue = "8") int size)
    {
        Page<Avion> prods = avionService.getAllAvionsParPage(page, size);
        modelMap.addAttribute("avions", prods);
        modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeAvions";
    }
    @RequestMapping("/supprimerAvion")
    public String supprimerAvion(@RequestParam("id") Long id,
                                   ModelMap modelMap,
                                   @RequestParam (name="page",defaultValue = "0") int page,
                                   @RequestParam (name="size", defaultValue = "8") int size)
    {
        avionService.deleteAvionById(id);
        Page<Avion> prods = avionService.getAllAvionsParPage(page,
                size);
        // Vérifier si la page actuelle est la dernière page
        /*if (prods.isEmpty() && page > 0) {
            return "redirect:/listeAvions?page=" + (page - 1) + "&size=" + size;
        }*/
        modelMap.addAttribute("avions", prods);
        modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeAvions";
    }

    @RequestMapping("/modifierAvion")
    public String editerAvion(@RequestParam("id") Long id,ModelMap modelMap)
    {
        Avion p= avionService.getAvion(id);
        modelMap.addAttribute("avion", p);
        return "editerAvion";
    }
    @RequestMapping("/updateAvion")
    public String updateAvion(@ModelAttribute("avion") Avion avion,
                                @RequestParam("date") String date,
                                ModelMap modelMap) throws ParseException
    {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        avion.setDateCreation(dateCreation);

        avionService.updateAvion(avion);
        List<Avion> prods = avionService.getAllAvions();
        modelMap.addAttribute("avions", prods);
        return "listeAvions";
    }
}
