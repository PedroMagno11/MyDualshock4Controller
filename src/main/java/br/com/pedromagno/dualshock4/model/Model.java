package br.com.pedromagno;

/**
 * Enumerates the models that the library supports.
 *
 * @author Pedro Magno <pedromagnopro@gmail.com>
 */
public enum Model {
    CUH_ZCT1(0x054C, 0x054C, "Dualshock 4 - 1º Generation", "CUH-ZCT1"),
    CUH_ZCT2(0x054C, 0x09CC, "Dualshock 4 - 2º Generation", "CUH_ZCT2");


    private final int vendorId;
    private final int productId;
    private final String displayName;
    private final String modelName;

    Model(int vendorId, int productId, String displayName, String modelName) {
        this.vendorId = vendorId;
        this.productId = productId;
        this.displayName = displayName;
        this.modelName = modelName;
    }

    public int getVendorId() {
        return vendorId;
    }

    public int getProductId() {
        return productId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getModelName() {
        return modelName;
    }

    @Override
    public String toString() {
        return "Display Name: " + displayName + ", Product Id: " + productId + ", Vendor: " + vendorId + ", Model: " + modelName;
    }
}
