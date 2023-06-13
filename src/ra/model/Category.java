package ra.model;

public class Category {
    private int id;
    private String name;
    private String descriptions;
    private boolean status = true;

    public Category() {
    }

    public Category(int id, String name, String descriptions, boolean status) {
        this.id = id;
        this.name = name;
        this.descriptions = descriptions;
        this.status = status;
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

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "-----------------------------------------------------\n"+
                "ID : "+ id + "| Name : "+name;
    }
}
