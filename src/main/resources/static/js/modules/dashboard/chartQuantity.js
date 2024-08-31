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

//Method to render the chart of quantity of items.
//src/main/resources/static/js/modules/dashboard/chartQuantity.js

/**
 * Page: Dashboard
 * Item: Chart - Quantity of Items
 * Method: Display chart of item quantities
 */
function renderQtyItemsChart(data) {
    let items = data.map(rent => rent.rentItem);
    let qty = data.map(rent => rent.rentQtyItem);

    const ctx4 = document.getElementById('myQtyItemsChart');
    new Chart(ctx4, {
        type: 'bar',
        data: {
            labels: items,
            datasets: [{
                data: qty,
                label: 'Items Quantity',
                lineTension: 0,
                borderWidth: 4,
                backgroundColor: '#2F5061'
            }],
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            aspectRatio: 1,
            indexAxis: 'y',
            plugins: {
                legend: {
                    display: true,
                },
                tooltip: {
                    boxPadding: '5px',
                },
                datalabels: {
                    enabled: true,
                }
            }
        }
    });
}
