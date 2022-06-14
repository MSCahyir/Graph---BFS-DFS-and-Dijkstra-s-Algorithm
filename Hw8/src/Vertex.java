import java.util.HashMap;

public class Vertex {

    private int index;
    private String label;
    private Double weight;
    private HashMap<String, String> properties = new HashMap<String, String>();

    Vertex(int index, String label) {
        this.index = index;
        this.label = label;
        this.weight = 0.0;
    }

    Vertex(int index, String label, Double weight) {
        this.index = index;
        this.label = label;
        this.weight = weight;
    }

    public int getIndex() {
        return index;
    }

    public String getLabel() {
        return label;
    }

    public Double getWeight() {
        return weight;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public HashMap<String,String> getProperties() {
        return this.properties;
    }

    public void setProperties(String key, String value) {
        this.properties.put(key, value);
    }

}
