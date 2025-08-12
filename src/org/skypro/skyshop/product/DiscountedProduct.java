package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountInWholePercentages;

    public DiscountedProduct(String name, int basePrice, int discountInWholePercentages) {
        super(name);
        this.basePrice = basePrice;
        this.discountInWholePercentages = discountInWholePercentages;
    }


    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getDiscountInWholePercentages() {
        return discountInWholePercentages;
    }


    public void setDiscountInWholePercentages(int discountInWholePercentages) {
        this.discountInWholePercentages = discountInWholePercentages;
    }


    @Override
    public int getPrice() {
        if (discountInWholePercentages < 1 || discountInWholePercentages > 100) {
            throw new IllegalArgumentException("Размер скидки должен быть от 1 до 100 процентов");
        }

        double discountedPrice = basePrice * (1 - (discountInWholePercentages / 100.0));
        return (int) Math.round(discountedPrice);
    }


    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getFormattedInfo() {
        return "<" + getName() + ">" + ":" + "<" + getPrice() + ">" + "(" + "<" + discountInWholePercentages + ">" + "%" + ")";
    }
}





            







