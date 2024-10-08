package domin;

public class House {
    private int id;//ID从1自增
    private String name;//租客姓名
    private String phone;//租客电话
    private String address;//地址
    private double rent;//租金
    private String state;//状态（已出租/未出租）

    public House(int id, String name, String phone, String address, double rent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return  id + "\t\t\t\t" +
                name + "\t\t\t\t" +
                phone + "\t\t\t\t" +
                address + "\t\t\t\t" +
                rent + "\t\t\t" +
                state;
    }
}
