<%@include file="common/header.jsp"  %>

<div class="dashboard_content">
    <div class="card-auto">
        <div class="card-body">
            <div class="heading_1">
                <h3>Employees</h3>
            </div>
            <div class="table-responsive">
                <table class="table display data-table text-nowrap dataTable no-footer" id="DataTables_0" role="grid">
                    <thead>
                    <tr role="row">
                        <th class="sorting" tabindex="0" aria-controls="DataTables_0" rowspan="1" colspan="1" aria-label="">
                            Full name
                        </th>
                        <th class="sorting" tabindex="0" aria-controls="DataTables_0" rowspan="1" colspan="1" aria-label="">
                            Countable
                        </th>
                        <th class="sorting" tabindex="0" aria-controls="DataTables_0" rowspan="1" colspan="1" aria-label="">
                            Total Amount
                        </th>
                        <th class="sorting_disabled" tabindex="0" aria-controls="DataTables_0" rowspan="1" colspan="1" aria-label=""></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr role="row" class="odd">
                        <td class="sorting_1"></td>
                        <td></td>
                        <td></td>
                        <td>
                            <div class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                    <span class="flaticon-more-button-of-three-dots"></span>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right" x-placement="bottom-end" style="position: absolute; transform: translate3d(-92px, 28px, 0px); top: 0px; left: 0px; will-change: transform;">
                                    <a class="dropdown-item" href="{{route('updateTests', $test->id)}}">
                                        <i class="fas fa-cogs text-green"></i>
                                        Изменить
                                    </a>
                                    <a class="dropdown-item" href="">
                                        <i class="fas fa-trash-alt text-green"></i>
                                        Удалить
                                    </a>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp"  %>