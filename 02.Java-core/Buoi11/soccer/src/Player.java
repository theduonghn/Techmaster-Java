public class Player {
    private int number;
    private String fullName;
    private PlayerPosition position;

    public Player(int number, String fullName, PlayerPosition position) {
        this.number = number;
        this.fullName = fullName;
        this.position = position;
    }

    @Override
    public String toString() {
        return "{" +
                " number='" + getNumber() + "'" +
                ", fullName='" + getFullName() + "'" +
                ", position='" + getPosition() + "'" +
                "}";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }

}
