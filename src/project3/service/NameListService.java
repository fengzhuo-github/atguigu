package project3.service;

import project3.domain.*;

import java.util.SplittableRandom;

import static project3.service.Data.*;

public class NameListService {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[EMPLOYEES.length];
        for(int i = 0; i < EMPLOYEES.length; i++){
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            int id =  Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            Double bonus;
            int stock;
            switch (type){
                case EMPLOYEE :
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER :
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER :
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] =new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT :
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment,bonus,stock);
                    break;
            }
        }
    }

    private Equipment createEquipment(int i) {
        int type = Integer.parseInt(EQUIPMENTS[i][0]);
        String string1 = EQUIPMENTS[i][1];
        String string2 = EQUIPMENTS[i][2];
        switch (type){
            case PC :
                return new PC(string1, string2);
            case NOTEBOOK :
                return new NoteBook(string1, Double.parseDouble(string2));
            case PRINTER :
                return new Printer(string1,string2);
        }
        return null;
    }

    public Employee[] getAllEmployees(){
        return employees;
    }

    public Employee getEmployee(int i) throws TeamException {
        for(Employee e: employees){
            if (e.getId() == i) return e;
        }
        throw new TeamException("员工不存在");
    }

    public static void main(String[] args) {
        NameListService list = new NameListService();
        Employee[] employees = list.getAllEmployees();
        for (Employee e : employees){
            System.out.println(e);
        }
        try {
            Employee e = list.getEmployee(11);
            System.out.println(e);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
