package cn.view;

public class StaffRank {
    private int channel_id;
    private String channel_name;
    private String staff_name;
    private int count;
    private float Gold;

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getGold() {
        return Gold;
    }

    public void setGold(float gold) {
        Gold = gold;
    }

}
