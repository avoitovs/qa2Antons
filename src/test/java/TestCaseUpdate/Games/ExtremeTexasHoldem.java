package TestCaseUpdate.Games;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avoitovs on 5/17/2017.
 */
public class ExtremeTexasHoldem {

    private List<Step> steps = new ArrayList<Step>();

    public List<Step> getSteps() {
        assignSteps();
        return steps;
    }

    private void assignSteps() {
        Step firstStep = new Step();
        firstStep.setStep("EXTREME TEXAS HOLDEM: UI&elements \n" + "\n" + "Verify that UI&elements fits screen and are not misplaces:\n" + "- when ETH table is loaded\n" + "- on rotation\n" + "- after minimization&restoring\n" + "- after refresh\n" + "- after device locking&unlocking\n");
        firstStep.setData("Detailed TC: https://jira.evolutiongaming.com/browse/TC-6854");
        firstStep.setResult("- ETH game is available and can be launched\n" + "- Tap to play message should be displayed \n" + "- ETH UI&elements fits screen\n");
        steps.add(firstStep);

        Step secondStep = new Step();
        secondStep.setStep("EXTREME TEXAS HOLDEM: Functionality (buttons, links, info)\n" + "\n" + "Menu from ETH Table:\n" + "go menu and open following item\n" + "- Limits:check if opens\n" + "- History : check if history opens\n" + "- Chat: check if chat opens. Type and send message and check if message appears in the chat.\n" + "- Help: check if opens and can select any chapter\n" + "- Settings:check if opens\n" + "\n");
        secondStep.setData("");
        secondStep.setResult("- All buttons are working as expected& provide corresponding info;\n" + "- Chat:dealer's name is displayed. Chat messages sent successfully\n" + "- help:player is able openhelp and can select any chapter\n" + "- All UI elements fits screen and are not misplaced");
        steps.add(secondStep);

        Step thirdStep = new Step();
        thirdStep.setStep("EXTREME TEXAS HOLDEM: Gameplay (1-2 bet)\n" + "- Place bet and check that bet is accepted and game result is processed according to expectation \n" + "- Check sidebets\n" + "- Check animation during gameplay");
        thirdStep.setData("");
        thirdStep.setResult("- Bets are successfully accepted\n" + "- It is possible to place bets on SB\n" + "- Winning/loosing paid out according to the game result\n" + "- There is no visual glitches with UI elements&animation during gameplay\n");
        steps.add(thirdStep);

        Step fourthStep = new Step();
        fourthStep.setStep("EXTREME TEXAS HOLDEM: Video&Sound\n" + "\n" + "Verify that Video and sound are working as expected after following steps:\n" + "- Rotate device from landscape to portrait orientation and backwards\n" + "- Open chat and send a message\n" + "- Minimize game and then restore it\n" + "- refresh browser\n" + "- lock&unlock device\n" + "- Video and sound plays – min play 2 min checked\n" + "\n");
        fourthStep.setData("");
        fourthStep.setResult("- video and sound are working as expected after described actions");
        steps.add(fourthStep);

    }
}
