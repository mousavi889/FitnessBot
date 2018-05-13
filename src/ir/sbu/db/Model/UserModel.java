package ir.sbu.db.Model;

public class UserModel {
    private long id;
    private String state;
    private long weight;
    private long height;
    private long age;
    private String gender;
    private String bloodType;
    private long category;
    private String email;
    private String aliasName;

    public UserModel() {
    }

    public UserModel(long id, long weight, long height, long age, String gender, String bloodType, String state, long category, String aliasName, String email) {
        this.id = id;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
        this.state = state;
        this.category = category;
        this.aliasName = aliasName;
        this.email = email;
        this.bloodType = bloodType;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }
    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }
    public String getAliasName()
    {
        return aliasName;
    }

    public void setAliasName(String aliasName)
    {
        this.aliasName = aliasName;
    }
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


    public String getBloodType()
    {
        return bloodType;
    }

    public void setBloodType(String bloodType)
    {
        this.bloodType = bloodType;
    }


}
