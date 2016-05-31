package no.ntnu.item.its.osgi.train.simulation.simulatedtest.component;

public class ComponentSM extends no.ntnu.item.arctis.runtime.IStateMachine {


    private no.ntnu.item.its.osgi.train.simulation.simulatedtest.component.Component b000;
    private no.ntnu.item.its.train.adapter.trainadapter.TrainAdapter b001;
    private no.ntnu.item.its.train.adapter.customeservicetracker.CustomeServiceTracker b002;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b003;
    private no.ntnu.item.its.train.adapter.sensorcontroller.SensorController b004;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b005;
    private no.ntnu.item.its.train.adapter.contextchecker.ContextChecker b006;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b007;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b008;
    private no.ntnu.item.its.train.adapter.remotecontrol.RemoteControl b009;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b010;
    private boolean b002_INVALID_r3;
    private boolean b004_SENSORSTATEEVENT_r3;
    private boolean b004_MAGNETOMETEREVENT_r4;
    private boolean b004_NFCEVENT_r1;
    private boolean b004_COLOREVENT_r0;
    private boolean b006_ADDTOPIC_r4;
    private boolean b009_ERROR_r1;
    private boolean b006_MESSAGE_r3;
    private boolean b004_DUMMYEVENT_r5;
    private boolean b006_REMOVETOPIC_r5;
    private boolean b006_CHANGEFILTER_r6;
    private boolean b004_ACCELEROMETEREVENT_r6;
    private boolean b006_STOP_r2;
    private boolean b002_REGISTRATION_r0;
    private boolean b004_TEMPERATUREEVENT_r2;
    private boolean b009_READY_r3;
    private boolean b002_MODIFIED_r2;
    private boolean b002_UNREGISTRATION_r1;
    private boolean b009_RECEIVED_r0;
    private boolean b006_SPEED_r0;
    private boolean b009_FAILED_r2;
    private boolean b006_LIGHT_r1;
    private enum No_ntnu_item_its_train_adapter_TrainAdapter {_IDLE, INITIALIZING, ACTIVE};
    private enum No_ntnu_item_its_train_adapter_CustomeServiceTracker {_IDLE, ACTIVE};
    private enum Com_bitreactive_library_osgi_GetBundleContext {_IDLE};
    private enum No_ntnu_item_its_train_adapter_SensorController {_IDLE, ACTIVE};
    private enum No_ntnu_item_its_train_adapter_ContextChecker {_IDLE, ACTIVE};
    private enum No_ntnu_item_its_train_adapter_RemoteControl {INITIALIZING, _IDLE, ACTIVE};
    private No_ntnu_item_its_train_adapter_TrainAdapter b001_state;
    private No_ntnu_item_its_train_adapter_CustomeServiceTracker b002_state;
    private Com_bitreactive_library_osgi_GetBundleContext b003_state;
    private No_ntnu_item_its_train_adapter_SensorController b004_state;
    private Com_bitreactive_library_osgi_GetBundleContext b005_state;
    private No_ntnu_item_its_train_adapter_ContextChecker b006_state;
    private Com_bitreactive_library_osgi_GetBundleContext b007_state;
    private Com_bitreactive_library_osgi_GetBundleContext b008_state;
    private No_ntnu_item_its_train_adapter_RemoteControl b009_state;
    private Com_bitreactive_library_osgi_GetBundleContext b010_state;
    public ComponentSM(no.ntnu.item.arctis.runtime.Scheduler scheduler) {
        super(scheduler);
    }


    public int fireInitial() {
        b000 = new no.ntnu.item.its.osgi.train.simulation.simulatedtest.component.Component();
        b000.setBlockID("b000", sessionID);
        b000.setRuntime(scheduler.getRuntime());
        b001 = new no.ntnu.item.its.train.adapter.trainadapter.TrainAdapter();
        b001.setBlockID("b001", sessionID);
        b001.setRuntime(scheduler.getRuntime());
        b002 = new no.ntnu.item.its.train.adapter.customeservicetracker.CustomeServiceTracker();
        b002.setBlockID("b002", sessionID);
        b002.setRuntime(scheduler.getRuntime());
        b003 = new com.bitreactive.library.osgi.getbundlecontext.GetBundleContext();
        b003.setBlockID("b003", sessionID);
        b003.setRuntime(scheduler.getRuntime());
        b004 = new no.ntnu.item.its.train.adapter.sensorcontroller.SensorController();
        b004.setBlockID("b004", sessionID);
        b004.setRuntime(scheduler.getRuntime());
        b005 = new com.bitreactive.library.osgi.getbundlecontext.GetBundleContext();
        b005.setBlockID("b005", sessionID);
        b005.setRuntime(scheduler.getRuntime());
        b006 = new no.ntnu.item.its.train.adapter.contextchecker.ContextChecker();
        b006.setBlockID("b006", sessionID);
        b006.setRuntime(scheduler.getRuntime());
        b007 = new com.bitreactive.library.osgi.getbundlecontext.GetBundleContext();
        b007.setBlockID("b007", sessionID);
        b007.setRuntime(scheduler.getRuntime());
        b008 = new com.bitreactive.library.osgi.getbundlecontext.GetBundleContext();
        b008.setBlockID("b008", sessionID);
        b008.setRuntime(scheduler.getRuntime());
        b009 = new no.ntnu.item.its.train.adapter.remotecontrol.RemoteControl();
        b009.setBlockID("b009", sessionID);
        b009.setRuntime(scheduler.getRuntime());
        b010 = new com.bitreactive.library.osgi.getbundlecontext.GetBundleContext();
        b010.setBlockID("b010", sessionID);
        b010.setRuntime(scheduler.getRuntime());
        b001_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
        b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
        b003_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b004_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
        b005_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b006_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
        b007_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b009_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
        b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        org.osgi.framework.BundleContext b008_o0 = b008.get();
        if(b008_o0==null) {
            java.lang.String b008_o1 = b008.errMsg();
            b000.logError(b008_o1);
            b002_INVALID_r3 = false;
            b004_MAGNETOMETEREVENT_r4 = false;
            b004_SENSORSTATEEVENT_r3 = false;
            b004_NFCEVENT_r1 = false;
            b004_COLOREVENT_r0 = false;
            b006_ADDTOPIC_r4 = false;
            b009_ERROR_r1 = false;
            b006_MESSAGE_r3 = false;
            b004_DUMMYEVENT_r5 = false;
            b006_CHANGEFILTER_r6 = false;
            b006_REMOVETOPIC_r5 = false;
            b004_ACCELEROMETEREVENT_r6 = false;
            b009_READY_r3 = false;
            b004_TEMPERATUREEVENT_r2 = false;
            b002_UNREGISTRATION_r1 = false;
            b002_REGISTRATION_r0 = false;
            b002_MODIFIED_r2 = false;
            b006_STOP_r2 = false;
            b009_RECEIVED_r0 = false;
            b006_SPEED_r0 = false;
            b009_FAILED_r2 = false;
            b006_LIGHT_r1 = false;
            b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
            b007_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b003_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b005_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b006_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
            b009_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
            b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b004_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
            // step 3a159;
            return CONSUME_SIGNAL;
        } else {
            b001.context = b008_o0;
            no.ntnu.item.its.train.adapter.trainInfo.TrainInfo b001_o1 = b001.getTrainInfo();
            b006.trainInfo = b001_o1;
            org.osgi.framework.BundleContext b007_o0 = b007.get();
            if(b007_o0==null) {
                java.lang.String b007_o1 = b007.errMsg();
                b000.logError(b007_o1);
                b002_INVALID_r3 = false;
                b004_MAGNETOMETEREVENT_r4 = false;
                b004_SENSORSTATEEVENT_r3 = false;
                b004_NFCEVENT_r1 = false;
                b004_COLOREVENT_r0 = false;
                b009_ERROR_r1 = false;
                b004_DUMMYEVENT_r5 = false;
                b004_ACCELEROMETEREVENT_r6 = false;
                b009_READY_r3 = false;
                b004_TEMPERATUREEVENT_r2 = false;
                b002_UNREGISTRATION_r1 = false;
                b002_REGISTRATION_r0 = false;
                b002_MODIFIED_r2 = false;
                b009_RECEIVED_r0 = false;
                b009_FAILED_r2 = false;
                b006_CHANGEFILTER_r6 = false;
                scheduler.flushEventQueue(sessionID, "CHANGEFILTER_b006");
                b006_REMOVETOPIC_r5 = false;
                scheduler.flushEventQueue(sessionID, "REMOVETOPIC_b006");
                b006_ADDTOPIC_r4 = false;
                scheduler.flushEventQueue(sessionID, "ADDTOPIC_b006");
                b006_MESSAGE_r3 = false;
                scheduler.flushEventQueue(sessionID, "MESSAGE_b006");
                b006_STOP_r2 = false;
                scheduler.flushEventQueue(sessionID, "STOP_b006");
                b006_SPEED_r0 = false;
                scheduler.flushEventQueue(sessionID, "SPEED_b006");
                b006_LIGHT_r1 = false;
                scheduler.flushEventQueue(sessionID, "LIGHT_b006");
                b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
                b003_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b005_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b009_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b004_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                // step b4cd5;
                return CONSUME_SIGNAL;
            } else {
                b006.context = b007_o0;
                b006.init();
                org.osgi.framework.BundleContext b010_o0 = b010.get();
                if(b010_o0==null) {
                    java.lang.String b010_o1 = b010.errMsg();
                    b000.logError(b010_o1);
                    b002_INVALID_r3 = false;
                    b004_MAGNETOMETEREVENT_r4 = false;
                    b004_SENSORSTATEEVENT_r3 = false;
                    b004_NFCEVENT_r1 = false;
                    b004_COLOREVENT_r0 = false;
                    b004_ACCELEROMETEREVENT_r6 = false;
                    b004_TEMPERATUREEVENT_r2 = false;
                    b002_UNREGISTRATION_r1 = false;
                    b002_REGISTRATION_r0 = false;
                    b002_MODIFIED_r2 = false;
                    b004_DUMMYEVENT_r5 = false;
                    b009_ERROR_r1 = false;
                    scheduler.flushEventQueue(sessionID, "ERROR_b009");
                    b009_READY_r3 = false;
                    scheduler.flushEventQueue(sessionID, "READY_b009");
                    b009_RECEIVED_r0 = false;
                    scheduler.flushEventQueue(sessionID, "RECEIVED_b009");
                    b009_FAILED_r2 = false;
                    scheduler.flushEventQueue(sessionID, "FAILED_b009");
                    b006_CHANGEFILTER_r6 = true;
                    b006_REMOVETOPIC_r5 = true;
                    b006_ADDTOPIC_r4 = true;
                    b006_MESSAGE_r3 = true;
                    b006_STOP_r2 = true;
                    b006_SPEED_r0 = true;
                    b006_LIGHT_r1 = true;
                    b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
                    b003_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b005_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b004_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                    b006_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                    // step 6145b;
                    return CONSUME_SIGNAL;
                } else {
                    b009.context = b010_o0;
                    b009.initAMQP();
                    b006_CHANGEFILTER_r6 = true;
                    b006_REMOVETOPIC_r5 = true;
                    b006_ADDTOPIC_r4 = true;
                    b009_ERROR_r1 = true;
                    b006_MESSAGE_r3 = true;
                    b009_READY_r3 = true;
                    b006_STOP_r2 = true;
                    b006_SPEED_r0 = true;
                    b009_FAILED_r2 = true;
                    b006_LIGHT_r1 = true;
                    b006_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                    b001_state = No_ntnu_item_its_train_adapter_TrainAdapter.INITIALIZING;
                    b009_state = No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING;
                    // step e92dc;
                    return CONSUME_SIGNAL;
                }
            }
        }
    }

    public int fireTimer(java.lang.String _timerID) {
                return DISCARD_SIGNAL;
    }

    public int fire(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.String _signalID, java.lang.Object _data) {
        if(_signalID.equals("FAILED_b009")) {
            return handleEvent_FAILED_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("STOP_b006")) {
            return handleEvent_STOP_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("REGISTRATION_b002")) {
            return handleEvent_REGISTRATION_b002(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("DUMMYEVENT_b004")) {
            return handleEvent_DUMMYEVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("TEMPERATUREEVENT_b004")) {
            return handleEvent_TEMPERATUREEVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("NFCEVENT_b004")) {
            return handleEvent_NFCEVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("ACCELEROMETEREVENT_b004")) {
            return handleEvent_ACCELEROMETEREVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("SENSORSTATEEVENT_b004")) {
            return handleEvent_SENSORSTATEEVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("REMOVETOPIC_b006")) {
            return handleEvent_REMOVETOPIC_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("READY_b009")) {
            return handleEvent_READY_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MODIFIED_b002")) {
            return handleEvent_MODIFIED_b002(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MESSAGE_b006")) {
            return handleEvent_MESSAGE_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("LIGHT_b006")) {
            return handleEvent_LIGHT_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("SPEED_b006")) {
            return handleEvent_SPEED_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("ERROR_b009")) {
            return handleEvent_ERROR_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("INVALID_b002")) {
            return handleEvent_INVALID_b002(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MAGNETOMETEREVENT_b004")) {
            return handleEvent_MAGNETOMETEREVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("COLOREVENT_b004")) {
            return handleEvent_COLOREVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("CHANGEFILTER_b006")) {
            return handleEvent_CHANGEFILTER_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("UNREGISTRATION_b002")) {
            return handleEvent_UNREGISTRATION_b002(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("ADDTOPIC_b006")) {
            return handleEvent_ADDTOPIC_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("RECEIVED_b009")) {
            return handleEvent_RECEIVED_b009(_sender, receiverSessionID, _data);
        }
        return TRIGGER_UNKNOWN;
    }

    private int handleEvent_FAILED_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_FAILED_r2) {
            if(b009_state==No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING) {
                b006.remoteErrorMsg = ((java.lang.String) _data);
                if(b006.runWithoutRemote()) {
                    org.osgi.framework.BundleContext b005_o0 = b005.get();
                    if(b005_o0==null) {
                        java.lang.String b005_o1 = b005.errMsg();
                        b000.logError(b005_o1);
                        b002_INVALID_r3 = false;
                        b002_UNREGISTRATION_r1 = false;
                        b002_REGISTRATION_r0 = false;
                        b002_MODIFIED_r2 = false;
                        b004_MAGNETOMETEREVENT_r4 = false;
                        scheduler.flushEventQueue(sessionID, "MAGNETOMETEREVENT_b004");
                        b004_SENSORSTATEEVENT_r3 = false;
                        scheduler.flushEventQueue(sessionID, "SENSORSTATEEVENT_b004");
                        b004_NFCEVENT_r1 = false;
                        scheduler.flushEventQueue(sessionID, "NFCEVENT_b004");
                        b004_COLOREVENT_r0 = false;
                        scheduler.flushEventQueue(sessionID, "COLOREVENT_b004");
                        b009_ERROR_r1 = false;
                        scheduler.flushEventQueue(sessionID, "ERROR_b009");
                        b004_ACCELEROMETEREVENT_r6 = false;
                        scheduler.flushEventQueue(sessionID, "ACCELEROMETEREVENT_b004");
                        b004_TEMPERATUREEVENT_r2 = false;
                        scheduler.flushEventQueue(sessionID, "TEMPERATUREEVENT_b004");
                        b009_READY_r3 = false;
                        scheduler.flushEventQueue(sessionID, "READY_b009");
                        b009_RECEIVED_r0 = false;
                        scheduler.flushEventQueue(sessionID, "RECEIVED_b009");
                        b009_FAILED_r2 = false;
                        scheduler.flushEventQueue(sessionID, "FAILED_b009");
                        b004_DUMMYEVENT_r5 = false;
                        scheduler.flushEventQueue(sessionID, "DUMMYEVENT_b004");
                        b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
                        b007_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b003_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b001_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
                        b009_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                        // step faf69;
                        return CONSUME_SIGNAL;
                    } else {
                        b004.context = b005_o0;
                        b004.init();
                        java.lang.String b001_o0 = b001.getFilter();
                        b002.filter = b001_o0;
                        org.osgi.framework.BundleContext b003_o0 = b003.get();
                        if(b003_o0==null) {
                            java.lang.String b003_o1 = b003.errMsg();
                            b000.logError(b003_o1);
                            b002_INVALID_r3 = false;
                            scheduler.flushEventQueue(sessionID, "INVALID_b002");
                            b009_ERROR_r1 = false;
                            scheduler.flushEventQueue(sessionID, "ERROR_b009");
                            b002_UNREGISTRATION_r1 = false;
                            scheduler.flushEventQueue(sessionID, "UNREGISTRATION_b002");
                            b002_REGISTRATION_r0 = false;
                            scheduler.flushEventQueue(sessionID, "REGISTRATION_b002");
                            b002_MODIFIED_r2 = false;
                            scheduler.flushEventQueue(sessionID, "MODIFIED_b002");
                            b009_READY_r3 = false;
                            scheduler.flushEventQueue(sessionID, "READY_b009");
                            b009_RECEIVED_r0 = false;
                            scheduler.flushEventQueue(sessionID, "RECEIVED_b009");
                            b009_FAILED_r2 = false;
                            scheduler.flushEventQueue(sessionID, "FAILED_b009");
                            b004_MAGNETOMETEREVENT_r4 = true;
                            b004_SENSORSTATEEVENT_r3 = true;
                            b004_NFCEVENT_r1 = true;
                            b004_COLOREVENT_r0 = true;
                            b004_ACCELEROMETEREVENT_r6 = true;
                            b004_TEMPERATUREEVENT_r2 = true;
                            b004_DUMMYEVENT_r5 = true;
                            b007_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                            b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                            b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                            b001_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
                            b004_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                            b009_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                            // step 2e0e7;
                            return CONSUME_SIGNAL;
                        } else {
                            b002.context = b003_o0;
                            b002.startListener(b002.filter);
                            b009_ERROR_r1 = false;
                            scheduler.flushEventQueue(sessionID, "ERROR_b009");
                            b009_READY_r3 = false;
                            scheduler.flushEventQueue(sessionID, "READY_b009");
                            b009_RECEIVED_r0 = false;
                            scheduler.flushEventQueue(sessionID, "RECEIVED_b009");
                            b009_FAILED_r2 = false;
                            scheduler.flushEventQueue(sessionID, "FAILED_b009");
                            b002_INVALID_r3 = true;
                            b004_MAGNETOMETEREVENT_r4 = true;
                            b004_SENSORSTATEEVENT_r3 = true;
                            b004_NFCEVENT_r1 = true;
                            b004_COLOREVENT_r0 = true;
                            b004_ACCELEROMETEREVENT_r6 = true;
                            b002_MODIFIED_r2 = true;
                            b002_REGISTRATION_r0 = true;
                            b002_UNREGISTRATION_r1 = true;
                            b004_TEMPERATUREEVENT_r2 = true;
                            b004_DUMMYEVENT_r5 = true;
                            b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                            b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker.ACTIVE;
                            b001_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                            b004_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                            b009_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                            // step cc427;
                            return CONSUME_SIGNAL;
                        }
                    }
                } else {
                    b000.logError(b006.remoteErrorMsg);
                    b002_INVALID_r3 = false;
                    b004_MAGNETOMETEREVENT_r4 = false;
                    b004_SENSORSTATEEVENT_r3 = false;
                    b004_NFCEVENT_r1 = false;
                    b004_COLOREVENT_r0 = false;
                    b004_ACCELEROMETEREVENT_r6 = false;
                    b004_TEMPERATUREEVENT_r2 = false;
                    b002_UNREGISTRATION_r1 = false;
                    b002_REGISTRATION_r0 = false;
                    b002_MODIFIED_r2 = false;
                    b004_DUMMYEVENT_r5 = false;
                    b006_CHANGEFILTER_r6 = false;
                    scheduler.flushEventQueue(sessionID, "CHANGEFILTER_b006");
                    b006_REMOVETOPIC_r5 = false;
                    scheduler.flushEventQueue(sessionID, "REMOVETOPIC_b006");
                    b006_ADDTOPIC_r4 = false;
                    scheduler.flushEventQueue(sessionID, "ADDTOPIC_b006");
                    b009_ERROR_r1 = false;
                    scheduler.flushEventQueue(sessionID, "ERROR_b009");
                    b006_MESSAGE_r3 = false;
                    scheduler.flushEventQueue(sessionID, "MESSAGE_b006");
                    b006_STOP_r2 = false;
                    scheduler.flushEventQueue(sessionID, "STOP_b006");
                    b009_READY_r3 = false;
                    scheduler.flushEventQueue(sessionID, "READY_b009");
                    b009_RECEIVED_r0 = false;
                    scheduler.flushEventQueue(sessionID, "RECEIVED_b009");
                    b006_SPEED_r0 = false;
                    scheduler.flushEventQueue(sessionID, "SPEED_b006");
                    b009_FAILED_r2 = false;
                    scheduler.flushEventQueue(sessionID, "FAILED_b009");
                    b006_LIGHT_r1 = false;
                    scheduler.flushEventQueue(sessionID, "LIGHT_b006");
                    b007_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
                    b003_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b005_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b004_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                    b006_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
                    b001_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
                    b009_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                    // step 879fd;
                    return CONSUME_SIGNAL;
                }
            } else if(b009_state==No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE) {
                b009_FAILED_r2 = false;
                // step dbad5;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_STOP_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_STOP_r2) {
            if(b001_state==No_ntnu_item_its_train_adapter_TrainAdapter.INITIALIZING) {
                // step 38d68;
                return CONSUME_SIGNAL;
            } else if(b001_state==No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE) {
                b000.stop();
                // step e1e17;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_REGISTRATION_b002(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b002_REGISTRATION_r0) {
            b004.registerSensor(((org.osgi.framework.ServiceReference) _data));
            // step 31e5a;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_DUMMYEVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_DUMMYEVENT_r5) {
            b006.handleDummyEvent();
            // step f9283;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_TEMPERATUREEVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_TEMPERATUREEVENT_r2) {
            b006.handleTemperatureEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading) _data));
            // step 5bc1d;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_NFCEVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_NFCEVENT_r1) {
            b006.handleNFCEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading) _data));
            // step 2e707;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_ACCELEROMETEREVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_ACCELEROMETEREVENT_r6) {
            b006.handleAccelerometerEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading) _data));
            // step a6d2d;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_SENSORSTATEEVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_SENSORSTATEEVENT_r3) {
            b006.handleSensorStateEvent(((org.osgi.framework.ServiceReference) _data));
            // step 418ac;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_REMOVETOPIC_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_REMOVETOPIC_r5) {
            if(b009_state==No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING) {
                // step 8acd5;
                return CONSUME_SIGNAL;
            } else if(b009_state==No_ntnu_item_its_train_adapter_RemoteControl._IDLE) {
                // step f24f6;
                return CONSUME_SIGNAL;
            } else if(b009_state==No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE) {
                b009.removeTopic(((java.lang.String) _data));
                // step a6f8c;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_READY_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_READY_r3) {
            org.osgi.framework.BundleContext b005_o0 = b005.get();
            if(b005_o0==null) {
                java.lang.String b005_o1 = b005.errMsg();
                b000.logError(b005_o1);
                b002_INVALID_r3 = false;
                b006_CHANGEFILTER_r6 = false;
                b006_REMOVETOPIC_r5 = false;
                b006_ADDTOPIC_r4 = false;
                b006_MESSAGE_r3 = false;
                b002_UNREGISTRATION_r1 = false;
                b002_REGISTRATION_r0 = false;
                b002_MODIFIED_r2 = false;
                b006_STOP_r2 = false;
                b006_SPEED_r0 = false;
                b006_LIGHT_r1 = false;
                b009_READY_r3 = false;
                b004_MAGNETOMETEREVENT_r4 = false;
                scheduler.flushEventQueue(sessionID, "MAGNETOMETEREVENT_b004");
                b004_SENSORSTATEEVENT_r3 = false;
                scheduler.flushEventQueue(sessionID, "SENSORSTATEEVENT_b004");
                b004_NFCEVENT_r1 = false;
                scheduler.flushEventQueue(sessionID, "NFCEVENT_b004");
                b004_COLOREVENT_r0 = false;
                scheduler.flushEventQueue(sessionID, "COLOREVENT_b004");
                b004_ACCELEROMETEREVENT_r6 = false;
                scheduler.flushEventQueue(sessionID, "ACCELEROMETEREVENT_b004");
                b004_TEMPERATUREEVENT_r2 = false;
                scheduler.flushEventQueue(sessionID, "TEMPERATUREEVENT_b004");
                b004_DUMMYEVENT_r5 = false;
                scheduler.flushEventQueue(sessionID, "DUMMYEVENT_b004");
                b009_RECEIVED_r0 = true;
                b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
                b007_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b003_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b006_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
                b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b001_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
                b009_state = No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE;
                // step 8deb8;
                return CONSUME_SIGNAL;
            } else {
                b004.context = b005_o0;
                b004.init();
                java.lang.String b001_o0 = b001.getFilter();
                b002.filter = b001_o0;
                org.osgi.framework.BundleContext b003_o0 = b003.get();
                if(b003_o0==null) {
                    java.lang.String b003_o1 = b003.errMsg();
                    b000.logError(b003_o1);
                    b006_CHANGEFILTER_r6 = false;
                    b006_REMOVETOPIC_r5 = false;
                    b006_ADDTOPIC_r4 = false;
                    b006_MESSAGE_r3 = false;
                    b006_STOP_r2 = false;
                    b006_SPEED_r0 = false;
                    b006_LIGHT_r1 = false;
                    b009_READY_r3 = false;
                    b002_INVALID_r3 = false;
                    scheduler.flushEventQueue(sessionID, "INVALID_b002");
                    b002_UNREGISTRATION_r1 = false;
                    scheduler.flushEventQueue(sessionID, "UNREGISTRATION_b002");
                    b002_REGISTRATION_r0 = false;
                    scheduler.flushEventQueue(sessionID, "REGISTRATION_b002");
                    b002_MODIFIED_r2 = false;
                    scheduler.flushEventQueue(sessionID, "MODIFIED_b002");
                    b004_MAGNETOMETEREVENT_r4 = true;
                    b004_SENSORSTATEEVENT_r3 = true;
                    b004_NFCEVENT_r1 = true;
                    b004_COLOREVENT_r0 = true;
                    b004_ACCELEROMETEREVENT_r6 = true;
                    b004_TEMPERATUREEVENT_r2 = true;
                    b009_RECEIVED_r0 = true;
                    b004_DUMMYEVENT_r5 = true;
                    b007_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b006_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
                    b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b001_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
                    b004_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                    b009_state = No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE;
                    // step d5c5a;
                    return CONSUME_SIGNAL;
                } else {
                    b002.context = b003_o0;
                    b002.startListener(b002.filter);
                    b009_READY_r3 = false;
                    b002_INVALID_r3 = true;
                    b004_MAGNETOMETEREVENT_r4 = true;
                    b004_SENSORSTATEEVENT_r3 = true;
                    b004_NFCEVENT_r1 = true;
                    b004_COLOREVENT_r0 = true;
                    b004_ACCELEROMETEREVENT_r6 = true;
                    b002_MODIFIED_r2 = true;
                    b002_REGISTRATION_r0 = true;
                    b002_UNREGISTRATION_r1 = true;
                    b004_TEMPERATUREEVENT_r2 = true;
                    b009_RECEIVED_r0 = true;
                    b004_DUMMYEVENT_r5 = true;
                    b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker.ACTIVE;
                    b001_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                    b004_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                    b009_state = No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE;
                    // step a1f50;
                    return CONSUME_SIGNAL;
                }
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_MODIFIED_b002(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b002_MODIFIED_r2) {
            b004.modifiedSensor(((org.osgi.framework.ServiceReference) _data));
            // step 7b36e;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_MESSAGE_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_MESSAGE_r3) {
            if(b009_state==No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING) {
                // step d9ef4;
                return CONSUME_SIGNAL;
            } else if(b009_state==No_ntnu_item_its_train_adapter_RemoteControl._IDLE) {
                // step 38634;
                return CONSUME_SIGNAL;
            } else if(b009_state==No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE) {
                b009.sendMsg(((no.ntnu.trainamqpservice.common.AMQPMessage) _data));
                // step 42fff;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_LIGHT_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_LIGHT_r1) {
            if(b001_state==No_ntnu_item_its_train_adapter_TrainAdapter.INITIALIZING) {
                // step 4a46d;
                return CONSUME_SIGNAL;
            } else if(b001_state==No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE) {
                b000.light(((Boolean)_data).booleanValue());
                // step 71acf;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_SPEED_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_SPEED_r0) {
            if(b001_state==No_ntnu_item_its_train_adapter_TrainAdapter.INITIALIZING) {
                // step a2c36;
                return CONSUME_SIGNAL;
            } else if(b001_state==No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE) {
                b000.logSpeed(((Double)_data).doubleValue());
                // step 859e3;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_ERROR_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_ERROR_r1) {
            if(b009_state==No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING) {
                // step 9af93;
                return CONSUME_SIGNAL;
            } else if(b009_state==No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE) {
                b006.handleSendError(((java.lang.String) _data));
                // step 531b5;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_INVALID_b002(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b002_INVALID_r3) {
            // step 3db10;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_MAGNETOMETEREVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_MAGNETOMETEREVENT_r4) {
            b006.handleMagnetometerEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading) _data));
            // step 77399;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_COLOREVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_COLOREVENT_r0) {
            b006.handleColorEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading) _data));
            // step 7028f;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_CHANGEFILTER_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_CHANGEFILTER_r6) {
            if(b002_state==No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE) {
                // step 2ff61;
                return CONSUME_SIGNAL;
            } else if(b002_state==No_ntnu_item_its_train_adapter_CustomeServiceTracker.ACTIVE) {
                b002.startListener(((java.lang.String) _data));
                // step 2aa58;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_UNREGISTRATION_b002(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b002_UNREGISTRATION_r1) {
            b004.unregisterSensor(((org.osgi.framework.ServiceReference) _data));
            // step 3562c;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_ADDTOPIC_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_ADDTOPIC_r4) {
            if(b009_state==No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING) {
                // step 4fd4b;
                return CONSUME_SIGNAL;
            } else if(b009_state==No_ntnu_item_its_train_adapter_RemoteControl._IDLE) {
                // step ae83d;
                return CONSUME_SIGNAL;
            } else if(b009_state==No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE) {
                b009.addTopic(((java.lang.String) _data));
                // step a5fa1;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_RECEIVED_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_RECEIVED_r0) {
            b006.handleMessage(((no.ntnu.item.its.train.adapter.common.TrainCommand) _data));
            // step c4e39;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    public java.lang.String getPartName() {
        return null;
    }
}
