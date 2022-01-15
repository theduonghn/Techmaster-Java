import java.util.ArrayList;
import java.util.Random;

public class Team {
    public ArrayList<Player> getAllPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(15, "Nguyễn Thành Chung", Position.DF));
        players.add(new Player(1, "Đặng Văn Lâm", Position.GK));
        players.add(new Player(5, "Nguyễn Tuấn Mạnh", Position.GK));
        players.add(new Player(2, "Phạm Văn Cường", Position.GK));
        players.add(new Player(9, "Bùi Tiến Dũng", Position.DF));
        players.add(new Player(21, "Nguyễn Văn Toàn", Position.FW));
        players.add(new Player(3, "Trần Văn Kiên", Position.DF));
        players.add(new Player(4, "Đỗ Duy Mạnh", Position.DF));
        players.add(new Player(6, "Nguyễn Hữu Tuấn", Position.DF));
        players.add(new Player(20, "Nguyễn Phong Hồng Duy", Position.MF));
        players.add(new Player(10, "Đoàn Văn Hậu", Position.DF));
        players.add(new Player(14, "Phạm Xuân Mạnh", Position.DF));
        players.add(new Player(8, "Quế Ngọc Hải", Position.DF));
        players.add(new Player(11, "Nguyễn Tuấn Anh", Position.MF));
        players.add(new Player(22, "Nguyễn Công Phượng", Position.FW));
        players.add(new Player(23, "Nguyễn Quang Hải", Position.MF));
        players.add(new Player(17, "Đỗ Hùng Dũng", Position.MF));
        players.add(new Player(12, "Nguyễn Huy Hùng", Position.MF));
        players.add(new Player(24, "Nguyễn Tiến Linh", Position.FW));
        players.add(new Player(25, "Nguyễn Việt Phong", Position.FW));
        players.add(new Player(13, "Nguyễn Trọng Hoàng", Position.MF));
        players.add(new Player(7, "Vũ Văn Thanh", Position.MF));
        players.add(new Player(16, "Phạm Đức Huy", Position.MF));
        players.add(new Player(18, "Nguyễn Anh Đức", Position.FW));
        players.add(new Player(19, "Nguyễn Trọng Hùng", Position.FW));

        return players;
    }

    public void show(ArrayList<Player> players) {
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public ArrayList<Player> buildTeam(ArrayList<Player> players, int numDf, int numMf, int numFw) {
        ArrayList<Player> chosenPlayers = new ArrayList<>();
        Random rd = new Random();
        // Choose GK
        int numChosenGk = 0;
        while (numChosenGk < 1) {
            Player choosingPlayer = players.get(rd.nextInt(players.size()));
            if (choosingPlayer.getPosition() == Position.GK) {
                chosenPlayers.add(choosingPlayer);
                numChosenGk++;
            }
        }

        // Choose DF
        int numChosenDf = 0;
        while (numChosenDf < numDf) {
            Player choosingPlayer = players.get(rd.nextInt(players.size()));
            if (choosingPlayer.getPosition() == Position.DF) {
                if (!chosenPlayers.contains(choosingPlayer)) {
                    chosenPlayers.add(choosingPlayer);
                    numChosenDf++;
                }
            }
        }

        // Choose MF
        int numChosenMf = 0;
        while (numChosenMf < numMf) {
            Player choosingPlayer = players.get(rd.nextInt(players.size()));
            if (choosingPlayer.getPosition() == Position.MF) {
                if (!chosenPlayers.contains(choosingPlayer)) {
                    chosenPlayers.add(choosingPlayer);
                    numChosenMf++;
                }
            }
        }

        // Choose FW
        int numChosenFw = 0;
        while (numChosenFw < numFw) {
            Player choosingPlayer = players.get(rd.nextInt(players.size()));
            if (choosingPlayer.getPosition() == Position.FW) {
                if (!chosenPlayers.contains(choosingPlayer)) {
                    chosenPlayers.add(choosingPlayer);
                    numChosenFw++;
                }
            }
        }

        return chosenPlayers;
    }
}
