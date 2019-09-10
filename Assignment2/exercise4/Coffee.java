package exercise4;

public class Coffee extends Product{
    private String origin, roast, flavor, aroma, acidity, body;

    public Coffee(String initialCode, String initialDescription, double initialPrice,
                  String initialOrigin, String initialRoast, String initialFlavor,
                  String initialAroma, String initialAcidity, String initialBody) {
        super(initialCode, initialDescription, initialPrice);
        origin = initialOrigin;
        roast = initialRoast;
        flavor = initialFlavor;
        aroma = initialAroma;
        acidity = initialAcidity;
        body = initialBody;
    }

    public String getAcidity() {
        return acidity;
    }

    public String getAroma() {
        return aroma;
    }

    public String getBody() {
        return body;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getOrigin() {
        return origin;
    }

    public String getRoast() {
        return roast;
    }

    @Override
    public String toString() {
        return super.toString() + "_" + origin + "_" + roast + "_"
                + flavor + "_" + aroma + "_" + acidity + "_" + body;
    }
}
