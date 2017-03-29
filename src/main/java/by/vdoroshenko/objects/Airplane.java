package by.vdoroshenko.objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by viktoriyadoroshenko on 3/29/17.
 */

@XmlRootElement(name = "Airplane")
public class Airplane {
    private int id;
    private String name;
    private String type;
    private int speed;
    private double capacity;
    private int length;

    public int getId() {
        return id;
    }

    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @XmlElement(name = "Type")
    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    @XmlElement(name = "MaxSpeed")
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getCapacity() {
        return capacity;
    }

    @XmlElement(name = "Capacity")
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public int getLength() {
        return length;
    }

    @XmlElement(name = "Length")
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n------Airplane----- \n");
        sb.append("id = ").append(id).append("\n");
        sb.append("Name = ").append(name).append("\n");
        sb.append("Type = ").append(type).append("\n");
        sb.append("Speed = ").append(speed).append(" km/h \n");
        sb.append("Capacity = ").append(capacity).append(" ton\n");
        sb.append("Length = ").append(length).append(" m \n");
        return sb.toString();
    }

}

