import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Team team = new Team();
        ArrayList<Player> players = team.getAllPlayers();

        System.out.println("Đội hình 1GK - 4DF - 4MF - 2FW");
        ArrayList<Player> chosenPlayers1 = team.buildTeam(players, 4, 4, 2);
        team.show(chosenPlayers1);
        System.out.println();

        System.out.println("Đội hình 1GK - 4DF - 3MF - 3FW");
        ArrayList<Player> chosenPlayers2 = team.buildTeam(players, 4, 3, 3);
        team.show(chosenPlayers2);
        System.out.println();

        System.out.println("Đội hình 1GK - 3DF - 5MF - 2FW");
        ArrayList<Player> chosenPlayers3 = team.buildTeam(players, 3, 5, 2);
        team.show(chosenPlayers3);
    }
}
