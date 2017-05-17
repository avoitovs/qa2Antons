package TestCaseUpdate.Games;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avoitovs on 5/17/2017.
 */
public class TripleOrThreeCardPoker {

    private List<Step> steps = new ArrayList<Step>();

    public List<Step> getSteps() {
        assignSteps();
        return steps;
    }

    private void assignSteps() {
        Step firstStep = new Step();
        firstStep.setStep("Check TCP (Three Card Poker) / TRP (triple Card Poker):\n" + "Launch the game");
        firstStep.setData("TRP roll out TC:https://jira.evolutiongaming.com/browse/TC-6639\n");
        firstStep.setResult("- The game is available and can be launched");
        steps.add(firstStep);

        Step secondStep = new Step();
        secondStep.setStep("Check TCP/TRP:\n" + "Game buttons (Cashier, Help, History,  Responsible Gaming, REPEAT/DOUBLE) and video background ");
        secondStep.setData("Branding colors and available buttons are defined via client parameter in table configurations.\n" + "\n" + "Repeat and Double Button:\n" + "http://wiki.evolutiongaming.com/display/PRODDEV/Repeat+and+Double+Button");
        secondStep.setResult("- All buttons are available for licensee under testing as their style file\n" + "- All buttons are working as expected\n" + "- video background is correct");
        steps.add(secondStep);

        Step thirdStep = new Step();
        thirdStep.setStep("Check TCP/TRP:\n" + "Game view (correct color, table/betting spot alignment, chips) and traffic light performance");
        thirdStep.setData("Chip colors: http://wiki.evolutiongaming.com/display/PRODDEV/Chip+Colors\n" + "\n" + "Three Card Poker - Traffic Light:\n" + "https://wiki.evolutiongaming.com/display/PRODDEV/Three+Card+Poker+-+Traffic+Light");
        thirdStep.setResult("- Correct table color, graphics are displayed (it may differ for each licensee)\n" + "- Bet spot alignments are correct \n" + "- Traffic light messages are correct");
        steps.add(thirdStep);

        Step fourthStep = new Step();
        fourthStep.setStep("Check TCP/TRP:\n" + "Chat (dealer name, chat)");
        fourthStep.setData("");
        fourthStep.setResult("- Correct dealer's name displayed\n" + "- Chat messages sent successfully");
        steps.add(fourthStep);

        Step fifthStep = new Step();
        fifthStep.setStep("Check TCP/TRP:\n" + "Game gameplay/balance (winning/loosing scenarios, bonus payout)");
        fifthStep.setData("");
        fifthStep.setResult("- Bets acre successfully accepted\n" + "- Winning/loosing paid out according to the game result");
        steps.add(fifthStep);

        Step sixthStep = new Step();
        sixthStep.setStep("Verify that Video and sound are still working (Video frame did not get corrupted (stretched, small) and everything is working as expected ) after following steps:\n" + "-Rotate device from landscape to portrait orientation and backwards\n" + "-Open chat and send a message (in both loyaout for tablets)\n" + "-Switch camera views\n" + "-Minimize game and then restore it");
        sixthStep.setData("");
        sixthStep.setResult("Video and sound are working (Video frame did not get corrupted (stretched, small) and everything is working as expected )");
        steps.add(sixthStep);



    }
}
