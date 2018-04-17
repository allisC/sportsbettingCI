package com.epam.training.sportsbetting.domain.bet;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.sportsbetting.domain.outcome.Outcome;
import com.epam.training.sportsbetting.domain.sportevent.SportEvent;

public class Bet {

    private SportEvent sportEvent;
    private String description;
    private List<Outcome> outcomes = new ArrayList<Outcome>(); // Different outcomes of the bet (list)

    public Bet(SportEvent sportEvent, String description, List<Outcome> outcomes) {
        super();
        this.sportEvent = sportEvent;
        this.description = description; 
        this.outcomes = outcomes;
    }

    

   

    public String getDescription() {
        return description;
    }


    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    @Override
    public String toString() {
        return "Bet [sportEvent=" + sportEvent + ", description=" + description + ", outcomes=" + outcomes + "]";
    }

}
