package reparacionesaa.control;

public class Device {
    private String generation;
    private String color;
    private String idTag;
    private Parts parts;

    public Device() {
    }


    public String getGeneration() {
        return this.generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIdTag() {
        return this.idTag;
    }

    public void setIdTag(String idTag) {
        this.idTag = idTag;
    }

    public Parts getParts() {
        return this.parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }


}
