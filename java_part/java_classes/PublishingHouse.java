public enum PublishingHouse {

    PENGUIN_RANDOM_HOUSE("Penguin random house"), HACHETTE_LIVRE("Hachette livre"), HARPER_COLLINS("Harper collins");

    private String normalName;


    PublishingHouse(String normalName) {
        this.normalName = normalName;
    }

    public static String getHouses() {
        PublishingHouse[] ph = PublishingHouse.values();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ph.length; i++) {
            sb.append(ph[i].normalName);
            if (i < ph.length - 1) sb.append(", ");
        }
        return sb.toString();
    }

    public static boolean isExist(String name) {
        boolean isExist = false;
        PublishingHouse[] ph = PublishingHouse.values();
        for (PublishingHouse house : ph) {
            if (house.name().equals(name)) {
                isExist = true;
            }
        }
        return isExist;
    }
}
