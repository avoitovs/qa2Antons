package TestCaseUpdate.Games;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avoitovs on 5/17/2017.
 */
public class DoubleBallRoulette {

    private List<Step> steps = new ArrayList<Step>();

    public List<Step> getSteps() {
        assignSteps();
        return steps;
    }

    private void assignSteps() {
        Step firstStep = new Step();
        firstStep.setStep("Check Double Ball Roulette:\n" + "Game buttons (Cashier, Help, History, Responsible Gaming, REPEAT/DOUBLE,Golden racetrack) and branding colors, video background, client logo on table");
        firstStep.setData("branding spec.:http://wiki.evolutiongaming.com/display/INT/Mobile+Client+Branding\n" + "Some buttons might be disabled depending on client's request. Button availability is described here: http://wiki.evolutiongaming.com/display/PRODDEV/style.xml\n" + "\n" + "Repeat and Double Button:\n" + "http://wiki.evolutiongaming.com/display/PRODDEV/Repeat+and+Double+Button");
        firstStep.setResult("- All buttons are available for licensee under testing as per their style file;\n" + "- All buttons are working as expected;\n" + "- Branding colors&area are correct\n" + "- Golden racetrack is visible, when player taps on DBR Golden Racetrack button\n");
        steps.add(firstStep);

        Step secondStep = new Step();
        secondStep.setStep("Check Double Ball Roulette:\n" + "Game view (correct color, table/statistic/betting spot alignment, special bets on race track/Golden racetrack, chips) and traffic light performance");
        secondStep.setData("Special and Neighbour bets:\n" + "http://wiki.evolutiongaming.com/display/PRODDEV/Roulette:+Special+and+Neighbour+Bets\n" + "\n" + "\n" + "Chip colors: http://wiki.evolutiongaming.com/display/PRODDEV/Chip+Colors\n" + "\n" + "Statistics: http://wiki.evolutiongaming.com/display/PRODDEV/iPad+and+Android+Tablet+Roulette+-+Game+Specification#iPadandAndroidTabletRoulette-GameSpecification-SCOREBOARD&STATISTICS\n" + "\n" + "Roulette - Traffic Light:\n" + "http://wiki.evolutiongaming.com/display/PRODDEV/iPad+and+Android+Tablet+Roulette+-+Game+Specification#iPadandAndroidTabletRoulette-GameSpecification-TRAFFICLIGHTPROCESS\n" + "\n" + "\n" + "DBR: https://wiki.evolutiongaming.com/display/PRODDEV/Double+Ball+Roulette%3A+Golden+Racetrack\n" + "\n" + "for mob: instead of \"Not all bets accepted\" is shown \"Currency amount accepted\" message");
        secondStep.setResult("- Correct table color, graphics are displayed (it may differ for each licensee)\n" + "- Bet spot alignments are correct for 2 video mode/chat mode\n" + "- Traffic light messages are correct");
        steps.add(secondStep);

        Step thirdStep = new Step();
        thirdStep.setStep("Check Double Ball Roulette:\n" + "Chat (dealer's name, messages are sent/seen in chat)");
        thirdStep.setData("");
        thirdStep.setResult("- Correct dealer's name is displayed\n" + "- Chat messages sent successfully");
        steps.add(thirdStep);

        Step fourthStep = new Step();
        fourthStep.setStep("Double Ball Roulette:\n" + "Game gameplay/balance (winning/loosing scenarios lo on both racetracks), ball lands on 0)");
        fourthStep.setData("");
        fourthStep.setResult("- Bets are successfully accepted\n" + "- Winning/loosing paid out according to the game result");
        steps.add(fourthStep);

        Step fifthStep = new Step();
        fifthStep.setStep("Verify that Video and sound are still working (Video frame did not get corrupted (stretched, small) and everything is working as expected ) after following steps:\n" + "-Rotate device from landscape to portrait orientation and backwards\n" + "-Open chat and send a message (in both loyaout for tablets)\n" + "-Switch camera views\n" + "-Minimize game and then restore it");
        fifthStep.setData("");
        fifthStep.setResult("Video and sound are working (Video frame did not get corrupted (stretched, small) and everything is working as expected )");
        steps.add(fifthStep);

    }
}
