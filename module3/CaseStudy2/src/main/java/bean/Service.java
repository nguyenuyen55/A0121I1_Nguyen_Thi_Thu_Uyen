package bean;

public class Service {
    private int service_id;
    private String service_name;
    private int service_area;
    private double service_cost;
    private int service_people;
    private int rent_id;
    private int service_type_id;
    private String standard_room;
    private String description;
    private double pool_area;
    private int number_foors;

    public Service(String service_name, int service_area, double service_cost, int service_people, int rent_id, int service_type_id, String standard_room, String description, double pool_area, int number_foors) {
        this.service_name = service_name;
        this.service_area = service_area;
        this.service_cost = service_cost;
        this.service_people = service_people;
        this.rent_id = rent_id;
        this.service_type_id = service_type_id;
        this.standard_room = standard_room;
        this.description = description;
        this.pool_area = pool_area;
        this.number_foors = number_foors;
    }

    public Service(int service_id, String service_name, int service_area, double service_cost, int service_people, int rent_id, int service_type_id, String standard_room, String description, double pool_area, int number_foors) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_area = service_area;
        this.service_cost = service_cost;
        this.service_people = service_people;
        this.rent_id = rent_id;
        this.service_type_id = service_type_id;
        this.standard_room = standard_room;
        this.description = description;
        this.pool_area = pool_area;
        this.number_foors = number_foors;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getService_area() {
        return service_area;
    }

    public void setService_area(int service_area) {
        this.service_area = service_area;
    }

    public double getService_cost() {
        return service_cost;
    }

    public void setService_cost(double service_cost) {
        this.service_cost = service_cost;
    }

    public int getService_people() {
        return service_people;
    }

    public void setService_people(int service_people) {
        this.service_people = service_people;
    }

    public int getRent_id() {
        return rent_id;
    }

    public void setRent_id(int rent_id) {
        this.rent_id = rent_id;
    }

    public int getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(int service_type_id) {
        this.service_type_id = service_type_id;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumber_foors() {
        return number_foors;
    }

    public void setNumber_foors(int number_foors) {
        this.number_foors = number_foors;
    }
}
