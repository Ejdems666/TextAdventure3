package libs.form;

import libs.form.inputs.FormField;
import libs.form.inputs.NumberField;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by becva on 14.09.2016.
 */
public class Form {
    private LinkedHashMap<String, FormField> inputs = new LinkedHashMap<String, FormField>();
    private Scanner scanner = new Scanner(System.in);

    public FormField addText(String name, String label) {
        FormField input = new FormField(label);
        inputs.put(name,input);
        return input;
    }

    public NumberField addNumber(String name, String label) {
        NumberField input = new NumberField(label);
        inputs.put(name,input);
        return input;
    }

    public FormField addContinue(String name, String label) {
        FormField input = new FormField(label+" (y/n)");
        input.setAllowedValues(new String[]{"y","n","Y","N","Yes","No","yes","no"})
            .setRequired(true);
        inputs.put(name,input);
        return input;
    }

    public int size() {
        return inputs.size();
    }

    public String get(String name) {
        return getInput(name).toString();
    }
    public float getNumber(String name) {
        FormField input = getInput(name);
        if (!(input instanceof NumberField)) {
            System.out.println("Nonexistent number form field '"+name+"'.");
            System.exit(1);
        }
        return ((NumberField) input).getValue();
    }
    public FormField getInput(String name) {
        FormField input = inputs.get(name);
        if(input == null) {
            System.out.println("Nonexistent form field '"+name+"'.");
            System.exit(1);
        }
        return input;
    }

    public ArrayList<Float> getAllNumberInputs() {
        ArrayList<Float> values = new ArrayList<>();
        for (Map.Entry<String,FormField> input : inputs.entrySet()) {
            if (input.getValue() instanceof NumberField) {
                values.add(((NumberField) input.getValue()).getValue());
            }
        }
        return values;
    }

    public String askForField(String name) {
        if(inputs.containsKey(name)) {
            inputs.get(name).askForInput(scanner);
            return inputs.get(name).toString();
        } else {
            System.out.println("Nonexistent form field "+name+", supposed to be asked!");
            System.exit(1);
            return "";
        }
    }

    public void askForAllFields() {
        for (Map.Entry<String,FormField> item : inputs.entrySet()) {
            askForField(item.getKey());
        }
    }
}
