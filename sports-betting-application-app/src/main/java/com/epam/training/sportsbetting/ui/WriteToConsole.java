package com.epam.training.sportsbetting.ui;


import java.util.ArrayList;
import java.util.List;

import com.epam.training.sportsbetting.domain.bet.Bet;
import com.epam.training.sportsbetting.domain.outcome.Outcome;
import com.epam.training.sportsbetting.domain.outcome.OutcomeOdd;
import com.epam.training.sportsbetting.domain.sportevent.SportEvent;
import com.epam.training.sportsbetting.domain.user.Player;
import com.epam.training.sportsbetting.domain.wager.Wager;

public class WriteToConsole {

    public static void printWelcomeMessage(Player player) {
        System.out.println("Welcome " + player.getName() + "!");
        System.out.println("Your balance is " + player.getBalance() + " " + player.currency);

    }
    
    public static ArrayList<OutcomeOdd> printOutcomes(List<SportEvent> sportEvents) {
        System.out.println("Please choose an outcome to bet on! (choose a number or press q for quit)");
        ArrayList<OutcomeOdd> savedOdd = new ArrayList<OutcomeOdd>();
        for (SportEvent spE : sportEvents) {
            for (Bet bet : spE.bets) {
                for (Outcome outcome : bet.getOutcomes()) {
                    for (OutcomeOdd outcomeOdd : outcome.outcomeOdds) {

                        System.out.println((savedOdd.size() + 1) + " Bet on the " + spE.getTitle() + " sport event, " + bet.getDescription()
                                + outcome.getValue() + ". The odd on this is " + outcomeOdd.getOddValue() + ", valid from " + outcomeOdd.getValidFrom() + " to "
                                + outcomeOdd.getValidTo());
                        savedOdd.add(outcomeOdd);

                    }
                }
            }
        }
        return savedOdd;
    }

    
    public static void listWinnerOutcomes(Player player, List<Wager> wagers) {
        System.out.println(" The winner bets are: ");
        int i = 0;
        for (Wager wager : wagers) {
            i++;
            if (wager.isWon() == true) {
                System.out.println("The winner is Outcome " + i + " " + "value=" + wager.getOutcomeodd().getOddValue() + ", outcomeOdds="
                        + wager.getOutcomeodd().getOddValue() + " and valid from " + wager.getOutcomeodd().getValidFrom() + " to "
                        + wager.getOutcomeodd().getValidTo());                
            }
        }
        printBalance(player);
    }

	public static void printBalance(Player player) {
		System.out.println("Your new balance is " + player.getBalance() + " " + player.currency);
	}
	
}
