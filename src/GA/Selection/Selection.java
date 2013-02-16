package GA.Selection;

import java.util.List;
import GA.Population;
import GA.Individual.Individual;

public interface Selection {
	
	List<Individual> select(Population creatures);
	
}
