package priorityQueue;

import java.time.LocalDateTime;

class Task implements Comparable<Task> {
    private final String aufgabeBeschreibung;
    private final int prioritaet;
    private LocalDateTime termin;

    Task(String aufgabeBeschreibung, EPrioritaet prioritaet) {
        this.aufgabeBeschreibung = aufgabeBeschreibung;
        this.prioritaet = switch (prioritaet) {
            case HIGH -> 3;
            case NORMAL -> 2;
            case LOW -> 1;
        };
    }

    void setTermin(LocalDateTime termin) {
        this.termin = termin;
    }

    @Override
    public String toString() {
        return this.aufgabeBeschreibung + " " + this.prioritaet;
    }

    @Override
    public int compareTo(Task task) {
        if(this.termin != null && task.termin != null) {
            if(this.termin.isEqual(task.termin)) {
                return task.prioritaet - this.prioritaet;
            }
            return this.termin.compareTo(task.termin);
        }
        return task.prioritaet - this.prioritaet;
    }
}
