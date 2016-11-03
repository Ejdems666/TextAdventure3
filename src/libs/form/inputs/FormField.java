package libs.form.inputs;

import libs.form.exceptions.AllowedValuesViolatedException;
import libs.form.exceptions.FieldRequiredException;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by becva on 14.09.2016.
 */
public class FormField {
    private final String HELP = "/?";

    protected String label;
    protected String[] allowedValues = {};
    protected String defaultValue = "";
    protected String value = "";
    protected int tryCount = 0;
    private boolean required = false;

    public String toString() {
        return value;
    }

    public FormField(String label) {
        this.label = label+" (enter '"+HELP+"' for help)";
    }

    public FormField setRequired(boolean required) {
        this.required = required;
        return this;
    }

    public FormField setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public FormField setAllowedValues(String[] allowedValues) {
        this.allowedValues = allowedValues;
        return this;
    }

    public void askForInput(Scanner scanner) {
        tryCount++;
        printLabel();
        value = scanner.nextLine();
        if(value.equals(HELP)) {
            printHelp();
            askForInput(scanner);
        }
        try {
            if(value.isEmpty()) {
                handleEmptyInput();
            }
            checkAllowedValues();
        } catch (AllowedValuesViolatedException e) {
            System.out.println("Wrong input! It has to match this one of these: "+ getAllowedValues());
            askForInput(scanner);
        } catch (FieldRequiredException e) {
            System.out.println("Please fill in this field.");
            askForInput(scanner);
        }
        tryCount = 0;
    }
    private void printLabel() {
        System.out.println(label +": ");
    }
    protected void printHelp() {
        if(required) {
            System.out.println("This field is required.");
        }
        if(!defaultValue.isEmpty()) {
            System.out.println("Default value is: "+defaultValue);
        }
        if(allowedValues.length > 0) {
            System.out.println("Allowed inputs are: "+getAllowedValues());
        }
    }
    private void handleEmptyInput() throws FieldRequiredException {
        if(!defaultValue.isEmpty()) {
            value = defaultValue;
        } else if(required) {
            throw new FieldRequiredException();
        }
    }
    private String getAllowedValues()
    {
        return Arrays.toString(allowedValues);
    }

    private void checkAllowedValues() throws AllowedValuesViolatedException{
        int unMatched = 0;
        for (int i = 0; i < allowedValues.length; i++) {
            if (!allowedValues[i].equals(value)) {
                unMatched++;
            }
        }
        if (unMatched == allowedValues.length && allowedValues.length > 0) {
            throw new AllowedValuesViolatedException();
        }
    }
}
