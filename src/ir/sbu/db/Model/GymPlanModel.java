package ir.sbu.db.Model;

public class GymPlanModel
{
    private long id;
    private String plan1;
    private String plan2;
    private String plan3;
    public GymPlanModel() {
    }

    public GymPlanModel(long id, String plan1, String plan2, String plan3) {
        this.id = id;
        this.plan1 = plan1;
        this.plan2 = plan2;
        this.plan3 = plan3;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlan1() {
        return plan1;
    }

    public void setPlan1(String plan1) {
        this.plan1 = plan1;
    }

    public String getPlan2(){
        return plan2;
    }
    public void setPlan2(String plan2){
        this.plan2 = plan2;
    }

    public String getPlan3()
    {
        return plan3;
    }

    public void setPlan3(String plan3)
    {
        this.plan3 = plan3;
    }

}
