package model;

import java.util.Objects;


public class ComputeEngine {

    private String numberOfInstanceField;
    private String cPUCheckBox;
    private String machineTypeDropList;
    private String machineTypeInstance;
    private String numberOfGPUDropList;
    private String numberOfGPUInput;
    private String gpuTypeDropList;
    private String gpuTypeInstance;
    private String localSSDDropList;
    private String localSSDInstance;
    private String datacenterLocationDropList;
    private String datacenterLocationInctance;
    private String commitedUsageDropList;
    private String commitedUsageInstance;
    private String addToEstimateButton;
    private String estimatedCost;

    public ComputeEngine(String numberOfInstanceField, String cPUCheckBox, String machineTypeDropList, String machineTypeInstance, String numberOfGPUDropList, String numberOfGPUInput, String gpuTypeDropList, String gpuTypeInstance, String localSSDDropList, String localSSDInstance, String datacenterLocationDropList, String datacenterLocationInctance, String commitedUsageDropList, String commitedUsageInstance, String addToEstimateButton,String estimatedCost) {
        this.numberOfInstanceField = numberOfInstanceField;
        this.cPUCheckBox = cPUCheckBox;
        this.machineTypeDropList = machineTypeDropList;
        this.machineTypeInstance = machineTypeInstance;
        this.numberOfGPUDropList = numberOfGPUDropList;
        this.numberOfGPUInput = numberOfGPUInput;
        this.gpuTypeDropList = gpuTypeDropList;
        this.gpuTypeInstance = gpuTypeInstance;
        this.localSSDDropList = localSSDDropList;
        this.localSSDInstance = localSSDInstance;
        this.datacenterLocationDropList = datacenterLocationDropList;
        this.datacenterLocationInctance = datacenterLocationInctance;
        this.commitedUsageDropList = commitedUsageDropList;
        this.commitedUsageInstance = commitedUsageInstance;
        this.addToEstimateButton = addToEstimateButton;
        this.estimatedCost= estimatedCost;
    }

    public ComputeEngine(String numberOfInstanceField, String machineTypeInstance, String numberOfGPUInput, String gpuTypeInstance, String localSSDInstance, String datacenterLocationInctance, String commitedUsageInstance, String estimatedCost) {
        this.numberOfInstanceField = numberOfInstanceField;
        this.machineTypeInstance = machineTypeInstance;
        this.numberOfGPUInput = numberOfGPUInput;
        this.gpuTypeInstance = gpuTypeInstance;
        this.localSSDInstance = localSSDInstance;
        this.datacenterLocationInctance = datacenterLocationInctance;
        this.commitedUsageInstance = commitedUsageInstance;
        this.estimatedCost= estimatedCost;
    }

    public String getNumberOfInstanceField() {
        return numberOfInstanceField;
    }

    public String getcPUCheckBox() {
        return cPUCheckBox;
    }

    public String getMachineTypeDropList() {
        return machineTypeDropList;
    }

    public String getMachineTypeInstance() {
        return machineTypeInstance;
    }

    public String getNumberOfGPUDropList() {
        return numberOfGPUDropList;
    }

    public String getNumberOfGPUInput() {
        return numberOfGPUInput;
    }

    public String getGpuTypeDropList() {
        return gpuTypeDropList;
    }

    public String getGpuTypeInstance() {
        return gpuTypeInstance;
    }

    public String getLocalSSDDropList() {
        return localSSDDropList;
    }

    public String getLocalSSDInstance() {
        return localSSDInstance;
    }

    public String getDatacenterLocationDropList() {
        return datacenterLocationDropList;
    }

    public String getDatacenterLocationInctance() {
        return datacenterLocationInctance;
    }

    public String getCommitedUsageDropList() {
        return commitedUsageDropList;
    }

    public String getCommitedUsageInstance() {
        return commitedUsageInstance;
    }

    public String getAddToEstimateButton() {
        return addToEstimateButton;
    }

    public String getEstimatedCost() { return estimatedCost;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return Objects.equals(numberOfInstanceField, that.numberOfInstanceField) &&
                Objects.equals(cPUCheckBox, that.cPUCheckBox) &&
                Objects.equals(machineTypeDropList, that.machineTypeDropList) &&
                Objects.equals(machineTypeInstance, that.machineTypeInstance) &&
                Objects.equals(numberOfGPUDropList, that.numberOfGPUDropList) &&
                Objects.equals(numberOfGPUInput, that.numberOfGPUInput) &&
                Objects.equals(gpuTypeDropList, that.gpuTypeDropList) &&
                Objects.equals(gpuTypeInstance, that.gpuTypeInstance) &&
                Objects.equals(localSSDDropList, that.localSSDDropList) &&
                Objects.equals(localSSDInstance, that.localSSDInstance) &&
                Objects.equals(datacenterLocationDropList, that.datacenterLocationDropList) &&
                Objects.equals(datacenterLocationInctance, that.datacenterLocationInctance) &&
                Objects.equals(commitedUsageDropList, that.commitedUsageDropList) &&
                Objects.equals(commitedUsageInstance, that.commitedUsageInstance) &&
                Objects.equals(addToEstimateButton, that.addToEstimateButton) &&
                Objects.equals(estimatedCost, that.estimatedCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstanceField,cPUCheckBox, machineTypeDropList, machineTypeInstance, numberOfGPUDropList, numberOfGPUInput, gpuTypeDropList, gpuTypeInstance, localSSDDropList, localSSDInstance, datacenterLocationDropList, datacenterLocationInctance, commitedUsageDropList, commitedUsageInstance, addToEstimateButton, estimatedCost);
    }
}
