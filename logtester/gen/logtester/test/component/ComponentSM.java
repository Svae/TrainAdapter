package logtester.test.component;

public class ComponentSM extends no.ntnu.item.arctis.runtime.IStateMachine {


    private logtester.test.component.Component b000;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b001;
    private boolean b000_MSG_r0;
    private enum Com_bitreactive_library_osgi_GetBundleContext {_IDLE};
    private Com_bitreactive_library_osgi_GetBundleContext b001_state;
    public ComponentSM(no.ntnu.item.arctis.runtime.Scheduler scheduler) {
        super(scheduler);
    }


    public int fireInitial() {
        b000 = new logtester.test.component.Component();
        b000.setBlockID("b000", sessionID);
        b000.setRuntime(scheduler.getRuntime());
        b001 = new com.bitreactive.library.osgi.getbundlecontext.GetBundleContext();
        b001.setBlockID("b001", sessionID);
        b001.setRuntime(scheduler.getRuntime());
        b001_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        org.osgi.framework.BundleContext b001_o0 = b001.get();
        if(b001_o0==null) {
            java.lang.String b001_o1 = b001.errMsg();
            // step 82ded;
            return CONSUME_SIGNAL;
        } else {
            b000.context = b001_o0;
            b000.initAMQP();
            b000_MSG_r0 = true;
            // step 9ca5d;
            return CONSUME_SIGNAL;
        }
    }

    public int fireTimer(java.lang.String _timerID) {
                return DISCARD_SIGNAL;
    }

    public int fire(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.String _signalID, java.lang.Object _data) {
        if(_signalID.equals("MSG_b000")) {
            return handleEvent_MSG_b000(_sender, receiverSessionID, _data);
        }
        return TRIGGER_UNKNOWN;
    }

    private int handleEvent_MSG_b000(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b000_MSG_r0) {
            b000.printMsg(((java.lang.String) _data));
            // step b2ef2;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    public java.lang.String getPartName() {
        return null;
    }
}
