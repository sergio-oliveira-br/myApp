/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie
 * Project Commencing May 2024
 * Version: 1.0
 */

/**
 Page: Dashboard
 Item: Chart
 Method: Display Chart -
 */
$(document).ready(function ()
{
    //items x sum of total price, group by item
    function renderItemsChart(data)
        {
            //variables
            var items = data.map(function(rent){return rent.rentItem});
            var price = data.map(function(rent){return rent.rentTotalPrice})

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

    //relation unpaid x paid
    function renderPaymentChart(data)
        {
            //variables
            var status = data.map(function(rent){return rent.rentPaymentStatus});
            var price = data.map(function(rent){return rent.rentTotalPrice})
            
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

    //relation quantity x item
    function renderQtyItemsChart(data)
    {
        //variables
        let item = data.map(function(rent){return rent.rentItem});
        let qty = data.map(function(rent){return rent.rentQtyItem});

        //graph
        const ctx4 = document.getElementById('myQtyItemsChart')

        //Config
        const myItemsChart = new Chart(ctx4,
            {
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


    //AJAX calls to load data and render graphics
    ajaxRequest('/items-total-price', //this came from:
        function (data) {
        renderItemsChart(data);
    });

    ajaxRequest('/rent-payment-status', function (data) {
        renderPaymentChart(data);
    });

    ajaxRequest('/item-quantity', function (data) {
        renderQtyItemsChart(data);
    })

});






