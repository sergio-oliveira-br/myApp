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
 * Page: Dashboard
 * Item: Chart - Payment Status
 * Method: Display chart of payment status
 */
function renderPaymentChart(data) {
    var status = data.map(rent => rent.rentPaymentStatus);
    var price = data.map(rent => rent.rentTotalPrice);

    const ctx3 = document.getElementById('myPaymentChart');
    new Chart(ctx3, {
        type: 'pie',
        data: {
            labels: status,
            datasets: [{
                data: price,
                label: 'Values',
                backgroundColor: ['#FF6384', 'rgba(62,198,104,0.66)'],
                pointBackgroundColor: '#007bff'
            }],
        },
        options: {
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
