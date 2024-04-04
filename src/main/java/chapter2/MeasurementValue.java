package chapter2;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MeasurementValue {

    private double inputValue;
    private String inputUOM;

    //metric
    private double centimetres;
    private double meters;
    private double kilometres;

    //imperial
    private double inches;
    private double feet;
    private double miles;

    //conversion constants
    private final int CENTIMETRES_PER_METERS = 100;
    private final int METRES_PER_KILOMETRES = 1000;
    private final int INCHES_PER_FOOT = 12;
    private final int FEET_PER_MILE = 5280;
    private final double METRES_PER_FOOT = 0.3048d;

    private static final DecimalFormat dFormat = new DecimalFormat("0.00");
    private static final DecimalFormat mKmFormat = new DecimalFormat("0.000");

    public MeasurementValue(String valueStr) throws Exception {
        parseInput(valueStr);
        runConversion();
    }

    public MeasurementValue(double value, String uom) throws Exception {
        inputValue = value;
        inputUOM = uom;
        runConversion();
    }

    private void parseInput(String input) {
        String[] params = input.trim().split(" ");
        inputValue = Double.parseDouble(params[0]);
        inputUOM = params[1];
    }

    private void runConversion() throws Exception {
        switch (inputUOM) {
            case "in":
                inches = inputValue;

                feet = inches / INCHES_PER_FOOT;

                miles = feet / FEET_PER_MILE;

                convertImperialToMetric();

                break;
            case "ft":
                feet = inputValue;

                inches = feet * INCHES_PER_FOOT;

                miles = feet / FEET_PER_MILE;

                convertImperialToMetric();

                break;
            case "mi":
                miles = inputValue;

                feet = miles * FEET_PER_MILE;

                inches = feet * INCHES_PER_FOOT;

                convertImperialToMetric();

                break;
            case "cm":
                centimetres = inputValue;

                meters = centimetres / CENTIMETRES_PER_METERS;

                kilometres = meters / METRES_PER_KILOMETRES;

                convertMetricToImperial();

                break;
            case "m":
                meters = inputValue;

                centimetres = meters * CENTIMETRES_PER_METERS;

                kilometres = meters / METRES_PER_KILOMETRES;

                convertMetricToImperial();

                break;
            case "km":
                kilometres = inputValue;

                meters = kilometres * METRES_PER_KILOMETRES;

                centimetres = meters * CENTIMETRES_PER_METERS;

                convertMetricToImperial();

                break;
            default:
                throw new InvalidUOMException();
        }
    }

    private void convertImperialToMetric() {
        // use feet/meters as our conversion
        meters = feet * METRES_PER_FOOT;
        centimetres = meters * CENTIMETRES_PER_METERS;
        kilometres = meters / METRES_PER_KILOMETRES;
    }

    private void convertMetricToImperial() {
        // use feet/meters as our conversion
        feet = meters / METRES_PER_FOOT;
        inches = feet * INCHES_PER_FOOT;
        miles = feet / FEET_PER_MILE;
    }

    public String toString() {
        dFormat.setRoundingMode(RoundingMode.UP);
        mKmFormat.setRoundingMode(RoundingMode.UP);

        StringBuilder values = new StringBuilder();
        values.append("\ninches = ");
        values.append(dFormat.format(inches));
        values.append("\nfeet = ");
        values.append(dFormat.format(feet));
        values.append("\nmiles = ");
        values.append(mKmFormat.format(miles));
        values.append("\ncentimetres = ");
        values.append(dFormat.format(centimetres));
        values.append("\nmeters = ");
        values.append(dFormat.format(meters));
        values.append("\nkilometres = ");
        values.append(mKmFormat.format(kilometres));

        return values.toString();
    }
}
