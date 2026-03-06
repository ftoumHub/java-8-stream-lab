package init.terminal.custom;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class CollectorUtils {


    public static Collector<Patient, HealthReport, HealthReport> healthReportCollector() {
        return Collector.of(

                // Supplier : création du conteneur
                HealthReport::new,

                // Accumulator : traitement de chaque patient
                (report, patient) -> {
                    report.totalPatients++;
                    report.totalTemperature += patient.getTemperature();
                    if (patient.getTemperature() > 38) {
                        report.feverPatients++;
                    }
                },

                // Combiner (utile en parallelStream)
                (r1, r2) -> {
                    r1.totalPatients += r2.totalPatients;
                    r1.feverPatients += r2.feverPatients;
                    r1.totalTemperature += r2.totalTemperature;
                    return r1;
                }
        );
    }

    public static void main(String[] args) {

        List<Patient> patients = Arrays.asList(
                new Patient("Alice Martin", 34, 36.8),
                new Patient("Bernard Dupont", 72, 38.5),
                new Patient("Claire Moreau", 15, 39.2),
                new Patient("David Leroy", 45, 37.4),
                new Patient("Emma Petit", 29, 40.1),
                new Patient("François Garcia", 60, 38.0),
                new Patient("Sophie Bernard", 50, 36.5),
                new Patient("Lucas Roux", 8, 39.0),
                new Patient("Chloé Fournier", 23, 37.8),
                new Patient("Hugo Lambert", 80, 38.7)
        );

        HealthReport report = patients.stream()
                .collect(healthReportCollector());

        System.out.println(report);
    }

}
