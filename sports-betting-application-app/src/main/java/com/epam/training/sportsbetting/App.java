package com.epam.training.sportsbetting;

import static com.epam.training.sportsbetting.service.SportBettingService.createWager;
import static com.epam.training.sportsbetting.service.SportBettingService.setResults;
import static com.epam.training.sportsbetting.service.TestDataGenerator.generateSportEvents;
import static com.epam.training.sportsbetting.ui.ReadFromConsole.readAmount;
import static com.epam.training.sportsbetting.ui.ReadFromConsole.readOneLine;
import static com.epam.training.sportsbetting.ui.ReadFromConsole.readPlayerDataFromConsole;
import static com.epam.training.sportsbetting.ui.WriteToConsole.listWinnerOutcomes;
import static com.epam.training.sportsbetting.ui.WriteToConsole.printBalance;
import static com.epam.training.sportsbetting.ui.WriteToConsole.printOutcomes;
import static com.epam.training.sportsbetting.ui.WriteToConsole.printWelcomeMessage;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.sportsbetting.domain.outcome.OutcomeOdd;
import com.epam.training.sportsbetting.domain.sportevent.SportEvent;
import com.epam.training.sportsbetting.domain.user.Player;
import com.epam.training.sportsbetting.domain.wager.Wager;

public class App {

    private Player player = new Player();
    private List<SportEvent> sportEvents;
    private List<Wager> wagers = new ArrayList<Wager>();
    private OutcomeOdd selectedOdd;
    private ArrayList<OutcomeOdd> savedOdds;

    private double choosedAmount;

    public static void main(String[] args) {

        App app = new App();
        readPlayerDataFromConsole(app.player);

        printWelcomeMessage(app.player);

        app.sportEvents = generateSportEvents();

        app.makeWagersList();

        setResults(app.player, app.wagers);

        listWinnerOutcomes(app.player, app.wagers);

    }

    public void makeWagersList() {

        selectedOdd = selectOdd();
        while (selectedOdd != null) {
            createWager(player, choosedAmount, selectedOdd, wagers);
            printBalance(player);
            if (player.getBalance() > 0) {
                selectedOdd = selectOdd();
            } else
                selectedOdd = null;
        }
    }

    public OutcomeOdd selectOdd() {
        savedOdds = printOutcomes(sportEvents);
        boolean dataIsValid = false;
        int choosedNumber;
        OutcomeOdd result = null;
        do {
            String readLine = readOneLine();
            if ((readLine).equals("q")) {
                dataIsValid = true;
            } else {
                choosedNumber = Integer.parseInt(readLine);
                if (choosedNumber <= savedOdds.size() && choosedNumber > 0) {
                    dataIsValid = true;
                    choosedAmount = readAmount(player);
                    if (choosedAmount > 0) {
                        result = savedOdds.get(choosedNumber - 1);
                    }
                }
            }
        } while (!dataIsValid);
        return result;
    }

}
