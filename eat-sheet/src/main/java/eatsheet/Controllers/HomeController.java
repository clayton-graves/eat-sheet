package eatsheet.Controllers;


import eatsheet.Models.Data.FoodDAO;
import eatsheet.Models.Food;
import eatsheet.Models.FoodData;
//import org.apache.tomcat.util.buf.StringUtils;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    @Autowired
    private FoodDAO foodDao;

    @RequestMapping(value = "")
    public String index(Model model, HttpServletRequest request){
        /*
        HttpSession session = request.getSession(false);
        if (session == null){
            return "redirect:/user/login";                                   //blocks unlogged user entry
        }
        */
        model.addAttribute("title", "Welcome to EatSheet!");
        //model.addAttribute("foods", foodDao.findAll());
        return "test/home";
    }

    @RequestMapping(value = "search")
    public String searchFunc(Model model, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null){
            return "redirect:/user/login";                                   //blocks unlogged user entry
        }
        model.addAttribute("title", "Welcome to EatSheet!");


        return "test/search";
    }

    @RequestMapping(value = "search", method= RequestMethod.POST)
    public String searchHandler(Model model, @RequestParam(value="unitType") String unit, @RequestParam(value="nutrientType") String nutrient, @RequestParam(value="condition") String conditional, @RequestParam(value="amountG") String amountGramsStr, @RequestParam(value="nutrientType2") String nutrient2, @RequestParam(value="condition2") String conditional2, @RequestParam(value="amountG2") String amountGrams2Str, @RequestParam(value="nutrientType3") String nutrient3, @RequestParam(value="condition3") String conditional3, @RequestParam(value="amountG3") String amountGrams3Str){


        double quantity = 1.0;
        double amountGrams = 0.0;
        double amountGrams2 = 0.0;
        double amountGrams3 = 0.0;

        /*
        if(!quantityStr.equals("")){
            quantity = Double.parseDouble(quantityStr);
        }
        */

        if(!amountGramsStr.equals("") && FoodData.isNumeric(amountGramsStr) == true){
            amountGrams = Double.parseDouble(amountGramsStr);
        }
        if(!amountGrams2Str.equals("") && FoodData.isNumeric(amountGrams2Str) == true){
            amountGrams2 = Double.parseDouble(amountGrams2Str);
        }
        if(!amountGrams3Str.equals("") && FoodData.isNumeric(amountGrams3Str) == true){
            amountGrams3 = Double.parseDouble(amountGrams3Str);
        }
        if(!amountGramsStr.equals("") && FoodData.isNumeric(amountGramsStr) == false || !amountGrams2Str.equals("") &&  FoodData.isNumeric(amountGrams2Str) == false || !amountGrams3Str.equals("") && FoodData.isNumeric(amountGrams3Str) == false){
            model.addAttribute("title", "Welcome to EatSheet!");
            model.addAttribute("amountError", "Input must be numeric!");
            return "test/search";

        }
        ArrayList<Food> correctFoods = new ArrayList<>();
        ArrayList<Food> correctFoods2 = new ArrayList<>();
        ArrayList<Food> correctFoods3 = new ArrayList<>();
        Iterable<Food> foods = foodDao.findAll();
        double unitVal = 1.0;

        if(unit.equals("ounce")){
            unitVal = 0.2835;
        }
        if(unit.equals("pound")){
            unitVal = 4.356;
        }

        for(Food food : foods){
            food.setWater(food.getWater() * unitVal);
            food.setWater(Math.round(food.getWater()*100.0)/100.0);
            food.setCalories(food.getCalories() * unitVal);
            food.setCalories(Math.round(food.getCalories()*100.0)/100.0);
            food.setProtein(food.getProtein() * unitVal);
            food.setProtein(Math.round(food.getProtein()*100.0)/100.0);
            food.setLipids(food.getLipids() * unitVal);
            food.setLipids(Math.round(food.getLipids()*100.0)/100.0);
            food.setAsh(food.getAsh() * unitVal);
            food.setAsh(Math.round(food.getAsh()*100.0)/100.0);
            food.setCarbs(food.getCarbs() * unitVal);
            food.setCarbs(Math.round(food.getCarbs()*100.0)/100.0);
            food.setFiber(food.getFiber() * unitVal);
            food.setFiber(Math.round(food.getFiber()*100.0)/100.0);
            food.setSugar(food.getSugar() * unitVal);
            food.setSugar(Math.round(food.getSugar()*100.0)/100.0);
            food.setCalcium(food.getCalcium() * unitVal);
            food.setCalcium(Math.round(food.getCalcium()*100.0)/100.0);
            food.setIron(food.getIron() * unitVal);
            food.setIron(Math.round(food.getIron()*100.0)/100.0);
            food.setMagnesium(food.getMagnesium() * unitVal);
            food.setMagnesium(Math.round(food.getMagnesium()*100.0)/100.0);
            food.setPhosphorus(food.getPhosphorus() * unitVal);
            food.setPhosphorus(Math.round(food.getPhosphorus()*100.0)/100.0);
            food.setPotassium(food.getPotassium() * unitVal);
            food.setPotassium(Math.round(food.getPotassium()*100.0)/100.0);
            food.setSodium(food.getSodium() * unitVal);
            food.setSodium(Math.round(food.getSodium()*100.0)/100.0);
            food.setZinc(food.getZinc() * unitVal);
            food.setZinc(Math.round(food.getZinc()*100.0)/100.0);
            food.setCopper(food.getCopper() * unitVal);
            food.setCopper(Math.round(food.getCopper()*100.0)/100.0);
            food.setManganese(food.getManganese() * unitVal);
            food.setManganese(Math.round(food.getManganese()*100.0)/100.0);
            food.setSelenium(food.getSelenium() * unitVal);
            food.setSelenium(Math.round(food.getSelenium()*100.0)/100.0);
            food.setVitC(food.getVitC() * unitVal);
            food.setVitC(Math.round(food.getVitC()*100.0)/100.0);
            food.setThiamin(food.getThiamin() * unitVal);
            food.setThiamin(Math.round(food.getThiamin()*100.0)/100.0);
            food.setRiboflaxin(food.getRiboflaxin() * unitVal);
            food.setRiboflaxin(Math.round(food.getRiboflaxin()*100.0)/100.0);
            food.setNiacin(food.getNiacin() * unitVal);
            food.setNiacin(Math.round(food.getNiacin()*100.0)/100.0);
            food.setPantoAcid(food.getPantoAcid() * unitVal);
            food.setPantoAcid(Math.round(food.getPantoAcid()*100.0)/100.0);
            food.setVitB6(food.getVitB6() * unitVal);
            food.setVitB6(Math.round(food.getVitB6()*100.0)/100.0);
            food.setFolate(food.getFolate() * unitVal);
            food.setFolate(Math.round(food.getFolate()*100.0)/100.0);
        }

        if(conditional2.equals("none") && conditional3.equals("none")){
            for(Food food : foods){
                if(FoodData.calculateFunc(food, nutrient, conditional, amountGrams) == true){
                    correctFoods.add(food);
                }
            }
        }
        else if(conditional2.equals("none")){
            for(Food food : foods){
                if(FoodData.calculateFunc(food, nutrient, conditional, amountGrams) == true && FoodData.calculateFunc(food, nutrient3, conditional3, amountGrams3) == true) {
                    correctFoods.add(food);
                }
            }
        }
        else if(conditional3.equals("none")){
            for(Food food : foods){
                if(FoodData.calculateFunc(food, nutrient, conditional, amountGrams) == true && FoodData.calculateFunc(food, nutrient2, conditional2, amountGrams2) == true){
                    correctFoods.add(food);
                }
            }
        }
        else{
            for(Food food : foods){
                if(FoodData.calculateFunc(food, nutrient, conditional, amountGrams) == true && FoodData.calculateFunc(food, nutrient2, conditional2, amountGrams2) == true && FoodData.calculateFunc(food, nutrient3, conditional3, amountGrams3) == true){
                    correctFoods.add(food);
                }
            }
        }

        if(correctFoods.isEmpty()){
            model.addAttribute("title", "Welcome to EatSheet!");
            return "test/empty";
        }


        model.addAttribute("title", "Welcome to EatSheet!");
        model.addAttribute("quantityNum", quantity);
        model.addAttribute("foods", correctFoods);
        return "test/display";
    }



    @RequestMapping(value = "name")
    public String searchName(Model model, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null){
            return "redirect:/user/login";                                   //blocks unlogged user entry
        }
        model.addAttribute("title", "Welcome to EatSheet!");
        return "test/search-name";
    }
    @RequestMapping(value = "name", method = RequestMethod.POST)
    public String searchNameHandle(Model model, @RequestParam(value="searchTerm") String term){
        ArrayList<Food> matchingFoods = new ArrayList<>();
        //ArrayList<Food> foods = foodDao.findAll();
        Iterable<Food> foods = foodDao.findAll();
        if(term.equals(null) || term.equals("")){
            model.addAttribute("title", "Welcome to EatSheet!");
            model.addAttribute("nameError","Search field cannot be blank!");
            return "test/search-name";
        }
        for (Food food : foods){
            if(food.getName().toLowerCase().contains(term.toLowerCase())){
                matchingFoods.add(food);
            }
        }


        if(matchingFoods.isEmpty()){
            model.addAttribute("title", "Welcome to EatSheet!");
            return "test/empty";

        }
        model.addAttribute("title", "Welcome to EatSheet!");

        model.addAttribute("foods", matchingFoods);
        //model.addAttribute("sizeNum", matchingFoods.size());

        //model.addAttribute("testValue",term);
        return "test/display";
    }


}
