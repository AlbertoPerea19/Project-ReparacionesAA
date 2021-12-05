package reparacionesaa.reparations;

import reparacionesaa.control.Parts;

public class Reparation {
  
    private String type;
    private int duration;
    private Parts parts;



    public Reparation() {
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Parts getParts() {
        return this.parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

}
