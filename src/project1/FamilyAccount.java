package project1;

import java.time.Year;

public class FamilyAccount {
    private static int account = 10000;
    private static boolean flag = true;
    private static String detail = "收支\t账户金额\t收支金额\t说    明\n";

    public static void main(String[] args) {
        while(flag){
            System.out.println("\n-----------------家庭收支记账软件-----------------\n");
            System.out.println("                   1 收支明细");
            System.out.println("                   2 登记收入");
            System.out.println("                   3 登记支出");
            System.out.println("                   4 退    出\n");
            System.out.print("                   请选择(1-4)：");

            char key = Utility.readMenuSelection();
            switch (key){
                case '1' :
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.print(detail);
                    System.out.println("--------------------------------------------------");
                    break;
                case '2' :
                    System.out.print("本次收入金额：");
                    int inMoney = Utility.readNumber();
                    account += inMoney;
                    System.out.print("本次收入说明：");
                    String inReason = Utility.readString();
                    detail += "收入\t" + account + "\t"+  inMoney + "\t"+ inReason + "\n";
                    System.out.println("---------------------登记完成---------------------");
                    break;
                case '3' :
                    System.out.print("本次支出金额：");
                    int outMoney = Utility.readNumber();
                    account -= outMoney;
                    System.out.print("本次支出说明：");
                    String outReason = Utility.readString();
                    detail += "支出\t" + account + "\t"+  outMoney + "\t"+ outReason + "\n";
                    System.out.println("---------------------登记完成---------------------");
                    break;
                case '4' :
                    System.out.print("确认是否退出(Y/N)：");
                    char isQuit = Utility.readConfirmSelection();
                    if (isQuit == 'Y') flag = false;
                    break;
            }
        }
    }
}
