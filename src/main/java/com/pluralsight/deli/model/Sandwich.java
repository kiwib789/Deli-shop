package com.pluralsight.deli.model;

import com.pluralsight.deli.model.enums.*;

import java.util.ArrayList;
import java.util.List;

import static com.pluralsight.deli.model.enums.SandwichSize.*;

public class Sandwich extends Product{
    private BreadType breadType;
    private SandwichSize size;
    private boolean isToasted;
    private List<RegularToppings> regularToppings;
    private List<PremiumToppings> premiumToppings;

    public Sandwich(String name, BreadType breadType, SandwichSize size, boolean isToasted) {
        super(name, 0);
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        this.regularToppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public List<RegularToppings> getRegularToppings() {
        return regularToppings;
    }

    public void setRegularToppings(List<RegularToppings> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public List<PremiumToppings> getPremiumToppings() {
        return premiumToppings;
    }

    public void setPremiumToppings(List<PremiumToppings> premiumToppings) {
        this.premiumToppings = premiumToppings;
    }
    public void addRegularToppings(RegularToppings toppings){
    RegularToppings.add(toppings);
    }

    public void addPremiumToppings(PremiumToppings toppings){
    PremiumToppings.add(toppings);
    }

    @Override
    public double getPrice() {
        double total = super.getPrice();
        for (PremiumToppings topping : premiumToppings) {
            if (topping.getType() == PremiumToppings.Type.MEAT) {
                if (size == SandwichSize.SMALL) {
                    total += 1.00;
                } else if (size == SandwichSize.MEDIUM) {
                    total += 2.00;
                } else if (size == SandwichSize.LARGE) {
                    total += 3.00;
                }

            } else if (topping.getType() == PremiumToppings.Type.CHEESE) {
                if (size == SandwichSize.SMALL) {
                    total += 0.75;
                } else if (size == SandwichSize.MEDIUM) {
                    total += 1.50;
                } else if (size == SandwichSize.LARGE) {
                    total += 2.25;
                }
            }
        }

        // Add the price for the bread type
        if (breadType == BreadType.SMALL) {
            total += 5.50;
        } else if (breadType == BreadType.MEDIUM) {
            total += 7.00;
        } else if (breadType == BreadType.LARGE) {
            total += 8.50;
        } else {
            throw new IllegalStateException("Unexpected value: " + breadType);
        }

        return total;
    }
        // need to calculate price based on topping type bread type conditional statements
        //look through premium topping (for loop) list
        // if premium topping is cheese create appropriate pay scale
        // if meat create appropriate pay scale
    }
}

