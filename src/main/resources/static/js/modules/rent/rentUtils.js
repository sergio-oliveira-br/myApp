/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie, oliveira-sergio@outlook.com
 * Project Commencing May 2024 | Version: 1.0
 * Refactoring & New Features - Aug 2024 | Version: 2.0
 */

//This file contains utility functions for rent-related calculations.
//src/main/resources/static/js/modules/rent/rentUtils.js

/**
 * Page: Rent
 * Item: Form -> Days = (End - Start)
 * Method: Simple math to calculate the days
 */
function mathDays(end, start) {
    let start_Date = new Date(start);
    let end_Date = new Date(end);
    let diffTime = Math.abs(end_Date - start_Date);
    let diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

    return diffDays;
}

/**
 * Page: Rent
 * Item: Form -> Days = (End - Start)
 * Method: applying the mathDays method
 */
function loadRentDays() {
    let newStart = document.getElementById('rentStarts').value;
    let newEnd = document.getElementById('rentEnds').value;

    let rentTotalDays = mathDays(newEnd, newStart);
    document.getElementById('rentTotalDays').value = rentTotalDays;
    console.log("The days have been calculated", rentTotalDays);

    loadTotalPrice();
}

/**
 * Page: Rent
 * Item: Form -> Total Price = (Days * Qty * UnitPrice)
 * Method: Simple math to calculate the total price and update
 */
function loadTotalPrice() {
    let newTotalDays = parseInt(document.getElementById('rentTotalDays').value);
    let newTotalQty = parseInt(document.getElementById('rentQtyItem').value);
    let newUnitPrice = parseFloat(document.getElementById('rentPrice').value);

    let newRentTotalPrice = (newTotalDays * newTotalQty * newUnitPrice);
    document.getElementById('rentTotalPrice').value = newRentTotalPrice.toFixed(2);
    console.log("The Rent Total Price was calculated by loadTotalPrice(). Result: " + newRentTotalPrice.toFixed(2));
}
