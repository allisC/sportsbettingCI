package com.epam.training.sportsbetting.domain.sportevent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.sportsbetting.domain.bet.Bet;

public abstract class SportEvent {

    protected String title;
    protected LocalDate startDate;
    protected LocalDate endDate;

    protected SportEvent(String title, LocalDate startDate, LocalDate endDate) {
        super();
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public List<Bet> bets = new ArrayList<Bet>();
    protected Result result = new Result();

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Bet> getBets() {
        return bets;
    }

    void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public Result getResult() {
        return result;
    }

    void setResult(Result result) {
        this.result = result;
    }

}
