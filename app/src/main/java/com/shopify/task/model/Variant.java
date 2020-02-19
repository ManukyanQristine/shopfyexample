
package com.shopify.task.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variant {

    @SerializedName("admin_graphql_api_id")
    private String adminGraphqlApiId;
    @Expose
    private String barcode;
    @SerializedName("compare_at_price")
    private String compareAtPrice;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("fulfillment_service")
    private String fulfillmentService;
    @Expose
    private Long grams;
    @Expose
    private Long id;
    @SerializedName("image_id")
    private Object imageId;
    @SerializedName("inventory_item_id")
    private Long inventoryItemId;
    @SerializedName("inventory_management")
    private String inventoryManagement;
    @SerializedName("inventory_policy")
    private String inventoryPolicy;
    @SerializedName("inventory_quantity")
    private Long inventoryQuantity;
    @SerializedName("old_inventory_quantity")
    private Long oldInventoryQuantity;
    @Expose
    private String option1;
    @Expose
    private Object option2;
    @Expose
    private Object option3;
    @Expose
    private Long position;
    @Expose
    private String price;
    @SerializedName("product_id")
    private Long productId;
    @SerializedName("requires_shipping")
    private Boolean requiresShipping;
    @Expose
    private String sku;
    @Expose
    private Boolean taxable;
    @Expose
    private String title;
    @SerializedName("updated_at")
    private String updatedAt;
    @Expose
    private Double weight;
    @SerializedName("weight_unit")
    private String weightUnit;

    public String getAdminGraphqlApiId() {
        return adminGraphqlApiId;
    }

    public void setAdminGraphqlApiId(String adminGraphqlApiId) {
        this.adminGraphqlApiId = adminGraphqlApiId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCompareAtPrice() {
        return compareAtPrice;
    }

    public void setCompareAtPrice(String compareAtPrice) {
        this.compareAtPrice = compareAtPrice;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getFulfillmentService() {
        return fulfillmentService;
    }

    public void setFulfillmentService(String fulfillmentService) {
        this.fulfillmentService = fulfillmentService;
    }

    public Long getGrams() {
        return grams;
    }

    public void setGrams(Long grams) {
        this.grams = grams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getImageId() {
        return imageId;
    }

    public void setImageId(Object imageId) {
        this.imageId = imageId;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getInventoryManagement() {
        return inventoryManagement;
    }

    public void setInventoryManagement(String inventoryManagement) {
        this.inventoryManagement = inventoryManagement;
    }

    public String getInventoryPolicy() {
        return inventoryPolicy;
    }

    public void setInventoryPolicy(String inventoryPolicy) {
        this.inventoryPolicy = inventoryPolicy;
    }

    public Long getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Long inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public Long getOldInventoryQuantity() {
        return oldInventoryQuantity;
    }

    public void setOldInventoryQuantity(Long oldInventoryQuantity) {
        this.oldInventoryQuantity = oldInventoryQuantity;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public Object getOption2() {
        return option2;
    }

    public void setOption2(Object option2) {
        this.option2 = option2;
    }

    public Object getOption3() {
        return option3;
    }

    public void setOption3(Object option3) {
        this.option3 = option3;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Boolean getRequiresShipping() {
        return requiresShipping;
    }

    public void setRequiresShipping(Boolean requiresShipping) {
        this.requiresShipping = requiresShipping;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Boolean getTaxable() {
        return taxable;
    }

    public void setTaxable(Boolean taxable) {
        this.taxable = taxable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

}
