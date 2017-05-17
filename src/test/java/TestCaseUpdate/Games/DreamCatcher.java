package TestCaseUpdate.Games;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avoitovs on 5/17/2017.
 */
public class DreamCatcher {


    private List<Step> steps = new ArrayList<Step>();

    public List<Step> getSteps() {
        assignSteps();
        return steps;
    }

    private void assignSteps() {
        Step firstStep = new Step();
        firstStep.setStep("Check Dream Catcher");
        firstStep.setData("Smoke detailed TC Dream Catcher: https://jira.evolutiongaming.com/browse/TC-7061\n");
        firstStep.setResult("- The game is available and can be launched");
        steps.add(firstStep);

        Step secondStep = new Step();
        secondStep.setStep("Check Dream Catcher:\n" + "Game buttons (Cashier, Help, History,  Responsible Gaming, REPEAT/DOUBLE) and video background ");
        secondStep.setData("*Useful links:*\n" + "* [Dream Catcher Menu controls|https://wiki.evolutiongaming.com/display/PRODDEV/Dream+Catcher+-+Specification+for+Certification#DreamCatcher-SpecificationforCertification-Menu_ControlsMenuControls]\n" + "* [Dream Catcher Repeat, double, undo buttons|https://wiki.evolutiongaming.com/display/PRODDEV/Dream+Catcher+-+Specification+for+Certification#DreamCatcher-SpecificationforCertification-Repeat,Double&Undo]\n" + "* [Dream Catcher Bet on all|https://wiki.evolutiongaming.com/display/PRODDEV/Dream+Catcher+-+Specification+for+Certification#DreamCatcher-SpecificationforCertification-BetonAll]\n");
        secondStep.setResult("- All buttons are available for licensee under testing as their style file\n" + "- All buttons are working as expected\n" + "- video background is correct");
        steps.add(secondStep);

        Step thirdStep = new Step();
        thirdStep.setStep("Check Dream Catcher\n" + "Game view (betting spot alignment, chips, statistics) and traffic light performance");
        thirdStep.setData("*Useful links:*\n" + "\n" + "* [Standart chip colors|http://wiki.evolutiongaming.com/display/PRODDEV/Chip+Colors]\n" + "\n" + "* [Dream Catcher Betting spot alignment|https://wiki.evolutiongaming.com/display/PRODDEV/Dream+Catcher+-+Specification+for+Certification#DreamCatcher-SpecificationforCertification-BetSpots]\n" + "* [Dream Catcher Chip stack|https://wiki.evolutiongaming.com/display/PRODDEV/Dream+Catcher+-+Specification+for+Certification#DreamCatcher-SpecificationforCertification-Chips]\n" + "* [Dream Catcher Traffic light |https://wiki.evolutiongaming.com/display/PRODDEV/Dream+Catcher+-+Specification+for+Certification#DreamCatcher-SpecificationforCertification-TrafficLight]\n" + "* [Dream Catcher Game Result Statistics|https://wiki.evolutiongaming.com/display/PRODDEV/Dream+Catcher+-+Specification+for+Certification#DreamCatcher-SpecificationforCertification-GameResultStatistics]\n");
        thirdStep.setResult("- Bet spot alignments are correct \n" + "- Traffic light messages are correct");
        steps.add(thirdStep);

        Step fourthStep = new Step();
        fourthStep.setStep("Check Dream Catcher:\n" + "Chat (dealer name, chat)");
        fourthStep.setData("");
        fourthStep.setResult("- Correct dealer's name displayed\n" + "- Chat messages sent successfully");
        steps.add(fourthStep);

        Step fifthStep = new Step();
        fifthStep.setStep("Check Dream Catcher:\n" + "Game gameplay/balance (winning/loosing scenarios, bonus payout)");
        fifthStep.setData("*Useful links:*\n" + "* [Dream Catcher game rules|https://wiki.evolutiongaming.com/display/PRODDEV/Dream+Catcher+-+Specification+for+Certification#DreamCatcher-SpecificationforCertification-GameRuless]\n" + "* [Dream Catcher Playing the game|https://wiki.evolutiongaming.com/display/PRODDEV/Dream+Catcher+-+Specification+for+Certification#DreamCatcher-SpecificationforCertification-PLAYINGTHEGAME]\n" + "* [Dream Catcher Game result and multiplier|https://wiki.evolutiongaming.com/display/PRODDEV/Dream+Catcher+-+Specification+for+Certification#DreamCatcher-SpecificationforCertification-GameResult]");
        fifthStep.setResult("- Bets are successfully accepted\n" + "- Multiplier positions on wheel processed correctly\n" + "- Winning/loosing paid out according to the game result");
        steps.add(fifthStep);


        Step sixthStep = new Step();
        sixthStep.setStep("Check Dream Catcher:\n" + "Autoplay functionality");
        sixthStep.setData("*Useful links:*\n" + "* [Dream Catcher autoplay|https://wiki.evolutiongaming.com/display/PRODDEV/Dream+Catcher+-+Specification+for+Certification#DreamCatcher-SpecificationforCertification-Autoplay]");
        sixthStep.setResult("* Autoplay works correctly");
        steps.add(sixthStep);

        Step seventhStep = new Step();
        seventhStep.setStep("Verify that Video and sound are still working (Video frame did not get corrupted (stretched, small) and everything is working as expected ) after following steps:\n" + "-Rotate device from landscape to portrait orientation and backwards\n" + "-Open chat and send a message (in both loyaout for tablets)\n" + "-Switch camera views\n" + "-Minimize game and then restore it");
        seventhStep.setData("");
        seventhStep.setResult("Video and sound are working (Video frame did not get corrupted (stretched, small) and everything is working as expected )");
        steps.add(seventhStep);
    }



}
