package TestCaseUpdate.Games;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avoitovs on 5/17/2017.
 */
public class UltimateTexasHoldem {

    private List<Step> steps = new ArrayList<Step>();

    public List<Step> getSteps() {
        assignSteps();
        return steps;
    }

    private void assignSteps() {
        Step firstStep = new Step();
        firstStep.setStep("Check UTH (Ultimate Texas Holdem):\n" + "Launch the game");
        firstStep.setData("Branding colors and available buttons are defined via client parameter in table configurations.\n" + "\n" + "*Useful links:*\n" + "* [UTH Menu controls|https://wiki.evolutiongaming.com/display/PRODDEV/Ultimate+Texas+Hold%27em+-+Specification+for+Certification#UltimateTexasHold'em-SpecificationforCertification-Menu_ControlsMenuControls]\n" + "* [UTH Repeat, double, undo buttons|https://wiki.evolutiongaming.com/display/PRODDEV/Ultimate+Texas+Hold%27em+-+Specification+for+Certification#UltimateTexasHold'em-SpecificationforCertification-Repeat,Double&Undo]");
        firstStep.setResult("- All buttons are available for licensee under testing as their style file\n" + "- All buttons are working as expected\n" + "- video background is correct");
        steps.add(firstStep);

        Step secondStep = new Step();
        secondStep.setStep("Check UTH:\n" + "Game view (correct color, table/betting spot alignment, chips) and traffic light performance");
        secondStep.setData("*Useful links:*\n" + "* [UTH Betting spot alignment|https://wiki.evolutiongaming.com/display/PRODDEV/Ultimate+Texas+Hold%27em+-+Specification+for+Certification#UltimateTexasHold'em-SpecificationforCertification-BetSpots]\n" + "* [UTH Chip stack|https://wiki.evolutiongaming.com/display/PRODDEV/Ultimate+Texas+Hold%27em+-+Specification+for+Certification#UltimateTexasHold'em-SpecificationforCertification-Chips]\n" + "* [Standart chip colors|http://wiki.evolutiongaming.com/display/PRODDEV/Chip+Colors]\n" + "* [UTH Traffic light |https://wiki.evolutiongaming.com/display/PRODDEV/Ultimate+Texas+Hold%27em+-+Specification+for+Certification#UltimateTexasHold'em-SpecificationforCertification-TrafficLight]");
        secondStep.setResult("- Correct table color, graphics are displayed (it may differ for each licensee)\n" + "- Bet spot alignments are correct \n" + "- Traffic light messages are correct");
        steps.add(secondStep);

        Step thirdStep = new Step();
        thirdStep.setStep("Check UTH:\n" + "Chat (dealer name, chat)");
        thirdStep.setData("");
        thirdStep.setResult("- Correct dealer's name displayed\n" + "- Chat messages sent successfully");
        steps.add(thirdStep);

        Step fourthStep = new Step();
        fourthStep.setStep("Check UTH:\n" + "Game gameplay/balance (winning/loosing scenarios, bonus payout)");
        fourthStep.setData("*Useful links:*\n" + "* [UTH game rules|https://wiki.evolutiongaming.com/display/PRODDEV/Ultimate+Texas+Hold%27em+-+Specification+for+Certification#UltimateTexasHold'em-SpecificationforCertification-GameRules]\n" + "* [Playing the game|https://wiki.evolutiongaming.com/display/PRODDEV/Ultimate+Texas+Hold%27em+-+Specification+for+Certification#UltimateTexasHold'em-SpecificationforCertification-PLAYINGTHEGAME]\n" + "* [UTH Game result|https://wiki.evolutiongaming.com/display/PRODDEV/Ultimate+Texas+Hold%27em+-+Specification+for+Certification#UltimateTexasHold'em-SpecificationforCertification-GAMERESULT]");
        fourthStep.setResult("- Bets are successfully accepted\n" + "- Winning/loosing paid out according to the game result");
        steps.add(fourthStep);

        Step fifthStep = new Step();
        fifthStep.setStep("Verify that Video and sound are still working (Video frame did not get corrupted (stretched, small) and everything is working as expected ) after following steps:\n" + "-Rotate device from landscape to portrait orientation and backwards\n" + "-Open chat and send a message (in both loyaout for tablets)\n" + "-Switch camera views\n" + "-Minimize game and then restore it");
        fifthStep.setData("");
        fifthStep.setResult("Video and sound are working (Video frame did not get corrupted (stretched, small) and everything is working as expected )");
        steps.add(fifthStep);


    }
}
