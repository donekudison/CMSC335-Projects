
public class Light {
    private String color;

    public Light() {
        this.color = "red";
    }

    public void changeColor() {
        switch(this.color) {
        case "red":
            this.color = "green";
            break;
        case "yellow":
            this.color = "red";
            break;
        case "green":
            this.color = "yellow";
            break;
        }
    }

    public String getColor() {
        return color;
    }
}
