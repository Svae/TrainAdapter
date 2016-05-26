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
    private boolean b006_STOP_r2;
    private boolean b002_MODIFIED_r2;
    private boolean b004_MAGNETOMETEREVENT_r4;
    private boolean b004_TEMPERATUREEVENT_r2;
    private boolean b004_NFCEVENT_r1;
    private boolean b006_COLOR_r3;
    private boolean b006_SPEED_r0;
    private boolean b004_COLOREVENT_r0;
    private boolean b006_LIGHT_r1;
    private boolean b004_DUMMYEVENT_r5;
    private boolean b002_UNREGISTRATION_r1;
    private boolean b004_ACCELEROMETEREVENT_r6;
    private boolean b002_INVALID_r3;
    private boolean b004_SENSORSTATEEVENT_r3;
    private boolean b002_REGISTRATION_r0;
    private enum No_ntnu_item_its_train_adapter_TrainAdapter {_IDLE, ACTIVE};
    private enum No_ntnu_item_its_train_adapter_CustomeServiceTracker {_IDLE, ACTIVE};
    private enum Com_bitreactive_library_osgi_GetBundleContext {_IDLE};
    private enum No_ntnu_item_its_train_adapter_SensorController {ACTIVE, _IDLE};
    private enum No_ntnu_item_its_train_adapter_ContextChecker {_IDLE, ACTIVE};
    private No_ntnu_item_its_train_adapter_TrainAdapter b001_state;
    private No_ntnu_item_its_train_adapter_CustomeServiceTracker b002_state;
    private Com_bitreactive_library_osgi_GetBundleContext b003_state;
    private No_ntnu_item_its_train_adapter_SensorController b004_state;
    private Com_bitreactive_library_osgi_GetBundleContext b005_state;
    private No_ntnu_item_its_train_adapter_ContextChecker b006_state;
    private Com_bitreactive_library_osgi_GetBundleContext b007_state;
    private Com_bitreactive_library_osgi_GetBundleContext b008_state;
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
        b001_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
        b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
        b003_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b004_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
        b005_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b006_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
        b007_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        java.lang.String b000_o0 = b000.getString();
        b001.filter = b000_o0;
        org.osgi.framework.BundleContext b008_o0 = b008.get();
        if(b008_o0==null) {
            java.lang.String b008_o1 = b008.errMsg();
            b006_STOP_r2 = false;
            b002_MODIFIED_r2 = false;
            b004_MAGNETOMETEREVENT_r4 = false;
            b004_TEMPERATUREEVENT_r2 = false;
            b006_COLOR_r3 = false;
            b004_NFCEVENT_r1 = false;
            b006_LIGHT_r1 = false;
            b006_SPEED_r0 = false;
            b004_COLOREVENT_r0 = false;
            b002_UNREGISTRATION_r1 = false;
            b004_DUMMYEVENT_r5 = false;
            b004_ACCELEROMETEREVENT_r6 = false;
            b002_INVALID_r3 = false;
            b004_SENSORSTATEEVENT_r3 = false;
            b002_REGISTRATION_r0 = false;
            b003_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b006_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
            b007_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            b004_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
            b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker._IDLE;
            b005_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
            // step 9aa0b;
            return CONSUME_SIGNAL;
        } else {
            b001.context = b008_o0;
            int b001_o1 = b001.getTrainID();
            java.lang.String b001_o0 = b001.getFilter();
            b002.filter = b001_o0;
            org.osgi.framework.BundleContext b003_o0 = b003.get();
            if(b003_o0==null) {
                java.lang.String b003_o1 = b003.errMsg();
                org.osgi.framework.BundleContext b007_o0 = b007.get();
                if(b007_o0==null) {
                    java.lang.String b007_o1 = b007.errMsg();
                    b004_COLOREVENT_r0 = false;
                    b004_DUMMYEVENT_r5 = false;
                    b004_ACCELEROMETEREVENT_r6 = false;
                    b004_MAGNETOMETEREVENT_r4 = false;
                    b004_TEMPERATUREEVENT_r2 = false;
                    b004_SENSORSTATEEVENT_r3 = false;
                    b004_NFCEVENT_r1 = false;
                    b002_UNREGISTRATION_r1 = false;
                    scheduler.flushEventQueue(sessionID, "UNREGISTRATION_b002");
                    b002_MODIFIED_r2 = false;
                    scheduler.flushEventQueue(sessionID, "MODIFIED_b002");
                    b002_INVALID_r3 = false;
                    scheduler.flushEventQueue(sessionID, "INVALID_b002");
                    b002_REGISTRATION_r0 = false;
                    scheduler.flushEventQueue(sessionID, "REGISTRATION_b002");
                    b004_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                    b005_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b006_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                    // step 2f749;
                    return CONSUME_SIGNAL;
                } else {
                    b006.context = b007_o0;
                    b006.init();
                    b004_COLOREVENT_r0 = false;
                    b004_DUMMYEVENT_r5 = false;
                    b004_ACCELEROMETEREVENT_r6 = false;
                    b004_MAGNETOMETEREVENT_r4 = false;
                    b004_TEMPERATUREEVENT_r2 = false;
                    b004_SENSORSTATEEVENT_r3 = false;
                    b004_NFCEVENT_r1 = false;
                    b002_UNREGISTRATION_r1 = false;
                    scheduler.flushEventQueue(sessionID, "UNREGISTRATION_b002");
                    b002_MODIFIED_r2 = false;
                    scheduler.flushEventQueue(sessionID, "MODIFIED_b002");
                    b002_INVALID_r3 = false;
                    scheduler.flushEventQueue(sessionID, "INVALID_b002");
                    b002_REGISTRATION_r0 = false;
                    scheduler.flushEventQueue(sessionID, "REGISTRATION_b002");
                    b006_STOP_r2 = true;
                    b006_LIGHT_r1 = true;
                    b006_SPEED_r0 = true;
                    b006_COLOR_r3 = true;
                    b004_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                    b005_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                    b006_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                    // step 105d0;
                    return CONSUME_SIGNAL;
                }
            } else {
                b002.context = b003_o0;
                b002.startListener(b002.filter);
                org.osgi.framework.BundleContext b007_o0 = b007.get();
                if(b007_o0==null) {
                    java.lang.String b007_o1 = b007.errMsg();
                    org.osgi.framework.BundleContext b005_o0 = b005.get();
                    if(b005_o0==null) {
                        java.lang.String b005_o1 = b005.errMsg();
                        b004_COLOREVENT_r0 = false;
                        scheduler.flushEventQueue(sessionID, "COLOREVENT_b004");
                        b004_DUMMYEVENT_r5 = false;
                        scheduler.flushEventQueue(sessionID, "DUMMYEVENT_b004");
                        b004_ACCELEROMETEREVENT_r6 = false;
                        scheduler.flushEventQueue(sessionID, "ACCELEROMETEREVENT_b004");
                        b004_MAGNETOMETEREVENT_r4 = false;
                        scheduler.flushEventQueue(sessionID, "MAGNETOMETEREVENT_b004");
                        b004_TEMPERATUREEVENT_r2 = false;
                        scheduler.flushEventQueue(sessionID, "TEMPERATUREEVENT_b004");
                        b004_SENSORSTATEEVENT_r3 = false;
                        scheduler.flushEventQueue(sessionID, "SENSORSTATEEVENT_b004");
                        b004_NFCEVENT_r1 = false;
                        scheduler.flushEventQueue(sessionID, "NFCEVENT_b004");
                        b002_UNREGISTRATION_r1 = true;
                        b002_MODIFIED_r2 = true;
                        b002_INVALID_r3 = true;
                        b002_REGISTRATION_r0 = true;
                        b006_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker.ACTIVE;
                        // step 633ee;
                        return CONSUME_SIGNAL;
                    } else {
                        b004.context = b005_o0;
                        b004.init();
                        b004_COLOREVENT_r0 = true;
                        b002_UNREGISTRATION_r1 = true;
                        b004_DUMMYEVENT_r5 = true;
                        b004_ACCELEROMETEREVENT_r6 = true;
                        b002_MODIFIED_r2 = true;
                        b004_MAGNETOMETEREVENT_r4 = true;
                        b004_TEMPERATUREEVENT_r2 = true;
                        b002_INVALID_r3 = true;
                        b004_SENSORSTATEEVENT_r3 = true;
                        b004_NFCEVENT_r1 = true;
                        b002_REGISTRATION_r0 = true;
                        b006_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b004_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                        b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker.ACTIVE;
                        b001_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                        // step cb0a6;
                        return CONSUME_SIGNAL;
                    }
                } else {
                    b006.context = b007_o0;
                    b006.init();
                    org.osgi.framework.BundleContext b005_o0 = b005.get();
                    if(b005_o0==null) {
                        java.lang.String b005_o1 = b005.errMsg();
                        b004_COLOREVENT_r0 = false;
                        scheduler.flushEventQueue(sessionID, "COLOREVENT_b004");
                        b004_DUMMYEVENT_r5 = false;
                        scheduler.flushEventQueue(sessionID, "DUMMYEVENT_b004");
                        b004_ACCELEROMETEREVENT_r6 = false;
                        scheduler.flushEventQueue(sessionID, "ACCELEROMETEREVENT_b004");
                        b004_MAGNETOMETEREVENT_r4 = false;
                        scheduler.flushEventQueue(sessionID, "MAGNETOMETEREVENT_b004");
                        b004_TEMPERATUREEVENT_r2 = false;
                        scheduler.flushEventQueue(sessionID, "TEMPERATUREEVENT_b004");
                        b004_SENSORSTATEEVENT_r3 = false;
                        scheduler.flushEventQueue(sessionID, "SENSORSTATEEVENT_b004");
                        b004_NFCEVENT_r1 = false;
                        scheduler.flushEventQueue(sessionID, "NFCEVENT_b004");
                        b006_STOP_r2 = true;
                        b006_LIGHT_r1 = true;
                        b006_SPEED_r0 = true;
                        b002_UNREGISTRATION_r1 = true;
                        b002_MODIFIED_r2 = true;
                        b002_INVALID_r3 = true;
                        b006_COLOR_r3 = true;
                        b002_REGISTRATION_r0 = true;
                        b006_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker.ACTIVE;
                        // step 1544a;
                        return CONSUME_SIGNAL;
                    } else {
                        b004.context = b005_o0;
                        b004.init();
                        b006_STOP_r2 = true;
                        b002_MODIFIED_r2 = true;
                        b004_MAGNETOMETEREVENT_r4 = true;
                        b004_TEMPERATUREEVENT_r2 = true;
                        b006_COLOR_r3 = true;
                        b004_NFCEVENT_r1 = true;
                        b006_LIGHT_r1 = true;
                        b004_COLOREVENT_r0 = true;
                        b006_SPEED_r0 = true;
                        b002_UNREGISTRATION_r1 = true;
                        b004_DUMMYEVENT_r5 = true;
                        b004_ACCELEROMETEREVENT_r6 = true;
                        b002_INVALID_r3 = true;
                        b004_SENSORSTATEEVENT_r3 = true;
                        b002_REGISTRATION_r0 = true;
                        b006_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b004_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                        b002_state = No_ntnu_item_its_train_adapter_CustomeServiceTracker.ACTIVE;
                        b001_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                        // step 5e9d8;
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
        if(_signalID.equals("INVALID_b002")) {
            return handleEvent_INVALID_b002(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("STOP_b006")) {
            return handleEvent_STOP_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("REGISTRATION_b002")) {
            return handleEvent_REGISTRATION_b002(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("DUMMYEVENT_b004")) {
            return handleEvent_DUMMYEVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("ACCELEROMETEREVENT_b004")) {
            return handleEvent_ACCELEROMETEREVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("UNREGISTRATION_b002")) {
            return handleEvent_UNREGISTRATION_b002(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("SPEED_b006")) {
            return handleEvent_SPEED_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MAGNETOMETEREVENT_b004")) {
            return handleEvent_MAGNETOMETEREVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("NFCEVENT_b004")) {
            return handleEvent_NFCEVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("SENSORSTATEEVENT_b004")) {
            return handleEvent_SENSORSTATEEVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("TEMPERATUREEVENT_b004")) {
            return handleEvent_TEMPERATUREEVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("COLOR_b006")) {
            return handleEvent_COLOR_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("COLOREVENT_b004")) {
            return handleEvent_COLOREVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("LIGHT_b006")) {
            return handleEvent_LIGHT_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MODIFIED_b002")) {
            return handleEvent_MODIFIED_b002(_sender, receiverSessionID, _data);
        }
        return TRIGGER_UNKNOWN;
    }

    private int handleEvent_INVALID_b002(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b002_INVALID_r3) {
            // step 3db10;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_STOP_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_STOP_r2) {
            // step c4d10;
            return CONSUME_SIGNAL;
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

    private int handleEvent_ACCELEROMETEREVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_ACCELEROMETEREVENT_r6) {
            b006.handleAccelerometerEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading) _data));
            // step a6d2d;
            return CONSUME_SIGNAL;
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

    private int handleEvent_SPEED_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_SPEED_r0) {
            b000.logSpeed(((Double)_data).doubleValue());
            // step 859e3;
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

    private int handleEvent_NFCEVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_NFCEVENT_r1) {
            b006.handleNFCEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading) _data));
            // step 2e707;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_SENSORSTATEEVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_SENSORSTATEEVENT_r3) {
            b006.handleSensorStateEvent(((org.osgi.framework.ServiceEvent) _data));
            // step 418ac;
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

    private int handleEvent_COLOR_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_COLOR_r3) {
            // step 9a036;
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

    private int handleEvent_LIGHT_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_LIGHT_r1) {
            // step 4e5fd;
            return CONSUME_SIGNAL;
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

    public java.lang.String getPartName() {
        return null;
    }
}
