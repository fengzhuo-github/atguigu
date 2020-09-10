package project3.service;

public enum Status {
    FREE("FREE"),BUSY("BUSY"),VOCATION("VOCATION");
    private String name;

    Status(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
