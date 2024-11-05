package Play;

public record RRecord(String name) {

    public RRecord(String msg, String msg2) {
        this(msg + msg2);
    }

    public RRecord(String name) {
        if (name != "karthik") {
            this.name = name;
        } else {
            this.name = "noname";
        }
    }
}
