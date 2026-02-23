package org.example.product;

public enum ProductCategory {

    GROCERIES("Lebensmittel"),
    HOUSEHOLD("Haushalt"),
    ELECTRONICS("Elektronik"),
    FURNITURE("Möbel"),
    HOME_DECOR("Dekoration"),
    KITCHEN("Küche"),
    BATHROOM("Badezimmer"),
    BEDROOM("Schlafzimmer"),
    GARDEN("Garten"),
    TOOLS("Werkzeuge"),
    LIGHTING("Beleuchtung"),
    STORAGE("Aufbewahrung"),
    CLEANING("Reinigung"),
    APPLIANCES("Haushaltsgeräte"),
    PET_SUPPLIES("Haustierbedarf"),
    OFFICE_SUPPLIES("Bürobedarf"),
    OTHER("Sonstiges");

    private final String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
