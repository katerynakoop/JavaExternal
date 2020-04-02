package javaexternal.epam.task6.xmlparser.model.beerbuilder;

import javaexternal.epam.task6.xmlparser.model.classes_for_xmlfile.*;
import javaexternal.epam.task6.xmlparser.model.validation.DataValidator;

public class BeerBuilder
{
    Beer beer;

    public BeerBuilder(Builder builder)
    {
        beer = builder.beer;
    }

    public Beer getBeer()
    {
        return beer;
    }
    public static class Builder
    {
        DataValidator dataValidator = new DataValidator();
        ObjectFactory objectFactory = new ObjectFactory();

        Beer beer;
        Characteristics characteristics;
        Grain grain;
        Hops hops;
        Ingredients ingredients;
        NutritionalValue nutritionalValue;
        Strength strength;
        Sugar sugar;
        Filtering filtering;
        Transparency transparency;
        Water water;
        Yeast yeast;

        public Builder()
        {
            beer = objectFactory.createBeerObject();
            characteristics = objectFactory .createCharacteristicsObject();
            grain = objectFactory.createGrainObject();
            hops = objectFactory.createHopsObject();
            ingredients = objectFactory.createIngredientsObject();
            nutritionalValue = objectFactory.createNutritionalValueObject();
            strength = objectFactory.createStrengthObject();
            sugar = objectFactory.createSugarObject();
            transparency = objectFactory.createTransparencyObject();
            water = objectFactory.createWaterObject();
            yeast = objectFactory.createYeastObject();
            filtering = objectFactory.createFilteringObject();
        }

        public Builder setBeer(String name, String type, String alcohol, String manufacturer)
        {
            beer.setName(name);
            beer.setType(type);
            beer.setAlcohol(alcohol);
            beer.setManufacturer(manufacturer);
            beer.setIngredients(ingredients);
            beer.setCharacteristics(characteristics);
            dataValidator.validate(beer);
            dataValidator.closeValidatorFactory();

            return this;
        }

        public Builder setIngredients()
        {
            ingredients.setGrain(grain);
            ingredients.setHops(hops);
            ingredients.setSugar(sugar);
            ingredients.setWater(water);
            ingredients.setYeast(yeast);

            dataValidator.validate(ingredients);
            dataValidator.closeValidatorFactory();

            return this;
        }

        public Builder setCharacteristics()
        {
            characteristics.setFiltering(filtering);
            characteristics.setStrength(strength);
            characteristics.setTransparency(transparency);
            characteristics.setNutritionalValue(nutritionalValue);

            dataValidator.validate(characteristics);
            dataValidator.closeValidatorFactory();

            return this;
        }

        public Builder setWater(int value, String unit)
        {
            water.setValue(value);
            water.setUnit(unit);

            dataValidator.validate(water);
            dataValidator.closeValidatorFactory();

            return this;
        }

        public Builder setGrain(int value, String unit)
        {
            grain.setValue(value);
            grain.setUnit(unit);

            dataValidator.validate(grain);
            dataValidator.closeValidatorFactory();

            return this;
        }

        public Builder setHops(int value, String unit)
        {
            hops.setValue(value);
            hops.setUnit(unit);

            dataValidator.validate(hops);
            dataValidator.closeValidatorFactory();

            return this;
        }

        public Builder setYeast(int value, String unit)
        {
            yeast.setValue(value);
            yeast.setUnit(unit);

            dataValidator.validate(yeast);
            dataValidator.closeValidatorFactory();

            return this;
        }

        public Builder setSugar(int value, String unit)
        {
            sugar.setValue(value);
            sugar.setUnit(unit);

            dataValidator.validate(sugar);
            dataValidator.closeValidatorFactory();

            return this;
        }

        public Builder setStrength(int value, String unit)
        {
            strength.setValue(value);
            strength.setUnit(unit);

            dataValidator.validate(strength);
            dataValidator.closeValidatorFactory();

            return this;
        }

        public Builder setFiltering(String value)
        {
            filtering.setValue(value);

            dataValidator.validate(filtering);
            dataValidator.closeValidatorFactory();

            return this;
        }

        public Builder setTransparency(int value, String unit)
        {
            transparency.setValue(value);
            transparency.setUnit(unit);

            dataValidator.validate(transparency);
            dataValidator.closeValidatorFactory();

            return this;
        }

        public Builder setNutritionalValue(int value, String unit)
        {
            nutritionalValue.setValue(value);
            nutritionalValue.setUnit(unit);

            dataValidator.validate(nutritionalValue);
            dataValidator.closeValidatorFactory();

            return this;
        }

        public BeerBuilder build()
        {
            return new BeerBuilder(this);
        }
    }
}
