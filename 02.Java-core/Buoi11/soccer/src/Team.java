import java.util.ArrayList;
import java.util.Random;

public class Team {
    private ArrayList<Player> players;

    public ArrayList<Player> Team() {
        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player(1, "Dang Van Lam", PlayerPosition.GK));
        players.add(new Player(2, "Nguyen Tuan Manh", PlayerPosition.GK));
        players.add(new Player(3, "Pham Van Cuong", PlayerPosition.GK));
        players.add(new Player(4, "Tran Van Kien", PlayerPosition.DF));
        players.add(new Player(5, "Nguyen Thanh Chung", PlayerPosition.DF));
        players.add(new Player(6, "Do Duy Manh", PlayerPosition.DF));
        players.add(new Player(7, "Nguyen Huu Tuan", PlayerPosition.DF));
        players.add(new Player(8, "Doan Van Hau", PlayerPosition.DF));
        players.add(new Player(9, "Pham Xuan Manh", PlayerPosition.DF));
        players.add(new Player(10, "Que Ngoc Hai", PlayerPosition.DF));
        players.add(new Player(11, "Bui Tien Dung", PlayerPosition.DF));
        players.add(new Player(12, "Nguyen Tuan Anh", PlayerPosition.MF));
        players.add(new Player(13, "Vu Van Thanh", PlayerPosition.MF));
        players.add(new Player(14, "Nguyen Phong Hong Duy", PlayerPosition.MF));
        players.add(new Player(15, "Pham Duc Huy", PlayerPosition.MF));
        players.add(new Player(16, "Nguyen Quang Hai", PlayerPosition.MF));
        players.add(new Player(17, "Do Hung Dung", PlayerPosition.MF));
        players.add(new Player(18, "Nguyen Huy Hung", PlayerPosition.MF));
        players.add(new Player(19, "Nguyen Trong Hoang", PlayerPosition.MF));
        players.add(new Player(20, "Nguyen Van Toan", PlayerPosition.FW));
        players.add(new Player(21, "Nguyen Cong Phuong", PlayerPosition.FW));
        players.add(new Player(22, "Nguyen Anh Duc", PlayerPosition.FW));
        players.add(new Player(23, "Nguyen Tien Linh", PlayerPosition.FW));
        players.add(new Player(24, "Nguyen Viet Phong", PlayerPosition.FW));
        players.add(new Player(25, "Nguyen Trong Hung", PlayerPosition.FW));

        return players;
    }

    public void show(ArrayList<Player> players) {
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public void buildTeam(ArrayList<Player> allPlayers, int numDf, int numMf, int numFW) {
        ArrayList<Player> choiceTeam = new ArrayList<>();

        int teamNumber = allPlayers.size();

        // Chon thu mon
        Random random = new Random();

        int gkNumber = 0;

        while (gkNumber < 1) {
            int gkRandom = random.nextInt(teamNumber);
            if (allPlayers.get(gkRandom).getPosition() == PlayerPosition.GK) {
                Player choicePlayer = allPlayers.get(gkRandom);
                choiceTeam.add(choicePlayer);
                System.out.println(allPlayers.get(gkRandom));
                gkNumber++;
            }
        }
    }
}
