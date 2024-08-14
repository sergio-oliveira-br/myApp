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

//This projection is used in the Index, loading the description and quantity available in Stock
public interface ItemQtyAvailableProjection {
    String getItemDescription();
    int getItemAvailableQty();
    //String getProductType();
}
