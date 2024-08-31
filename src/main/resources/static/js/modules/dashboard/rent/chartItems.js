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

//Method to render the price chart of items.
//src/main/resources/static/js/modules/dashboard/chartItems.js

/**
 * Page: Dashboard
 * Item: Chart - Total Price by Item
 * Method: Display chart of total price grouped by item
 */
function renderItemsChart(data) {
    //variables
    let items = data.map(function(rent){return rent.rentItem});
    let price = data.map(function(rent){return rent.rentTotalPrice})

    // Graphs
    const ctx = document.getElementById('myTotalPriceItemsChart')
    const myChart = new Chart(ctx,{
        type: 'bar',
        data: {
            labels: items,
            datasets: [{
                data: price,
                label: 'Total Price',
                lineTension: 0,
                borderWidth: 4,
                pointBackgroundColor: '#007bff'
            }],
        },
        options:{
            plugins:{
                legend:{
                    display: false,
                },
                tooltip:{
                    boxPadding: '5px',
                },
            }
        },
        options:{
            plugins:{
                datalabels:{
                    enabled: true,
                }
            }
        },
    });
}