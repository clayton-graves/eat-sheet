package eatsheet.Models;

import eatsheet.Models.Data.FoodDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class FoodData {
    //@Autowired
    //private FoodDAO foodDao;
    //Iterable<Food> foods = foodDao.findAll();
    //ArrayList<Food> theCorrectFoods = new ArrayList<>();

    public static double findNutrientType(Food aFood, String nutrientType){

        if(nutrientType.equals("calories")){
            return aFood.getCalories();
        }
        if(nutrientType.equals("water")){
            return aFood.getWater();
        }
        if(nutrientType.equals("protein")){
            return aFood.getProtein();
        }
        if(nutrientType.equals("lipids")){
            return aFood.getLipids();
        }
        if(nutrientType.equals("ash")){
            return aFood.getAsh();
        }
        if(nutrientType.equals("carbs")){
            return aFood.getCarbs();
        }
        if(nutrientType.equals("fiber")){
            return aFood.getFiber();
        }
        if(nutrientType.equals("sugar")){
            return aFood.getSugar();
        }
        if(nutrientType.equals("calcium")){
            return aFood.getCalcium();
        }
        if(nutrientType.equals("iron")){
            return aFood.getIron();
        }
        if(nutrientType.equals("magnesium")){
            return aFood.getMagnesium();
        }
        if(nutrientType.equals("phosphorus")){
            return aFood.getPhosphorus();
        }
        if(nutrientType.equals("potassium")){
            return aFood.getPotassium();
        }
        if(nutrientType.equals("sodium")){
            return aFood.getSodium();
        }
        if(nutrientType.equals("zinc")){
            return aFood.getZinc();
        }
        if(nutrientType.equals("copper")){
            return aFood.getCopper();
        }
        if(nutrientType.equals("manganese")){
            return aFood.getManganese();
        }
        if(nutrientType.equals("selenium")){
            return aFood.getSelenium();
        }
        if(nutrientType.equals("vitC")){
            return aFood.getVitC();
        }
        if(nutrientType.equals("thiamin")){
            return aFood.getThiamin();
        }
        if(nutrientType.equals("riboflaxin")){
            return aFood.getRiboflaxin();
        }
        if(nutrientType.equals("niacin")){
            return aFood.getNiacin();
        }
        if(nutrientType.equals("pantoAcid")){
            return aFood.getPantoAcid();
        }
        if(nutrientType.equals("vitB6")){
            return aFood.getVitB6();
        }
        if(nutrientType.equals("folate")){
            return aFood.getFolate();
        }

        return 0.0;
    }


    public static boolean calculateFunc(Food aFood, String nutrientType, String aCondition, double amount){

        if(aCondition.equals("greaterThan")){
            if(findNutrientType(aFood, nutrientType) > amount){
                return true;
            }
            else{
                return false;
            }
        }
        if(aCondition.equals("greaterThanEqual")){
            if(findNutrientType(aFood, nutrientType) >= amount){
                return true;
            }
            else{
                return false;
            }

        }
        if(aCondition.equals("lessThan")){
            if(findNutrientType(aFood, nutrientType) < amount){
                return true;
            }
            else{
                return false;
            }

        }
        if(aCondition.equals("lessThanEqual")){
            if(findNutrientType(aFood, nutrientType) <= amount){
                return true;
            }
            else{
                return false;
            }
        }
        if(aCondition.equals("equalTo")){
            if(findNutrientType(aFood, nutrientType) == amount){
                return true;
            }
            else{
                return false;
            }

        }

        return false;
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            int d = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
