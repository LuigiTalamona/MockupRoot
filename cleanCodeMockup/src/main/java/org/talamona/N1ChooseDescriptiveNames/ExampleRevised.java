package org.talamona.N1ChooseDescriptiveNames;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/4/13
 * Time: 9:11 AM
 */
public class ExampleRevised {
    private int[] rolls;

    public int score(){
        int score = 0, frame = 0;
        for (int frameNumber = 0; frameNumber < 10; frameNumber ++){
            if (this.isStrike(frame)){
                score += 10 + this.nextTwoBallsForStrike(frame);
                frame += 1;
            }
            else if(this.isSpare(frame)){
                score += 10 + nextBallForSpare(frame);
                frame += 2;
            }else{
                score += this.twoBallsInFrame(frame);
                frame += 2;
            }
        }
        return score;
    }

    private int twoBallsInFrame(int frame) {
        return rolls[frame] + rolls[frame + 1];
    }

    private int nextBallForSpare(int frame) {
        return rolls[frame + 2];
    }

    private boolean isSpare(int frame) {
        return rolls[frame] + rolls[frame + 1] == 10;
    }

    private int nextTwoBallsForStrike(int frame) {
        return rolls[frame + 1] + rolls[frame + 2];
    }

    private boolean isStrike(int frame) {
        return false;
    }
}
