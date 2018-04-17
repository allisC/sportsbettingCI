package com.epam.training.sportsbetting.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import com.epam.training.sportsbetting.domain.outcome.OutcomeOdd;
import com.epam.training.sportsbetting.domain.user.Player;
import com.epam.training.sportsbetting.domain.wager.Wager;

public class SportBettingService {

	public static void createWager(Player player, double choosedAmount, OutcomeOdd selectedOdd, List<Wager> wagers) {
		wagers.add(new Wager(player, selectedOdd, choosedAmount));
		player.setBalance(player.getBalance() - choosedAmount);
	}

    public static void setResults(Player player, List<Wager> wagers) {
        double wonAmount;
        int i = 0;
        for (Wager wager : wagers) {
            i++;
            Random rand = new Random();
            wager.setWon(rand.nextBoolean());
            wager.setProcessed(true);
            if (wager.isWon() == true) {

                wonAmount = wager.getAmount() * wager.getOutcomeodd().getOddValue();
                player.setBalance(player.getBalance() + wonAmount);
            }
        }        
    }
    
    
    public static LocalDate stringToDate(String givenDate) {
        String[] dateString = new String[3];
        dateString = givenDate.split("\\.|-|:");
        int[] dateInt = new int[3];
        for (int i = 0; i < 3; i++) {
            dateInt[i] = Integer.parseInt(dateString[i]);
        }
        LocalDate givenDate2 = LocalDate.of(dateInt[0], dateInt[1], dateInt[2]);
        return givenDate2;
    }
    
}
