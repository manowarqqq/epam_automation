package utils;

import service.ComputeEngineDataCreator;

public class RegexCreator {
    public static String estimatedCostRegex = "(?i).*"+ ComputeEngineDataCreator.engineFromProperties().getEstimatedCost()+".*";
}
