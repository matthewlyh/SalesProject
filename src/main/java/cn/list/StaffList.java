package cn.list;

public class StaffList {
    private String staff_code;
    private String staff_name;
    private int sex;
    private String lan_name;
    private String phone_nbr;
    private String channel_name;
    private int Type;
    private float Gold;
    private int Sank;
    
    
    public int getSank() {
		return Sank;
	}

	public void setSank(int sank) {
		Sank = sank;
	}

	public float getGold() {
		return Gold;
	}

	public void setGold(float gold) {
		Gold = gold;
	}

	public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getStaff_code() {
        return staff_code;
    }

    public void setStaff_code(String staff_code) {
        this.staff_code = staff_code;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getLan_name() {
        return lan_name;
    }

    public void setLan_name(String lan_name) {
        this.lan_name = lan_name;
    }

    public String getPhone_nbr() {
        return phone_nbr;
    }

    public void setPhone_nbr(String phone_nbr) {
        this.phone_nbr = phone_nbr;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }
}
