import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (m_score1 == m_score2) {

            Map<Integer, String> scoresValues = getIntegerStringMap();
            for (int key : scoresValues.keySet()) {
                if (key == m_score1) {
                    score = scoresValues.get(key);
                }
            }
            if (score.equals("")) {
                score = "Deuce";
            }


        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = statePlayer();
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = m_score1;
                else {
                    score += "-";
                    tempScore = m_score2;
                }

                Map<Integer, String> point = getPoints();

                for (int key : point.keySet()) {
                    if (key == tempScore) {
                        score = score + point.get(key);
                    }
                }

            }
        }
        return score;
    }

    private String statePlayer() {
        String score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private Map<Integer, String> getPoints() {
        Map<Integer, String> point = new HashMap();
        point.put(0, "Love");
        point.put(1, "Fifteen");
        point.put(2, "Thirty");
        point.put(3, "Forty");
        return point;
    }

    private Map<Integer, String> getIntegerStringMap() {
        Map<Integer, String> scoresValues = new HashMap();
        scoresValues.put(0, "Love-All");
        scoresValues.put(1, "Fifteen-All");
        scoresValues.put(2, "Thirty-All");
        return scoresValues;
    }
}