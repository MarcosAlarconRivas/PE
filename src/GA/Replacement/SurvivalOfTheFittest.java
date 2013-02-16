package GA.Replacement;

import java.util.List;

import GA.Population;
import GA.Individual.Individual;

public class SurvivalOfTheFittest implements Replacement {

	@Override
	public void replace(Population creatures, List<Individual> parents,
			List<Individual> children) {
		// TODO ignore parents, Fitter children replace creatures in population

	}

	@Override
	public boolean respectsElitism() {
		return false;
	}

}
