package service;

import model.ComputeEngine;

public class ComputeEngineDataCreator {


    public static final String TEST_DATA_NUMBER_OF_INSTANCE = "testdata.computeengine.numberOfInstance";
    public static final String TEST_DATA_MACHINE_TYPE = "testdata.computeengine.machineType";
    public static final String TEST_DATA_NUMBER_OF_GPU = "testdata.computeengine.numberOfGPUInput";
    public static final String TEST_DATA_GPU_TYPE = "testdata.computeengine.gpuTypeInstance";
    public static final String TEST_DATA_LOCAL_SSD =  "testdata.computeengine.localSSDInstance";
    public static final String TEST_DATA_DATA_CENTER_LOCATION ="testdata.computeengine.datacenterLocationInctance";
    public static final String TEST_DATA_COMMITED_USAGE = "testdata.computeengine.commitedUsageInstance";
    public static final String TEST_DATA_ESTIMATED_COST ="testdata.computeengine.estimatedcost";









    public static ComputeEngine engineFromProperties() {

        return  new ComputeEngine(TestDataReader.getTestData(TEST_DATA_NUMBER_OF_INSTANCE),TestDataReader.getTestData(TEST_DATA_MACHINE_TYPE),TestDataReader.getTestData(TEST_DATA_NUMBER_OF_GPU),TestDataReader.getTestData(TEST_DATA_GPU_TYPE),TestDataReader.getTestData(TEST_DATA_LOCAL_SSD),TestDataReader.getTestData(TEST_DATA_DATA_CENTER_LOCATION),TestDataReader.getTestData(TEST_DATA_COMMITED_USAGE),TestDataReader.getTestData(TEST_DATA_ESTIMATED_COST));
    }
}
