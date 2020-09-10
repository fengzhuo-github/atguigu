package project3.domain;

public class PC implements Equipment{
    private String model;
    private String display;

    public PC(String model, String display){
        this.display = display;
        this.model = model;
    }

    public String getDescription(){
        return this.model + "(" + this.display +")";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
