//
// Money.java är en hjälpklass som finns för att hantera pengar.
// 

package myassets.helper;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 *
 * @author Patrick
 */

// Valutor vi känner till
enum Currency {

    SEK, EUR, USD
}

public class Money {

    private BigDecimal amount;
    private Currency currency;

    public Money(double amount) {
        this.amount = BigDecimal.valueOf(amount);
        this.currency = Currency.SEK;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(this.amount) + " " + this.currency;
    }
}
