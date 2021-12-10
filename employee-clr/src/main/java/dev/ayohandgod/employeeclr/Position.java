package dev.ayohandgod.employeeclr;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Position {

    SERVITOR ("Servitor"), DESK_HELP ("Desk Help"), SECURITY ("Security"), BOSS ("Boss"), FRONT_DESK("Front Desk"),
    HOUSEKEEPING("Housekeeping"), CONCIERGE("Concierge");

    private String position;

    private Position(String position){
        this.position = position;
    }

    public String toString() {
        switch (this) {
            case SERVITOR:
                return "Servitor";
            case DESK_HELP:
                return "Desk Helper";
            case SECURITY:
                return "Security";
            case BOSS:
                return "Boss";
        }
        return "";
    }

    @JsonValue
    public String getPosition() {return this.position; }
}
