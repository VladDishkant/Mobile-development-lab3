package ua.kpi.comsys.iv7312;

public class State {

    private String title; // назва
    private String year;  // рік
    private String type;  // тип
    private int poster; // ресурс флага

    public State(String title, String year, String type, int poster){

        this.title=title;
        this.year=year;
        this.type=type;
        this.poster=poster;
    }

    public String getTitle() {
        return this.title;
    }

    public String getYear() {
        return this.year;
    }

    public String getType() { return this.type; }

    public int getPoster() {
        return this.poster;
    }
}