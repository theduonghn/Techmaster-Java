import java.util.ArrayList;
import java.util.Random;

public class Team {

    public ArrayList<Player> getAllTeam() {
        ArrayList<Player> list = new ArrayList<>();
        list.add(new Player(1, "Đặng Văn Lâm", Position.GK));
        list.add(new Player(32, "Đặng Văn Trường", Position.GK));
        list.add(new Player(2, "Quế Ngọc Hải", Position.DF));
        list.add(new Player(4, "Sergio Ramos", Position.DF));
        list.add(new Player(3, "Pepe", Position.DF));
        list.add(new Player(5, "Nacho", Position.DF));
        list.add(new Player(26, "Vidic", Position.DF));
        list.add(new Player(30, "Van Dijk", Position.DF));
        list.add(new Player(6, "Kroos", Position.MF));
        list.add(new Player(8, "Iniesta", Position.MF));
        list.add(new Player(17, "Modric", Position.MF));
        list.add(new Player(36, "Casemiro", Position.MF));
        list.add(new Player(45, "Xavi", Position.MF));
        list.add(new Player(7, "Ronaldo", Position.FW));
        list.add(new Player(9, "Benzema", Position.FW));
        list.add(new Player(11, "Bale", Position.FW));
        list.add(new Player(10, "Messi", Position.FW));
        list.add(new Player(60, "Cavani", Position.FW));
        list.add(new Player(15, "Suarez", Position.FW));
        return list;
    }

    public void show(ArrayList<Player> players) {
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public ArrayList<Player> buildTeam(int df, int mf, int fw, ArrayList<Player> allPlayer) {
        ArrayList<Player> choiceTeam = new ArrayList<>();

        int teamNumber = allPlayer.size();

        // Chọn thủ môn
        Random random = new Random();

        int gkNumber = 0;
        int dfNumber = 0;
        int mfNumber = 0;
        int fwNumber = 0;

        while (gkNumber < 1) {
            int gkRandom = random.nextInt(teamNumber);
            if (allPlayer.get(gkRandom).getPosition() == Position.GK) {
                Player choicePlayer = allPlayer.get(gkRandom);
                choiceTeam.add(choicePlayer);
                gkNumber++;
            }
        }

        // Chọn hậu vệ
        while (dfNumber < df) {
            int dfRandom = random.nextInt(teamNumber);
            if (allPlayer.get(dfRandom).getPosition() == Position.DF) { // Kiểm tra vị trí có chính xác không
                if (!choiceTeam.contains(allPlayer.get(dfRandom))) { // Kiểm tra cầu thủ đó đã có trong đội hay chưa
                    choiceTeam.add(allPlayer.get(dfRandom)); // Thêm vào đội
                    dfNumber++;
                }

            }
        }

        // Chọn trung vệ
        while (mfNumber < mf) {
            int mfRandom = random.nextInt(teamNumber);
            if (allPlayer.get(mfRandom).getPosition() == Position.MF) { // Kiểm tra vị trí có chính xác không
                if (!choiceTeam.contains(allPlayer.get(mfRandom))) { // Kiểm tra cầu thủ đó đã có trong đội hay chưa
                    choiceTeam.add(allPlayer.get(mfRandom)); // Thêm vào đội
                    mfNumber++;
                }

            }
        }

        // Chọn tiền đạo
        while (fwNumber < fw) {
            int fwRandom = random.nextInt(teamNumber);
            if (allPlayer.get(fwRandom).getPosition() == Position.FW) { // Kiểm tra vị trí có chính xác không
                if (!choiceTeam.contains(allPlayer.get(fwRandom))) { // Kiểm tra cầu thủ đó đã có trong đội hay chưa
                    choiceTeam.add(allPlayer.get(fwRandom)); // Thêm vào đội
                    fwNumber++;
                }

            }
        }

        return choiceTeam;
    }
}