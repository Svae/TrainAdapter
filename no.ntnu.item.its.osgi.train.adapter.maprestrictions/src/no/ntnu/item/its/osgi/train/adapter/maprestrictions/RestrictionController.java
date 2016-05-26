package no.ntnu.item.its.osgi.train.adapter.maprestrictions;

import no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces.MapRestrictionChecker;
import no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces.MapRestrictionController;
import no.ntnu.item.its.osgi.train.adapter.maprestrictions.legomap.LegoMapRestrictionChecker;

public class RestrictionController implements MapRestrictionController {

	public MapRestrictionChecker getMapRestrictionChecker(int mapID){
		if(mapID == 1) return new LegoMapRestrictionChecker();
		return null;
	}
}
