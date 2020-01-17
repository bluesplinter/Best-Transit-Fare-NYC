package BestTransit;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class BestPTNewYork {

    //FARE PRICES
    double[] fare_price = {2.75, 33.00, 127.00};
    

    public double prices (double trips_per_day, double days_staying) {

        //TAKING OUT DECIMALS
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        //WEEKS AND MONTHS MULTIPLIER VARIABLES
        double weeks = 0;
        double months = 0;

        double month_price = fare_price [2];
        double week_price = fare_price [1];
        double day_price = fare_price [0];


        // WEEKS & MONTH PRICE MULTIPLIER
        while (weeks != Math.floor(days_staying / 7)) {
            weeks += 1;
        }
        fare_price[1] = fare_price[1] * (weeks - 1) + 33;

        while (months != Math.floor(days_staying / 30)) {
            months += 1;
        }
        fare_price[2] = fare_price[2] * months + 127;

        // DAYS PRICE MULTIPLIER
        for (double i = 0; i < days_staying; i++) {
            fare_price[0] = trips_per_day * 2.75 * days_staying;
        }
        if (fare_price[0] > fare_price[2] && fare_price[1] > fare_price[2] && days_staying > 21) {
            return month_price;
        } else if (fare_price[0] < fare_price[1]) {
            return week_price;
        } else {
            return day_price;
        }
    }


    // MAIN METHOD
    public static void main(String[] args) {
            //TOURIST
            BestPTNewYork tourist = new BestPTNewYork();
        System.out.println(tourist.prices(5,8));
    }
    }
