package ua.opnu;


public class TimeSpan {

    int hours;
    int minutes;

    TimeSpan(int hours, int minutes) {
        if (hours >= 0 && minutes >=0 && minutes <= 59) {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    int getHours() {
        return this.hours;
    }

    int getMinutes() {
        return this.minutes;
    }

    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            return;
        } else if (this.minutes + minutes >= 60) {
            hours++;
            this.minutes += minutes - 60;
        } else {
            this.minutes += minutes;
        }
        this.hours += hours;
    }

    void addTimeSpan(TimeSpan timespan) {
        this.hours += timespan.getHours();
        this.minutes += timespan.getMinutes();
        if (this.minutes >= 60) {
            this.minutes -= 60;
            this.hours ++;
        }
    }

    double getTotalHours() {
        return this.hours + (double)(this.minutes) / 60;
    }

    int getTotalMinutes() {
        return this.hours * 60 + this.minutes;
    }

    public void subtract(TimeSpan span) {
        if (span == null) {
            return;
        }
        int currentTotal = this.getTotalMinutes();
        int subTotal = span.getTotalMinutes();
        if (subTotal > currentTotal) {
            return;
        }
        int result = currentTotal - subTotal;
        this.hours = result / 60;
        this.minutes = result % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) {
            return;
        }
        int total = this.getTotalMinutes();
        long scaled = (long) total * factor;
        if (scaled > Integer.MAX_VALUE) {
            return;
        }
        int newTotal = (int) scaled;
        this.hours = newTotal / 60;
        this.minutes = newTotal % 60;
    }
}