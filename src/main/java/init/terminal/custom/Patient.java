package init.terminal.custom;

class Patient {
    private String name;
    private int age;
    private double temperature; // température corporelle

    public Patient(String name, int age, double temperature) {
        this.name = name;
        this.age = age;
        this.temperature = temperature;
    }

    public double getTemperature() { return temperature; }
}

