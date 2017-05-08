/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava; 
 */

package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        boolean hasWhippedCream = ((CheckBox) findViewById(R.id.whipped_cream)).isChecked();
        boolean hasChocolate = ((CheckBox) findViewById(R.id.chocolate)).isChecked();
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String customerName = ((TextView) findViewById(R.id.customer_name)).getText().toString();
        String priceMessage = createOrderSummary(customerName, price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    private String createOrderSummary(String customerName, int price, boolean hasWhippedCream, boolean hasChocolate) {
        String priceMessage = "Name: " + customerName;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nAdd whipped cream? " + hasWhippedCream;
        priceMessage += "\nAdd chocolate? " + hasChocolate;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int price = 5;
        if (hasWhippedCream && hasChocolate) {
            price += 3;
        } else if (hasWhippedCream) {
            price += 1;
        } else if (hasChocolate) {
            price += 2;
        }
        return quantity * price;
    }

    /**
     * This method increments quantity by 1 when + button is clicked
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method decrements quantity by 1 when - button is clicked
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    public void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}