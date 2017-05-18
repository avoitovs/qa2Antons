package TestCaseUpdate;

import TestCaseUpdate.Games.*;

import java.util.List;

/**
 * Created by avoitovs on 5/18/2017.
 */
public class AddGameHelper {

    JiraHelper jiraHelper = new JiraHelper();

    protected void addMOWSteps(){
        DreamCatcher dreamCatcher = new DreamCatcher();
        List<Step> mow = dreamCatcher.getSteps();
        iterateSteps(mow);
    }

    protected void addDBRSteps(){
        DoubleBallRoulette doubleBallRoulette = new DoubleBallRoulette();
        List<Step> dbr = doubleBallRoulette.getSteps();
        iterateSteps(dbr);
    }

    protected void addUTHSteps(){
        UltimateTexasHoldem ultimateTexasHoldem = new UltimateTexasHoldem();
        List<Step> uth = ultimateTexasHoldem.getSteps();
        iterateSteps(uth);
    }

    protected void addETHSteps(){
        ExtremeTexasHoldem extremeTexasHoldem = new ExtremeTexasHoldem();
        List<Step> eth = extremeTexasHoldem.getSteps();
        iterateSteps(eth);
    }

    protected void addCSPSteps(){
        CaribbeanStudPoker caribbeanStudPoker = new CaribbeanStudPoker();
        List<Step> csp = caribbeanStudPoker.getSteps();
        iterateSteps(csp);
    }

    protected void addTRPorTCPSteps(){
        TripleOrThreeCardPoker tripleOrThreeCardPoker = new TripleOrThreeCardPoker();
        List<Step> trp = tripleOrThreeCardPoker.getSteps();
        iterateSteps(trp);
    }

    private void iterateSteps (List<Step> game){
        for (Step step : game){
            jiraHelper.addStep(step.getStep(),step.getData(),step.getResult());
        }
    }




}
