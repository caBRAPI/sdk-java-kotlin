package br.com.cabrapi.sdk.model.payment;

public class FilterPaymentsRequest {
    private String id;
    private String uuid;
    private PaymentStatus status;
    private String name;
    private String email;
    private String cpf;
    private Double price;
    private Double minPrice;
    private Double maxPrice;
    private Boolean coupon;
    private PaymentGateway gateway;
    private PaymentShipmentStatus shipment;
    private String createdAtFrom;
    private String createdAtTo;
    private String updatedAtFrom;
    private String updatedAtTo;
    private String productId;
    private String metadataKey;
    private String metadataValue;
    private PaymentSortBy sortBy;
    private PaymentSortOrder sortOrder;
    private Integer page;
    private Integer limit;

    public FilterPaymentsRequest() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUuid() { return uuid; }
    public void setUuid(String uuid) { this.uuid = uuid; }
    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Double getMinPrice() { return minPrice; }
    public void setMinPrice(Double minPrice) { this.minPrice = minPrice; }
    public Double getMaxPrice() { return maxPrice; }
    public void setMaxPrice(Double maxPrice) { this.maxPrice = maxPrice; }
    public Boolean getCoupon() { return coupon; }
    public void setCoupon(Boolean coupon) { this.coupon = coupon; }
    public PaymentGateway getGateway() { return gateway; }
    public void setGateway(PaymentGateway gateway) { this.gateway = gateway; }
    public PaymentShipmentStatus getShipment() { return shipment; }
    public void setShipment(PaymentShipmentStatus shipment) { this.shipment = shipment; }
    public String getCreatedAtFrom() { return createdAtFrom; }
    public void setCreatedAtFrom(String createdAtFrom) { this.createdAtFrom = createdAtFrom; }
    public String getCreatedAtTo() { return createdAtTo; }
    public void setCreatedAtTo(String createdAtTo) { this.createdAtTo = createdAtTo; }
    public String getUpdatedAtFrom() { return updatedAtFrom; }
    public void setUpdatedAtFrom(String updatedAtFrom) { this.updatedAtFrom = updatedAtFrom; }
    public String getUpdatedAtTo() { return updatedAtTo; }
    public void setUpdatedAtTo(String updatedAtTo) { this.updatedAtTo = updatedAtTo; }
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public String getMetadataKey() { return metadataKey; }
    public void setMetadataKey(String metadataKey) { this.metadataKey = metadataKey; }
    public String getMetadataValue() { return metadataValue; }
    public void setMetadataValue(String metadataValue) { this.metadataValue = metadataValue; }
    public PaymentSortBy getSortBy() { return sortBy; }
    public void setSortBy(PaymentSortBy sortBy) { this.sortBy = sortBy; }
    public PaymentSortOrder getSortOrder() { return sortOrder; }
    public void setSortOrder(PaymentSortOrder sortOrder) { this.sortOrder = sortOrder; }
    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }
    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
}
