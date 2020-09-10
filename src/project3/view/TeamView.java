package view;

import project3.domain.Employee;
import project3.domain.Programmer;
import project3.service.NameListService;
import project3.service.TeamException;
import project3.service.TeamService;

import static project3.view.TSUtility.*;

public class TeamView {
    private NameListService listSvc;
    private TeamService teamSvc;

    public TeamView() {
        listSvc = new NameListService();
        teamSvc = new TeamService();
    }

    public void enterMainMenu(){
        boolean loopFlag = true;
        char key = '0';

        while(loopFlag){
            if( key != '1'){
                listAllEmployees();
            }
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            key = readMenuSelection();
            switch (key){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N)：");
                    char isEnsure = readConfirmSelection();
                    if (isEnsure == 'Y') loopFlag =false;
                    break;
            }
        }

    }

    private void listAllEmployees(){
        System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
        Employee[] employees = listSvc.getAllEmployees();
        System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        for (Employee e : employees){
            System.out.println(e);
        }
        System.out.println("-------------------------------------------------------------------------------");
    }
    private void getTeam(){
        System.out.println("\n--------------------团队成员列表---------------------\n");
        Programmer[] programmers = teamSvc.getTeams();
        if(programmers.length == 0) System.out.println("开发团队目前没有成员！");
        else System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
        for (Programmer p : programmers){
            System.out.println(p.getTeamDetail());
        }
        System.out.println("-----------------------------------------------------");
    }

    private void addMember(){
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID：");
        int id = readInt();
        try {
            Employee e = listSvc.getEmployee(id);
            teamSvc.addMember(e);
            System.out.println("添加成功");
        } catch (TeamException ex) {
            System.out.println("添加失败，原因：" + ex.getMessage());
        }
        readReturn();
    }

    private void deleteMember(){
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除员工的TID：");
        int id = readInt();
        System.out.println("确认是否删除(Y/N)：");
        char isEnsure = readConfirmSelection();
        if (isEnsure == 'N') return;
        try {
            teamSvc.removeMember(id);
            System.out.println("删除成功");
        } catch (TeamException ex) {
            System.out.println("删除失败，原因：" + ex.getMessage());
        }
        readReturn();
    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
