package init.terminal.custom;

class HealthReport {

    long totalPatients;
    long feverPatients;
    double totalTemperature;

    public double getAverageTemperature() {
        return totalPatients == 0 ? 0 : totalTemperature / totalPatients;
    }

    @Override
    public String toString() {
        return "Total=" + totalPatients + ", \n" +
                "Fever=" + feverPatients + ", \n" +
                "AvgTemp=" + getAverageTemperature();
    }
}
