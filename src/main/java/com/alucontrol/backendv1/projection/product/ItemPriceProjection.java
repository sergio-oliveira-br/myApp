/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie
 * Project Commencing May 2024
 * Version: 2.0
 */
package com.alucontrol.backendv1.projection.product;

//This projection is used in the Sales and rent FORM, loading the description and price
public interface ItemPriceProjection {
    Long getId();
    String getItemDescription();
    String getProductType();
    Double getItemPrice();
}
