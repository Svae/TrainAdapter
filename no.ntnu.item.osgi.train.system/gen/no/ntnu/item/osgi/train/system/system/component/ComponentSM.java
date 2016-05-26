package no.ntnu.item.osgi.train.system.system.component;

public class ComponentSM extends no.ntnu.item.arctis.runtime.IStateMachine {


    private no.ntnu.item.osgi.train.system.train.Train b001;
    private no.ntnu.item.osgi.train.system.motorcontroller.MotorController b002;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b003;
    private no.ntnu.item.its.train.adapter.trainadapter.TrainAdapter b004;
    private no.ntnu.item.its.train.adapter.customeservicetracker.CustomeServiceTracker b005;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b006;
    private no.ntnu.item.its.train.adapter.sensorcontroller.SensorController b007;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b008;
    private no.ntnu.item.its.train.adapter.contextchecker.ContextChecker b009;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b010;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b011;
    private no.ntnu.item.its.train.adapter.remotecontrol.RemoteControl b012;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b013;
    private boolean b007_ACCELEROMETEREVENT_r6;
    private boolean b007_SENSORSTATEEVENT_r3;
    private boolean b005_UNREGISTRATION_r1;
    private boolean b009_ADDTOPIC_r4;
    private boolean b009_SPEED_r0;
    private boolean b007_COLOREVENT_r0;
    private boolean b009_CHANGEFILTER_r6;
    private boolean b007_DUMMYEVENT_r5;
    private boolean b007_TEMPERATUREEVENT_r2;
    private boolean b012_FAILED_r2;
    private boolean b005_MODIFIED_r2;
    private boolean b009_MESSAGE_r3;
    private boolean b012_READY_r3;
    private boolean b007_NFCEVENT_r1;
    private boolean b007_MAGNETOMETEREVENT_r4;
    private boolean b009_STOP_r2;
    private boolean b009_REMOVETOPIC_r5;
    private boolean b005_REGISTRATION_r0;
    private boolean b009_LIGHT_r1;
    private boolean b012_RECEIVED_r0;
    private boolean b005_INVALID_r3;
    private boolean b012_ERROR_r1;
    private enum No_ntnu_item_osgi_train_system_Train {ACTIVE, _IDLE};
    private enum No_ntnu_item_osgi_train_system_MotorController {_IDLE, ACTIVE};
    private enum Com_bitreactive_library_osgi_GetBundleContext {_IDLE};
    private enum No_ntnu_item_its_train_adapter_TrainAdapter {ACTIVE, _IDLE};
    private enum No_ntnu_item_its_train_adapter_CustomeServiceTracker {_IDLE, ACTIVE};
    private enum No_ntnu_item_its_train_adapter_SensorController {_IDLE, ACTIVE};
    private enum No_ntnu_item_its_train_adapter_ContextChecker {_IDLE, ACTIVE};
    private enum No_ntnu_item_its_train_adapter_RemoteControl {ACTIVE, _IDLE, INITIALIZING};
    private No_ntnu_item_osgi_train_system_Train b001_state;
    private No_ntnu_item_osgi_train_system_MotorController b002_state;
    private Com_bitreactive_library_osgi_GetBundleContext b003_state;
    private No_ntnu_item_its_train_adapter_TrainAdapter b004_state;
    private No_ntnu_item_its_train_adapter_CustomeServiceTracker b005_state;
    private Com_bitreactive_library_osgi_GetBundleContext b006_state;
    private No_ntnu_item_its_train_adapter_SensorController b007_state;
    private Com_bitreactive_library_osgi_GetBundleContext b008_state;
    private No_ntnu_item_its_train_adapter_ContextChecker b009_state;
    private Com_bitreactive_library_osgi_GetBundleContext b010_state;
    private Com_bitreactive_library_osgi_GetBundleContext b011_state;
    private No_ntnu_item_its_train_adapter_RemoteControl b012_state;
    private Com_bitreactive_library_osgi_GetBundleContext b013_state;
    public ComponentSM(no.ntnu.item.arctis.runtime.Scheduler scheduler) {
        super(scheduler);
    }


    public int fireInitial() {
        b001 = new no.ntnu.item.osgi.train.system.train.Train();
        b001.setBlockID("b001", sessionID);
        b001.setRuntime(scheduler.getRuntime());
        b002 = new no.ntnu.item.osgi.train.system.motorcontroller.MotorController();
        b002.setBlockID("b002", sessionID);
        b002.setRuntime(scheduler.getRuntime());
        b003 = new com.bitreactive.library.osgi.getbundlecontext.GetBundleContext();
        b003.setBlockID("b003", sessionID);
        b003.setRuntime(scheduler.getRuntime());
        b004 = new no.ntnu.item.its.train.adapter.trainadapter.TrainAdapter();
        b004.setBlockID("b004", sessionID);
        b004.setRuntime(scheduler.getRuntime());
        b005 = new no.ntnu.item.its.train.adapter.customeservicetracker.CustomeServiceTracker();
        b005.setBlockID("b005", sessionID);
        b005.setRuntime(scheduler.getRuntime());
        b006 = new com.bitreactive.library.osgi.getbundlecontext.GetBundleContext();
        b006.setBlockID("b006", sessionID);
        b006.setRuntime(scheduler.getRuntime());
        b007 = new no.ntnu.item.its.train.adapter.sensorcontroller.SensorController();
        b007.setBlockID("b007", sessionID);
        b007.setRuntime(scheduler.getRuntime());
        b008 = new com.bitreactive.library.osgi.getbundlecontext.GetBundleContext();
        b008.setBlockID("b008", sessionID);
        b008.setRuntime(scheduler.getRuntime());
        b009 = new no.ntnu.item.its.train.adapter.contextchecker.ContextChecker();
        b009.setBlockID("b009", sessionID);
        b009.setRuntime(scheduler.getRuntime());
        b010 = new com.bitreactive.library.osgi.getbundlecontext.GetBundleContext();
        b010.setBlockID("b010", sessionID);
        b010.setRuntime(scheduler.getRuntime());
        b011 = new com.bitreactive.library.osgi.getbundlecontext.GetBundleContext();
        b011.setBlockID("b011", sessionID);
        b011.setRuntime(scheduler.getRuntime());
        b012 = new no.ntnu.item.its.train.adapter.remotecontrol.RemoteControl();
        b012.setBlockID("b012", sessionID);
        b012.setRuntime(scheduler.getRuntime());
        b013 = new com.bitreactive.library.osgi.getbundlecontext.GetBundleContext();
        b013.setBlockID("b013", sessionID);
        b013.setRuntime(scheduler.getRuntime());
        b001_state = No_ntnu_item_osgi_train_system_Train._IDLE;
        b002_state = No_ntnu_item_osgi_train_system_MotorController._IDLE;
        b003_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b004_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
        b005_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
        b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
        b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b011_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
        b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        java.lang.String b001_o0 = b001.getSensorFilter();
        b004.filter = b001_o0;
        org.osgi.framework.BundleContext b011_o0 = b011.get();
        if(b011_o0==null) {
            java.lang.String b011_o1 = b011.errMsg();
            b001.logError(b011_o1);
            org.osgi.framework.BundleContext b003_o0 = b003.get();
            if(b003_o0==null) {
                java.lang.String b003_o1 = b003.errMsg();
                b007_SENSORSTATEEVENT_r3 = false;
                b007_ACCELEROMETEREVENT_r6 = false;
                b005_UNREGISTRATION_r1 = false;
                b009_ADDTOPIC_r4 = false;
                b007_COLOREVENT_r0 = false;
                b009_SPEED_r0 = false;
                b009_CHANGEFILTER_r6 = false;
                b007_DUMMYEVENT_r5 = false;
                b007_TEMPERATUREEVENT_r2 = false;
                b012_FAILED_r2 = false;
                b005_MODIFIED_r2 = false;
                b009_MESSAGE_r3 = false;
                b012_READY_r3 = false;
                b007_NFCEVENT_r1 = false;
                b007_MAGNETOMETEREVENT_r4 = false;
                b009_STOP_r2 = false;
                b009_REMOVETOPIC_r5 = false;
                b005_REGISTRATION_r0 = false;
                b009_LIGHT_r1 = false;
                b012_RECEIVED_r0 = false;
                b005_INVALID_r3 = false;
                b012_ERROR_r1 = false;
                b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
                b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b005_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
                b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                // step 92cc7;
                return CONSUME_SIGNAL;
            } else {
                b002.context = b003_o0;
                b002.init();
                b007_SENSORSTATEEVENT_r3 = false;
                b007_ACCELEROMETEREVENT_r6 = false;
                b005_UNREGISTRATION_r1 = false;
                b009_ADDTOPIC_r4 = false;
                b007_COLOREVENT_r0 = false;
                b009_SPEED_r0 = false;
                b009_CHANGEFILTER_r6 = false;
                b007_DUMMYEVENT_r5 = false;
                b007_TEMPERATUREEVENT_r2 = false;
                b012_FAILED_r2 = false;
                b005_MODIFIED_r2 = false;
                b009_MESSAGE_r3 = false;
                b012_READY_r3 = false;
                b007_NFCEVENT_r1 = false;
                b007_MAGNETOMETEREVENT_r4 = false;
                b009_STOP_r2 = false;
                b009_REMOVETOPIC_r5 = false;
                b005_REGISTRATION_r0 = false;
                b009_LIGHT_r1 = false;
                b012_RECEIVED_r0 = false;
                b005_INVALID_r3 = false;
                b012_ERROR_r1 = false;
                b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
                b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b005_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
                b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                // step 098bf;
                return CONSUME_SIGNAL;
            }
        } else {
            b004.context = b011_o0;
            int b004_o1 = b004.getTrainID();
            org.osgi.framework.BundleContext b010_o0 = b010.get();
            if(b010_o0==null) {
                java.lang.String b010_o1 = b010.errMsg();
                org.osgi.framework.BundleContext b003_o0 = b003.get();
                if(b003_o0==null) {
                    java.lang.String b003_o1 = b003.errMsg();
                    org.osgi.framework.BundleContext b013_o0 = b013.get();
                    if(b013_o0==null) {
                        java.lang.String b013_o1 = b013.errMsg();
                        b001.logError(b013_o1);
                        b007_SENSORSTATEEVENT_r3 = false;
                        b007_ACCELEROMETEREVENT_r6 = false;
                        b007_NFCEVENT_r1 = false;
                        b005_UNREGISTRATION_r1 = false;
                        b007_MAGNETOMETEREVENT_r4 = false;
                        b007_COLOREVENT_r0 = false;
                        b007_DUMMYEVENT_r5 = false;
                        b005_REGISTRATION_r0 = false;
                        b005_INVALID_r3 = false;
                        b007_TEMPERATUREEVENT_r2 = false;
                        b005_MODIFIED_r2 = false;
                        b012_READY_r3 = false;
                        scheduler.flushEventQueue(sessionID, "READY_b012");
                        b012_RECEIVED_r0 = false;
                        scheduler.flushEventQueue(sessionID, "RECEIVED_b012");
                        b012_FAILED_r2 = false;
                        scheduler.flushEventQueue(sessionID, "FAILED_b012");
                        b012_ERROR_r1 = false;
                        scheduler.flushEventQueue(sessionID, "ERROR_b012");
                        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b005_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
                        b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                        // step 867ca;
                        return CONSUME_SIGNAL;
                    } else {
                        b012.context = b013_o0;
                        b012.initAMQP();
                        b012_READY_r3 = true;
                        b012_ERROR_r1 = true;
                        b012_FAILED_r2 = true;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b012_state = No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING;
                        b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                        b004_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                        // step b5ba8;
                        return CONSUME_SIGNAL;
                    }
                } else {
                    b002.context = b003_o0;
                    b002.init();
                    org.osgi.framework.BundleContext b013_o0 = b013.get();
                    if(b013_o0==null) {
                        java.lang.String b013_o1 = b013.errMsg();
                        b001.logError(b013_o1);
                        b007_SENSORSTATEEVENT_r3 = false;
                        b007_ACCELEROMETEREVENT_r6 = false;
                        b007_NFCEVENT_r1 = false;
                        b005_UNREGISTRATION_r1 = false;
                        b007_MAGNETOMETEREVENT_r4 = false;
                        b007_COLOREVENT_r0 = false;
                        b007_DUMMYEVENT_r5 = false;
                        b005_REGISTRATION_r0 = false;
                        b005_INVALID_r3 = false;
                        b007_TEMPERATUREEVENT_r2 = false;
                        b005_MODIFIED_r2 = false;
                        b012_READY_r3 = false;
                        scheduler.flushEventQueue(sessionID, "READY_b012");
                        b012_RECEIVED_r0 = false;
                        scheduler.flushEventQueue(sessionID, "RECEIVED_b012");
                        b012_FAILED_r2 = false;
                        scheduler.flushEventQueue(sessionID, "FAILED_b012");
                        b012_ERROR_r1 = false;
                        scheduler.flushEventQueue(sessionID, "ERROR_b012");
                        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b005_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
                        b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                        b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                        // step 6aece;
                        return CONSUME_SIGNAL;
                    } else {
                        b012.context = b013_o0;
                        b012.initAMQP();
                        b012_READY_r3 = true;
                        b012_ERROR_r1 = true;
                        b012_FAILED_r2 = true;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b012_state = No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING;
                        b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                        b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                        b004_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                        // step c2bff;
                        return CONSUME_SIGNAL;
                    }
                }
            } else {
                b009.context = b010_o0;
                b009.init();
                org.osgi.framework.BundleContext b003_o0 = b003.get();
                if(b003_o0==null) {
                    java.lang.String b003_o1 = b003.errMsg();
                    org.osgi.framework.BundleContext b013_o0 = b013.get();
                    if(b013_o0==null) {
                        java.lang.String b013_o1 = b013.errMsg();
                        b001.logError(b013_o1);
                        b007_SENSORSTATEEVENT_r3 = false;
                        b007_ACCELEROMETEREVENT_r6 = false;
                        b007_NFCEVENT_r1 = false;
                        b005_UNREGISTRATION_r1 = false;
                        b007_MAGNETOMETEREVENT_r4 = false;
                        b007_COLOREVENT_r0 = false;
                        b007_DUMMYEVENT_r5 = false;
                        b005_REGISTRATION_r0 = false;
                        b005_INVALID_r3 = false;
                        b007_TEMPERATUREEVENT_r2 = false;
                        b005_MODIFIED_r2 = false;
                        b012_READY_r3 = false;
                        scheduler.flushEventQueue(sessionID, "READY_b012");
                        b012_RECEIVED_r0 = false;
                        scheduler.flushEventQueue(sessionID, "RECEIVED_b012");
                        b012_FAILED_r2 = false;
                        scheduler.flushEventQueue(sessionID, "FAILED_b012");
                        b012_ERROR_r1 = false;
                        scheduler.flushEventQueue(sessionID, "ERROR_b012");
                        b009_ADDTOPIC_r4 = true;
                        b009_SPEED_r0 = true;
                        b009_CHANGEFILTER_r6 = true;
                        b009_STOP_r2 = true;
                        b009_REMOVETOPIC_r5 = true;
                        b009_LIGHT_r1 = true;
                        b009_MESSAGE_r3 = true;
                        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b005_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
                        b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                        // step 289d8;
                        return CONSUME_SIGNAL;
                    } else {
                        b012.context = b013_o0;
                        b012.initAMQP();
                        b012_READY_r3 = true;
                        b009_ADDTOPIC_r4 = true;
                        b009_SPEED_r0 = true;
                        b009_CHANGEFILTER_r6 = true;
                        b009_STOP_r2 = true;
                        b009_REMOVETOPIC_r5 = true;
                        b009_LIGHT_r1 = true;
                        b012_ERROR_r1 = true;
                        b012_FAILED_r2 = true;
                        b009_MESSAGE_r3 = true;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b012_state = No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING;
                        b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                        b004_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                        // step 2eec1;
                        return CONSUME_SIGNAL;
                    }
                } else {
                    b002.context = b003_o0;
                    b002.init();
                    org.osgi.framework.BundleContext b013_o0 = b013.get();
                    if(b013_o0==null) {
                        java.lang.String b013_o1 = b013.errMsg();
                        b001.logError(b013_o1);
                        b007_SENSORSTATEEVENT_r3 = false;
                        b007_ACCELEROMETEREVENT_r6 = false;
                        b007_NFCEVENT_r1 = false;
                        b005_UNREGISTRATION_r1 = false;
                        b007_MAGNETOMETEREVENT_r4 = false;
                        b007_COLOREVENT_r0 = false;
                        b007_DUMMYEVENT_r5 = false;
                        b005_REGISTRATION_r0 = false;
                        b005_INVALID_r3 = false;
                        b007_TEMPERATUREEVENT_r2 = false;
                        b005_MODIFIED_r2 = false;
                        b012_READY_r3 = false;
                        scheduler.flushEventQueue(sessionID, "READY_b012");
                        b012_RECEIVED_r0 = false;
                        scheduler.flushEventQueue(sessionID, "RECEIVED_b012");
                        b012_FAILED_r2 = false;
                        scheduler.flushEventQueue(sessionID, "FAILED_b012");
                        b012_ERROR_r1 = false;
                        scheduler.flushEventQueue(sessionID, "ERROR_b012");
                        b009_ADDTOPIC_r4 = true;
                        b009_SPEED_r0 = true;
                        b009_CHANGEFILTER_r6 = true;
                        b009_STOP_r2 = true;
                        b009_REMOVETOPIC_r5 = true;
                        b009_LIGHT_r1 = true;
                        b009_MESSAGE_r3 = true;
                        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b005_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
                        b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                        b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                        // step b4ce3;
                        return CONSUME_SIGNAL;
                    } else {
                        b012.context = b013_o0;
                        b012.initAMQP();
                        b012_READY_r3 = true;
                        b009_ADDTOPIC_r4 = true;
                        b009_SPEED_r0 = true;
                        b009_CHANGEFILTER_r6 = true;
                        b009_STOP_r2 = true;
                        b009_REMOVETOPIC_r5 = true;
                        b009_LIGHT_r1 = true;
                        b012_ERROR_r1 = true;
                        b012_FAILED_r2 = true;
                        b009_MESSAGE_r3 = true;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b012_state = No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING;
                        b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                        b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                        b004_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                        // step 1cba3;
                        return CONSUME_SIGNAL;
                    }
                }
            }
        }
    }

    public int fireTimer(java.lang.String _timerID) {
                return DISCARD_SIGNAL;
    }

    public int fire(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.String _signalID, java.lang.Object _data) {
        if(_signalID.equals("FAILED_b012")) {
            return handleEvent_FAILED_b012(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MAGNETOMETEREVENT_b007")) {
            return handleEvent_MAGNETOMETEREVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("REGISTRATION_b005")) {
            return handleEvent_REGISTRATION_b005(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("TEMPERATUREEVENT_b007")) {
            return handleEvent_TEMPERATUREEVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("INVALID_b005")) {
            return handleEvent_INVALID_b005(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("READY_b012")) {
            return handleEvent_READY_b012(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("CHANGEFILTER_b009")) {
            return handleEvent_CHANGEFILTER_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("ACCELEROMETEREVENT_b007")) {
            return handleEvent_ACCELEROMETEREVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("UNREGISTRATION_b005")) {
            return handleEvent_UNREGISTRATION_b005(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("SENSORSTATEEVENT_b007")) {
            return handleEvent_SENSORSTATEEVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("SPEED_b009")) {
            return handleEvent_SPEED_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("LIGHT_b009")) {
            return handleEvent_LIGHT_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("ERROR_b012")) {
            return handleEvent_ERROR_b012(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("DUMMYEVENT_b007")) {
            return handleEvent_DUMMYEVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("COLOREVENT_b007")) {
            return handleEvent_COLOREVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("RECEIVED_b012")) {
            return handleEvent_RECEIVED_b012(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MODIFIED_b005")) {
            return handleEvent_MODIFIED_b005(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("STOP_b009")) {
            return handleEvent_STOP_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("REMOVETOPIC_b009")) {
            return handleEvent_REMOVETOPIC_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("NFCEVENT_b007")) {
            return handleEvent_NFCEVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("ADDTOPIC_b009")) {
            return handleEvent_ADDTOPIC_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MESSAGE_b009")) {
            return handleEvent_MESSAGE_b009(_sender, receiverSessionID, _data);
        }
        return TRIGGER_UNKNOWN;
    }

    private int handleEvent_FAILED_b012(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b012_FAILED_r2) {
            if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE) {
                b012_FAILED_r2 = false;
                // step 2851d;
                return CONSUME_SIGNAL;
            } else if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING) {
                b012_READY_r3 = false;
                scheduler.flushEventQueue(sessionID, "READY_b012");
                b012_RECEIVED_r0 = false;
                scheduler.flushEventQueue(sessionID, "RECEIVED_b012");
                b012_FAILED_r2 = false;
                scheduler.flushEventQueue(sessionID, "FAILED_b012");
                b012_ERROR_r1 = false;
                scheduler.flushEventQueue(sessionID, "ERROR_b012");
                b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                // step 74e57;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_MAGNETOMETEREVENT_b007(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b007_MAGNETOMETEREVENT_r4) {
            b009.handleMagnetometerEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading) _data));
            // step a4d13;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_REGISTRATION_b005(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b005_REGISTRATION_r0) {
            if(b007_state==No_ntnu_item_its_train_adapter_SensorController._IDLE) {
                // step 81ace;
                return CONSUME_SIGNAL;
            } else if(b007_state==No_ntnu_item_its_train_adapter_SensorController.ACTIVE) {
                b007.registerSensor(((org.osgi.framework.ServiceReference) _data));
                // step 20131;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_TEMPERATUREEVENT_b007(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b007_TEMPERATUREEVENT_r2) {
            b009.handleTemperatureEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading) _data));
            // step d9062;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_INVALID_b005(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b005_INVALID_r3) {
            // step 03b5d;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_READY_b012(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b012_READY_r3) {
            java.lang.String b004_o0 = b004.getFilter();
            b005.filter = b004_o0;
            org.osgi.framework.BundleContext b006_o0 = b006.get();
            if(b006_o0==null) {
                java.lang.String b006_o1 = b006.errMsg();
                b012_READY_r3 = false;
                b005_UNREGISTRATION_r1 = false;
                scheduler.flushEventQueue(sessionID, "UNREGISTRATION_b005");
                b005_REGISTRATION_r0 = false;
                scheduler.flushEventQueue(sessionID, "REGISTRATION_b005");
                b005_INVALID_r3 = false;
                scheduler.flushEventQueue(sessionID, "INVALID_b005");
                b005_MODIFIED_r2 = false;
                scheduler.flushEventQueue(sessionID, "MODIFIED_b005");
                b012_RECEIVED_r0 = true;
                b012_state = No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE;
                // step 8cabf;
                return CONSUME_SIGNAL;
            } else {
                b005.context = b006_o0;
                b005.startListener(b005.filter);
                org.osgi.framework.BundleContext b008_o0 = b008.get();
                if(b008_o0==null) {
                    java.lang.String b008_o1 = b008.errMsg();
                    b012_READY_r3 = false;
                    b007_SENSORSTATEEVENT_r3 = false;
                    scheduler.flushEventQueue(sessionID, "SENSORSTATEEVENT_b007");
                    b007_ACCELEROMETEREVENT_r6 = false;
                    scheduler.flushEventQueue(sessionID, "ACCELEROMETEREVENT_b007");
                    b007_NFCEVENT_r1 = false;
                    scheduler.flushEventQueue(sessionID, "NFCEVENT_b007");
                    b007_MAGNETOMETEREVENT_r4 = false;
                    scheduler.flushEventQueue(sessionID, "MAGNETOMETEREVENT_b007");
                    b007_COLOREVENT_r0 = false;
                    scheduler.flushEventQueue(sessionID, "COLOREVENT_b007");
                    b007_DUMMYEVENT_r5 = false;
                    scheduler.flushEventQueue(sessionID, "DUMMYEVENT_b007");
                    b007_TEMPERATUREEVENT_r2 = false;
                    scheduler.flushEventQueue(sessionID, "TEMPERATUREEVENT_b007");
                    b005_UNREGISTRATION_r1 = true;
                    b005_REGISTRATION_r0 = true;
                    b012_RECEIVED_r0 = true;
                    b005_INVALID_r3 = true;
                    b005_MODIFIED_r2 = true;
                    b012_state = No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE;
                    b005_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker.ACTIVE;
                    // step 27e0a;
                    return CONSUME_SIGNAL;
                } else {
                    b007.context = b008_o0;
                    b007.init();
                    b012_READY_r3 = false;
                    b007_ACCELEROMETEREVENT_r6 = true;
                    b007_SENSORSTATEEVENT_r3 = true;
                    b007_NFCEVENT_r1 = true;
                    b005_UNREGISTRATION_r1 = true;
                    b007_MAGNETOMETEREVENT_r4 = true;
                    b007_COLOREVENT_r0 = true;
                    b007_DUMMYEVENT_r5 = true;
                    b005_REGISTRATION_r0 = true;
                    b012_RECEIVED_r0 = true;
                    b005_INVALID_r3 = true;
                    b007_TEMPERATUREEVENT_r2 = true;
                    b005_MODIFIED_r2 = true;
                    b012_state = No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE;
                    b005_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker.ACTIVE;
                    b007_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                    // step 4e1e0;
                    return CONSUME_SIGNAL;
                }
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_CHANGEFILTER_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_CHANGEFILTER_r6) {
            if(b005_state==No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE) {
                // step 08a64;
                return CONSUME_SIGNAL;
            } else if(b005_state==No_ntnu_item_its_train_adapter_CustomeServiceTracker.ACTIVE) {
                b005.startListener(((java.lang.String) _data));
                // step 07bd6;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_ACCELEROMETEREVENT_b007(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b007_ACCELEROMETEREVENT_r6) {
            b009.handleAccelerometerEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading) _data));
            // step 04bc9;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_UNREGISTRATION_b005(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b005_UNREGISTRATION_r1) {
            if(b007_state==No_ntnu_item_its_train_adapter_SensorController._IDLE) {
                // step fde6b;
                return CONSUME_SIGNAL;
            } else if(b007_state==No_ntnu_item_its_train_adapter_SensorController.ACTIVE) {
                b007.unregisterSensor(((org.osgi.framework.ServiceReference) _data));
                // step c949a;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_SENSORSTATEEVENT_b007(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b007_SENSORSTATEEVENT_r3) {
            b009.handleSensorStateEvent(((org.osgi.framework.ServiceEvent) _data));
            // step 5e6d4;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_SPEED_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_SPEED_r0) {
            int b001_o2 = b001.convertSpeed(((Double)_data).doubleValue());
            if(b002_state==No_ntnu_item_osgi_train_system_MotorController._IDLE) {
                // step 7554d;
                return CONSUME_SIGNAL;
            } else if(b002_state==No_ntnu_item_osgi_train_system_MotorController.ACTIVE) {
                b002.setSpeed(b001_o2);
                // step 2e309;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_LIGHT_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_LIGHT_r1) {
            // step f25b5;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_ERROR_b012(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b012_ERROR_r1) {
            if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE) {
                b009.handleSendError(((java.lang.String) _data));
                // step 69d11;
                return CONSUME_SIGNAL;
            } else if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING) {
                // step 67515;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_DUMMYEVENT_b007(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b007_DUMMYEVENT_r5) {
            b009.handleDummyEvent();
            // step 54671;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_COLOREVENT_b007(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b007_COLOREVENT_r0) {
            b009.handleColorEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading) _data));
            // step 2b06f;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_RECEIVED_b012(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b012_RECEIVED_r0) {
            b009.handleMessage(((no.ntnu.item.its.train.adapter.common.TrainCommand) _data));
            // step 551ce;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_MODIFIED_b005(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b005_MODIFIED_r2) {
            if(b007_state==No_ntnu_item_its_train_adapter_SensorController._IDLE) {
                // step 977d9;
                return CONSUME_SIGNAL;
            } else if(b007_state==No_ntnu_item_its_train_adapter_SensorController.ACTIVE) {
                b007.modifiedSensor(((org.osgi.framework.ServiceReference) _data));
                // step f726e;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_STOP_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_STOP_r2) {
            b001.stop();
            if(b002_state==No_ntnu_item_osgi_train_system_MotorController._IDLE) {
                // step 50b63;
                return CONSUME_SIGNAL;
            } else if(b002_state==No_ntnu_item_osgi_train_system_MotorController.ACTIVE) {
                b002.stopTrain();
                // step f205e;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_REMOVETOPIC_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_REMOVETOPIC_r5) {
            if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE) {
                b012.removeTopic(((java.lang.String) _data));
                // step d0294;
                return CONSUME_SIGNAL;
            } else if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl._IDLE) {
                // step 17bb4;
                return CONSUME_SIGNAL;
            } else if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING) {
                // step 68b87;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_NFCEVENT_b007(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b007_NFCEVENT_r1) {
            b009.handleNFCEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading) _data));
            // step fb746;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_ADDTOPIC_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_ADDTOPIC_r4) {
            if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE) {
                b012.addTopic(((java.lang.String) _data));
                // step 23c6d;
                return CONSUME_SIGNAL;
            } else if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl._IDLE) {
                // step 7a570;
                return CONSUME_SIGNAL;
            } else if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING) {
                // step 92a42;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_MESSAGE_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_MESSAGE_r3) {
            if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE) {
                b012.sendMsg(((no.ntnu.trainamqpservice.common.AMQPMessage) _data));
                // step 99e19;
                return CONSUME_SIGNAL;
            } else if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl._IDLE) {
                // step 5668b;
                return CONSUME_SIGNAL;
            } else if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING) {
                // step a0a62;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    public java.lang.String getPartName() {
        return null;
    }
}
