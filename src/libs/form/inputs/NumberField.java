package libs.form.inputs;

import libs.form.exceptions.AllowedValuesViolatedException;

import java.util.Scanner;

/**
 * Created by becva on 14.09.2016.
 */
public class NumberField extends FormField {
    private float rangeFrom = Float.MAX_VALUE;
    private float rangeTo = Float.MIN_VALUE;
    private float value;

    public NumberField(String label) {
        super(label);
    }

    /**
     * @param rangeFrom insert Float.MAX_VALUE to be ignored
     * @param rangeTo insert Float.MIN_VALUE to be ignored
     */
    public FormField setRange(float rangeFrom, float rangeTo) {
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        return this;
    }

    public float getValue() {
        return Float.parseFloat(super.value);
    }

    public void askForInput(Scanner scanner) {
        try {
            super.askForInput(scanner);
            value = Float.parseFloat(super.value);
            checkRange(value);
        } catch (NumberFormatException e) {
            System.out.println("Wrong input! It has to be float.");
            askForInput(scanner);
        } catch (AllowedValuesViolatedException e) {
            System.out.println("Wrong input! It has to be float " + getRangeName());
            askForInput(scanner);
        }
    }
    private void checkRange(float value) throws AllowedValuesViolatedException {
        if(rangeFrom != Float.MAX_VALUE && value < rangeFrom) {
            throw new AllowedValuesViolatedException();
        }
        if(rangeTo != Float.MIN_VALUE && value > rangeTo) {
            throw new AllowedValuesViolatedException();
        }
    }
    private String getRangeName() {
        if(rangeFrom != Float.MAX_VALUE ) {
            if(rangeTo != Float.MIN_VALUE) {
                return "between "+ rangeFrom +" and "+ rangeTo;
            }
            return "from "+ rangeFrom;
        } else if(rangeTo != Float.MIN_VALUE){
            return  "up to "+ rangeTo;
        }
        return "";
    }

    protected void printHelp() {
        super.printHelp();
        String rangeHelper = getRangeName();
        if (!rangeHelper.isEmpty()) {
            System.out.println("Allowed input is float " + rangeHelper);
        }
    }
}
