public class University {
    String name;
    String program;
    String status;

    University(String name, String program) {
        this.name = name;
        this.program = program;
        this.status = "Planned";
    }
    void display() {
        System.out.println("University: " + name);
        System.out.println("Program: " + program);
        System.out.println("Status: " + status);
    }

}
