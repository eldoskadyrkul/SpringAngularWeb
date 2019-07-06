<%@include file="common/header.jsp"  %>
<section class="testimonial py-5" id="testimonial">
    <div class="container">
        <div class="row ">
            <div class="col-md-4 py-5 bg-primary text-white text-center ">
                <div class=" ">
                    <div class="card-body">
                        <img src="http://www.ansonika.com/mavia/img/registration_bg.svg" style="width:30%">
                        <h2 class="py-3"></h2>
                        <p></p>
                    </div>
                </div>
            </div>
            <div class="col-md-8 py-5 border">
                <h4 class="pb-4">Пожалуйста заполните данные сотрудника</h4>
                <form action="/register" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input id="firstname" name="firstname" placeholder="Введите фамилию" class="form-control" type="text">
                        </div>
                        <div class="form-group col-md-6">
                            <input id="lastname" name="lastname" placeholder="Введите имя" class="form-control" type="text">
                        </div>
                        <div class="form-group col-md-6">
                            <input id="surname" name="surname" placeholder="Введите отчество" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input type="email" class="form-control" id="Email" placeholder="Введите ваш email">
                        </div>
                        <div class="form-group col-md-6">

                            <select id="inputState" name="gender" class="form-control">
                                <option selected>Пол</option>
                                <option name="male"> Мужской</option>
                                <option name="female"> Женский</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <button type="button" class="btn btn-danger">Отправить</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<%@include file="common/footer.jsp"  %>