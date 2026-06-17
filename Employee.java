public class Employee {

    private String id;
    private String name;
    private String position;
    private String department;
    private String email;
    private String phone;

    private String address;
    private String education;
    private String aadhar;

    private double salary;
    private boolean paid;

    // ===== Default Constructor =====
    public Employee() {}

    // ===== Full Constructor =====
    public Employee(String id, String name, String position,
                    String department, String email,
                    String phone, String address,
                    String education, String aadhar,
                    double salary, boolean paid) {

        this.id = id;
        this.name = name;
        this.position = position;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.education = education;
        this.aadhar = aadhar;
        this.salary = salary;
        this.paid = paid;
    }

    // ===== Getters =====
    public String getId() { return id; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public String getDepartment() { return department; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getEducation() { return education; }
    public String getAadhar() { return aadhar; }
    public double getSalary() { return salary; }
    public boolean isPaid() { return paid; }

    // ===== Setters =====
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPosition(String position) { this.position = position; }
    public void setDepartment(String department) { this.department = department; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    public void setEducation(String education) { this.education = education; }
    public void setAadhar(String aadhar) { this.aadhar = aadhar; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setPaid(boolean paid) { this.paid = paid; }

    // ===== Helper Method for UI =====
    public String getPaidStatus() {
        return paid ? "Yes" : "No";
    }

    // ===== Debug / Logging =====
    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", education='" + education + '\'' +
                ", aadhar='" + aadhar + '\'' +
                ", salary=" + salary +
                ", paid=" + paid +
                '}';
    }
}
