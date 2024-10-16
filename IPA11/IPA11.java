import java.util.Scanner;

class Player {
    private int playerId;
    private String skill;
    private String level;
    private int points;

    // Parameterized constructor
    public Player(int playerId, String skill, String level, int points) {
        this.playerId = playerId;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }

    // Getters
    public int getPlayerId() {
        return playerId;
    }

    public String getSkill() {
        return skill;
    }

    public String getLevel() {
        return level;
    }

    public int getPoints() {
        return points;
    }

    // Setters
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

class Solution {
    public static int findPointsForGivenSkill(Player[] players, String skill) {
        int totalPoints = 0;
        for (Player player : players) {
            if (player.getSkill().equalsIgnoreCase(skill)) {
                totalPoints += player.getPoints();
            }
        }
        return totalPoints;
    }

    public static Player getPlayerBasedOnLevel(Player[] players, String level, String skill) {
        for (Player player : players) {
            if (player.getSkill().equalsIgnoreCase(skill) && 
                player.getLevel().equalsIgnoreCase(level) && 
                player.getPoints() >= 20) {
                return player;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player[] players = new Player[4];
        
        // Input 4 player details
        for (int i = 0; i < 4; i++) {
            int playerId = sc.nextInt();
            sc.nextLine();  // Consume newline
            String skill = sc.nextLine();
            String level = sc.nextLine();
            int points = sc.nextInt();
            players[i] = new Player(playerId, skill, level, points);
        }

        sc.nextLine(); // Consume newline
        
        // Input skill and level
        String skill = sc.nextLine();
        String level = sc.nextLine();

        // Call findPointsForGivenSkill method
        int totalPoints = findPointsForGivenSkill(players, skill);
        if (totalPoints > 0) {
            System.out.println(totalPoints);
        } else {
            System.out.println("The given Skill is not available");
        }

        // Call getPlayerBasedOnLevel method
        Player resultPlayer = getPlayerBasedOnLevel(players, level, skill);
        if (resultPlayer != null) {
            System.out.println(resultPlayer.getPlayerId());
        } else {
            System.out.println("No player is available with specified level, skill and eligibility points");
        }
    }
}
