package com.intern.ILoveZappos;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result extends BaseObservable {

    @SerializedName("brandName")
    @Expose
    private String brandName;
    @SerializedName("thumbnailImageUrl")
    @Expose
    private String thumbnailImageUrl;
    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("originalPrice")
    @Expose
    private String originalPrice;
    @SerializedName("styleId")
    @Expose
    private String styleId;
    @SerializedName("colorId")
    @Expose
    private String colorId;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("percentOff")
    @Expose
    private String percentOff;
    @SerializedName("productUrl")
    @Expose
    private String productUrl;
    @SerializedName("productName")
    @Expose
    private String productName;

    public Result(String brandName,
                  String thumbnailImageUrl,
                  String productId,
                  String originalPrice,
                  String styleId,
                  String colorId,
                  String price,
                  String percentOff,
                  String productUrl,
                  String productName){
        this.brandName = brandName;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.productId = productId;
        this.originalPrice = originalPrice;
        this.styleId = styleId;
        this.colorId = colorId;
        this.price = price;
        this.percentOff = percentOff;
        this.productId = productUrl;
        this.productName = productName;
    }

    @Bindable
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
        notifyPropertyChanged(BR.brandName);
    }

    @Bindable
    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
        notifyPropertyChanged(BR.thumbnailImageUrl);
    }

    @Bindable
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
        notifyPropertyChanged(BR.productId);
    }

    @Bindable
    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
        notifyPropertyChanged(BR.originalPrice);
    }

    @Bindable
    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
        notifyPropertyChanged(BR.styleId);
    }

    @Bindable
    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
        notifyPropertyChanged(BR.colorId);
    }

    @Bindable
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

    @Bindable
    public String getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(String percentOff) {
        this.percentOff = percentOff;
        notifyPropertyChanged(BR.percentOff);
    }

    @Bindable
    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
        notifyPropertyChanged(BR.productUrl);
    }

    @Bindable
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
        notifyPropertyChanged(BR.productName);
    }

}
