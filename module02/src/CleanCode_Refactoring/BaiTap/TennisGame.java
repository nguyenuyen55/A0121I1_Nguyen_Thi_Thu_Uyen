package CleanCode_Refactoring.BaiTap;

public class TennisGame {
     static final String DAUTRU="-";

    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        String score = "";
        int tempScore = 0;
        boolean isPlay1More40=scorePlayer1>=4;
        boolean isPlay2More40=scorePlayer1>=4;
        if (scorePlayer1 == scorePlayer1) {
            getScore(scorePlayer1 ,score);
        } else if (isPlay1More40 || isPlay2More40 ) {
            winLoss(scorePlayer1,scorePlayer2,score);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = scorePlayer1;
                else {
                    score += DAUTRU;
                    tempScore = scorePlayer2;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }
    private static String getScore(int scorePlayer1 ,String score){
        switch (scorePlayer1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
    return score;
}
    private static String winLoss(int scorePlayer1 ,int scorePlayer2,String score){
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }
}
