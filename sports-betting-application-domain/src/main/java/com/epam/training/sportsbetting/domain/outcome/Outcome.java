package com.epam.training.sportsbetting.domain.outcome;

import java.util.ArrayList;
import java.util.List;

public class Outcome {

    private String value;

    public Outcome(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    void setValue(String value) {
        this.value = value;
    }

    public List<OutcomeOdd> outcomeOdds = new ArrayList<OutcomeOdd>();

    @Override
    public String toString() {
        return "Outcome [value=" + value + ", outcomeOdds=" + outcomeOdds + "]";
    }

}
