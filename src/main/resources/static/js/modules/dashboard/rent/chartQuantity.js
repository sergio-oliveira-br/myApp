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
 * Page: dashboard
 * Item: Chart - Quantity of Items
 * Method: Display chart of item quantities
 */
function renderQtyItemsChart(data) {
    let item = data.map(function(rent){return rent.rentItem});
    let qty = data.map(function(rent){return rent.rentQtyItem});

        //graph
    const ctx4 = document.getElementById('myQtyItemsChart')

    //Config
    const myItemsChart = new Chart(ctx4, {
        type: 'bar',
        data:{
            labels: item,
            datasets: [{
                data: qty,
                label: 'Items Quantity',
                lineTension: 0,
                borderWidth: 4,
                backgroundColor: '#2F5061',
                //pointBackgroundColor: '#007bff'
            }],
        },
        options:{
            responsive: true,           //allows responsiveness
            maintainAspectRatio: false, //disables the maintenance of the aspect
            aspectRatio: 1,             //ratio between width and height
            plugins:{
                legend:{
                    display: true,
                },
                tooltip:{
                    boxPadding: '5px',
                },
            }
        },
        options:{
            indexAxis: 'y', // This property makes the bars horizontal
            plugins:{
                datalabels:{
                    enabled: true,
                }
            }
        },
    });
}

