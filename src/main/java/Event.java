import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Event extends TaskWithDate {
    protected LocalDate startDate;
    protected LocalDate endDate;

    public Event(String name, LocalDate startDate, LocalDate endDate) {
        super(name);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean overlapsWith(LocalDate localDate) {
        return (localDate.equals(this.startDate) || localDate.isAfter(this.startDate))
                && (localDate.equals(this.endDate) || localDate.isBefore(this.endDate));
    }

    @Override
    public String formatDate(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
    }

    @Override
    public String toString() {
        return "[E]"
                + super.toString()
                + " (from: "
                + this.formatDate(this.startDate)
                + " to: "
                + this.formatDate(this.endDate)
                + ")";
    }

    @Override
    public String parseTaskInfo() {
        return "E, "
                + (this.isCompleted ? "1, " : "0, ")
                + this.name + ", "
                + this.startDate + ", "
                + this.endDate
                + "\n";
    }
}
