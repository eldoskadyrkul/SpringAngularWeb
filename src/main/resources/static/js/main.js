$(function () {
    /*-------------------------------------
          Data Table init
      -------------------------------------*/
    if ($.fn.DataTable !== undefined) {
        $('.data-table').DataTable({
            paging: true,
            searching: false,
            info: false,
            lengthChange: false,
            lengthMenu: [20, 50, 75, 100],
            columnDefs: [{
                targets: [0, -1], // column or columns numbers
                orderable: false // set orderable for selected columns
            }],
        });
    }
});