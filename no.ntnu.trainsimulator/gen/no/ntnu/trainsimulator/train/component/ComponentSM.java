package no.ntnu.trainsimulator.train.component;

import no.ntnu.item.its.train.adapter.trainadapter.TrainAdapter;

public class ComponentSM extends no.ntnu.item.arctis.runtime.IStateMachine {


    private no.ntnu.trainsimulator.train.component.Component b000;
    private no.ntnu.item.its.train.adapter.trainadapter.TrainAdapter b001;
    private no.ntnu.item.its.train.adapter.customeservicelistener.CustomeServiceListener b002;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b003;
    private no.ntnu.item.its.train.adapter.sensorcontroller.SensorController b004;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b005;
    private no.ntnu.item.its.train.adapter.contextchecker.ContextChecker b006;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b007;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b008;
    private boolean b004_SENSORSTATEEVENT_r3;
    private boolean b004_TEMPERATUREEVENT_r2;
    private boolean b004_ACCELEROMETEREVENT_r6;
    private boolean b006_LIGHT_r1;
    private boolean b004_NFCEVENT_r1;
    private boolean b002_UNREGISTRATION_r1;
    private boolean b006_SPEED_r0;
    private boolean b004_MAGNETOMETEREVENT_r4;
    private boolean b006_STOP_r2;
    private boolean b002_MODIFIED_r2;
    private boolean b002_REGISTRATION_r0;
    private boolean b004_DUMMYEVENT_r5;
    private boolean b004_COLOREVENT_r0;
    private enum No_ntnu_item_its_train_adapter_TrainAdapter {ACTIVE, _IDLE};
    private enum No_ntnu_item_its_train_adapter_CustomeServiceListener {ACTIVE, _IDLE};
    private enum Com_bitreactive_library_osgi_GetBundleContext {_IDLE};
    private enum No_ntnu_item_its_train_adapter_SensorController {ACTIVE, _IDLE};
    private enum No_ntnu_item_its_train_adapter_ContextChecker {ACTIVE, _IDLE};
    private No_ntnu_item_its_train_adapter_TrainAdapter b001_state;
    private No_ntnu_item_its_train_adapter_CustomeServiceListener b002_state;
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
        b000 = new no.ntnu.trainsimulator.train.component.Component();
        b000.setBlockID("b000", sessionID);
        b000.setRuntime(scheduler.getRuntime());
        b001 = new TrainAdapter();
        b001.setBlockID("b001", sessionID);
        b001.setRuntime(scheduler.getRuntime());
        b002 = new no.ntnu.item.its.train.adapter.customeservicelistener.CustomeServiceListener();
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
        b002_state = No_ntnu_item_its_train_adapter_CustomeServiceListener._IDLE;
        b003_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b004_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
        b005_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b006_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
        b007_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        java.lang.String b000_o3 = b000.getId();
        b001.filter = b000_o3;
        org.osgi.framework.BundleContext b008_o0 = b008.get();
        if(b008_o0==null) {
            java.lang.String b008_o1 = b008.errMsg();
            b000.logError(b008_o1);
            // step 59f15;
            return TERMINATE_MACHINE;
        } else {
            b001.context = b008_o0;
            int b001_o1 = b001.getTrainID();
            b002.filter = b001.filter;
            org.osgi.framework.BundleContext b003_o0 = b003.get();
            if(b003_o0==null) {
                java.lang.String b003_o1 = b003.errMsg();
                org.osgi.framework.BundleContext b007_o0 = b007.get();
                if(b007_o0==null) {
                    java.lang.String b007_o1 = b007.errMsg();
                    // step b7827;
                    return TERMINATE_MACHINE;
                } else {
                    b006.context = b007_o0;
                    b006.init();
                    // step f6516;
                    return TERMINATE_MACHINE;
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
                        // step d2ee0;
                        return TERMINATE_MACHINE;
                    } else {
                        b004.context = b005_o0;
                        b004.init();
                        b004_TEMPERATUREEVENT_r2 = true;
                        b004_SENSORSTATEEVENT_r3 = true;
                        b004_ACCELEROMETEREVENT_r6 = true;
                        b004_MAGNETOMETEREVENT_r4 = true;
                        b002_MODIFIED_r2 = true;
                        b002_REGISTRATION_r0 = true;
                        b004_NFCEVENT_r1 = true;
                        b004_DUMMYEVENT_r5 = true;
                        b002_UNREGISTRATION_r1 = true;
                        b004_COLOREVENT_r0 = true;
                        b004_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                        b006_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b001_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                        b002_state = No_ntnu_item_its_train_adapter_CustomeServiceListener.ACTIVE;
                        // step 031ca;
                        return CONSUME_SIGNAL;
                    }
                } else {
                    b006.context = b007_o0;
                    b006.init();
                    org.osgi.framework.BundleContext b005_o0 = b005.get();
                    if(b005_o0==null) {
                        java.lang.String b005_o1 = b005.errMsg();
                        // step daa4b;
                        return TERMINATE_MACHINE;
                    } else {
                        b004.context = b005_o0;
                        b004.init();
                        b004_TEMPERATUREEVENT_r2 = true;
                        b004_SENSORSTATEEVENT_r3 = true;
                        b004_ACCELEROMETEREVENT_r6 = true;
                        b006_LIGHT_r1 = true;
                        b004_NFCEVENT_r1 = true;
                        b002_UNREGISTRATION_r1 = true;
                        b006_SPEED_r0 = true;
                        b004_MAGNETOMETEREVENT_r4 = true;
                        b006_STOP_r2 = true;
                        b002_MODIFIED_r2 = true;
                        b002_REGISTRATION_r0 = true;
                        b004_DUMMYEVENT_r5 = true;
                        b004_COLOREVENT_r0 = true;
                        b004_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                        b006_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b001_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                        b002_state = No_ntnu_item_its_train_adapter_CustomeServiceListener.ACTIVE;
                        // step b0ae4;
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
        if(_signalID.equals("SPEED_b006")) {
            return handleEvent_SPEED_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("COLOREVENT_b004")) {
            return handleEvent_COLOREVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MODIFIED_b002")) {
            return handleEvent_MODIFIED_b002(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("DUMMYEVENT_b004")) {
            return handleEvent_DUMMYEVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("ACCELEROMETEREVENT_b004")) {
            return handleEvent_ACCELEROMETEREVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("NFCEVENT_b004")) {
            return handleEvent_NFCEVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MAGNETOMETEREVENT_b004")) {
            return handleEvent_MAGNETOMETEREVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("SENSORSTATEEVENT_b004")) {
            return handleEvent_SENSORSTATEEVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("UNREGISTRATION_b002")) {
            return handleEvent_UNREGISTRATION_b002(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("STOP_b006")) {
            return handleEvent_STOP_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("LIGHT_b006")) {
            return handleEvent_LIGHT_b006(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("TEMPERATUREEVENT_b004")) {
            return handleEvent_TEMPERATUREEVENT_b004(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("REGISTRATION_b002")) {
            return handleEvent_REGISTRATION_b002(_sender, receiverSessionID, _data);
        }
        return TRIGGER_UNKNOWN;
    }

    private int handleEvent_SPEED_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_SPEED_r0) {
            b000.logSpeed();
            // step 75dd0;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_COLOREVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_COLOREVENT_r0) {
            b006.handleColorEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading) _data));
            // step 34d22;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_MODIFIED_b002(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b002_MODIFIED_r2) {
            b004.modifiedSensor(((org.osgi.framework.ServiceEvent) _data));
            // step 97265;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_DUMMYEVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_DUMMYEVENT_r5) {
            b006.handleDummyEvent();
            // step 4c853;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_ACCELEROMETEREVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_ACCELEROMETEREVENT_r6) {
            b006.handleAccelerometerEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading) _data));
            // step 69106;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_NFCEVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_NFCEVENT_r1) {
            b006.handleNFCEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading) _data));
            // step 941db;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_MAGNETOMETEREVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_MAGNETOMETEREVENT_r4) {
            b006.handleMagnetometerEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading) _data));
            // step 36269;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_SENSORSTATEEVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_SENSORSTATEEVENT_r3) {
            b006.handleSensorStateEvent(((org.osgi.framework.ServiceEvent) _data));
            // step 5a3a9;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_UNREGISTRATION_b002(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b002_UNREGISTRATION_r1) {
            b004.unregisterSensor(((org.osgi.framework.ServiceEvent) _data));
            // step 79eda;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_STOP_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_STOP_r2) {
            b000.logStopp();
            // step 958a7;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_LIGHT_b006(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b006_LIGHT_r1) {
            // step 0af1d;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_TEMPERATUREEVENT_b004(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b004_TEMPERATUREEVENT_r2) {
            b006.handleTemperatureEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading) _data));
            // step 71528;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_REGISTRATION_b002(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b002_REGISTRATION_r0) {
            b004.registerSensor(((org.osgi.framework.ServiceEvent) _data));
            // step 733ab;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    public java.lang.String getPartName() {
        return null;
    }
}
