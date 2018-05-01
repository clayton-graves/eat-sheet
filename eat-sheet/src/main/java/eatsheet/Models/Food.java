package eatsheet.Models;


//import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data")
public class Food {

    @Id
    public int id;

    public String name;

    public double water;

    public double calories;

    public double protein;

    public double lipids;

    public double ash;

    public double carbs;

    public double fiber;

    public double sugar;

    public double calcium;

    public double iron;

    public double magnesium;

    public double phosphorus;

    public double potassium;

    public double sodium;

    public double zinc;

    public double copper;

    public double manganese;

    public double selenium;

    public double vitC;

    public double thiamin;

    public double riboflaxin;

    public double niacin;

    public double pantoAcid;

    public double vitB6;

    public double folate;

    public double getAsh() {
        return ash;
    }

    public double getCalcium() {
        return calcium;
    }

    public double getCalories() {
        return calories;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getCopper() {
        return copper;
    }

    public double getFiber() {
        return fiber;
    }

    public double getFolate() {
        return folate;
    }

    public double getIron() {
        return iron;
    }

    public double getLipids() {
        return lipids;
    }

    public double getMagnesium() {
        return magnesium;
    }

    public double getManganese() {
        return manganese;
    }

    public String getName() {
        return name;
    }

    public double getNiacin() {
        return niacin;
    }

    public double getPantoAcid() {
        return pantoAcid;
    }

    public double getPhosphorus() {
        return phosphorus;
    }

    public double getPotassium() {
        return potassium;
    }

    public double getProtein() {
        return protein;
    }

    public double getRiboflaxin() {
        return riboflaxin;
    }

    public double getSelenium() {
        return selenium;
    }

    public double getSodium() {
        return sodium;
    }

    public double getSugar() {
        return sugar;
    }

    public double getThiamin() {
        return thiamin;
    }

    public double getVitB6() {
        return vitB6;
    }

    public double getVitC() {
        return vitC;
    }

    public double getWater() {
        return water;
    }

    public double getZinc() {
        return zinc;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public void setAsh(double ash) {
        this.ash = ash;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public void setCopper(double copper) {
        this.copper = copper;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    public void setFolate(double folate) {
        this.folate = folate;
    }

    public void setIron(double iron) {
        this.iron = iron;
    }

    public void setLipids(double lipids) {
        this.lipids = lipids;
    }

    public void setMagnesium(double magnesium) {
        this.magnesium = magnesium;
    }

    public void setManganese(double manganese) {
        this.manganese = manganese;
    }

    public void setNiacin(double niacin) {
        this.niacin = niacin;
    }

    public void setPantoAcid(double pantoAcid) {
        this.pantoAcid = pantoAcid;
    }

    public void setPhosphorus(double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setRiboflaxin(double riboflaxin) {
        this.riboflaxin = riboflaxin;
    }

    public void setSelenium(double selenium) {
        this.selenium = selenium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public void setThiamin(double thiamin) {
        this.thiamin = thiamin;
    }

    public void setVitB6(double vitB6) {
        this.vitB6 = vitB6;
    }

    public void setVitC(double vitC) {
        this.vitC = vitC;
    }

    public void setZinc(double zinc) {
        this.zinc = zinc;
    }

    public Food() {

    }

    //may need other constructor
}
