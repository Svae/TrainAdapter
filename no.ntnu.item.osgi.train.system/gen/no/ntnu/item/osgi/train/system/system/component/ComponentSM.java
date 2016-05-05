package no.ntnu.item.osgi.train.system.system.component;

public class ComponentSM extends no.ntnu.item.arctis.runtime.IStateMachine {


    private no.ntnu.item.osgi.train.system.train.Train b001;
    private no.ntnu.item.osgi.train.system.motorcontroller.MotorController b002;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b003;
    private no.ntnu.item.its.train.adapter.trainadapter.TrainAdapter b004;
    private no.ntnu.item.its.train.adapter.customeservicelistener.CustomeServiceListener b005;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b006;
    private no.ntnu.item.its.train.adapter.sensorcontroller.SensorController b007;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b008;
    private no.ntnu.item.its.train.adapter.contextchecker.ContextChecker b009;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b010;
    private com.bitreactive.library.osgi.getbundlecontext.GetBundleContext b011;
    private boolean b007_DUMMYEVENT_r5;
    private boolean b007_ACCELEROMETEREVENT_r6;
    private boolean b007_NFCEVENT_r1;
    private boolean b009_STOP_r2;
    private boolean b009_LIGHT_r1;
    private boolean b007_TEMPERATUREEVENT_r2;
    private boolean b009_COLOR_r3;
    private boolean b005_REGISTRATION_r0;
    private boolean b009_SPEED_r0;
    private boolean b007_COLOREVENT_r0;
    private boolean b005_UNREGISTRATION_r1;
    private boolean b007_SENSORSTATEEVENT_r3;
    private boolean b005_MODIFIED_r2;
    private boolean b007_MAGNETOMETEREVENT_r4;
    private enum No_ntnu_item_osgi_train_system_Train {ACTIVE, _IDLE};
    private enum No_ntnu_item_osgi_train_system_MotorController {ACTIVE, _IDLE};
    private enum Com_bitreactive_library_osgi_GetBundleContext {_IDLE};
    private enum No_ntnu_item_its_train_adapter_TrainAdapter {ACTIVE, _IDLE};
    private enum No_ntnu_item_its_train_adapter_CustomeServiceListener {ACTIVE, _IDLE};
    private enum No_ntnu_item_its_train_adapter_SensorController {_IDLE, ACTIVE};
    private enum No_ntnu_item_its_train_adapter_ContextChecker {_IDLE, ACTIVE};
    private No_ntnu_item_osgi_train_system_Train b001_state;
    private No_ntnu_item_osgi_train_system_MotorController b002_state;
    private Com_bitreactive_library_osgi_GetBundleContext b003_state;
    private No_ntnu_item_its_train_adapter_TrainAdapter b004_state;
    private No_ntnu_item_its_train_adapter_CustomeServiceListener b005_state;
    private Com_bitreactive_library_osgi_GetBundleContext b006_state;
    private No_ntnu_item_its_train_adapter_SensorController b007_state;
    private Com_bitreactive_library_osgi_GetBundleContext b008_state;
    private No_ntnu_item_its_train_adapter_ContextChecker b009_state;
    private Com_bitreactive_library_osgi_GetBundleContext b010_state;
    private Com_bitreactive_library_osgi_GetBundleContext b011_state;
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
        b005 = new no.ntnu.item.its.train.adapter.customeservicelistener.CustomeServiceListener();
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
        b001_state = No_ntnu_item_osgi_train_system_Train._IDLE;
        b002_state = No_ntnu_item_osgi_train_system_MotorController._IDLE;
        b003_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b004_state = No_ntnu_item_its_train_adapter_TrainAdapter._IDLE;
        b005_state = No_ntnu_item_its_train_adapter_CustomeServiceListener._IDLE;
        b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
        b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        b011_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
        java.lang.String b001_o0 = b001.getSensorFilter();
        b004.filter = b001_o0;
        org.osgi.framework.BundleContext b011_o0 = b011.get();
        if(b011_o0==null) {
            java.lang.String b011_o1 = b011.errMsg();
            org.osgi.framework.BundleContext b003_o0 = b003.get();
            if(b003_o0==null) {
                java.lang.String b003_o1 = b003.errMsg();
                b007_DUMMYEVENT_r5 = false;
                b007_ACCELEROMETEREVENT_r6 = false;
                b007_NFCEVENT_r1 = false;
                b009_STOP_r2 = false;
                b009_LIGHT_r1 = false;
                b007_TEMPERATUREEVENT_r2 = false;
                b009_COLOR_r3 = false;
                b005_REGISTRATION_r0 = false;
                b009_SPEED_r0 = false;
                b005_UNREGISTRATION_r1 = false;
                b007_COLOREVENT_r0 = false;
                b007_SENSORSTATEEVENT_r3 = false;
                b005_MODIFIED_r2 = false;
                b007_MAGNETOMETEREVENT_r4 = false;
                b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
                b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                b005_state = No_ntnu_item_its_train_adapter_CustomeServiceListener._IDLE;
                b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                // step 06496;
                return CONSUME_SIGNAL;
            } else {
                b002.context = b003_o0;
                b002.init();
                b007_DUMMYEVENT_r5 = false;
                b007_ACCELEROMETEREVENT_r6 = false;
                b007_NFCEVENT_r1 = false;
                b009_STOP_r2 = false;
                b009_LIGHT_r1 = false;
                b007_TEMPERATUREEVENT_r2 = false;
                b009_COLOR_r3 = false;
                b005_REGISTRATION_r0 = false;
                b009_SPEED_r0 = false;
                b005_UNREGISTRATION_r1 = false;
                b007_COLOREVENT_r0 = false;
                b007_SENSORSTATEEVENT_r3 = false;
                b005_MODIFIED_r2 = false;
                b007_MAGNETOMETEREVENT_r4 = false;
                b009_state = No_ntnu_item_its_train_adapter_ContextChecker._IDLE;
                b010_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b006_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                b005_state = No_ntnu_item_its_train_adapter_CustomeServiceListener._IDLE;
                b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                // step 3dbb3;
                return CONSUME_SIGNAL;
            }
        } else {
            b004.context = b011_o0;
            int b004_o1 = b004.getTrainID();
            java.lang.String b004_o0 = b004.getFilter();
            b005.filter = b004_o0;
            org.osgi.framework.BundleContext b006_o0 = b006.get();
            if(b006_o0==null) {
                java.lang.String b006_o1 = b006.errMsg();
                org.osgi.framework.BundleContext b003_o0 = b003.get();
                if(b003_o0==null) {
                    java.lang.String b003_o1 = b003.errMsg();
                    org.osgi.framework.BundleContext b010_o0 = b010.get();
                    if(b010_o0==null) {
                        java.lang.String b010_o1 = b010.errMsg();
                        b007_DUMMYEVENT_r5 = false;
                        b007_ACCELEROMETEREVENT_r6 = false;
                        b007_NFCEVENT_r1 = false;
                        b007_COLOREVENT_r0 = false;
                        b007_SENSORSTATEEVENT_r3 = false;
                        b007_TEMPERATUREEVENT_r2 = false;
                        b007_MAGNETOMETEREVENT_r4 = false;
                        b005_REGISTRATION_r0 = false;
                        scheduler.flushEventQueue(sessionID, "REGISTRATION_b005");
                        b005_UNREGISTRATION_r1 = false;
                        scheduler.flushEventQueue(sessionID, "UNREGISTRATION_b005");
                        b005_MODIFIED_r2 = false;
                        scheduler.flushEventQueue(sessionID, "MODIFIED_b005");
                        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                        b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        // step fa0a6;
                        return CONSUME_SIGNAL;
                    } else {
                        b009.context = b010_o0;
                        b009.init();
                        b007_DUMMYEVENT_r5 = false;
                        b007_ACCELEROMETEREVENT_r6 = false;
                        b007_NFCEVENT_r1 = false;
                        b007_COLOREVENT_r0 = false;
                        b007_SENSORSTATEEVENT_r3 = false;
                        b007_TEMPERATUREEVENT_r2 = false;
                        b007_MAGNETOMETEREVENT_r4 = false;
                        b005_REGISTRATION_r0 = false;
                        scheduler.flushEventQueue(sessionID, "REGISTRATION_b005");
                        b005_UNREGISTRATION_r1 = false;
                        scheduler.flushEventQueue(sessionID, "UNREGISTRATION_b005");
                        b005_MODIFIED_r2 = false;
                        scheduler.flushEventQueue(sessionID, "MODIFIED_b005");
                        b009_COLOR_r3 = true;
                        b009_SPEED_r0 = true;
                        b009_STOP_r2 = true;
                        b009_LIGHT_r1 = true;
                        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                        b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        // step d0d2e;
                        return CONSUME_SIGNAL;
                    }
                } else {
                    b002.context = b003_o0;
                    b002.init();
                    org.osgi.framework.BundleContext b010_o0 = b010.get();
                    if(b010_o0==null) {
                        java.lang.String b010_o1 = b010.errMsg();
                        b007_DUMMYEVENT_r5 = false;
                        b007_ACCELEROMETEREVENT_r6 = false;
                        b007_NFCEVENT_r1 = false;
                        b007_COLOREVENT_r0 = false;
                        b007_SENSORSTATEEVENT_r3 = false;
                        b007_TEMPERATUREEVENT_r2 = false;
                        b007_MAGNETOMETEREVENT_r4 = false;
                        b005_REGISTRATION_r0 = false;
                        scheduler.flushEventQueue(sessionID, "REGISTRATION_b005");
                        b005_UNREGISTRATION_r1 = false;
                        scheduler.flushEventQueue(sessionID, "UNREGISTRATION_b005");
                        b005_MODIFIED_r2 = false;
                        scheduler.flushEventQueue(sessionID, "MODIFIED_b005");
                        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                        b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                        // step acd26;
                        return CONSUME_SIGNAL;
                    } else {
                        b009.context = b010_o0;
                        b009.init();
                        b007_DUMMYEVENT_r5 = false;
                        b007_ACCELEROMETEREVENT_r6 = false;
                        b007_NFCEVENT_r1 = false;
                        b007_COLOREVENT_r0 = false;
                        b007_SENSORSTATEEVENT_r3 = false;
                        b007_TEMPERATUREEVENT_r2 = false;
                        b007_MAGNETOMETEREVENT_r4 = false;
                        b005_REGISTRATION_r0 = false;
                        scheduler.flushEventQueue(sessionID, "REGISTRATION_b005");
                        b005_UNREGISTRATION_r1 = false;
                        scheduler.flushEventQueue(sessionID, "UNREGISTRATION_b005");
                        b005_MODIFIED_r2 = false;
                        scheduler.flushEventQueue(sessionID, "MODIFIED_b005");
                        b009_COLOR_r3 = true;
                        b009_SPEED_r0 = true;
                        b009_STOP_r2 = true;
                        b009_LIGHT_r1 = true;
                        b008_state = Com_bitreactive_library_osgi_GetBundleContext._IDLE;
                        b007_state = No_ntnu_item_its_train_adapter_SensorController._IDLE;
                        b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                        b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                        b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                        // step a91c0;
                        return CONSUME_SIGNAL;
                    }
                }
            } else {
                b005.context = b006_o0;
                b005.startListener(b005.filter);
                org.osgi.framework.BundleContext b003_o0 = b003.get();
                if(b003_o0==null) {
                    java.lang.String b003_o1 = b003.errMsg();
                    org.osgi.framework.BundleContext b010_o0 = b010.get();
                    if(b010_o0==null) {
                        java.lang.String b010_o1 = b010.errMsg();
                        org.osgi.framework.BundleContext b008_o0 = b008.get();
                        if(b008_o0==null) {
                            java.lang.String b008_o1 = b008.errMsg();
                            b007_DUMMYEVENT_r5 = false;
                            scheduler.flushEventQueue(sessionID, "DUMMYEVENT_b007");
                            b007_ACCELEROMETEREVENT_r6 = false;
                            scheduler.flushEventQueue(sessionID, "ACCELEROMETEREVENT_b007");
                            b007_NFCEVENT_r1 = false;
                            scheduler.flushEventQueue(sessionID, "NFCEVENT_b007");
                            b007_COLOREVENT_r0 = false;
                            scheduler.flushEventQueue(sessionID, "COLOREVENT_b007");
                            b007_SENSORSTATEEVENT_r3 = false;
                            scheduler.flushEventQueue(sessionID, "SENSORSTATEEVENT_b007");
                            b007_TEMPERATUREEVENT_r2 = false;
                            scheduler.flushEventQueue(sessionID, "TEMPERATUREEVENT_b007");
                            b007_MAGNETOMETEREVENT_r4 = false;
                            scheduler.flushEventQueue(sessionID, "MAGNETOMETEREVENT_b007");
                            b005_REGISTRATION_r0 = true;
                            b005_UNREGISTRATION_r1 = true;
                            b005_MODIFIED_r2 = true;
                            b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                            b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                            b005_state = No_ntnu_item_its_train_adapter_CustomeServiceListener.ACTIVE;
                            // step 28c9f;
                            return CONSUME_SIGNAL;
                        } else {
                            b007.context = b008_o0;
                            b007.init();
                            b007_DUMMYEVENT_r5 = true;
                            b005_REGISTRATION_r0 = true;
                            b007_ACCELEROMETEREVENT_r6 = true;
                            b007_NFCEVENT_r1 = true;
                            b007_COLOREVENT_r0 = true;
                            b005_UNREGISTRATION_r1 = true;
                            b007_SENSORSTATEEVENT_r3 = true;
                            b005_MODIFIED_r2 = true;
                            b007_TEMPERATUREEVENT_r2 = true;
                            b007_MAGNETOMETEREVENT_r4 = true;
                            b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                            b004_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                            b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                            b007_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                            b005_state = No_ntnu_item_its_train_adapter_CustomeServiceListener.ACTIVE;
                            // step 07430;
                            return CONSUME_SIGNAL;
                        }
                    } else {
                        b009.context = b010_o0;
                        b009.init();
                        org.osgi.framework.BundleContext b008_o0 = b008.get();
                        if(b008_o0==null) {
                            java.lang.String b008_o1 = b008.errMsg();
                            b007_DUMMYEVENT_r5 = false;
                            scheduler.flushEventQueue(sessionID, "DUMMYEVENT_b007");
                            b007_ACCELEROMETEREVENT_r6 = false;
                            scheduler.flushEventQueue(sessionID, "ACCELEROMETEREVENT_b007");
                            b007_NFCEVENT_r1 = false;
                            scheduler.flushEventQueue(sessionID, "NFCEVENT_b007");
                            b007_COLOREVENT_r0 = false;
                            scheduler.flushEventQueue(sessionID, "COLOREVENT_b007");
                            b007_SENSORSTATEEVENT_r3 = false;
                            scheduler.flushEventQueue(sessionID, "SENSORSTATEEVENT_b007");
                            b007_TEMPERATUREEVENT_r2 = false;
                            scheduler.flushEventQueue(sessionID, "TEMPERATUREEVENT_b007");
                            b007_MAGNETOMETEREVENT_r4 = false;
                            scheduler.flushEventQueue(sessionID, "MAGNETOMETEREVENT_b007");
                            b009_COLOR_r3 = true;
                            b005_REGISTRATION_r0 = true;
                            b009_SPEED_r0 = true;
                            b005_UNREGISTRATION_r1 = true;
                            b005_MODIFIED_r2 = true;
                            b009_STOP_r2 = true;
                            b009_LIGHT_r1 = true;
                            b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                            b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                            b005_state = No_ntnu_item_its_train_adapter_CustomeServiceListener.ACTIVE;
                            // step 524cf;
                            return CONSUME_SIGNAL;
                        } else {
                            b007.context = b008_o0;
                            b007.init();
                            b007_DUMMYEVENT_r5 = true;
                            b007_ACCELEROMETEREVENT_r6 = true;
                            b007_NFCEVENT_r1 = true;
                            b009_STOP_r2 = true;
                            b009_LIGHT_r1 = true;
                            b007_TEMPERATUREEVENT_r2 = true;
                            b009_COLOR_r3 = true;
                            b005_REGISTRATION_r0 = true;
                            b009_SPEED_r0 = true;
                            b007_COLOREVENT_r0 = true;
                            b005_UNREGISTRATION_r1 = true;
                            b007_SENSORSTATEEVENT_r3 = true;
                            b005_MODIFIED_r2 = true;
                            b007_MAGNETOMETEREVENT_r4 = true;
                            b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                            b004_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                            b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                            b007_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                            b005_state = No_ntnu_item_its_train_adapter_CustomeServiceListener.ACTIVE;
                            // step bb87b;
                            return CONSUME_SIGNAL;
                        }
                    }
                } else {
                    b002.context = b003_o0;
                    b002.init();
                    org.osgi.framework.BundleContext b010_o0 = b010.get();
                    if(b010_o0==null) {
                        java.lang.String b010_o1 = b010.errMsg();
                        org.osgi.framework.BundleContext b008_o0 = b008.get();
                        if(b008_o0==null) {
                            java.lang.String b008_o1 = b008.errMsg();
                            b007_DUMMYEVENT_r5 = false;
                            scheduler.flushEventQueue(sessionID, "DUMMYEVENT_b007");
                            b007_ACCELEROMETEREVENT_r6 = false;
                            scheduler.flushEventQueue(sessionID, "ACCELEROMETEREVENT_b007");
                            b007_NFCEVENT_r1 = false;
                            scheduler.flushEventQueue(sessionID, "NFCEVENT_b007");
                            b007_COLOREVENT_r0 = false;
                            scheduler.flushEventQueue(sessionID, "COLOREVENT_b007");
                            b007_SENSORSTATEEVENT_r3 = false;
                            scheduler.flushEventQueue(sessionID, "SENSORSTATEEVENT_b007");
                            b007_TEMPERATUREEVENT_r2 = false;
                            scheduler.flushEventQueue(sessionID, "TEMPERATUREEVENT_b007");
                            b007_MAGNETOMETEREVENT_r4 = false;
                            scheduler.flushEventQueue(sessionID, "MAGNETOMETEREVENT_b007");
                            b005_REGISTRATION_r0 = true;
                            b005_UNREGISTRATION_r1 = true;
                            b005_MODIFIED_r2 = true;
                            b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                            b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                            b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                            b005_state = No_ntnu_item_its_train_adapter_CustomeServiceListener.ACTIVE;
                            // step c2aee;
                            return CONSUME_SIGNAL;
                        } else {
                            b007.context = b008_o0;
                            b007.init();
                            b007_DUMMYEVENT_r5 = true;
                            b005_REGISTRATION_r0 = true;
                            b007_ACCELEROMETEREVENT_r6 = true;
                            b007_NFCEVENT_r1 = true;
                            b007_COLOREVENT_r0 = true;
                            b005_UNREGISTRATION_r1 = true;
                            b007_SENSORSTATEEVENT_r3 = true;
                            b005_MODIFIED_r2 = true;
                            b007_TEMPERATUREEVENT_r2 = true;
                            b007_MAGNETOMETEREVENT_r4 = true;
                            b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                            b004_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                            b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                            b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                            b007_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                            b005_state = No_ntnu_item_its_train_adapter_CustomeServiceListener.ACTIVE;
                            // step 26255;
                            return CONSUME_SIGNAL;
                        }
                    } else {
                        b009.context = b010_o0;
                        b009.init();
                        org.osgi.framework.BundleContext b008_o0 = b008.get();
                        if(b008_o0==null) {
                            java.lang.String b008_o1 = b008.errMsg();
                            b007_DUMMYEVENT_r5 = false;
                            scheduler.flushEventQueue(sessionID, "DUMMYEVENT_b007");
                            b007_ACCELEROMETEREVENT_r6 = false;
                            scheduler.flushEventQueue(sessionID, "ACCELEROMETEREVENT_b007");
                            b007_NFCEVENT_r1 = false;
                            scheduler.flushEventQueue(sessionID, "NFCEVENT_b007");
                            b007_COLOREVENT_r0 = false;
                            scheduler.flushEventQueue(sessionID, "COLOREVENT_b007");
                            b007_SENSORSTATEEVENT_r3 = false;
                            scheduler.flushEventQueue(sessionID, "SENSORSTATEEVENT_b007");
                            b007_TEMPERATUREEVENT_r2 = false;
                            scheduler.flushEventQueue(sessionID, "TEMPERATUREEVENT_b007");
                            b007_MAGNETOMETEREVENT_r4 = false;
                            scheduler.flushEventQueue(sessionID, "MAGNETOMETEREVENT_b007");
                            b009_COLOR_r3 = true;
                            b005_REGISTRATION_r0 = true;
                            b009_SPEED_r0 = true;
                            b005_UNREGISTRATION_r1 = true;
                            b005_MODIFIED_r2 = true;
                            b009_STOP_r2 = true;
                            b009_LIGHT_r1 = true;
                            b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                            b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                            b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                            b005_state = No_ntnu_item_its_train_adapter_CustomeServiceListener.ACTIVE;
                            // step 7b766;
                            return CONSUME_SIGNAL;
                        } else {
                            b007.context = b008_o0;
                            b007.init();
                            b007_DUMMYEVENT_r5 = true;
                            b007_ACCELEROMETEREVENT_r6 = true;
                            b007_NFCEVENT_r1 = true;
                            b009_STOP_r2 = true;
                            b009_LIGHT_r1 = true;
                            b007_TEMPERATUREEVENT_r2 = true;
                            b009_COLOR_r3 = true;
                            b005_REGISTRATION_r0 = true;
                            b009_SPEED_r0 = true;
                            b007_COLOREVENT_r0 = true;
                            b005_UNREGISTRATION_r1 = true;
                            b007_SENSORSTATEEVENT_r3 = true;
                            b005_MODIFIED_r2 = true;
                            b007_MAGNETOMETEREVENT_r4 = true;
                            b001_state = No_ntnu_item_osgi_train_system_Train.ACTIVE;
                            b004_state = No_ntnu_item_its_train_adapter_TrainAdapter.ACTIVE;
                            b009_state = No_ntnu_item_its_train_adapter_ContextChecker.ACTIVE;
                            b002_state = No_ntnu_item_osgi_train_system_MotorController.ACTIVE;
                            b007_state = No_ntnu_item_its_train_adapter_SensorController.ACTIVE;
                            b005_state = No_ntnu_item_its_train_adapter_CustomeServiceListener.ACTIVE;
                            // step 7a787;
                            return CONSUME_SIGNAL;
                        }
                    }
                }
            }
        }
    }

    public int fireTimer(java.lang.String _timerID) {
                return DISCARD_SIGNAL;
    }

    public int fire(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.String _signalID, java.lang.Object _data) {
        if(_signalID.equals("DUMMYEVENT_b007")) {
            return handleEvent_DUMMYEVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("COLOREVENT_b007")) {
            return handleEvent_COLOREVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("SPEED_b009")) {
            return handleEvent_SPEED_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("UNREGISTRATION_b005")) {
            return handleEvent_UNREGISTRATION_b005(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MODIFIED_b005")) {
            return handleEvent_MODIFIED_b005(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("SENSORSTATEEVENT_b007")) {
            return handleEvent_SENSORSTATEEVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("TEMPERATUREEVENT_b007")) {
            return handleEvent_TEMPERATUREEVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("LIGHT_b009")) {
            return handleEvent_LIGHT_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("STOP_b009")) {
            return handleEvent_STOP_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("ACCELEROMETEREVENT_b007")) {
            return handleEvent_ACCELEROMETEREVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("REGISTRATION_b005")) {
            return handleEvent_REGISTRATION_b005(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("NFCEVENT_b007")) {
            return handleEvent_NFCEVENT_b007(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("COLOR_b009")) {
            return handleEvent_COLOR_b009(_sender, receiverSessionID, _data);
        } else if(_signalID.equals("MAGNETOMETEREVENT_b007")) {
            return handleEvent_MAGNETOMETEREVENT_b007(_sender, receiverSessionID, _data);
        }
        return TRIGGER_UNKNOWN;
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

    private int handleEvent_SPEED_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_SPEED_r0) {
            int b001_o2 = b001.convertSpeed(((Double)_data).doubleValue());
            if(b002_state==No_ntnu_item_osgi_train_system_MotorController.ACTIVE) {
                b002.setSpeed(b001_o2);
                // step 2e309;
                return CONSUME_SIGNAL;
            } else if(b002_state==No_ntnu_item_osgi_train_system_MotorController._IDLE) {
                // step 7554d;
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
            b007.unregisterSensor(((org.osgi.framework.ServiceEvent) _data));
            // step f89d1;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_MODIFIED_b005(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b005_MODIFIED_r2) {
            b007.modifiedSensor(((org.osgi.framework.ServiceEvent) _data));
            // step acb94;
            return CONSUME_SIGNAL;
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

    private int handleEvent_TEMPERATUREEVENT_b007(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b007_TEMPERATUREEVENT_r2) {
            b009.handleTemperatureEvent(((no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading) _data));
            // step d9062;
            return CONSUME_SIGNAL;
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

    private int handleEvent_STOP_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_STOP_r2) {
            if(b002_state==No_ntnu_item_osgi_train_system_MotorController.ACTIVE) {
                b002.stopTrain();
                // step 890e9;
                return CONSUME_SIGNAL;
            } else if(b002_state==No_ntnu_item_osgi_train_system_MotorController._IDLE) {
                // step 147cc;
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

    private int handleEvent_REGISTRATION_b005(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b005_REGISTRATION_r0) {
            b007.registerSensor(((org.osgi.framework.ServiceEvent) _data));
            // step 27131;
            return CONSUME_SIGNAL;
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

    private int handleEvent_COLOR_b009(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if(b009_COLOR_r3) {
            // step 5c230;
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

    public java.lang.String getPartName() {
        return null;
    }
}
