package no.ntnu.item.osgi.train.system.system.component;

public class ComponentSM extends no.ntnu.item.arctis.runtime.IStateMachine {


    private no.ntnu.item.osgi.train.system.train.Train b001;
    private no.ntnu.item.osgi.train.system.motorcontroller.MotorController b002;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b003;
    private no.ntnu.item.its.train.adapter.trainadapter.TrainAdapter b004;
    private no.ntnu.item.its.train.adapter.customservicetracker.CustomServiceTracker b005;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b006;
    private no.ntnu.item.its.train.adapter.sensorcontroller.SensorController b007;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b008;
    private no.ntnu.item.its.train.adapter.contextchecker.ContextChecker b009;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b010;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b011;
    private no.ntnu.item.its.train.adapter.remotecontrol.RemoteControl b012;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b013;
    private boolean b007_ACCELEROMETEREVENT_r6;
    private boolean b007_COLOREVENT_r0;
    private boolean b009_LIGHT_r1;
    private boolean b009_RECONFIGURESENSOR_r9;
    private boolean b009_REMOVETOPIC_r5;
    private boolean b009_ADDTOPIC_r4;
    private boolean b012_ERROR_r1;
    private boolean b007_SENSORSTATEEVENT_r3;
    private boolean b009_MESSAGE_r3;
    private boolean b009_SPEED_r0;
    private boolean b005_INVALID_r3;
    private boolean b009_UPDATEHANDLER_r7;
    private boolean b009_CHANGEFILTER_r6;
    private boolean b007_MAGNETOMETEREVENT_r4;
    private boolean b005_REGISTRATION_r0;
    private boolean b007_NFCEVENT_r1;
    private boolean b005_UNREGISTRATION_r1;
    private boolean b007_TEMPERATUREEVENT_r2;
    private boolean b005_MODIFIED_r2;
    private boolean b007_DUMMYEVENT_r5;
    private boolean b012_RECEIVED_r0;
    private boolean b009_STOP_r2;
    private boolean b012_READY_r3;
    private boolean b009_FAILED_r8;
    private boolean b012_FAILED_r2;
    private enum No_ntnu_item_osgi_train_system_Train {_IDLE, ACTIVE, INITIALIZING};
    private enum No_ntnu_item_osgi_train_system_MotorController {ACTIVE, _IDLE};
    private enum Com_bitreactive_library_osgi_GetBundleContext {_IDLE};
    private enum No_ntnu_item_its_train_adapter_TrainAdapter {_IDLE, INITIALIZING, ACTIVE};
    private enum No_ntnu_item_its_train_adapter_CustomServiceTracker {_IDLE, ACTIVE};
    private enum No_ntnu_item_its_train_adapter_SensorController {ACTIVE, _IDLE};
    private enum No_ntnu_item_its_train_adapter_ContextChecker {ACTIVE, _IDLE};
    private enum No_ntnu_item_its_train_adapter_RemoteControl {ACTIVE, _IDLE, INITIALIZING};
    private No_ntnu_item_osgi_train_system_Train b001_state;
    private No_ntnu_item_osgi_train_system_MotorController b002_state;
    private Com_bitreactive_library_osgi_GetBundleContext b003_state;
    private No_ntnu_item_its_train_adapter_TrainAdapter b004_state;
    private No_ntnu_item_its_train_adapter_CustomServiceTracker b005_state;
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
        b005 = new no.ntnu.item.its.train.adapter.customservicetracker.CustomServiceTracker();
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
        b005_state = No_ntnu_item_its_train_adapter_CustomServiceTracker._IDLE;
        b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
        b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b011_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
        b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        org.osgi.framework.BundleContext b003_o0 = b003.get();
        if(b003_o0==null) {
            java.lang.String b003_o1 = b003.errMsg();
            b001.logError(b003_o1);
            b007_ACCELEROMETEREVENT_r6 = false;
            b007_COLOREVENT_r0 = false;
            b009_LIGHT_r1 = false;
            b009_REMOVETOPIC_r5 = false;
            b009_RECONFIGURESENSOR_r9 = false;
            b009_ADDTOPIC_r4 = false;
            b012_ERROR_r1 = false;
            b007_SENSORSTATEEVENT_r3 = false;
            b009_MESSAGE_r3 = false;
            b009_SPEED_r0 = false;
            b005_INVALID_r3 = false;
            b009_UPDATEHANDLER_r7 = false;
            b009_CHANGEFILTER_r6 = false;
            b007_MAGNETOMETEREVENT_r4 = false;
            b005_REGISTRATION_r0 = false;
            b007_NFCEVENT_r1 = false;
            b005_UNREGISTRATION_r1 = false;
            b005_MODIFIED_r2 = false;
            b007_TEMPERATUREEVENT_r2 = false;
            b007_DUMMYEVENT_r5 = false;
            b009_STOP_r2 = false;
            b012_RECEIVED_r0 = false;
            b012_READY_r3 = false;
            b009_FAILED_r8 = false;
            b012_FAILED_r2 = false;
            b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
            b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b005_state = No_ntnu_item_its_train_adapter_CustomServiceTracker._IDLE;
            b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
            b004_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
            b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
            b011_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            // step aaebb;
            return CONSUME_SIGNAL;
        } else {
            b002.context = b003_o0;
            b002.init();
            org.osgi.framework.BundleContext b011_o0 = b011.get();
            if(b011_o0==null) {
                java.lang.String b011_o1 = b011.errMsg();
                b001.logError(b011_o1);
                b007_ACCELEROMETEREVENT_r6 = false;
                b007_COLOREVENT_r0 = false;
                b009_LIGHT_r1 = false;
                b009_REMOVETOPIC_r5 = false;
                b009_RECONFIGURESENSOR_r9 = false;
                b009_ADDTOPIC_r4 = false;
                b012_ERROR_r1 = false;
                b007_SENSORSTATEEVENT_r3 = false;
                b009_MESSAGE_r3 = false;
                b009_SPEED_r0 = false;
                b005_INVALID_r3 = false;
                b009_UPDATEHANDLER_r7 = false;
                b009_CHANGEFILTER_r6 = false;
                b007_MAGNETOMETEREVENT_r4 = false;
                b005_REGISTRATION_r0 = false;
                b007_NFCEVENT_r1 = false;
                b005_UNREGISTRATION_r1 = false;
                b005_MODIFIED_r2 = false;
                b007_TEMPERATUREEVENT_r2 = false;
                b007_DUMMYEVENT_r5 = false;
                b009_STOP_r2 = false;
                b012_RECEIVED_r0 = false;
                b012_READY_r3 = false;
                b009_FAILED_r8 = false;
                b012_FAILED_r2 = false;
                b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
                b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b005_state = No_ntnu_item_its_train_adapter_CustomServiceTracker._IDLE;
                b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                // step 7837d;
                return CONSUME_SIGNAL;
            } else {
                b004.context = b011_o0;
                no.ntnu.item.its.train.adapter.trainInfo.TrainInfo b004_o1 = b004.getTrainInfo();
                b009.trainInfo = b004_o1;
                org.osgi.framework.BundleContext b010_o0 = b010.get();
                if(b010_o0==null) {
                    java.lang.String b010_o1 = b010.errMsg();
                    b001.logError(b010_o1);
                    b007_ACCELEROMETEREVENT_r6 = false;
                    b007_COLOREVENT_r0 = false;
                    b007_MAGNETOMETEREVENT_r4 = false;
                    b005_REGISTRATION_r0 = false;
                    b007_NFCEVENT_r1 = false;
                    b005_UNREGISTRATION_r1 = false;
                    b005_MODIFIED_r2 = false;
                    b007_TEMPERATUREEVENT_r2 = false;
                    b007_DUMMYEVENT_r5 = false;
                    b012_ERROR_r1 = false;
                    b012_RECEIVED_r0 = false;
                    b012_READY_r3 = false;
                    b007_SENSORSTATEEVENT_r3 = false;
                    b005_INVALID_r3 = false;
                    b012_FAILED_r2 = false;
                    b009_STOP_r2 = false;
                    scheduler.flushEventQueue(sessionID, "STOP_b009");
                    b009_LIGHT_r1 = false;
                    scheduler.flushEventQueue(sessionID, "LIGHT_b009");
                    b009_MESSAGE_r3 = false;
                    scheduler.flushEventQueue(sessionID, "MESSAGE_b009");
                    b009_REMOVETOPIC_r5 = false;
                    scheduler.flushEventQueue(sessionID, "REMOVETOPIC_b009");
                    b009_RECONFIGURESENSOR_r9 = false;
                    scheduler.flushEventQueue(sessionID, "RECONFIGURESENSOR_b009");
                    b009_SPEED_r0 = false;
                    scheduler.flushEventQueue(sessionID, "SPEED_b009");
                    b009_UPDATEHANDLER_r7 = false;
                    scheduler.flushEventQueue(sessionID, "UPDATEHANDLER_b009");
                    b009_FAILED_r8 = false;
                    scheduler.flushEventQueue(sessionID, "FAILED_b009");
                    b009_CHANGEFILTER_r6 = false;
                    scheduler.flushEventQueue(sessionID, "CHANGEFILTER_b009");
                    b009_ADDTOPIC_r4 = false;
                    scheduler.flushEventQueue(sessionID, "ADDTOPIC_b009");
                    b005_state = No_ntnu_item_its_train_adapter_CustomServiceTracker._IDLE;
                    b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                    b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                    b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                    // step e9176;
                    return CONSUME_SIGNAL;
                } else {
                    b009.context = b010_o0;
                    b009.init();
                    org.osgi.framework.BundleContext b013_o0 = b013.get();
                    if(b013_o0==null) {
                        java.lang.String b013_o1 = b013.errMsg();
                        b001.logError(b013_o1);
                        b005_MODIFIED_r2 = false;
                        b007_ACCELEROMETEREVENT_r6 = false;
                        b007_TEMPERATUREEVENT_r2 = false;
                        b007_DUMMYEVENT_r5 = false;
                        b007_COLOREVENT_r0 = false;
                        b007_MAGNETOMETEREVENT_r4 = false;
                        b007_SENSORSTATEEVENT_r3 = false;
                        b005_INVALID_r3 = false;
                        b005_REGISTRATION_r0 = false;
                        b007_NFCEVENT_r1 = false;
                        b005_UNREGISTRATION_r1 = false;
                        b012_ERROR_r1 = false;
                        scheduler.flushEventQueue(sessionID, "ERROR_b012");
                        b012_RECEIVED_r0 = false;
                        scheduler.flushEventQueue(sessionID, "RECEIVED_b012");
                        b012_READY_r3 = false;
                        scheduler.flushEventQueue(sessionID, "READY_b012");
                        b012_FAILED_r2 = false;
                        scheduler.flushEventQueue(sessionID, "FAILED_b012");
                        b009_STOP_r2 = true;
                        b009_LIGHT_r1 = true;
                        b009_MESSAGE_r3 = true;
                        b009_REMOVETOPIC_r5 = true;
                        b009_RECONFIGURESENSOR_r9 = true;
                        b009_SPEED_r0 = true;
                        b009_UPDATEHANDLER_r7 = true;
                        b009_FAILED_r8 = true;
                        b009_CHANGEFILTER_r6 = true;
                        b009_ADDTOPIC_r4 = true;
                        b005_state = No_ntnu_item_its_train_adapter_CustomServiceTracker._IDLE;
                        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                        // step d2d75;
                        return CONSUME_SIGNAL;
                    } else {
                        b012.context = b013_o0;
                        b012.initAMQP();
                        b009_LIGHT_r1 = true;
                        b009_REMOVETOPIC_r5 = true;
                        b009_RECONFIGURESENSOR_r9 = true;
                        b009_ADDTOPIC_r4 = true;
                        b012_ERROR_r1 = true;
                        b009_STOP_r2 = true;
                        b012_READY_r3 = true;
                        b009_MESSAGE_r3 = true;
                        b009_SPEED_r0 = true;
                        b009_UPDATEHANDLER_r7 = true;
                        b009_FAILED_r8 = true;
                        b009_CHANGEFILTER_r6 = true;
                        b012_FAILED_r2 = true;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                        b012_state = No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING;
                        b004_state = No_ntnu_item_its_train_adapter_TrainAdapter.INITIALIZING;
                        b001_state = No_ntnu_item_osgi_train_system_Train.INITIALIZING;
                        // step 4aa63;
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
        if(_signalID.equals("RECEIVED_b012")) {
            return handleEvent_RECEIVED_b012(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("RECONFIGURESENSOR_b009")) {
            return handleEvent_RECONFIGURESENSOR_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MESSAGE_b009")) {
            return handleEvent_MESSAGE_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("TEMPERATUREEVENT_b007")) {
            return handleEvent_TEMPERATUREEVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("REMOVETOPIC_b009")) {
            return handleEvent_REMOVETOPIC_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("UNREGISTRATION_b005")) {
            return handleEvent_UNREGISTRATION_b005(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("DUMMYEVENT_b007")) {
            return handleEvent_DUMMYEVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("READY_b012")) {
            return handleEvent_READY_b012(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("FAILED_b009")) {
            return handleEvent_FAILED_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("INVALID_b005")) {
            return handleEvent_INVALID_b005(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("STOP_b009")) {
            return handleEvent_STOP_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("NFCEVENT_b007")) {
            return handleEvent_NFCEVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("ACCELEROMETEREVENT_b007")) {
            return handleEvent_ACCELEROMETEREVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("COLOREVENT_b007")) {
            return handleEvent_COLOREVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MAGNETOMETEREVENT_b007")) {
            return handleEvent_MAGNETOMETEREVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("FAILED_b012")) {
            return handleEvent_FAILED_b012(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("SENSORSTATEEVENT_b007")) {
            return handleEvent_SENSORSTATEEVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("UPDATEHANDLER_b009")) {
            return handleEvent_UPDATEHANDLER_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("SPEED_b009")) {
            return handleEvent_SPEED_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MODIFIED_b005")) {
            return handleEvent_MODIFIED_b005(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("ERROR_b012")) {
            return handleEvent_ERROR_b012(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("REGISTRATION_b005")) {
            return handleEvent_REGISTRATION_b005(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("LIGHT_b009")) {
            return handleEvent_LIGHT_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("CHANGEFILTER_b009")) {
            return handleEvent_CHANGEFILTER_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("ADDTOPIC_b009")) {
            return handleEvent_ADDTOPIC_b009(_sender, receiverSessionID, _data);
        }
        return TRIGGER_UNKNOWN;
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

    private int handleEvent_RECONFIGURESENSOR_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_RECONFIGURESENSOR_r9) {
            if(b007_state==No_ntnu_item_its_train_adapter_SensorController.ACTIVE) {
                b007.reconfigureSensor(((no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorReconfiguration) _data));
                // step 86311;
                return CONSUME_SIGNAL;
            } else if(b007_state==No_ntnu_item_its_train_adapter_SensorController._IDLE) {
                // step 56cfa;
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

    private int handleEvent_TEMPERATUREEVENT_b007(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b007_TEMPERATUREEVENT_r2) {
            b009.handleTemperatureEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading) _data));
            // step d9062;
            return CONSUME_SIGNAL;
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

    private int handleEvent_UNREGISTRATION_b005(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b005_UNREGISTRATION_r1) {
            b007.unregisterSensor(((org.osgi.framework.ServiceReference) _data));
            // step 2d799;
            return CONSUME_SIGNAL;
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

    private int handleEvent_READY_b012(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b012_READY_r3) {
            org.osgi.framework.BundleContext b008_o0 = b008.get();
            if(b008_o0==null) {
                java.lang.String b008_o1 = b008.errMsg();
                b001.logError(b008_o1);
                b009_LIGHT_r1 = false;
                b009_REMOVETOPIC_r5 = false;
                b009_RECONFIGURESENSOR_r9 = false;
                b005_REGISTRATION_r0 = false;
                b009_ADDTOPIC_r4 = false;
                b005_UNREGISTRATION_r1 = false;
                b005_MODIFIED_r2 = false;
                b009_STOP_r2 = false;
                b009_MESSAGE_r3 = false;
                b009_SPEED_r0 = false;
                b005_INVALID_r3 = false;
                b009_UPDATEHANDLER_r7 = false;
                b009_FAILED_r8 = false;
                b009_CHANGEFILTER_r6 = false;
                b012_READY_r3 = false;
                b007_ACCELEROMETEREVENT_r6 = false;
                scheduler.flushEventQueue(sessionID, "ACCELEROMETEREVENT_b007");
                b007_TEMPERATUREEVENT_r2 = false;
                scheduler.flushEventQueue(sessionID, "TEMPERATUREEVENT_b007");
                b007_DUMMYEVENT_r5 = false;
                scheduler.flushEventQueue(sessionID, "DUMMYEVENT_b007");
                b007_COLOREVENT_r0 = false;
                scheduler.flushEventQueue(sessionID, "COLOREVENT_b007");
                b007_MAGNETOMETEREVENT_r4 = false;
                scheduler.flushEventQueue(sessionID, "MAGNETOMETEREVENT_b007");
                b007_SENSORSTATEEVENT_r3 = false;
                scheduler.flushEventQueue(sessionID, "SENSORSTATEEVENT_b007");
                b007_NFCEVENT_r1 = false;
                scheduler.flushEventQueue(sessionID, "NFCEVENT_b007");
                b012_RECEIVED_r0 = true;
                b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
                b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b005_state = No_ntnu_item_its_train_adapter_CustomServiceTracker._IDLE;
                b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b011_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b012_state = No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE;
                b004_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
                // step 72542;
                return CONSUME_SIGNAL;
            } else {
                b007.context = b008_o0;
                b007.init();
                java.lang.String b004_o0 = b004.getFilter();
                b005.filter = b004_o0;
                org.osgi.framework.BundleContext b006_o0 = b006.get();
                if(b006_o0==null) {
                    java.lang.String b006_o1 = b006.errMsg();
                    b001.logError(b006_o1);
                    b009_STOP_r2 = false;
                    b009_LIGHT_r1 = false;
                    b009_MESSAGE_r3 = false;
                    b009_REMOVETOPIC_r5 = false;
                    b009_RECONFIGURESENSOR_r9 = false;
                    b009_SPEED_r0 = false;
                    b009_UPDATEHANDLER_r7 = false;
                    b009_FAILED_r8 = false;
                    b009_CHANGEFILTER_r6 = false;
                    b009_ADDTOPIC_r4 = false;
                    b012_READY_r3 = false;
                    b005_MODIFIED_r2 = false;
                    scheduler.flushEventQueue(sessionID, "MODIFIED_b005");
                    b005_INVALID_r3 = false;
                    scheduler.flushEventQueue(sessionID, "INVALID_b005");
                    b005_REGISTRATION_r0 = false;
                    scheduler.flushEventQueue(sessionID, "REGISTRATION_b005");
                    b005_UNREGISTRATION_r1 = false;
                    scheduler.flushEventQueue(sessionID, "UNREGISTRATION_b005");
                    b007_ACCELEROMETEREVENT_r6 = true;
                    b007_TEMPERATUREEVENT_r2 = true;
                    b007_DUMMYEVENT_r5 = true;
                    b007_COLOREVENT_r0 = true;
                    b007_MAGNETOMETEREVENT_r4 = true;
                    b012_RECEIVED_r0 = true;
                    b007_SENSORSTATEEVENT_r3 = true;
                    b007_NFCEVENT_r1 = true;
                    b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
                    b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b011_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b012_state = No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE;
                    b004_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
                    b007_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                    // step 47461;
                    return CONSUME_SIGNAL;
                } else {
                    b005.context = b006_o0;
                    b005.startListener(b005.filter);
                    b012_READY_r3 = false;
                    b007_ACCELEROMETEREVENT_r6 = true;
                    b005_MODIFIED_r2 = true;
                    b007_TEMPERATUREEVENT_r2 = true;
                    b007_DUMMYEVENT_r5 = true;
                    b007_COLOREVENT_r0 = true;
                    b007_MAGNETOMETEREVENT_r4 = true;
                    b012_RECEIVED_r0 = true;
                    b007_SENSORSTATEEVENT_r3 = true;
                    b005_INVALID_r3 = true;
                    b005_REGISTRATION_r0 = true;
                    b007_NFCEVENT_r1 = true;
                    b005_UNREGISTRATION_r1 = true;
                    b005_state = No_ntnu_item_its_train_adapter_CustomServiceTracker.ACTIVE;
                    b012_state = No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE;
                    b004_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                    b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                    b007_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                    // step 31ef2;
                    return CONSUME_SIGNAL;
                }
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_FAILED_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_FAILED_r8) {
            if(b004_state==No_ntnu_item_its_train_adapter_TrainAdapter.INITIALIZING) {
                b001.logError(((java.lang.String) _data));
                b007_ACCELEROMETEREVENT_r6 = false;
                b007_COLOREVENT_r0 = false;
                b007_MAGNETOMETEREVENT_r4 = false;
                b005_REGISTRATION_r0 = false;
                b007_NFCEVENT_r1 = false;
                b005_UNREGISTRATION_r1 = false;
                b005_MODIFIED_r2 = false;
                b007_TEMPERATUREEVENT_r2 = false;
                b007_DUMMYEVENT_r5 = false;
                b012_ERROR_r1 = false;
                b012_RECEIVED_r0 = false;
                b012_READY_r3 = false;
                b007_SENSORSTATEEVENT_r3 = false;
                b005_INVALID_r3 = false;
                b012_FAILED_r2 = false;
                b009_STOP_r2 = false;
                scheduler.flushEventQueue(sessionID, "STOP_b009");
                b009_LIGHT_r1 = false;
                scheduler.flushEventQueue(sessionID, "LIGHT_b009");
                b009_MESSAGE_r3 = false;
                scheduler.flushEventQueue(sessionID, "MESSAGE_b009");
                b009_REMOVETOPIC_r5 = false;
                scheduler.flushEventQueue(sessionID, "REMOVETOPIC_b009");
                b009_RECONFIGURESENSOR_r9 = false;
                scheduler.flushEventQueue(sessionID, "RECONFIGURESENSOR_b009");
                b009_SPEED_r0 = false;
                scheduler.flushEventQueue(sessionID, "SPEED_b009");
                b009_UPDATEHANDLER_r7 = false;
                scheduler.flushEventQueue(sessionID, "UPDATEHANDLER_b009");
                b009_FAILED_r8 = false;
                scheduler.flushEventQueue(sessionID, "FAILED_b009");
                b009_CHANGEFILTER_r6 = false;
                scheduler.flushEventQueue(sessionID, "CHANGEFILTER_b009");
                b009_ADDTOPIC_r4 = false;
                scheduler.flushEventQueue(sessionID, "ADDTOPIC_b009");
                b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b005_state = No_ntnu_item_its_train_adapter_CustomServiceTracker._IDLE;
                b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                b011_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
                b004_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
                // step f8a7f;
                return CONSUME_SIGNAL;
            } else if(b004_state==No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE) {
                b001.logError(((java.lang.String) _data));
                b007_ACCELEROMETEREVENT_r6 = false;
                b007_COLOREVENT_r0 = false;
                b007_MAGNETOMETEREVENT_r4 = false;
                b005_REGISTRATION_r0 = false;
                b007_NFCEVENT_r1 = false;
                b005_UNREGISTRATION_r1 = false;
                b005_MODIFIED_r2 = false;
                b007_TEMPERATUREEVENT_r2 = false;
                b007_DUMMYEVENT_r5 = false;
                b012_ERROR_r1 = false;
                b012_RECEIVED_r0 = false;
                b012_READY_r3 = false;
                b007_SENSORSTATEEVENT_r3 = false;
                b005_INVALID_r3 = false;
                b012_FAILED_r2 = false;
                b009_STOP_r2 = false;
                scheduler.flushEventQueue(sessionID, "STOP_b009");
                b009_LIGHT_r1 = false;
                scheduler.flushEventQueue(sessionID, "LIGHT_b009");
                b009_MESSAGE_r3 = false;
                scheduler.flushEventQueue(sessionID, "MESSAGE_b009");
                b009_REMOVETOPIC_r5 = false;
                scheduler.flushEventQueue(sessionID, "REMOVETOPIC_b009");
                b009_RECONFIGURESENSOR_r9 = false;
                scheduler.flushEventQueue(sessionID, "RECONFIGURESENSOR_b009");
                b009_SPEED_r0 = false;
                scheduler.flushEventQueue(sessionID, "SPEED_b009");
                b009_UPDATEHANDLER_r7 = false;
                scheduler.flushEventQueue(sessionID, "UPDATEHANDLER_b009");
                b009_FAILED_r8 = false;
                scheduler.flushEventQueue(sessionID, "FAILED_b009");
                b009_CHANGEFILTER_r6 = false;
                scheduler.flushEventQueue(sessionID, "CHANGEFILTER_b009");
                b009_ADDTOPIC_r4 = false;
                scheduler.flushEventQueue(sessionID, "ADDTOPIC_b009");
                b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b005_state = No_ntnu_item_its_train_adapter_CustomServiceTracker._IDLE;
                b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                b011_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
                b004_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
                // step 9ea8c;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_INVALID_b005(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b005_INVALID_r3) {
            b001.logError(((java.lang.String) _data));
            b007_ACCELEROMETEREVENT_r6 = false;
            b007_COLOREVENT_r0 = false;
            b007_MAGNETOMETEREVENT_r4 = false;
            b009_LIGHT_r1 = false;
            b009_REMOVETOPIC_r5 = false;
            b009_RECONFIGURESENSOR_r9 = false;
            b007_NFCEVENT_r1 = false;
            b009_ADDTOPIC_r4 = false;
            b007_TEMPERATUREEVENT_r2 = false;
            b007_DUMMYEVENT_r5 = false;
            b012_ERROR_r1 = false;
            b009_STOP_r2 = false;
            b012_RECEIVED_r0 = false;
            b012_READY_r3 = false;
            b007_SENSORSTATEEVENT_r3 = false;
            b009_MESSAGE_r3 = false;
            b009_SPEED_r0 = false;
            b009_UPDATEHANDLER_r7 = false;
            b009_FAILED_r8 = false;
            b009_CHANGEFILTER_r6 = false;
            b012_FAILED_r2 = false;
            b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
            b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
            b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
            b011_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b004_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
            // step 96de0;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_STOP_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_STOP_r2) {
            if(b004_state==No_ntnu_item_its_train_adapter_TrainAdapter.INITIALIZING) {
                // step 29e6c;
                return CONSUME_SIGNAL;
            } else if(b004_state==No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE) {
                b001.stop();
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

    private int handleEvent_NFCEVENT_b007(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b007_NFCEVENT_r1) {
            b009.handleNFCEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading) _data));
            // step fb746;
            return CONSUME_SIGNAL;
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

    private int handleEvent_COLOREVENT_b007(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b007_COLOREVENT_r0) {
            b009.handleColorEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading) _data));
            // step 2b06f;
            return CONSUME_SIGNAL;
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

    private int handleEvent_FAILED_b012(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b012_FAILED_r2) {
            if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl.ACTIVE) {
                b012_FAILED_r2 = false;
                // step 2851d;
                return CONSUME_SIGNAL;
            } else if(b012_state==No_ntnu_item_its_train_adapter_RemoteControl.INITIALIZING) {
                b009.remoteErrorMsg = ((java.lang.String) _data);
                if(b009.runWithoutRemote()) {
                    org.osgi.framework.BundleContext b008_o0 = b008.get();
                    if(b008_o0==null) {
                        java.lang.String b008_o1 = b008.errMsg();
                        b001.logError(b008_o1);
                        b005_MODIFIED_r2 = false;
                        b005_INVALID_r3 = false;
                        b005_REGISTRATION_r0 = false;
                        b005_UNREGISTRATION_r1 = false;
                        b007_ACCELEROMETEREVENT_r6 = false;
                        scheduler.flushEventQueue(sessionID, "ACCELEROMETEREVENT_b007");
                        b007_TEMPERATUREEVENT_r2 = false;
                        scheduler.flushEventQueue(sessionID, "TEMPERATUREEVENT_b007");
                        b007_DUMMYEVENT_r5 = false;
                        scheduler.flushEventQueue(sessionID, "DUMMYEVENT_b007");
                        b012_ERROR_r1 = false;
                        scheduler.flushEventQueue(sessionID, "ERROR_b012");
                        b012_RECEIVED_r0 = false;
                        scheduler.flushEventQueue(sessionID, "RECEIVED_b012");
                        b007_COLOREVENT_r0 = false;
                        scheduler.flushEventQueue(sessionID, "COLOREVENT_b007");
                        b007_MAGNETOMETEREVENT_r4 = false;
                        scheduler.flushEventQueue(sessionID, "MAGNETOMETEREVENT_b007");
                        b012_READY_r3 = false;
                        scheduler.flushEventQueue(sessionID, "READY_b012");
                        b007_SENSORSTATEEVENT_r3 = false;
                        scheduler.flushEventQueue(sessionID, "SENSORSTATEEVENT_b007");
                        b007_NFCEVENT_r1 = false;
                        scheduler.flushEventQueue(sessionID, "NFCEVENT_b007");
                        b012_FAILED_r2 = false;
                        scheduler.flushEventQueue(sessionID, "FAILED_b012");
                        b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b005_state = No_ntnu_item_its_train_adapter_CustomServiceTracker._IDLE;
                        b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b011_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                        b004_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
                        // step 789a5;
                        return CONSUME_SIGNAL;
                    } else {
                        b007.context = b008_o0;
                        b007.init();
                        java.lang.String b004_o0 = b004.getFilter();
                        b005.filter = b004_o0;
                        org.osgi.framework.BundleContext b006_o0 = b006.get();
                        if(b006_o0==null) {
                            java.lang.String b006_o1 = b006.errMsg();
                            b001.logError(b006_o1);
                            b005_MODIFIED_r2 = false;
                            scheduler.flushEventQueue(sessionID, "MODIFIED_b005");
                            b012_ERROR_r1 = false;
                            scheduler.flushEventQueue(sessionID, "ERROR_b012");
                            b012_RECEIVED_r0 = false;
                            scheduler.flushEventQueue(sessionID, "RECEIVED_b012");
                            b012_READY_r3 = false;
                            scheduler.flushEventQueue(sessionID, "READY_b012");
                            b005_INVALID_r3 = false;
                            scheduler.flushEventQueue(sessionID, "INVALID_b005");
                            b005_REGISTRATION_r0 = false;
                            scheduler.flushEventQueue(sessionID, "REGISTRATION_b005");
                            b012_FAILED_r2 = false;
                            scheduler.flushEventQueue(sessionID, "FAILED_b012");
                            b005_UNREGISTRATION_r1 = false;
                            scheduler.flushEventQueue(sessionID, "UNREGISTRATION_b005");
                            b007_ACCELEROMETEREVENT_r6 = true;
                            b007_TEMPERATUREEVENT_r2 = true;
                            b007_DUMMYEVENT_r5 = true;
                            b007_COLOREVENT_r0 = true;
                            b007_MAGNETOMETEREVENT_r4 = true;
                            b007_SENSORSTATEEVENT_r3 = true;
                            b007_NFCEVENT_r1 = true;
                            b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                            b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                            b011_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                            b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                            b004_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
                            b007_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                            // step f1cc6;
                            return CONSUME_SIGNAL;
                        } else {
                            b005.context = b006_o0;
                            b005.startListener(b005.filter);
                            b012_ERROR_r1 = false;
                            scheduler.flushEventQueue(sessionID, "ERROR_b012");
                            b012_RECEIVED_r0 = false;
                            scheduler.flushEventQueue(sessionID, "RECEIVED_b012");
                            b012_READY_r3 = false;
                            scheduler.flushEventQueue(sessionID, "READY_b012");
                            b012_FAILED_r2 = false;
                            scheduler.flushEventQueue(sessionID, "FAILED_b012");
                            b007_ACCELEROMETEREVENT_r6 = true;
                            b005_MODIFIED_r2 = true;
                            b007_TEMPERATUREEVENT_r2 = true;
                            b007_DUMMYEVENT_r5 = true;
                            b007_COLOREVENT_r0 = true;
                            b007_MAGNETOMETEREVENT_r4 = true;
                            b007_SENSORSTATEEVENT_r3 = true;
                            b005_INVALID_r3 = true;
                            b005_REGISTRATION_r0 = true;
                            b007_NFCEVENT_r1 = true;
                            b005_UNREGISTRATION_r1 = true;
                            b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                            b005_state = No_ntnu_item_its_train_adapter_CustomServiceTracker.ACTIVE;
                            b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                            b004_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                            b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                            b007_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                            // step e0975;
                            return CONSUME_SIGNAL;
                        }
                    }
                } else {
                    b001.logError(b009.remoteErrorMsg);
                    b005_MODIFIED_r2 = false;
                    b007_ACCELEROMETEREVENT_r6 = false;
                    b007_TEMPERATUREEVENT_r2 = false;
                    b007_DUMMYEVENT_r5 = false;
                    b007_COLOREVENT_r0 = false;
                    b007_MAGNETOMETEREVENT_r4 = false;
                    b007_SENSORSTATEEVENT_r3 = false;
                    b005_INVALID_r3 = false;
                    b005_REGISTRATION_r0 = false;
                    b007_NFCEVENT_r1 = false;
                    b005_UNREGISTRATION_r1 = false;
                    b009_LIGHT_r1 = false;
                    scheduler.flushEventQueue(sessionID, "LIGHT_b009");
                    b009_REMOVETOPIC_r5 = false;
                    scheduler.flushEventQueue(sessionID, "REMOVETOPIC_b009");
                    b009_RECONFIGURESENSOR_r9 = false;
                    scheduler.flushEventQueue(sessionID, "RECONFIGURESENSOR_b009");
                    b009_ADDTOPIC_r4 = false;
                    scheduler.flushEventQueue(sessionID, "ADDTOPIC_b009");
                    b012_ERROR_r1 = false;
                    scheduler.flushEventQueue(sessionID, "ERROR_b012");
                    b009_STOP_r2 = false;
                    scheduler.flushEventQueue(sessionID, "STOP_b009");
                    b012_RECEIVED_r0 = false;
                    scheduler.flushEventQueue(sessionID, "RECEIVED_b012");
                    b012_READY_r3 = false;
                    scheduler.flushEventQueue(sessionID, "READY_b012");
                    b009_MESSAGE_r3 = false;
                    scheduler.flushEventQueue(sessionID, "MESSAGE_b009");
                    b009_SPEED_r0 = false;
                    scheduler.flushEventQueue(sessionID, "SPEED_b009");
                    b009_UPDATEHANDLER_r7 = false;
                    scheduler.flushEventQueue(sessionID, "UPDATEHANDLER_b009");
                    b009_FAILED_r8 = false;
                    scheduler.flushEventQueue(sessionID, "FAILED_b009");
                    b009_CHANGEFILTER_r6 = false;
                    scheduler.flushEventQueue(sessionID, "CHANGEFILTER_b009");
                    b012_FAILED_r2 = false;
                    scheduler.flushEventQueue(sessionID, "FAILED_b012");
                    b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b005_state = No_ntnu_item_its_train_adapter_CustomServiceTracker._IDLE;
                    b013_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                    b011_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
                    b012_state = No_ntnu_item_its_train_adapter_RemoteControl._IDLE;
                    b004_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
                    // step 74231;
                    return CONSUME_SIGNAL;
                }
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_SENSORSTATEEVENT_b007(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b007_SENSORSTATEEVENT_r3) {
            b009.handleSensorStateEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.SensorStateEvent) _data));
            // step 5e6d4;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_UPDATEHANDLER_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_UPDATEHANDLER_r7) {
            if(b007_state==No_ntnu_item_its_train_adapter_SensorController.ACTIVE) {
                b007.externalUpdate(((no.ntnu.item.its.osgi.common.enums.PublisherType) _data));
                // step c35c6;
                return CONSUME_SIGNAL;
            } else if(b007_state==No_ntnu_item_its_train_adapter_SensorController._IDLE) {
                // step 7001b;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_SPEED_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_SPEED_r0) {
            if(b004_state==No_ntnu_item_its_train_adapter_TrainAdapter.INITIALIZING) {
                // step 1eca8;
                return CONSUME_SIGNAL;
            } else if(b004_state==No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE) {
                int b001_o2 = b001.convertSpeed(((Double)_data).doubleValue());
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

    private int handleEvent_MODIFIED_b005(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b005_MODIFIED_r2) {
            b007.modifiedSensor(((org.osgi.framework.ServiceReference) _data));
            // step 5e524;
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

    private int handleEvent_REGISTRATION_b005(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b005_REGISTRATION_r0) {
            b007.registerSensor(((org.osgi.framework.ServiceReference) _data));
            // step 94afd;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_LIGHT_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_LIGHT_r1) {
            if(b004_state==No_ntnu_item_its_train_adapter_TrainAdapter.INITIALIZING) {
                // step f5863;
                return CONSUME_SIGNAL;
            } else if(b004_state==No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE) {
                // step f25b5;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_CHANGEFILTER_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_CHANGEFILTER_r6) {
            if(b005_state==No_ntnu_item_its_train_adapter_CustomServiceTracker._IDLE) {
                // step d4776;
                return CONSUME_SIGNAL;
            } else if(b005_state==No_ntnu_item_its_train_adapter_CustomServiceTracker.ACTIVE) {
                b005.startListener(((java.lang.String) _data));
                // step d04e7;
                return CONSUME_SIGNAL;
            } else {
                return DISCARD_SIGNAL;
            }
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

    public java.lang.String getPartName() {
        return null;
    }
}
