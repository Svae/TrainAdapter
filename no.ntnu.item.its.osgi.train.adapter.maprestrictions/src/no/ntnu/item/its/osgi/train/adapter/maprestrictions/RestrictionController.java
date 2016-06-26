package no.ntnu.item.its.osgi.train.adapter.maprestrictions;

import no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces.MapChecker;
import no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces.MapRestrictionController;
import no.ntnu.item.its.osgi.train.adapter.maprestrictions.legomap.LegoMapChecker;

public class RestrictionController implements MapRestrictionController {

	public MapChecker getMapRestrictionChecker(int mapID){
		if(mapID == 1) return new LegoMapChecker();
		return null;
	}
}
