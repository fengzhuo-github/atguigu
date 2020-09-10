package project3.service;


import project3.domain.*;

public class TeamService {
    private final static int MAX_MEMBER = 5;

    private Programmer[] teams;
    private int memberId = 1;
    private int totalMember = 0;
    private int numOfArch = 0;
    private int numOfDsgn = 0;
    private int numOfPrg = 0;



    public TeamService() {
        this.teams = new Programmer[MAX_MEMBER];
    }

    public Programmer[] getTeams(){
        Programmer[] teams = new Programmer[totalMember];
        for(int i = 0; i < totalMember; i++){
            teams[i] = this.teams[i];
        }
        return teams;
    }

    public void addMember(Employee e) throws TeamException{
//        成员已满，无法添加
        if(totalMember >= MAX_MEMBER) throw new TeamException("成员已满，无法添加");
//        该成员不是开发人员，无法添加
        if(!(e instanceof Programmer)) throw new TeamException("该成员不是开发人员，无法添加");
        Programmer p = (Programmer) e;
//        该员工已在本开发团队中
        if(isExit(p)) throw new TeamException("该员工已在本开发团队中");
//        该员工已是某团队成员
        Status status = p.getStatus();
        if(status == Status.BUSY) throw new TeamException("该员工已是某团队成员");
//        该员正在休假，无法添加
        if(status == Status.VOCATION) throw new TeamException("该员正在休假，无法添加");

//        团队中至多只能有一名架构师
        if (p.getClass() == Architect.class ){
            if(numOfArch < 1){
                insertToTeams(p);
                numOfArch++;
            }else throw new TeamException("团队中至多只能有一名架构师");
        }
//        团队中至多只能有两名设计师
        else if(p.getClass() == Designer.class){
            if (numOfDsgn < 2){
                insertToTeams(p);
                numOfDsgn++;
            }else throw new TeamException("团队中至多只能有两名设计师");
        }
//        团队中至多只能有三名程序员
        else if(p.getClass() == Programmer.class) {
            if (numOfPrg < 3) {
                insertToTeams(p);
                numOfPrg++;
            } else throw new TeamException("团队中至多只能有三名程序员");
        }
    }

    private void insertToTeams(Programmer p) {
        p.setStatus(Status.BUSY);
        p.setMemberId(memberId++);
        teams[totalMember++] = p;
    }

    private boolean isExit(Programmer p){
        for (int i = 0; i < totalMember; i++){
            if(teams[i].getMemberId() == p.getMemberId()) return true;
        }
        return false;
    }

    private int isExit(int memberId){
        for (int i = 0; i < totalMember; i++){
            if(teams[i].getMemberId() == memberId) return i;
        }
        return -1;
    }

    public void removeMember(int memberId) throws TeamException{
        int index = isExit(memberId);
        if (index < 0) throw new  TeamException("找不到该成员，无法删除");
        if (teams[index].getClass() == Architect.class ){
            numOfArch--;
        }
        else if(teams[index].getClass() == Designer.class){
            numOfDsgn--;
        }
        else if(teams[index].getClass() == Programmer.class) {
            numOfPrg--;
        }
        teams[index].setStatus(Status.FREE);
        // for(; index < --totalMember; ){ 不能--totalMember，这样每循环一次，totalMember都-1
        for(; index < totalMember - 1; ){
            teams[index] = teams[++index];
        }
        teams[--totalMember] = null;
    }
}
