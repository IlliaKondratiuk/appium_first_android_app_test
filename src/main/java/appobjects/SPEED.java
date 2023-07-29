package appobjects;

public enum SPEED {
    MPH("mph"), KMH("km/h"), MS("m/s"), KNOTS("knots"), FTS("ft/s");

    final String speedinapp;
    SPEED(String speedinapp) {
        this.speedinapp = speedinapp;
    }
}
