package br.com.unisoma.api.util;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class RoundingNumbers {
    public Float RoundingNumber(Float number, String locale) {
        Locale local = new Locale(locale);
        NumberFormat nf = NumberFormat.getInstance(local);

        nf.setRoundingMode(RoundingMode.HALF_EVEN);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        Float roundingFloat = Float.parseFloat(nf.format(number).replaceAll(",", ""));

        return roundingFloat;
    }
}
