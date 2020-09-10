package project3.domain;

import project3.service.Status;

public class Designer extends Programmer {
    private double bonus;

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getTeamDetail(){return getPrgDetail() + "\t设计师\t" + bonus;}

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" +  bonus +"\t\t\t" + getEquipment().getDescription();
    }
}
