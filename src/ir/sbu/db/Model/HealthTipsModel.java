package ir.sbu.db.Model;

public class HealthTipsModel
{
    private long id;
    private String tip;
    public HealthTipsModel() {
    }

    public HealthTipsModel(long id, String tip) {
        this.id = id;
        this.tip = tip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

}
