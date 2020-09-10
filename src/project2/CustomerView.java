package project2;

import com.sun.org.apache.xerces.internal.impl.xs.util.XSObjectListImpl;

import java.util.ArrayList;

import static project2.CMUtility.*;


public class CustomerView {
    private boolean flag =true;
    private ArrayList<Customer> customers = new ArrayList<>(10);

    private void addCustomer(){
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(4);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(15);
        System.out.print("邮箱：");
        String email = CMUtility.readString(15);
        customers.add(new Customer(name, Character.toString(gender), age, phone, email));
        System.out.println("---------------------添加完成---------------------");
    }

    private void modifyCustomer(){
        System.out.println("---------------------修改客户---------------------");
        int i = 0;
        for(;;) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            i = readInt();
            if( i == -1) return;
            else if (i > customers.size() ) System.out.println("对象不存在，请重新选择");
            else if (i < 1) System.out.println("对象从1开始，请重新选择");
            else break;
        }
        Customer cust = customers.get(i - 1);

        System.out.print("姓名(" + cust.getName() + ")：");
        String name = CMUtility.readString(4, cust.getName());

        System.out.print("性别(" + cust.getSex() + ")：");
        char gender = CMUtility.readChar(cust.getSex().charAt(0));

        System.out.print("年龄(" + cust.getAge() + ")：");
        int age = CMUtility.readInt(cust.getAge());

        System.out.print("电话(" + cust.getTel() + ")：");
        String phone = CMUtility.readString(15, cust.getTel());

        System.out.print("邮箱(" + cust.getMail() + ")：");
        String email = CMUtility.readString(15, cust.getMail());

        Customer newCust = new Customer(name, Character.toString(gender), age, phone, email);
        customers.set(i -1,newCust);

        System.out.println("---------------------修改完成---------------------");
    }

    private void deleteCustomer(){
        System.out.println("---------------------删除客户---------------------");
        int i = 0;
        for(;;){
            System.out.print("请选择待删除客户编号(-1退出)：");
            i = readInt();
            if( i == -1) return;
            else if (i > customers.size() ) System.out.println("对象不存在，请重新选择");
            else if (i < 1) System.out.println("对象从1开始，请重新选择");
            else break;
        }
        System.out.println("确认是否删除(Y/N)：");
        char isEnsure = readConfirmSelection();
        if (isEnsure == 'N') return;
        else {
            customers.remove(i -1);
            System.out.println("---------------------删除完成---------------------");
        }
    }

    private void listCustomers(){
        System.out.println("---------------------------客户列表---------------------------");
        if(customers.size() == 0) System.out.println("没有客户记录！");
        else {
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
            for (int i = 0; i < customers.size(); i++) {
                System.out.println(i + 1 + "\t" + customers.get(i).getDetails());
            }
        }
        System.out.println("-------------------------客户列表完成-------------------------");
    }

    public  void mainMenu() {
        while(flag){
            System.out
                    .println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char key = CMUtility.readMenuSelection();
            switch (key){
                case '1' :
                    addCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4' :
                    listCustomers();
                    break;
                case '5' :
                    System.out.println("确认是否退出(Y/N)：");
                    char isQuit = readConfirmSelection();
                    if (isQuit == 'Y') flag = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.mainMenu();
    }
}
