import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class RegistroEntradaYSalida {

    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private DateTimeFormatter dateTimeFormatter;

    public RegistroEntradaYSalida() {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        this.horaEntrada = LocalDateTime.now();
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalidaDefault() {
        this.horaSalida = LocalDateTime.now();
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }


    public String formatDate(LocalDateTime date) {
        return date.format(this.dateTimeFormatter);
    }

}