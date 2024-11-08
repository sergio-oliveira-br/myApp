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

//Method to render the payment status chart.
//src/main/resources/static/js/modules/dashboard/chartPayments.js

/**
 * Page: dashboard
 * Item: Chart - Payment Status
 * Method: Display chart of payment status
 */
function renderPaymentChart(data) {
    //variables
    let status = data.map(function(rent){return rent.rentPaymentStatus});
    let price = data.map(function(rent){return rent.rentTotalPrice})

    // Graphs
    const ctx3 = document.getElementById('myPaymentChart')
    const myRentChart = new Chart(ctx3,{
        type: 'pie',
        data: {
            labels: status,
            datasets: [{
                data: price,
                label: 'Values',
                lineTension: 0,
                borderWidth: 4,
                backgroundColor: ['#FF6384', 'rgba(62,198,104,0.66)'],
                pointBackgroundColor: '#007bff'
            }],
        },
        options:{
            //responsive: true,           //allows responsiveness
            //maintainAspectRatio: false, //disables the maintenance of the aspect
            //aspectRatio: 1,             //ratio between width and height
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
            plugins:{
                datalabels:{
                    enabled: true,
                }
            }
        }
    });
}
