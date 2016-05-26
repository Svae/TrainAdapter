package examplesystem.server.component;

import com.bitreactive.library.mqtt.MQTTConfigParam;
import com.bitreactive.library.mqtt.MQTTMessage;
import com.bitreactive.library.mqtt.robustmqtt.RobustMQTT.Parameters;

import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {
	
	public Parameters getMQTTParameters() {
		MQTTConfigParam p = new MQTTConfigParam("blocks2.bitreactive.com");    
		return new Parameters(p, 2);
	}

	public String parseMessage(MQTTMessage msg) {
		return new String(msg.getPayload());
	}

}
