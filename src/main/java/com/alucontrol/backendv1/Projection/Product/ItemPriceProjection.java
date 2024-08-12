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
package com.alucontrol.backendv1.Projection.Product;

//This projection is used in the Sales and Rent FORM, loading the description and price
public interface ItemPriceProjection {
    String getItemDescription();
    Double getItemPrice();
}
